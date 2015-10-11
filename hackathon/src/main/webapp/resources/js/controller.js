mainApp.controller("mainController", function($scope, $http) {
	$scope.event_data = [{type:"Donation",title:"Back To School",desc:"donate to operation back to school chandler"}]
});

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
			"emailId" : $scope.formData.email,
			"mobileNumber" : $scope.formData.mobileNumber,
			"password" : $scope.formData.password,
			"zipCode" : $scope.formData.zipCode,
		};
	    $http({
	    	url: 'login-user/register',
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
	    	url: 'login-user/process',
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
	$scope.parent.title = ''
	$scope.parent.type = ''
	$scope.parent.desc = ''
	$scope.sub_tab = 'true'
	$scope.parent.e_id = ''
	$scope.parent.e_title = ''
	$scope.parent.e_type = ''
	$scope.parent.e_desc = ''
	$scope.parent.edit = ''
	$scope.parent.del = ''
	
	$scope.all_data = []
	
	$scope.create = function() {
	    var params = {"title":$scope.parent.title,"type":$scope.parent.type,"description":$scope.parent.desc}
	    $http({
	       url: 'admin/job/create',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		   if(data) {}
	   		   else {}
	   	   }).
	       error(function(data,status) {
	       });
	   }
	
	$scope.editfunc = function() {
		console.log('wwww')
		if($scope.parent.edit == true) {
			console.log('qwwqe')
			$scope.parent.del = false
			var params = {"title":$scope.parent.e_title,"jobId":$scope.parent.e_id,"type":$scope.parent.e_type,"description":$scope.parent.e_desc}
		    $http({
		       url: 'admin/job/update',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		if(data) {}
		   		else {}
		   		   
		   	   }).
		       error(function(data, status) {
		       });
		}
		if($scope.parent.del == true){
			$scope.parent.edit = false
			console.log('s')
			var params = {"title":$scope.parent.e_title,"jobId":$scope.parent.e_id,"type":$scope.parent.e_type,"description":$scope.parent.e_desc}
			   $http({
		       url: 'admin/job/delete',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		if (data){
		   			$scope.parent.e_title = ''
		   			$scope.parent.e_id = ''
		   			$scope.parent.e_type =''
		   			$scope.parent.e_desc = ''
		   		   }
	   		   else{}
		   	   }).
		       error(function(data,status) {
		       });
		}    
	   }
	
	$scope.openTab = function() {
		$scope.sub_tab = 'true'
	    var params = {}
	    $http({
	       url: 'admin/job/viewall',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		   if (data){
	   			   $scope.all_data= []
	   			   for(var itr in data['jobs']){
	   				   $scope.all_data.push({id:data['jobs'][itr]['jobSettingsId'],title:data['jobs'][itr]['jobTitle'],type:data['jobs'][itr]['jobType'],description:data['jobs'][itr]['description']})
	   			   }   			
	   		   }
	   	   }).
	       error(function(data,status) {
	    	   	$scope.alerts = []
	   			$scope.addAlert('alert-warning',15000,'Error')
	       });
	   }

	$scope.stateChange = function(row){
		$scope.parent.e_id = row.id
		$scope.parent.e_title = row.title
		$scope.parent.e_type = row.type
		$scope.parent.e_desc = row.description
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
	  };
});


mainApp.controller("contentController", function($scope, $http) {
	$scope.parent = {}
	$scope.parent.id = ''
	$scope.parent.type = ''
	$scope.parent.content = ''	
	$scope.sub_tab = 'true'
		
	$scope.parent.e_id = ''
	$scope.parent.e_type = ''
	$scope.parent.e_content = ''
	$scope.parent.edit = ''
	$scope.parent.del = ''
	
	$scope.parent.alerts = []
	
	$scope.all_data = []
	
	$scope.create = function(){
	    var params = {"contentId":$scope.parent.id,"contentTypeName":$scope.parent.type,"content":$scope.parent.content}
	    $http({
	       url: 'admin/content/create',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		   if (data){}
	   		   else{}
	   	   }).
	       error(function(data,status) {
	    	   
	       });
	   }
	
	$scope.editfunc= function(){
		if($scope.parent.edit == true){
			$scope.parent.del = false
			var params = {"contentId":$scope.parent.e_id,"contentTypeName":$scope.parent.e_type,"content":$scope.parent.e_content}
		    $http({
		       url: 'admin/content/update',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		if (data['response']['severity']=='VALID'){}
	   		   else{}
		   		   
		   	   }).
		       error(function(data, status){
		       });
		}
		if($scope.parent.del == true){
			$scope.parent.edit = false
			var params = {"contentId":$scope.parent.e_id,"contentTypeName":$scope.parent.e_type,"content":$scope.parent.e_content}
		    $http({
		       url: 'admin/content/delete',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		if (data['response']['severity']=='VALID'){
		   			$scope.parent.e_id = ''
		   			$scope.parent.e_type =''
		   			$scope.parent.e_content = ''
		   		   }
	   		   else{}
		   		   
		   	   }).
		       error(function(data,status) {
		       });
		}
	   }
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
	   		   if (data){
	   			$scope.all_data= []
	   			for(var itr in data['contents']){
	   				$scope.all_data.push({id:data['contents'][itr]['contentId'],type:data['contents'][itr]['contentTypeName'],content:data['contents'][itr]['content']})
	   			}
	   		   }
	   	   }).
	       error(function(data,status) {
	    	$scope.alerts = []
	   		$scope.addAlert('alert-warning',15000,'Error')
	       });
	   }
	$scope.stateChange = function(row){
		$scope.parent.e_id = row.id
		$scope.parent.e_type = row.type
		$scope.parent.e_content = row.content
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
	  };
});


