<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="bg-primary" id="events">
	<div class="container">
		<div class="row">
			<uib-tabset>
				<uib-tab heading="Register For Events" active="true">
					<div class="table-responsive">
					    		<table class="table table-striped table-hover ">
					  				<thead>
					    				<tr>
									      <th  class ="col-lg-3">Type</th>
									      <th class ="col-lg-3">Title</th>
									      <th  class ="col-lg-3">Description</th>
									      <th  class ="col-lg-3">Register</th>
					    				</tr>
					  				</thead>
					  				
					  				<tbody>
									    <tr ng-repeat="itr in event_data">
									    	<td class ="col-lg-3">{{itr.type}}</td>
									    	<td class ="col-lg-3">{{itr.title}}</td>
									    	<td class ="col-lg-3">{{itr.desc}}</td>
									    	<td class ="col-lg-3"><button class="btn btn-default btn-md">Register</button> </td>
										</tr>
					  				</tbody>
								</table>
								
							</div>
    			</uib-tab>
    			<uib-tab heading="Back To School" active="true">
    			<div class='col-lg-10 col-lg-offset-1 text-center' style='margin-top:10px;'>
    				<p >As we approach the end of the school year, many parents begin to worry about where next years school supplies will come from. You can help be a part of reducing the stress and preparing kids to go back to school ready to learn.
						Chandler Christian Community Center works diligently to ensure that as many children as possible receive the necessary items to go back to school prepped with supplies, a smile and an excited attitude.  This is done in partnership with the Operation Back to School Chandler program, which does the distribution of items in a combined event designed to reach as many children as possible from all over Chandler.
						Donations and sponsors are needed for Chandler’s annual citywide drive to supply disadvantaged students with backpacks, school supplies, shoes, socks, underwear and uniforms.
						Now in its third year, Operation Back to School Chandler helps hundreds of Chandler families who struggle to provide basic school supplies for their children each year.
						We need your help to make this year an even greater outreach.  Every backpack, school supply, and financial donation you make helps us reach more children.  You can drop off donations at CCCC.
						All checks / money orders should be made out to Chandler Christian Community Center and mailed to:
						Chandler Christian Community Center,PO Box 591Chandler, AZ 85244-0591.</p>

				</div>
    			</uib-tab>
    			<uib-tab heading="Operation">
    			<div class='col-lg-10 col-lg-offset-1 text-center' style='margin-top:10px;'><p>
    			Operation Santa provides toys and gifts to children in need in our community.  In addition, the Adopt-a-Family program matches donor groups with families in need to provide gifts such as toys or clothes for the children, basic household items for the family, grocery gift cards, or food for a holiday meal.  In 2012, our program expanded to include children in the Gilbert community, as well as Chandler, which meant more children.  In 2013 we served over 2000 children, yet we work collaboratively with other organizations to cross-check the names of all individuals registered to eliminate duplication of services, which allows us to reach more children.
    			</p></div>
    			</uib-tab>
    			<uib-tab heading="Senior Center Activities">
    			<div class='col-lg-10 col-lg-offset-1 text-center' style='margin-top:10px;'><p>
    			---------------------------
    			</p></div>
    			</uib-tab>
    			<uib-tab heading="A Walk In The Park">
    			<div class='col-lg-10 col-lg-offset-1 text-center' style='margin-top:10px;'><p>
    			---------------------------
    			</p></div>
    			</uib-tab>
  			</uib-tabset>
		</div>
	</div>
</section>