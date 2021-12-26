$(document).ready(function(){
	var folderLength = localStorage.getItem("editFolderLength");
	$('#editProjectFolderList').find('option').remove().end();
	$('#editProjectFolderList').multiselect({
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true,
        includeSelectAllOption: true
    });
	
	
	
	var projectId;
	var projectName;
	var folderName;
	folderList();
	function folderList() {

		var fetchStatesUrlPath = apiUrl + "/api/folder/getFolderlist";

		getJSONAjaxCall(fetchStatesUrlPath,function(response) {

					JSON.stringify(response);
					finalRes1 = response.folderList;
					
					$('#projectFolderList').find('option').remove();
	                
	                $("#projectFolderList").multiselect('destroy');

					var select = document.getElementById("projectFolderList");
					var selectUpdate = document.getElementById("projectFolderList");

					$('#projectFolderList').find('option').remove().end();

					for ( var i in finalRes1) {
						folderObj = finalRes1[i];
						id = folderObj.folderId;
						name = folderObj.folderName;
						select.options[select.options.length] = new Option(name, id);
						//selectUpdate.options[selectUpdate.options.length] = new Option(name, id);

					}

					$('#projectFolderList').multiselect({ 
			            enableFiltering: true,
			            enableCaseInsensitiveFiltering: true,
			            includeSelectAllOption: true });
				});

	}
	//create Project
	
	
	$(document).on("submit", "#create-project-form", function(event) {
		
		var forms = document.getElementsByClassName('needs-validation-project-cration');
	
	formValidation(forms, function(data){
		
		if(data === false){
			
			 $('#projectFolderList').on('change', function() {
			        if($("#projectFolderList").val().length > 0) {
			            $("#fromUsersError").hide();
			           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #ced4da");
			        } else if($("#projectFolderList").val().length == 0) {
			            $("#fromUsersError").show();
			           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #e81212");
			        }
			      });
		}else{
			

			var projectName = $("#createProjectField").val();
			var folderIds = $("#projectFolderList").val();
			
			var createUserPostDataString={folderId : folderIds,projectName: projectName }
			
			var createUserPostDataJSON = JSON.stringify(createUserPostDataString);
			
			var createUserUrlPath=apiUrl+"/api/project/createProject";
			
			postJSONAjaxCall(createUserUrlPath, createUserPostDataJSON, function(response){
				
		        if(response.status == "success") {
		        	
		        	swal("Project Creation", "Project Created SuccessFully", "success").then((value) => {
		        		location.reload();
					});
		        	
		        }  else if(response.status == failStatus) {
		        	swal("Project Creation", response.message, "error")
		        }  else if(response.status == failAjaxStatus) {
		        	swal("Project Creation", "Something went wrong, please try after some time", "error")
		        }
		        
		    });
	
			
		}
	})
	
	return false;
	
})


// edit project folder list


function editProjectFolderList(folderList) {

		var fetchStatesUrlPath = apiUrl + "/api/folder/getFolderlist";

		getJSONAjaxCall(fetchStatesUrlPath,function(response) {

					JSON.stringify(response);
					finalRes1 = response.folderList;
					
					$('#editProjectFolderList').find('option').remove();
	                
	                $("#editProjectFolderList").multiselect('destroy');

					var select = document.getElementById("editProjectFolderList");
					var selectUpdate = document.getElementById("editProjectFolderList");

					$('#editProjectFolderList').find('option').remove().end();

					for ( var i in finalRes1) {
						folderObj = finalRes1[i];
						id = folderObj.folderId;
						name = folderObj.folderName;
						select.options[select.options.length] = new Option(name, id);
						//selectUpdate.options[selectUpdate.options.length] = new Option(name, id);

					}
					

					if(folderList) {
						$("#editProjectFolderList").val(folderList);										
					}
					
					$('#editProjectFolderList').multiselect({
			            enableFiltering: true,
			            enableCaseInsensitiveFiltering: true,
				        includeSelectAllOption: true
				    });
					
					
					$('#editProjectFolderList').multiselect({ 
			            enableFiltering: true,
			            enableCaseInsensitiveFiltering: true,
			            includeSelectAllOption: true });
					
				});

	}



	// Edit Projects
	
$(document).on("submit", "#edit-project-form", function(event) {
	 
		var forms = document.getElementsByClassName('needs-validation-edit-project-cration');
	
	formValidation(forms, function(data){
		
		if(data === false){
			
			  if($("#editProjectFolderList").val().length > 0) {
		            $("#editfromUsersError").hide();
		           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #ced4da");
		        } else if($("#editProjectFolderList").val().length == 0) {
		            $("#editfromUsersError").show();
		           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #e81212");
		        }
		}else{
			var projectId=localStorage.getItem("editProjectId");

			var projectName = $("#editProjectName").val();
			var folderIds = $("#editProjectFolderList").val();
		
			
			var createUserPostDataString={folderId : folderIds,projectName: projectName,projectId: projectId }
			
			var createUserPostDataJSON = JSON.stringify(createUserPostDataString);
			
			var createUserUrlPath=apiUrl+"/api/project/editProject";
			
			postJSONAjaxCall(createUserUrlPath, createUserPostDataJSON, function(response){
				
		        if(response.status == "success") {
		        	
		        	swal("Update Project ", "Project Updated SuccessFully", "success").then((value) => {
		        		location.reload();
					});
		        	
		        }  else if(response.status == failStatus) {
		        	swal("Update Project", response.message, "error")
		        }  else if(response.status == failAjaxStatus) {
		        	swal("Upadate Project", "Something went wrong, please try after some time", "error")
		        }
		        
		    });
	
			
		}
	})
	
	return false;
	
})


	// dataTables
	var fetchProjectFolderUrlPath = apiUrl + "/api/project/getlistWithFolders";
		getJSONDatatableAjaxCall(fetchProjectFolderUrlPath, function(response){
		
        if(response.status == "success") {
        	
        	
        	
        	$('#project-list-dataTables').DataTable({
        		destroy : true,
				searching : true,
				autoWidth : false,
		        "order": [[ 0, "desc" ]],
                "data" : response.projectListResponse,
                "columns" : [{
						"data" : "projectId", "defaultContent" : ""
				 	}, {
						"data" : "prjectName", "defaultContent" : ""
					}, {
						"data" : "folderName", "defaultContent" : ""
					},{"sortable":false,"defaultContent" : /*"<a href=\"\"  data-toggle=\"modal\" data-animation=\"bounce\" data-target=\".bs-example-modal-lg-folder\"><i class=\"mdi mdi-folder-plus font-20 mr-2\"></i></a>"+*/
						"<a href=\"\" class=\"editProject\" data-toggle=\"modal\" data-animation=\"bounce\" data-target=\".bs-example-modal-lg-edit\"><i class=\"mdi mdi-tooltip-edit font-20 mr-2\"></i></a>"}]

        	})
        }  else if(response.status == failStatus) {
        	swal("Department list", response.message, "error")
        }  else if(response.status == failAjaxStatus) {
        	swal("Department list", "Something went wrong, please try after some time", "error")
        }
        
    });
	
	
		$("body").on("click", "#project-list-dataTables tbody tr .editProject", function (e) {
			var row = $('#project-list-dataTables').DataTable().row($(this).closest('tr')).data();
			
			 projectId=row.projectId;
			 projectName=row.prjectName;
			 folderName=row.folderName;
			 localStorage.setItem("editProjectId", row.projectId);
			 
			 localStorage.setItem("editFolderLength", row.folderListId.length);
			 var projectId=$("#editProjectName").val(projectName);
			 
			 $('#editProjectFolderList').multiselect('select', row.folderListId);
			$('#editProjectFolderList').multiselect('rebuild');
			 
			 editProjectFolderList(row.folderListId);
			 
			 $("#editProjectFolderList").multiselect('destroy');
			 

		
			        if( row.folderListId.length > 0) {
			            $("#editfromUsersError").hide();
			           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #ced4da");
			        } else if(row.folderListId.length == 0) {
			            $("#editfromUsersError").show();
			           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #e81212");
			        }
			  
			 
			
		})
	
	
	
	
	
	
	//Folder MultiSelect Jquery
	$("#create-project-model").on("hidden.bs.modal", function () {
		folderList();
		$("#create-project-form").trigger("reset");
		$('#projectFolderList').find('option').remove().end().append('<option value=\"\">Choose option</option>');
		$(".was-validated").removeClass("was-validated")
	});
	
	$('#projectFolderList').multiselect({
		enableFiltering: true,
		enableCaseInsensitiveFiltering: true,
		includeSelectAllOption: true
    });
	
	 $('#btnSelected').click(function () {
	        var selected = $("#projectFolderList option:selected");
	        var message = "";
	        selected.each(function () {
	            message += $(this).text() + " " + $(this).val() + "\n";
	        });
	        alert(message);
	    });

	 $('#projectFolderList').on('change', function() {
	        if($("#projectFolderList").val().length > 0) {
	            $("#fromUsersError").hide();
	           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #ced4da");
	        } else if($("#projectFolderList").val().length == 0) {
	            $("#fromUsersError").show();
	           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #e81212");
	        }
	      });
	 
	 
	 
	 $('#editProjectFolderList').on('change', function() {
	        if($("#editProjectFolderList").val().length > 0) {
	            $("#editfromUsersError").hide();
	           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #ced4da");
	        } else if($("#editProjectFolderList").val().length == 0) {
	            $("#editfromUsersError").show();
	           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #e81212");
	        }
	      });
	 
	 
		 $('#editProjectFolderList').materialSelect();
		 
	 // ************************************ edit prject folder multiSelect *****************************
	 
	//Folder MultiSelect Jquery
		/*$("#create-project-model").on("hidden.bs.modal", function () {
			folderList();
			$("#create-project-form").trigger("reset");
			$('#projectFolderList').find('option').remove().end().append('<option value=\"\">Choose option</option>');
			$(".was-validated").removeClass("was-validated")
		});
		
		$('#editProjectFolderList').multiselect({
	        includeSelectAllOption: true
	    });
		
		 $('#btnSelected').click(function () {
		        var selected = $("#editProjectFolderList option:selected");
		        var message = "";
		        selected.each(function () {
		            message += $(this).text() + " " + $(this).val() + "\n";
		        });
		        alert(message);
		    });

		 $('#editProjectFolderList').on('change', function() {
		        if($("#editProjectFolderList").val().length > 0) {
		            $("#fromUsersError").hide();
		           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #ced4da");
		        } else if($("#editProjectFolderList").val().length == 0) {
		            $("#fromUsersError").show();
		           // $(".multiselect.dropdown-toggle.btn.btn-light").css("border","1px solid #e81212");
		        }
		      });
		 */
	 // ****************************   end  **********************************************
	 
	 
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
