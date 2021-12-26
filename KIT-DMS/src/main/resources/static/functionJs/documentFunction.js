$(document).ready(function(){
	
	
	$('#uploadDocumentFolderList').find('option').remove().end().append('<option>Choose option</option>');
	$('#uploadDocumentFolderList').find('option').remove().end().append('<option value=\"\">Choose option</option>');
	
	$('#documentProjectName	').find('option').remove().end().append('<option>Choose option</option>');
	$('#documentProjectName').find('option').remove().end().append('<option value=\"\">Choose option</option>');
	
	
	$('#documentFolderList').find('option').remove().end().append('<option>Choose option</option>');
	$('#documentFolderList').find('option').remove().end().append('<option value=\"\">Choose option</option>');

	projectList();
	function projectList() {

		var fetchStatesUrlPath = apiUrl + "/api/project/getProjectList";

		getJSONAjaxCall(fetchStatesUrlPath,function(response) {

					JSON.stringify(response);
					finalRes1 = response.projecdtList;

					var select = document.getElementById("documentProjectName");
					
					/*$('#documentProjectName').find('option').remove().end().append('<option value=\"\">Choose option</option>');
					$('#documentProjectName').find('option').remove().end().append('<option>Choose option</option>');*/
				
					for ( var i in finalRes1) {
						projectObj = finalRes1[i];
						id = projectObj.projectId;
						name = projectObj.projectName;
						select.options[select.options.length] = new Option(
								name, id);

					}

				});

	}
	
	
	//uploadDocumentProjectList();
	function uploadDocumentProjectList() {

		var fetchStatesUrlPath = apiUrl + "/api/project/getProjectList";

		getJSONAjaxCall(fetchStatesUrlPath,function(response) {

					JSON.stringify(response);
					finalRes1 = response.projecdtList;

					var select = document.getElementById("uploadDocumentProjectList");
					$('#uploadDocumentProjectList').find('option').remove().end().append('<option>Choose option</option>');
					$('#uploadDocumentProjectList').find('option').remove().end().append('<option value=\"\">Choose option</option>');


					for ( var i in finalRes1) {
						projectObj = finalRes1[i];
						id = projectObj.projectId;
						name = projectObj.projectName;
						select.options[select.options.length] = new Option(
								name, id);

					}

				});

	}
	
	

	
$("#uploadDocumentProjectList").on('change', function() {
		
	
	var projectId = $("#uploadDocumentProjectList").val();
	
	var userListByDepartmentAPIUrl = apiUrl + "/api/folder/folderListbyProject";
	var	userListDataString = { projectId: projectId};
	var userListListDataJSON = JSON.stringify(userListDataString);

	
	
			postJSONAjaxCall(userListByDepartmentAPIUrl, userListListDataJSON, function(response){
						
						if (response.status == successStatus) {
							
							JSON.stringify(response);
							finalRes1 = response.folderResponseList;
			
							var select = document.getElementById("uploadDocumentFolderList");
							$('#uploadDocumentFolderList').find('option').remove().end().append('<option>Choose option</option>');
							$('#uploadDocumentFolderList').find('option').remove().end().append('<option value=\"\">Choose option</option>');

							for ( var i in finalRes1) {
								locationobj = finalRes1[i];
								id = locationobj.folderId;
								name = locationobj.folderName;
								select.options[select.options.length] = new Option(name, id);
							}
							
						} else if (response.status == failStatus) {
							swal("Document List", response.message, "error");
						} else if (response.status == failAjaxStatus) {
							swal("Document List", "Something went wrong, please try after sometime", "error");
						}
			
					});
		
	})
	
	
	
	
	
	
	//document search folder list Based on Project
	
	
	$("#documentProjectName").on('change', function() {
		
	
	var projectId = $("#documentProjectName").val();
	
	var userListByDepartmentAPIUrl = apiUrl + "/api/folder/folderListbyProject";
	var	userListDataString = { projectId: projectId};
	var userListListDataJSON = JSON.stringify(userListDataString);

	
	
			postJSONAjaxCall(userListByDepartmentAPIUrl, userListListDataJSON, function(response){
						
						if (response.status == successStatus) {
							
							JSON.stringify(response);
							finalRes1 = response.folderResponseList;
			
							var select = document.getElementById("documentFolderList");
							$('#documentFolderList').find('option').remove().end().append('<option>Choose option</option>');
							$('#documentFolderList').find('option').remove().end().append('<option value=\"\">Choose option</option>');

							for ( var i in finalRes1) {
								locationobj = finalRes1[i];
								id = locationobj.folderId;
								name = locationobj.folderName;
								select.options[select.options.length] = new Option(name, id);
							}
							
						} else if (response.status == failStatus) {
							swal("Project List", response.message, "error");
						} else if (response.status == failAjaxStatus) {
							swal("Project List", "Something went wrong, please try after sometime", "error");
						}
			
					});
		
	})
	
	
	
	
	
	$('#documentFileUpload').change(function(e){
      var fileName = "";
      $(e.target.files).each(function(index, file){
          if (fileName.length > 0) {
              fileName = fileName+", "
          }
          if(file.size >= 20971520){
				swal("Upload Document", "File size Must be Less than 20 MB", "error").then((value) => {
					location.reload();
				});
			}
          
      fileName = fileName+file.name;
      });
      var selectFile = fileName.split(", ").length
      if(selectFile <= 1){
      $('#documentFileUpload').next().text(fileName);
      }else{
          $('#documentFileUpload').next().text(selectFile+ "    	Files Selected");
      }
    });
	
	
		$(document).on("submit", "#upload-document-form", function(event) {
		
		var forms = document.getElementsByClassName('needs-validation-upload-form');
		
		formValidation(forms, function(data){
			
			if(data === false){
			}else{
				
				var projectId=$("#uploadDocumentProjectList").val();
				var folderId=$("#uploadDocumentFolderList").val();
			
				

				
				var userListByDepartmentAPIUrl = apiUrl + "/api/document/uploadDocument";
				var	userListDataString = { projectId: projectId,folderId:folderId};
				var userListListDataJSON = JSON.stringify(userListDataString);

				var data = new FormData();
				$.each($("#documentFileUpload")[0].files, function(i, file) {
					data.append('document', file);
					
				});
			
				data.append('documentDto', userListListDataJSON);
				
				postFormDataAjaxCall(userListByDepartmentAPIUrl, data, function(response){
					var obj = JSON.parse(response);
									
									if (obj.status == successStatus) {
										
										swal("Upload Document","Document Uploaded Successfully","success").then((value) => {
											location.reload();
										});
										
									} else if (obj.status == failStatus) {
										
										swal("Upload Document", obj.message, "error").then((value) => {
											location.reload();
										});
									} else if (obj.status == failAjaxStatus) {
										swal("Upload Document", "Something went wrong, please try after sometime", "error");
									}
						
								});
				
			}
		})
		
		return false;
		
	})
	
	
	
	
	
	
	
	
	$(document).on("submit", "#document-fiter-form", function(event) {
		
		var forms = document.getElementsByClassName('needs-validation-document-filter');
		
		formValidation(forms, function(data){
			
			if(data === false){
			}else{
				
				var projectId=$("#documentProjectName").val();
				var folderId=$("#documentFolderList").val();
				
				var userListByDepartmentAPIUrl = apiUrl + "/api/document/uploadDocument";
				var	userListDataString = { projectId: projectId,folderId:folderId};
				var userListListDataJSON = JSON.stringify(userListDataString);
				
				
				
				
				
				
				
				
				
				var fetchFolderUrlPath = apiUrl + "/api/document/list";
				postJSONAjaxCall(fetchFolderUrlPath, userListListDataJSON, function(response){
				
		        if(response.status == "success") {
		        	
		        	
		        	
		        	$('#document-list-dataTable').DataTable({
		        		destroy : true,
						searching : true,
						autoWidth : false,
				        "order": [[ 0, "desc" ]],
		                "data" : response.documentlistResponse,
		                "columns" : [{
								"data" : "sNo", "defaultContent" : ""
						 	}, {
								"data" : "documentName", "defaultContent" : ""
							}, {
								"data" : "createdDate", "defaultContent" : ""
							},{"sortable":false,"defaultContent" : "<a href=\"javascirpt:void(0);\" class=\"viewDocumentClass\"><i class=\"mdi mdi-eye font-20 mr-2\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"View\"></i></a>"+
								"<a href=\"javascirpt:void(0);\" class=\"dawnloadDocumentClass\" id=\"dowloandfiledocument\"><i class=\"mdi mdi-download font-20 mr-2\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Download\"></i></a>"+
								" <a href=\"#\"class=\"deletDocumentClass\" id=\"dawnloadfile\" dawnload><i class=\"mdi mdi-delete font-20 mr-2\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Remove\"></i></a>"}]

		        	})
		        }  else if(response.status == failStatus) {
		        	swal("Document list", response.message, "error")
		        }  else if(response.status == failAjaxStatus) {
		        	swal("document list", "Something went wrong, please try after some time", "error")
		        }
		        
		    });
				
			}
		})
		
		return false;
		
	})
	
	
	
	
	
	$("body").on("click", "#document-list-dataTable tbody tr .deletDocumentClass", function (e) {
		var row = $('#document-list-dataTable').DataTable().row($(this).closest('tr')).data();
		//alert("changeRequestId "+row.changeRequestId);
		localStorage.setItem("deletDocumentNumber", row.documentNo);
		
		swal({
			  title: "File Deletion",
			  text: "Are You Sure You Want To Delet This File",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
		var docId = localStorage.getItem("deletDocumentNumber");
		var editbillingPostDataString={documentId : docId}
		
		var editbillingPostDataJSON=JSON.stringify(editbillingPostDataString);
		
		var editbillingtypeUrlPath=apiUrl+"/api/document/deletFile";
		postJSONAjaxCall(editbillingtypeUrlPath,editbillingPostDataJSON,function(response) {
			
		if(response.status=="success") {
			
			swal("Delet File", "File Deleted Successfully", "success").then((value) => {
				location.reload();
			});
			
		} else if(repsonse.status==failStatus)	{
			swal("File Delet", response.message, "error")
		} else if(response.status==failAjaxStatus) {
			swal("File Delet", "Something is wrong", "error")
		}
		
	});
			  }
			});
		
	})
	
	
	$("body").on("click", "#document-list-dataTable tbody tr .viewDocumentClass", function (e) {
		var row = $('#document-list-dataTable').DataTable().row($(this).closest('tr')).data();
		
		localStorage.setItem("viewDocumentNumber", row.documentNo);
		localStorage.setItem("viewDocumentLocation", row.documentLocation);
		
		var docId = localStorage.getItem("viewDocumentNumber");
		var docLocation = localStorage.getItem("viewDocumentLocation");
		
		
		var period = docLocation.lastIndexOf('.');
		var pluginName = docLocation.substring(0, period);
		var fileExtension = docLocation.substring(period + 1);
		if( fileExtension.localeCompare('pptx')==0){
			window.open("https://view.officeapps.live.com/op/embed.aspx?src="+docLocation);
		}else if(fileExtension.localeCompare('xlsx')==0 || fileExtension.localeCompare('xls')==0){
			window.open("https://view.officeapps.live.com/op/embed.aspx?src="+docLocation);
			
		}else if(fileExtension.localeCompare('jpg')==0 ||fileExtension.localeCompare('jpeg')==0||fileExtension.localeCompare('png')==0){
			window.open(docLocation);
		}else if(fileExtension.localeCompare('pdf')==0){
			window.open("http://docs.google.com/gview?url="+docLocation+"&embedded=true");
			
			
		}else if(fileExtension.localeCompare('csv')==0){
			window.open("http://docs.google.com/gview?url="+docLocation+"&embedded=true");
			
			
		}else if(fileExtension.localeCompare('docx')==0 ){
			
			window.open("https://view.officeapps.live.com/op/embed.aspx?src="+docLocation);
		}else if(fileExtension.localeCompare('doc')==0){
			window.open("https://docs.google.com/viewer?embedded=true&url="+docLocation);
		}else if(fileExtension.localeCompare('txt')==0){
			
			
			window.open(" https://docs.google.com/a/umd.edu/viewer?url="+docLocation+"&embedded=true");
			
		
		}
	})
	
	
	
	$("body").on("click", "#document-list-dataTable tbody tr .dawnloadDocumentClass", function (e) {
		var row = $('#document-list-dataTable').DataTable().row($(this).closest('tr')).data();
		
		localStorage.setItem("dawnloadDocumentNumber", row.documentNo);
		localStorage.setItem("dawnloadDocumentLocation", row.documentLocation);
		
		var docId = localStorage.getItem("dawnloadDocumentNumber");
		var docLocation = localStorage.getItem("dawnloadDocumentLocation");
		
		//window.open(docLocation);
		
		var period = docLocation.lastIndexOf('.');
		var pluginName = docLocation.substring(0, period);
		var fileExtension = docLocation.substring(period + 1);
		
	    
		window.open(docLocation);
		
			
	})
	
	

	
	$("#documentClearButton").on("click",  function (e) {
		
		
		location.reload();
	})
	
	
	$("#uploadDocumentCloseButton").on("click",  function (e) {
		
		location.reload();
		//	location.reload();
	})
	
	$("#upladDocumentclose").on("click",  function (e) {
		location.reload();
	})

	
	function downloadURL(url) {
    var hiddenIFrameID = 'hiddenDownloader',
        iframe = document.getElementById(hiddenIFrameID);
    if (iframe === null) {
        iframe = document.createElement('iframe');
        iframe.id = hiddenIFrameID;
        iframe.style.display = 'none';
        document.body.appendChild(iframe);
    }
    iframe.src = url;
};
	
	
	
	
		uploadDocumentProjectList();
	
	$("#upload-folder-modal").on("hidden.bs.modal", function () {
	
		$("#upload-document-form").trigger("reset");
		$(".was-validated").removeClass("was-validated")
	});
	
	
	
	
	function formValidation(forms, callback){
	
	//Remove class
	$(".was-validated").removeClass("was-validated")
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
        if (form.checkValidity() === false) {
          callback(form.checkValidity());
        }else{
        	callback("true");
        }
        form.classList.add('was-validated');
    });
}
	
	
	
})
