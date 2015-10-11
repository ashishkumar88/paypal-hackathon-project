<section id="login" class="border-bottom2">
	<div class="container">
		<div class="row">
			<form action="login" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<table class="table-type-2">
					<tr>
						<td width="20%"><h5>Username</h5></td>
						<td><input type="text" placeholder="Username" name="username"
							required="required"/></td>
					</tr>
					<tr>
						<td width="20%"><h5>Password</h5></td>
						<td><input type="password" placeholder="Password"
							name="password" required="required"/></td>
					</tr>
					<tr>
						<td colspan="2" align="left"><input type="submit"
							value="Login" class="submit-button" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</section>