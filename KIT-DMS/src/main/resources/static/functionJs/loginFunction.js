$(document).ready(function(){
	
	
	$(document).on("submit", "#user-login-form", function(event) {
	
		var forms = document.getElementsByClassName('needs-validation-user-login');
	
	formValidation(forms, function(data){
		
		if(data === false){
		}else{
			
			var userEmail=$("#userName").val();
			var password=$("#password").val();
			var createUserPostDataString={email : userEmail, password: password}
			
			var createUserPostDataJSON = JSON.stringify(createUserPostDataString);
			
			var createUserUrlPath=apiUrl+"/api/user/login";
			
			postJSONAjaxCall(createUserUrlPath, createUserPostDataJSON, function(response){
				
		        if(response.status == "success") {
		        	
		        	
		        	localStorage.setItem("userMobile", response.mobileNumber);
					localStorage.setItem("email", response.email);
					localStorage.setItem("employeeUserName",response.userName);
		        	
		        	
		        	
		        	window.top.location = apiUrl +"/index";
		        	
		        }  else if(response.status == failStatus) {
		        	swal("Login User", response.message, "error")
		        }  else if(response.status == failAjaxStatus) {
		        	swal("Login User", "Something went wrong, please try after some time", "error")
		        }
		        
		    });
		
			

			
			
		}
	})
	
	return false;
	
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