mainApp.controller("eventController", function($scope, $http, $log) {
	$scope.parent = {}
	$scope.parent.id = ''
	$scope.parent.eventName = ''
	$scope.parent.eventDate = ''
	$scope.parent.time = ''	
	$scope.parent.desc = ''
	$scope.sub_tab = 'true'
	$scope.parent.dt = ''
		
	$scope.parent.e_id = ''
	$scope.parent.e_eventName = ''
	$scope.parent.e_eventDate = ''
	$scope.parent.e_time = ''
	$scope.parent.e_desc = ''
		
	$scope.parent.edit = ''
	$scope.parent.del = ''
	
	parent.alerts = []
	
	$scope.all_data = []

	$scope.parent.mytime = new Date();

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
	    $scope.parent.mytime = d;
	  };

	  $scope.changed = function () {
	    $log.log('Time changed to: ' + $scope.parent.mytime);
	  };

	  $scope.clear = function() {
	    $scope.parent.mytime = null;
	  };
	
	$scope.create = function(){
	    var params = {"eventId":$scope.parent.id,"eventName":$scope.parent.eventName,"eventDate":String($scope.parent.dt),"eventTime":String($scope.parent.mytime),"eventDescription":$scope.parent.desc}
	    console.log(params)
	    $http({
	       url: 'admin/event/create',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		   console.log(data)
	   		   if(data) {}
	   		   else{}
	   	   }).
	       error(function(data,status) {
	       });
	   }
	
	$scope.editfunc= function() {
		if($scope.edit == true) {
			$scope.del = false
			var params = {"eventId":$scope.parent.e_id,"eventName":$scope.parent.e_eventName,"eventDate":$scope.parent.e_eventDate,"eventTime":$scope.parent.e_time,"eventDescription":$scope.parent.e_desc}
		    $http({
		       url: 'admin/event/update',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		if (data){}
	   		   else{}
		   	   }).
		       error(function(data, status) {
		       });
		}
		if($scope.del == true){
			$scope.edit = false
			var params = {"eventId":$scope.parent.id,"eventName":$scope.parent.eventName,"eventDate":$scope.parent.eventDate,"eventTime":$scope.parent.time,"eventDescription":$scope.parent.desc}
		    $http({
		       url: 'admin/event/delete',
		       method: "POST",
		       data: params,
		       headers: {'Content-Type': 'application/json'}
		       }).
		   	   success(function(data) {
		   		if (data['response']['severity']=='VALID'){
		   				$scope.e_id = ''
		   				$scope.e_type =''
		   				$scope.e_content = ''
		   		   }
	   		   else{}
		   	   }).
		       error(function(data,status) {
		       });
		}
	   }
	
	$scope.openTab = function(){
		$scope.sub_tab = 'true'
	    var params = {}
	    $http({
	       url: 'admin/event/viewall',
	       method: "POST",
	       data: params,
	       headers: {'Content-Type': 'application/json'}
	       }).
	   	   success(function(data) {
	   		   console.log(data)
	   		   if (data){
	   			$scope.all_data= []
	   			for(var itr in data['events']){
	   				$scope.all_data.push({id:data['events'][itr]['eventId'],name:data['events'][itr]['eventName'],date:data['events'][itr]['eventDate'],time:data['events'][itr]['eventTime'],description:data['events'][itr]['eventDescription']})
	   			}	   			
	   		   }
	   	   }).
	       error(function(data,status) {
	       });
	   }
	
	$scope.stateChange = function(row) {
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
	  parent.alerts = []
	  parent.alerts.push({type:a,time:b,msg:c})
	  };
});
