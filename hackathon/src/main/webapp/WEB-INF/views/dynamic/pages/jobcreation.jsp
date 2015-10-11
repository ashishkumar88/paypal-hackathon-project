<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section id="jobs"  class="border-bottom3" ng-controller="jobController">
	<div class="container">
		<div class="row">
		
			 <uib-tabset>
			 <!-- TAB 1 -->
			    <uib-tab heading="Add Job" active="true">
			 <!-- CREATE TAB -->
			    	<form class="form-horizontal" ng-submit="create()" style="margin-top:2%">
					    <div class="col-lg-6">
					    	
					    	<div class="form-group">
						    	<label for="inputTitle" class="col-lg-2 control-label">Title</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputTitle" ng-model="title" placeholder="Title" ng-required="true">
						      	</div>
					    	</div>
					    	
						    <div class="form-group">
						    	<label for="inputType" class="col-lg-2 control-label">Type</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputType" ng-model="type" placeholder="Enter Job Type" ng-required="true">
						      	</div>
						    </div>
						</div>
						
						<div class="col-lg-6">
							<div class="form-group">
						    	<label for="inputDesc" class="col-lg-2 control-label">Description</label>
						      	<div class="col-lg-10">
						        <textarea class="form-control" id="inputDesc" ng-model="desc" placeholder="Enter Description" ng-required="true" style="height:15%;"></textarea>
						      	</div>
					    	</div>
					    		<!-- <uib-alert ng-repeat="alert in alerts" type="{{alert.type}}" close="closeAlert($index)">{{alert.msg}}</uib-alert> -->
						</div>
							<div class="form-group">
						      	<div class="col-lg-10 col-lg-offset-2">
						        <button type="submit" class="btn btn-primary">Add Job</button><br><br>
						       	</div>
						       	
						    </div>		
					<!--  <uib-alert type="{{alert.type}}" ng-repeat="alert in parent.alerts" close="closeAlert($index)" dismiss-on-timeout={{alert.time}}>{{alert.msg}}</uib-alert>-->
					</form>
			 <!-- END CREATE TAB -->   	
			    </uib-tab>
			 <!-- END TAB1 -->
			 
			 <!-- TAB2 -->   	   
			    <uib-tab heading="Search and Edit Jobs">
			 <!-- SUB TAB1 -->   
			    		<form class="form-horizontal" ng-show="sub_tab=='true'">
						    <div class="table-responsive">
					    		<table class="table table-striped table-hover ">
					  				<thead>
					    				<tr>
									      <th  class ="col-lg-3">ID</th>
									      <th  class ="col-lg-3">Type</th>
									      <th class ="col-lg-3">Title</th>
									      <th  class ="col-lg-3">Description</th>
									      <th  class ="col-lg-3">Select</th>
					    				</tr>
					  				</thead>
								</table>
								</div>
								<div class="table-responsive" style="max-height:300px;overflow-y: auto;">
					    		<table class="table table-striped table-hover ">
					  				
					  				<tbody>
									    <tr ng-repeat="itr in all_data">
									    	<td class ="col-lg-3">{{itr.id}}</td>
									    	<td class ="col-lg-3">{{itr.title}}</td>
									    	<td class ="col-lg-3">{{itr.type}}</td>
									    	<td class ="col-lg-3">{{itr.description}}</td>
									    	<td><input class="padded" name="group" type="radio" ng-model='parent.radio' value="{{itr}}" ng-click="stateChange(itr)"> </td>
										</tr>
					  				</tbody>
								</table>
								
							</div>
						</form>
			   <!-- SUB TAB1 END --> 		
			    		
			   <!-- SUB TAB2 -->
			    		<form class="form-horizontal" ng-submit="editfunc()" ng-click="openTab()" ng-show="sub_tab=='false'" style = "margin-top:2%">
			    			
			    			<div class="col-lg-5">
						    <div class="form-group">
						      	<label for="editID" class="col-lg-2 control-label">ID</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="editID" ng-model="e_id" placeholder="ID" required="true" readonly="true">
						      	</div>
						    </div>
					
						    <div class="form-group">
						      	<label for="editTitle" class="col-lg-2 control-label">Title</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="editTitle" ng-model="e_title" placeholder="Title">
						      	</div>
						    </div>
						    
						    <div class="form-group">
						      	<label for="editType" class="col-lg-2 control-label">Type</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="editType" ng-model="e_type" placeholder="Type">
						      	</div>
						    </div>
						    
						    </div>
					
							<div class="col-lg-6">
							
							<div class="form-group">
					    		<label for="inputDesc" class="col-lg-2 control-label">Description</label>
					      		<div class="col-lg-10">
					        	<textarea class="form-control" id="inputDesc" ng-model="e_desc" placeholder="Enter Description" ng-required="true" style="height:15%;"></textarea>
					      	</div>
							
							<br><br>
						    <div class="form-group" style="margin-top:3%">
						      	<div class="col-lg-2 col-lg-offset-2">
						        <button type="submit" ng-click="edit=true" class="btn btn-primary">Edit Job</button><br><br>
						        </div>
						        
						        <div class="col-lg-2 col-lg-offset-2">
						        <button type="submit" ng-click="del=true" class="btn btn-primary">Delete Job</button><br><br>
						        </div>
						    </div>
						    
						    <div class="form-group">
						      	<div class="col-lg-2">
						        <button type="button"  class="btn btn-success" ng-click='tabHide()'>Back to ViewAll</button><br><br>
						        </div>
						    </div>
						    
					  		<!--<alert ng-repeat="alert in alerts" type="{{alert.type}}" close="closeAlert($index)">{{alert.msg}}</alert> -->
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