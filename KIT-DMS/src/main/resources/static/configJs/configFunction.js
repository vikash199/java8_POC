$(document).ready(function(){
	var empMobile = localStorage.getItem("userMobile");
	checkSessions();

function checkSessions() {
	if(empMobile == null) {
		window.top.location = apiUrl + "/login";
		return false;
	}
}

$('#logoutFunction').click(function(){
	
	localStorage.clear();		
	window.location.replace(projectFinalName+"/login");
	
});

userRolename.innerText="Mr. Admin";

var name = localStorage.getItem("employeeUserName");

$("#rolebasedName").html(name+" !");


})
