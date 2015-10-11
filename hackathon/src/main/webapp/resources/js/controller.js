/**
 * Angular Controller for the Login and Sign Up
 */
mainApp.controller("loginController", function($scope, $location, $http) {
	$scope.formData = {};
	$scope.signup = function() {
		var params = {
			"gender" : $scope.formData.gender,
			"firstName" : $scope.formData.firstName,
			"middleName" : $scope.formData.middleName,
			"lastName" : $scope.formData.lastName,
			"address1" : $scope.formData.address1,
			"address2" : $scope.formData.address2,
			"city" : $scope.formData.city,
			"stateCode" : $scope.formData.stateCode,
			"emailId" : $scope.formData.emailId,
			"mobileNumber" : $scope.formData.mobileNumber,
			"password" : $scope.formData.password,
			"zipCode" : $scope.formData.zipCode,
		};
	    $http({
	    	url: 'login/register',
		    method: "POST",
		    data: params,
		    headers: {'Content-Type': 'application/json'}
		}).success(function(data) {
			window.location.href = "home";
		}).error(function(data,status) {
			$.blockUI({
				message : data+status
			});
			$(document).click($.unblockUI);
		});
	};
	
	$scope.login = function() {
		var params = $scope.formData;
	    $http({
	    	url: 'login/process',
		    method: "POST",
		    data: params,
		    headers: {'Content-Type': 'application/json'}
		}).success(function(data) {
			window.location.href = "home";
		}).error(function(data,status) {
			$.blockUI({
				message : data+status
			});
			$(document).click($.unblockUI);
		});
	};
});

