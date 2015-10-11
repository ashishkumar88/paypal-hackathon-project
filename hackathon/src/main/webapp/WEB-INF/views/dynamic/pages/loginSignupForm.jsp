<section id="login" class="border-bottom2" style="padding-top: 20px;" ng-controller="loginController">
	<div class="container">
		<div class="row">
			<uib-tabset> <uib-tab heading="Login" active="true">
			<br>
			<form ng-submit="login()" >
				<input type="hidden" name="${_csrf.parameterName}" ng-model="${_csrf.parameterName}"
					value="${_csrf.token}" />
				
				<input type="hidden" ng-model="formData.type" value="login"/>
				<table class="table-type-2">
					<tr>
						<td width="20%"><h5>Username(Email ID)</h5></td>
						<td><input type="email" placeholder="Username(Email ID)" name="emailId" ng-model="formData.emailId"
							required="required" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>Password</h5></td>
						<td><input type="password" placeholder="Password" ng-model="formData.password"
							name="password" required="required" /></td>
					</tr>
					<tr>
						<td colspan="2" align="left"><input type="submit"
							value="Login" class="submit-button" /></td>
					</tr>
				</table>
			</form>
			</uib-tab> <uib-tab heading="Sign-Up"> <br>
			<form ng-submit="signup()" >
				<input type="hidden" ng-model="formData.type" value="signup"/>
				<table class="table-type-2">
					<tr>
						<td width="20%"><h5>First Name</h5></td>
						<td><input type="text" placeholder="First Name" ng-model="formData.firstName"
							name="firstName" required="required" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>Middle Name</h5></td>
						<td><input type="text" placeholder="Middle Name" ng-model="formData.middleName"
							name="middleName" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>Last Name</h5></td>
						<td><input type="text" placeholder="Last Name" ng-model="formData.lastName"
							name="lastName" required="required" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>Gender</h5></td>
						<td><input type="radio" name="gender" ng-model="formData.gender" value="M" >Male&nbsp;<input
							type="radio" name="gender" ng-model="formData.gender" value="F">Female&nbsp;<input
							type="radio" name="gender" ng-model="formData.gender" value="D">Don't Want To
							Specify&nbsp;</td>
					</tr>
					<tr>
						<td width="20%"><h5>Address 1</h5></td>
						<td><input type="text" placeholder="Address 1" ng-model="formData.address1"
							name="address1" required="required" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>Address 2</h5></td>
						<td><input type="text" placeholder="Address 2" ng-model="formData.address2"
							name="address2" required="required" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>City</h5></td>
						<td><input type="text" placeholder="City" name="city" ng-model="formData.city"
							required="required" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>State</h5></td>
						<td><select name="stateCode" required="required" ng-model="formData.stateCode">
								<option value="AL">Alabama</option>
								<option value="AK">Alaska</option>
								<option value="AZ">Arizona</option>
								<option value="AR">Arkansas</option>
								<option value="CA">California</option>
								<option value="CO">Colorado</option>
								<option value="CT">Connecticut</option>
								<option value="DE">Delaware</option>
								<option value="DC">District Of Columbia</option>
								<option value="FL">Florida</option>
								<option value="GA">Georgia</option>
								<option value="HI">Hawaii</option>
								<option value="ID">Idaho</option>
								<option value="IL">Illinois</option>
								<option value="IN">Indiana</option>
								<option value="IA">Iowa</option>
								<option value="KS">Kansas</option>
								<option value="KY">Kentucky</option>
								<option value="LA">Louisiana</option>
								<option value="ME">Maine</option>
								<option value="MD">Maryland</option>
								<option value="MA">Massachusetts</option>
								<option value="MI">Michigan</option>
								<option value="MN">Minnesota</option>
								<option value="MS">Mississippi</option>
								<option value="MO">Missouri</option>
								<option value="MT">Montana</option>
								<option value="NE">Nebraska</option>
								<option value="NV">Nevada</option>
								<option value="NH">New Hampshire</option>
								<option value="NJ">New Jersey</option>
								<option value="NM">New Mexico</option>
								<option value="NY">New York</option>
								<option value="NC">North Carolina</option>
								<option value="ND">North Dakota</option>
								<option value="OH">Ohio</option>
								<option value="OK">Oklahoma</option>
								<option value="OR">Oregon</option>
								<option value="PA">Pennsylvania</option>
								<option value="RI">Rhode Island</option>
								<option value="SC">South Carolina</option>
								<option value="SD">South Dakota</option>
								<option value="TN">Tennessee</option>
								<option value="TX">Texas</option>
								<option value="UT">Utah</option>
								<option value="VT">Vermont</option>
								<option value="VA">Virginia</option>
								<option value="WA">Washington</option>
								<option value="WV">West Virginia</option>
								<option value="WI">Wisconsin</option>
								<option value="WY">Wyoming</option>
						</select></td>
					</tr>
					<tr>
						<td width="20%"><h5>Zip Code</h5></td>
						<td><input type="text" placeholder="Zip Code" ng-model="formData.zipCode"
							name="zipCode" required="required" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>Email</h5></td>
						<td><input type="email" placeholder="Email" ng-model="formData.email"
							name="email" required="required" /></td>
					</tr>
					<tr>
						<td width="20%"><h5>Password</h5></td>
						<td><input type="password" placeholder="Password" ng-model="formData.password"
							name="password" required="required" /></td>
					</tr>
					<tr>
						<td colspan="2" align="left"><input type="submit"
							value="Sign Up" class="submit-button" /></td>
					</tr>
				</table>
			</form>
			</uib-tab> </uib-tabset>
		</div>
	</div>
</section>