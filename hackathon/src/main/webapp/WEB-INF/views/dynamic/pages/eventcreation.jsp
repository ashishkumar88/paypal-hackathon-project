<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="events" ng-controller="eventController">
	<div class="container">
		<div class="row">
			<uib-tabset>
			 <!-- TAB 1 -->
			    <uib-tab heading="Create Event" active="true">
			 <!-- CREATE TAB -->
			    	<form class="form-horizontal" ng-submit="create()" style="margin-top:2%">
					    <div class="col-lg-6">
					    	
					    	<div class="form-group">
						    	<label for="inputeID" class="col-lg-2 control-label">Event Id</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputeID" ng-model="id" placeholder="Event Id" ng-required="true">
						      	</div>
					    	</div>
					    	
						    <div class="form-group">
						    	<label for="inputeName" class="col-lg-2 control-label">Event Name</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputeName" ng-model="eventName" placeholder="Enter Event Name" ng-required="true">
						      	</div>
						    </div>
						    
						    <div class="form-group">
						    	<label for="inputeDesc" class="col-lg-2 control-label">Event Description</label>
						      	<div class="col-lg-10">
						        <textarea class="form-control" id="inputeDesc" ng-model="desc" placeholder="Enter Description" ng-required="true" style="height:15%;"></textarea>
						      	</div>
					    	</div>
					    	
					    	<div class="form-group">
						    	<label for="inputeTime" class="col-lg-2 control-label">Event time</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputeTime" ng-model="time" ng-value="mytime | date:'shortTime'" placeholder="Select Time" ng-required="true" readonly="true">
						      	</div>
						    </div>
					    	<div class="col-lg-offset-2">
					    	<uib-timepicker ng-model="mytime" ng-change="changed()" hour-step="hstep" minute-step="mstep" show-meridian="ismeridian"></uib-timepicker>
					    	</div>
						</div>
						
						<div class="col-lg-6">
							
					    		<!-- <uib-alert ng-repeat="alert in alerts" type="{{alert.type}}" close="closeAlert($index)">{{alert.msg}}</uib-alert> -->
					    		<div class="form-group">
						    	<label for="inputeDate" class="col-lg-2 control-label">Event Date</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputeDate" ng-model=eventDate ng-value="dt| date:'fullDate'" placeholder="Enter Event Name" ng-required="true" readonly="true">
						      	</div>
						    	</div>
							    <div class="col-lg-offset-3" style="display:inline-block; min-height:290px;">
							      <uib-datepicker ng-model="dt" min-date="minDate" show-weeks="true" class="well well-sm" custom-class="getDayClass(date, mode)"></uib-datepicker>
							    </div>
						</div>
							<div class="form-group">
						      	<div class="col-lg-10 col-lg-offset-2">
						        <button type="submit" class="btn btn-primary">Create Event</button><br><br>
						       	</div>
						       	
						    </div>		
					<!--  <uib-alert type="{{alert.type}}" ng-repeat="alert in parent.alerts" close="closeAlert($index)" dismiss-on-timeout={{alert.time}}>{{alert.msg}}</uib-alert>-->
					</form>
			 <!-- END CREATE TAB -->   	
			    </uib-tab>
			 <!-- END TAB1 -->
			 
			 <!-- TAB2 -->   	   
			    <uib-tab heading="Search and Edit Events" ng-click="openTab()">
			 <!-- SUB TAB1 -->   
			    		<form class="form-horizontal" ng-show="sub_tab=='true'">
						    <div class="table-responsive">
					    		<table class="table table-striped table-hover ">
					  				<thead>
					    				<tr>
									      <th class ="col-lg-3">Event Id</th>
									      <th  class ="col-lg-3">Event Name</th>
									      <th class ="col-lg-3">Event Date</th>
									      <th  class ="col-lg-3">Event Time</th>
									      <th  class ="col-lg-3">Event Description</th>
					    				</tr>
					  				</thead>
								</table>
								</div>
								<div class="table-responsive" style="max-height:300px;overflow-y: auto;">
					    		<table class="table table-striped table-hover ">
					  				
					  				<tbody>
									    <tr ng-repeat="itr in all_data">
									    	<td class ="col-lg-3">{{itr.id}}</td>
									    	<td class ="col-lg-3">{{itr.name}}</td>
									    	<td class ="col-lg-3">{{itr.date}}</td>
									    	<td class ="col-lg-3">{{itr.time}}</td>
									    	<td class ="col-lg-3">{{itr.description}}</td>
									    	<td class ="col-lg-3"><input class="padded" name="group" type="radio" ng-model='parent.radio' value="{{itr}}" ng-click="stateChange(itr)"> </td>
										</tr>
					  				</tbody>
								</table>
								
							</div>
						</form>
			   <!-- SUB TAB1 END --> 		
			    		
			   <!-- SUB TAB2 -->
			    		<form class="form-horizontal" ng-submit="editfunc()"  ng-show="sub_tab=='false'" style = "margin-top:2%">
			    			
			    			<div class="col-lg-5">
						    <div class="form-group">
						      	<label for="editxID" class="col-lg-2 control-label">Event Id</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="editxID" ng-model="e_id" placeholder="ID" required="true" readonly="true">
						      	</div>
						    </div>
					
						    <div class="form-group">
						      	<label for="editxTitle" class="col-lg-2 control-label">Event Name</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="editxTitle" ng-model="e_eventName" placeholder="Event Name">
						      	</div>
						    </div>
						    
						    <div class="form-group">
						    	<label for="inputexDesc" class="col-lg-2 control-label">Event Description</label>
						      	<div class="col-lg-10">
						        <textarea class="form-control" id="inputexDesc" ng-model="e_desc" placeholder="Enter Description" ng-required="true" style="height:15%;"></textarea>
						      	</div>
					    	</div>
					    	
					    	<div class="form-group">
						    	<label for="inputexTime" class="col-lg-2 control-label">Event time</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputexTime" ng-model="e_time" ng-value="mytime | date:'shortTime'" placeholder="Select Time" ng-required="true" readonly="true">
						      	</div>
						    </div>
					    	<div class="col-lg-offset-2">
					    	<uib-timepicker ng-model="mytime" ng-change="changed()" hour-step="hstep" minute-step="mstep" show-meridian="ismeridian"></uib-timepicker>
					    	</div>
						    
						    </div>
					
							<div class="col-lg-6">
							
							<div class="form-group">
						    	<label for="inputeDate" class="col-lg-2 control-label">Event Date</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputeDate" ng-model="e_eventDate" ng-value="dt| date:'fullDate'" placeholder="Enter Event Name" ng-required="true" readonly="true">
						      	</div>
						    	</div>
							    <div class="col-lg-offset-3" style="display:inline-block; min-height:290px;">
							      <uib-datepicker ng-model="dt" min-date="minDate" show-weeks="true" class="well well-sm" custom-class="getDayClass(date, mode)"></uib-datepicker>
							    </div>
								
								<div class="form-group" style="margin-top:3%">
						      	<div class="col-lg-2 col-lg-offset-2">
						        <button type="submit" ng-click="edit=true" class="btn btn-primary">Edit Event</button><br><br>
						        </div>
						        
						        <div class="col-lg-2 col-lg-offset-2">
						        <button type="submit" ng-click="del=true" class="btn btn-primary">Delete Event</button><br><br>
						        </div>
						    </div>
						    
						    <div class="form-group">
						      	<div class="col-lg-2">
						        <button type="button"  class="btn btn-success" ng-click='tabHide()'>Back to ViewAll</button><br><br>
						        </div>
						    </div>
						    
							
							</div>
						</form>
				<!-- SUB TAB2 END -->
			    </uib-tab>
			   <!-- TAB2 END -->
			 </uib-tabset>
		</div>
	</div>
</section>