mainApp.controller("jobController", function($scope, $http) {
	$scope.parent = {}
	$scope.title = ''
	$scope.type = ''
	$scope.desc = ''
	$scope.sub_tab = 'true'
	$scope.e_id = ''
	$scope.e_title = ''
	$scope.e_type = ''
	$scope.e_desc = ''
	$scope.edit = ''
	$scope.del = ''
	
	parent.alerts = []
	
	$scope.all_data = [{id:'1',type:'abc',title:'W',description:'xxxxxxx'},{id:'2',type:'csv',title:'A',description:'yyyyyyyyy'}]
	
	//create()------------------------------------------------------------------------
	
	$scope.create = function(){
	    var params = {"title":$scope.title,"type":$scope.type,"description":$scope.desc}
	    $http({
	       url: 'admin/job/create',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		   console.log(data)
	   		//{"response":{"severity":"VALID","message":"Job has been successfully created."},"id":"c2114dbe-426c-4277-bf88-cd9c49c4e7d2"}
	   		   if (data['response']['severity']=='VALID'){
	   			$scope.alerts = []
	   			$scope.addAlert('alert-success',15000,'added new job')
	   			   
	   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
	   	   }).
	       error(function(data,status) {
	    	   $scope.alerts = []
	   		$scope.addAlert('alert-warning',15000,'Error status : '+status)
	       });
	   }
	
	//------------------------------------------------------------------------

	//edit()------------------------------------------------------------------------
	
	$scope.editfunc= function(){
		if($scope.edit = true){
			$scope.del = false
			var params = {"title":$scope.e_title,"jobId":$scope.e_id,"type":$scope.e_type,"description":$scope.e_desc}
		    $http({
		       url: 'admin/job/update',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		   //chck success
		   		if (data['response']['severity']=='VALID'){
		   			$scope.alerts = []
		   			$scope.addAlert('alert-success',15000,'updated job')
		   			   
		   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
		   		   
		   	   }).
		       error(function(data, status) {
		    	   //chk error
		    	   $scope.alerts = []
		   			$scope.addAlert('alert-warning',15000,'Error status : '+ status)
		       });
		}
		if($scope.del = true){
			$scope.edit = false
			var params = {"title":$scope.e_title,"jobId":$scope.e_id,"type":$scope.e_type,"description":$scope.e_desc}
		    $http({
		       url: 'admin/job/delete',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		   //chck succecc
		   		if (data['response']['severity']=='VALID'){
		   			   $scope.alert.deletealert.type = 'alert-success'
		   			   $scope.alert.deletealert.time = 15000
		   			   $scope.alert.deletealert.msg = 'deleted job ' + title
		   			   $scope.e_title = ''
		   				   $scope.e_id = ''
		   				$scope.e_type =''
		   			   $scope.e_desc = ''
		   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
		   		   
		   	   }).
		       error(function(data,status) {
		    	   //chk error
		    	   $scope.alerts = []
		   			$scope.addAlert('alert-warning',15000,'Error status : '+status)
		       });
		}
	    
	   }
	//------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	$scope.openTab = function(){
		$scope.sub_tab = 'true'
	    var params = {}
	    $http({
	       url: 'admin/job/viewall',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		console.log(data)
	   		//{"response":{"severity":"VALID","message":"Job has been successfully created."},"id":"c2114dbe-426c-4277-bf88-cd9c49c4e7d2"}
	   		   if (data['response']['severity']=='VALID'){
	   			   //alert success
	   			$scope.all_data= []
	   			for(var itr in data['jobs']){
	   				$scope.all_data.push({id:itr['jobSettingsId'],title:itr['jobTitle'],type:itr['jobType'],description:itr['description']})
	   			}
	   			
	   		   }
	   	   }).
	       error(function(data,status) {
	    	   //create http error alert with status
	    	$scope.alerts = []
	   		$scope.addAlert('alert-warning',15000,'Error')
	       });
	   }
	//-------------------------------------------------------------------------------------------------
	$scope.stateChange = function(row){
		console.log(row)
		$scope.e_id = row.id
		$scope.e_title = row.title
		$scope.e_type = row.type
		$scope.e_desc = row.description
		$scope.sub_tab = 'false'
	}
	$scope.tabHide = function(){
		$scope.sub_tab = 'true'
			$scope.openTab()
	}
	
	$scope.closeAlert = function(index) {
	    parent.alerts.splice(index, 1);
	  };
  $scope.addAlert = function(a,b,c) {
	  console.log('here'+a+b+c)
	  parent.alerts = []
	  parent.alerts.push({type:a,time:b,msg:c})
	  console.log(parent.alerts)
	  };
});


mainApp.controller("contentController", function($scope, $http) {
	$scope.parent = {}
	$scope.id = ''
	$scope.type = ''
	$scope.content = ''	
	$scope.sub_tab = 'true'
		
	$scope.e_id = ''
	$scope.e_type = ''
	$scope.e_content = ''
	$scope.edit = ''
	$scope.del = ''
	
	parent.alerts = []
	
	$scope.all_data = [{id:'1',type:'abc',content:'xxxxxxx'},{id:'2',type:'csv',content:'yyyyyyyyy'}]
	
	//create()------------------------------------------------------------------------
	
	$scope.create = function(){
	    var params = {"contentId":$scope.id,"contentTypeName":$scope.type,"content":$scope.content}
	    $http({
	       url: 'admin/content/create',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		   console.log(data)
	   		//{"response":{"severity":"VALID","message":"Job has been successfully created."},"id":"c2114dbe-426c-4277-bf88-cd9c49c4e7d2"}
	   		   if (data['response']['severity']=='VALID'){
	   			$scope.alerts = []
	   			$scope.addAlert('alert-success',15000,'created new content')
	   			   
	   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
	   	   }).
	       error(function(data,status) {
	    	   $scope.alerts = []
	   		$scope.addAlert('alert-warning',15000,'Error status : '+status)
	       });
	   }
	
	//------------------------------------------------------------------------

	//edit()------------------------------------------------------------------------
	
	$scope.editfunc= function(){
		if($scope.edit = true){
			$scope.del = false
			var params = {"contentId":$scope.e_id,"contentTypeName":$scope.e_type,"content":$scope.e_content}
		    $http({
		       url: 'admin/content/update',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		   //chck success
		   		if (data['response']['severity']=='VALID'){
		   			$scope.alerts = []
		   			$scope.addAlert('alert-success',15000,'updated content')
		   			   
		   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
		   		   
		   	   }).
		       error(function(data, status) {
		    	   //chk error
		    	   $scope.alerts = []
		   			$scope.addAlert('alert-warning',15000,'Error status : '+ status)
		       });
		}
		if($scope.del = true){
			$scope.edit = false
			var params = {"contentId":$scope.e_id,"contentTypeName":$scope.e_type,"content":$scope.e_content}
		    $http({
		       url: 'admin/content/delete',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		   //chck succecc
		   		if (data['response']['severity']=='VALID'){
		   			   $scope.alert.deletealert.type = 'alert-success'
		   			   $scope.alert.deletealert.time = 15000
		   			   $scope.alert.deletealert.msg = 'deleted content id ' + e_id
		 
		   				   $scope.e_id = ''
		   				$scope.e_type =''
		   			   $scope.e_content = ''
		   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
		   		   
		   	   }).
		       error(function(data,status) {
		    	   //chk error
		    	   $scope.alerts = []
		   			$scope.addAlert('alert-warning',15000,'Error status : '+status)
		       });
		}
	    
	   }
	//------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	$scope.openTab = function(){
		$scope.sub_tab = 'true'
	    var params = {}
	    $http({
	       url: 'admin/content/viewall',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		console.log(data)
	   		//{"response":{"severity":"VALID","message":"Job has been successfully created."},"id":"c2114dbe-426c-4277-bf88-cd9c49c4e7d2"}
	   		   if (data['response']['severity']=='VALID'){
	   			   //alert success
	   			$scope.all_data= []
	   			for(var itr in data['contents']){
	   				$scope.all_data.push({id:itr['contentId'],type:itr['contentTypeName'],content:itr['content']})
	   			}
	   			
	   		   }
	   	   }).
	       error(function(data,status) {
	    	   //create http error alert with status
	    	$scope.alerts = []
	   		$scope.addAlert('alert-warning',15000,'Error')
	       });
	   }
	//-------------------------------------------------------------------------------------------------
	$scope.stateChange = function(row){
		console.log(row)
		$scope.e_id = row.id
		$scope.e_type = row.type
		$scope.e_content = row.content
		$scope.sub_tab = 'false'
	}
	$scope.tabHide = function(){
		$scope.sub_tab = 'true'
			$scope.openTab()
	}
	
	$scope.closeAlert = function(index) {
	    parent.alerts.splice(index, 1);
	  };
  $scope.addAlert = function(a,b,c) {
	  console.log('here'+a+b+c)
	  parent.alerts = []
	  parent.alerts.push({type:a,time:b,msg:c})
	  console.log(parent.alerts)
	  };
});


mainApp.controller("eventController", function($scope, $http, $log) {
	$scope.parent = {}
	$scope.id = ''
	$scope.eventName = ''
	$scope.eventDate = ''
	$scope.time = ''	
	$scope.desc = ''
	$scope.sub_tab = 'true'
	$scope.dt = ''
		
	$scope.e_id = ''
	$scope.e_eventName = ''
	$scope.e_eventDate = ''
	$scope.e_time = ''
	$scope.e_desc = ''
		
	$scope.edit = ''
	$scope.del = ''
	
	parent.alerts = []
	
	$scope.all_data = [{id:'1',name:'abc',date:'asdsad',time:'123123',description:'xxxxxxx'},
	                   {id:'134',name:'fdeee',date:'234324',time:'sdf',description:'ttttttt'}]
	//-----------
	//-----------

	//-----------

	$scope.mytime = new Date();

	  $scope.hstep = 1;
	  $scope.mstep = 1;

	  $scope.options = {
	    hstep: [1, 2, 3],
	    mstep: [1, 5, 10, 15, 25, 30]
	  };

	  $scope.ismeridian = true;
	  $scope.toggleMode = function() {
	    $scope.ismeridian = ! $scope.ismeridian;
	  };

	  $scope.update = function() {
	    var d = new Date();
	    d.setHours( 14 );
	    d.setMinutes( 0 );
	    $scope.mytime = d;
	  };

	  $scope.changed = function () {
	    $log.log('Time changed to: ' + $scope.mytime);
	  };

	  $scope.clear = function() {
	    $scope.mytime = null;
	  };
		//-----------

		//-----------

	//-------------
	//create()------------------------------------------------------------------------
	
	$scope.create = function(){
	    var params = {"eventId":$scope.id,"eventName":$scope.eventName,"eventDate":$scope.eventDate,"eventTime":$scope.time,"eventDescription":$scope.desc}
	    $http({
	       url: 'admin/event/create',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		//{"response":{"severity":"VALID","message":"Job has been successfully created."},"id":"c2114dbe-426c-4277-bf88-cd9c49c4e7d2"}
	   		   if (data['response']['severity']=='VALID'){
	   			$scope.alerts = []
	   			$scope.addAlert('alert-success',15000,'created new event')
	   			   
	   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
	   	   }).
	       error(function(data,status) {
	    	   $scope.alerts = []
	   		$scope.addAlert('alert-warning',15000,'Error status : '+status)
	       });
	   }
	
	//------------------------------------------------------------------------

	//edit()------------------------------------------------------------------------
	
	$scope.editfunc= function(){
		if($scope.edit = true){
			$scope.del = false
			var params = {"eventId":$scope.e_id,"eventName":$scope.e_eventName,"eventDate":$scope.e_eventDate,"eventTime":$scope.e_time,"eventDescription":$scope.e_desc}
		    $http({
		       url: 'admin/event/update',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		   //chck success
		   		if (data['response']['severity']=='VALID'){
		   			$scope.alerts = []
		   			$scope.addAlert('alert-success',15000,'updated events')
		   			   
		   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
		   		   
		   	   }).
		       error(function(data, status) {
		    	   //chk error
		    	   $scope.alerts = []
		   			$scope.addAlert('alert-warning',15000,'Error status : '+ status)
		       });
		}
		if($scope.del = true){
			$scope.edit = false
			var params = {"eventId":$scope.id,"eventName":$scope.eventName,"eventDate":$scope.eventDate,"eventTime":$scope.time,"eventDescription":$scope.desc}
		    $http({
		       url: 'admin/event/delete',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		   //chck succecc
		   		if (data['response']['severity']=='VALID'){
		   			   $scope.alert.deletealert.type = 'alert-success'
		   			   $scope.alert.deletealert.time = 15000
		   			   $scope.alert.deletealert.msg = 'deleted event id ' + e_id
		 
		   				   $scope.e_id = ''
		   				$scope.e_type =''
		   			   $scope.e_content = ''
		   		   }
	   		   else{
	   			$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	   		   }
		   		   
		   	   }).
		       error(function(data,status) {
		    	   //chk error
		    	   $scope.alerts = []
		   			$scope.addAlert('alert-warning',15000,'Error status : '+status)
		       });
		}
	    
	   }
	//------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	$scope.openTab = function(){
		$scope.sub_tab = 'true'
	    var params = {}
	    $http({
	       url: 'admin/content/viewall',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		//{"response":{"severity":"VALID","message":"Job has been successfully created."},"id":"c2114dbe-426c-4277-bf88-cd9c49c4e7d2"}
	   		   if (data['response']['severity']=='VALID'){
	   			   //alert success
	   			$scope.all_data= []
	   			for(var itr in data['events']){
	   				$scope.all_data.push({id:itr['eventId'],name:itr['eventName'],date:itr['eventDate'],time:itr['eventTime'],description:itr['eventDescription']})
	   			}
	   			
	   		   }
	   	   }).
	       error(function(data,status) {
	    	   //create http error alert with status
	    	$scope.alerts = []
	   		$scope.addAlert('alert-warning',15000,'Error')
	       });
	   }
	//-------------------------------------------------------------------------------------------------
	$scope.stateChange = function(row){
		console.log(row)
		$scope.e_id = row.id
		$scope.e_eventName = row.name
		$scope.e_eventDate = row.date
		$scope.e_time = row.time
		$scope.e_desc = row.description
		$scope.sub_tab = 'false'
	}
	$scope.tabHide = function(){
		$scope.sub_tab = 'true'
			$scope.openTab()
	}
	
	$scope.closeAlert = function(index) {
	    parent.alerts.splice(index, 1);
	  };
  $scope.addAlert = function(a,b,c) {
	  console.log('here'+a+b+c)
	  parent.alerts = []
	  parent.alerts.push({type:a,time:b,msg:c})
	  console.log(parent.alerts)
	  };
});
