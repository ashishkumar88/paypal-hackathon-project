<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="contents" ng-controller="contentController">
	<div class="container">
		<div class="row">
			
			<uib-tabset>
			 <!-- TAB 1 -->
			    <uib-tab heading="Create Content" active="true">
			 <!-- CREATE TAB -->
			    	<form class="form-horizontal" ng-submit="create()" style="margin-top:2%">
					    <div class="col-lg-6">
					    	
					    	<div class="form-group">
						    	<label for="inputid" class="col-lg-2 control-label">Content Id</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="inputid" ng-model="id" placeholder="Content Id" ng-required="true">
						      	</div>
					    	</div>
					    	
						    <div class="form-group">
						    	<label for="contType" class="col-lg-2 control-label">Content Type</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="contType" ng-model="type" placeholder="Enter Content Type" ng-required="true">
						      	</div>
						    </div>
						</div>
						
						<div class="col-lg-6">
							<div class="form-group">
						    	<label for="inputCont" class="col-lg-2 control-label">Content</label>
						      	<div class="col-lg-10">
						        <textarea class="form-control" id="inputCont" ng-model="content" placeholder="Enter Content" ng-required="true" style="height:15%;"></textarea>
						      	</div>
					    	</div>
					    		<!-- <uib-alert ng-repeat="alert in alerts" type="{{alert.type}}" close="closeAlert($index)">{{alert.msg}}</uib-alert> -->
						</div>
							<div class="form-group">
						      	<div class="col-lg-10 col-lg-offset-2">
						        <button type="submit" class="btn btn-primary">Create Content</button><br><br>
						       	</div>
						       	
						    </div>		
					<!--  <uib-alert type="{{alert.type}}" ng-repeat="alert in parent.alerts" close="closeAlert($index)" dismiss-on-timeout={{alert.time}}>{{alert.msg}}</uib-alert>-->
					</form>
			 <!-- END CREATE TAB -->   	
			    </uib-tab>
			 <!-- END TAB1 -->
			 
			 <!-- TAB2 -->   	   
			    <uib-tab heading="Search and Edit Content" ng-click="openTab()">
			 <!-- SUB TAB1 -->   
			    		<form class="form-horizontal" ng-show="sub_tab=='true'">
						    <div class="table-responsive">
					    		<table class="table table-striped table-hover ">
					  				<thead>
					    				<tr>
									      <th class ="col-lg-3" >Content ID</th>
									      <th class ="col-lg-3">Content Type Name</th>
									      <th class ="col-lg-3">Content</th>
									      <th class ="col-lg-3">Select</th>
					    				</tr>
					  				</thead>
								</table>
								</div>
								<div class="table-responsive" style="max-height:300px;overflow-y: auto;">
					    		<table class="table table-striped table-hover ">
					  				
					  				<tbody>
									    <tr ng-repeat="itr in all_data">
									    	<td class ="col-lg-3">{{itr.id}}</td>
									    	
									    	<td class ="col-lg-3">{{itr.type}}</td>
									    	<td class ="col-lg-3">{{itr.content}}</td>
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
						      	<label for="editcID" class="col-lg-2 control-label">Content Id</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="editcID" ng-model="e_id" placeholder="Content ID" required="true" readonly="true">
						      	</div>
						    </div>
					
						    
						    
						    <div class="form-group">
						      	<label for="editcType" class="col-lg-2 control-label">Type</label>
						      	<div class="col-lg-10">
						        <input type="text" class="form-control" id="editcType" ng-model="e_type" placeholder="Content Type">
						      	</div>
						    </div>
						    
						    </div>
					
							<div class="col-lg-6">
							
							<div class="form-group">
					    		<label for="inputcDesc" class="col-lg-2 control-label">Content</label>
					      		<div class="col-lg-10">
					        	<textarea class="form-control" id="inputcDesc" ng-model="e_content" placeholder="Enter Content" ng-required="true" style="height:15%;"></textarea>
					      	</div>
							
							<br><br>
						    <div class="form-group" style="margin-top:3%">
						      	<div class="col-lg-2 col-lg-offset-2">
						        <button type="submit" ng-click="edit=true" class="btn btn-primary">Edit Content</button><br><br>
						        </div>
						        
						        <div class="col-lg-2">
						        <button type="submit" ng-click="del=true" class="btn btn-primary">Delete Content</button><br><br>
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