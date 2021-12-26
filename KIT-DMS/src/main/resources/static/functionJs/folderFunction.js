$(document).ready(function(){

	
	
	
	
		$(document).on("submit", "#create-folder-form", function(event) {
		
			var forms = document.getElementsByClassName('needs-validation-folder-cration');
		
		formValidation(forms, function(data){
			
			if(data === false){
			}else{
				
				var folderName=$("#createFolderName").val();
				var createUserPostDataString={folderName : folderName}
				
				var createUserPostDataJSON = JSON.stringify(createUserPostDataString);
				
				var createUserUrlPath=apiUrl+"/api/folder/createfolder";
				
				postJSONAjaxCall(createUserUrlPath, createUserPostDataJSON, function(response){
					
			        if(response.status == "success") {
			        	
			        	swal("Folder Creation", "Folder Created SuccessFully", "success").then((value) => {
			        		location.reload();
						});
			        	
			        }  else if(response.status == failStatus) {
			        	swal("Folder Creation", response.message, "error")
			        }  else if(response.status == failAjaxStatus) {
			        	swal("Folder Creation", "Something went wrong, please try after some time", "error")
			        }
			        
			    });
			
				

				
				
			}
		})
		
		return false;
		
	})
	
	
	
	//datatables
	
	
	var fetchFolderUrlPath = apiUrl + "/api/folder/getFolderlist";
		getJSONDatatableAjaxCall(fetchFolderUrlPath, function(response){
		
        if(response.status == "success") {
        	
        	
        	
        	$('#folder-list-dataTable').DataTable({
        		destroy : true,
				searching : true,
				autoWidth : false,
		        "order": [[ 0, "desc" ]],
                "data" : response.folderList,
                "columns" : [{
						"data" : "folderId", "defaultContent" : ""
				 	}, {
						"data" : "folderName", "defaultContent" : ""
					}, {
						"data" : "createdDate", "defaultContent" : ""
					}]

        	})
        }  else if(response.status == failStatus) {
        	swal("Department list", response.message, "error")
        }  else if(response.status == failAjaxStatus) {
        	swal("Department list", "Something went wrong, please try after some time", "error")
        }
        
    });
	
	
	
	
		$("#folderCreateCloseButton").on("click",  function (e) {
			$("#createFolderName").val('');
			
		})
	$("#closeCreateFolderEvent").on("click",  function (e) {
			$("#createFolderName").val('');
			
		})
	
	
	
	
	
	
	
	
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
