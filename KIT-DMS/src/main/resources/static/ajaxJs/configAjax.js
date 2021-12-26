function postJSONDatatableAjaxCall(apiURL, authToken, ajaxPostData, callback){
    
	var apiDrawCount = 0;
	
	tables = $('#datatable-responsive').DataTable({
		destroy : true,
		searching : true,
		"ajax" : {
			url : apiURL,
			type : 'POST',
			contentType: "application/json",
			headers: {
		        'Authorization': authToken
		    },
			data : function (data) {
				
				apiDrawCount++;
				
				ajaxPostData[0].drawCount = apiDrawCount;
				ajaxPostData[0].pageNumber = $('#datatable-responsive').DataTable().page.info().page;
				ajaxPostData[0].pageSize = $('#datatable-responsive').DataTable().page.info().length;
				ajaxPostData[0].searchString = data.search.value;
				ajaxPostData[0].sortType = data.order[0].dir;
				
	    		return data = JSON.stringify(ajaxPostData[0]);
	    		
			},
			success : function(data) {
				callback(data);
			},
			error : function() {
				var failDataString = { status: failAjaxStatus};
				var failDataJSON = JSON.stringify(failDataString);
				
				callback(failDataJSON);
			}
		}
	})
}

function getJSONDatatableAjaxCall(apiURL, callback){
    
	$.ajax({
		url : apiURL,
		async: false,
		type : "GET",
		
		success : function(data) {
			callback(data);
		},
		error : function() {
			var failDataString = { status: failAjaxStatus};
			var failDataJSON = JSON.stringify(failDataString);
			
			callback(failDataJSON);
		}
	});
	
}

function postFormDataAjaxCall(apiURL, apiData, callback) {
    
    $.ajax({
        url : apiURL,
        type : "POST",
       
        data : apiData,
        contentType : false,
        mimeType : "multipart/form-data",
        processData : false,
        success : function(data) {
            callback(data);
        },
        error : function() {
        	var failDataString = { status: failAjaxStatus};
			var failDataJSON = JSON.stringify(failDataString);
			
			callback(failDataJSON);
        }
    });
    
}

function postJSONAjaxCall(apiURL, apiData, callback){
    
	$.ajax({
		url : apiURL,
		type : "POST",
		
		data : apiData,
		contentType : 'application/json',
		success : function(data) {
			callback(data);
		},
		error : function() {
			var failDataString = { status: failAjaxStatus};
			var failDataJSON = JSON.stringify(failDataString);
			
			callback(failDataJSON);
		}
	});
    
}

function getJSONAjaxCall(apiURL, callback){
	
	$.ajax({
		url : apiURL,
		type : "GET",
       
		success : function(data) {
			callback(data);
		},
		error : function() {
			var failDataString = { status: failAjaxStatus};
			var failDataJSON = JSON.stringify(failDataString);
			
			callback(failDataJSON);
		}
	});
	
}

function getJSONAjaxCallForAsync(apiURL, authToken, callback){
	
	$.ajax({
		url : apiURL,
		type : "GET",
		async:false,
        headers: {
            'Authorization': authToken
        },
		success : function(data) {
			callback(data);
		},
		error : function() {
			var failDataString = { status: failAjaxStatus};
			var failDataJSON = JSON.stringify(failDataString);
			
			callback(failDataJSON);
		}
	});
	
}
