<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
<style>
text-error {
	color: #e80c4d;
	font-size: 0.9em;
}
</style>
<script type="text/javascript">
	//  jsLessons/pageJ.html
	//  jsLessons/pageK.html
	var companyNameCheck = function() {
		var nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.companyName.value.match(nameRegex)) {
			if (alert("Company Name can't be empty and must contain only alphabets")) {
				document.form.companyName.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	var contactPersonCheck = function() {
		var nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.contactPerson.value.match(nameRegex)) {
			if (alert("Contact Person can't be empty and must contain only alphabets")) {
				document.form.contactPerson.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	var contactPersonRoleCheck = function() {
		var nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.contactPersonRole.value.match(nameRegex)) {
			if (alert("Contact Person Role can't be empty and must contain only alphabets")) {
				document.form.contactPersonRole.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	var contactPersonPhoneCheck = function() {
		var nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.contactPersonPhone.value.match(nameRegex)) {
			if (alert("Contact Person Role can't be empty and must contain only alphabets")) {
				document.form.contactPersonPhone.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	var accountTypeCheck = function() {
		var nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.accountType.value.match(nameRegex)) {
			if (alert("Contact Person Role can't be empty and must contain only alphabets")) {
				document.form.accountType.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	var addressCheck1 = function() {
		var nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.address.value.match(nameRegex)) {
			if (alert("Contact Person Role can't be empty and must contain only alphabets")) {
				document.form.address.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	var leadThroughChannelCheck = function() {
		var nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.leadThroughChannel.value.match(nameRegex)) {
			if (alert("Contact Person Role can't be empty and must contain only alphabets")) {
				document.form.leadThroughChannel.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}

	var emailCheck = function() {
		var nameRegex = new RegExp("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		if (!document.form.email.value.match(nameRegex)) {
			if (alert("Email not in the correct format")) {
				document.form.email.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}

	var passwordCheck = function() {
		var nameRegex = new RegExp(
				"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
		if (!document.form.password.value.match(nameRegex)) {
			if (alert("Password must begin with letter and contain atleast one number and must have atleast 8 characters")) {
				document.form.password.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	var contactPersonPhoneCheck = function() {
		var nameRegex = new RegExp("[0-9]{10}");
		if (!document.form.contactPersonPhone.value.match(nameRegex)) {
			if (alert("Phone number must have 10 digits")) {
				document.form.contactPersonPhone.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}
	}
	var addressCheck = function() {
		if (document.form.address.value == "") {
			if (alert("Address cannot be blank")) {
				document.form.address.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}
	}
</script>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="addaccount" method="post"
				modelAttribute="addAccount" name="form">

				<div>
					<label for="companyName">Company Name</label>
					<div>
						<form:input placeholder="Enter Comapany Name" path="companyName"
							name="companyName" onchange="validate()"
							pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
							title="Please enter only character in CompanyName"
							required="true" onblur="companyNameCheck()" />
					</div>
				</div>
				<div>
					<label for="contactPerson">Contact Person</label>
					<div>
						<form:input placeholder="Enter Your Contact Person"
							path="contactPerson" name="contactPerson" onchange="validate()"
							pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
							title="Please enter only character in Contactperson"
							required="true" onblur="contactPersonCheck()" />
					</div>
				</div>
				<div>
					<label for="contactPersonRole">Contact Person Role</label>
					<div>
						<form:input placeholder="Enter Your Contact Person Role"
							path="contactPersonRole" name="contactPersonRole"
							onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
							title="Please enter only character in Contact Person Role"
							required="true" onblur="contactPersonRoleCheck()" />
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" placeholder="Enter Your Email"
							onchange="validate()" name="email"
							pattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\d.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
							title="Please Enter Valid Email" required="true"
							onblur="emailCheck()" />
					</div>
				</div>
				<div>
					<label for="contactPersonPhone">Contact Person Phone</label>
					<div>
						<form:input placeholder="Enter Your Contact Person Phone Number"
							path="contactPersonPhone" onchange="validate()"
							pattern="^[0-9]+{10}$" name="contactPersonPhone"
							title="Please Enter Phone Number" required="true"
							onblur="contactPersonPhoneCheck()" />
					</div>
				</div>
				<div>
					<label for="address">Address</label>
					<div>
						<form:input placeholder="Enter Your Address" path="address"
							name="address" onchange="validate()"
							title="Please Enter valid Address" required="true"
							onblur="addressCheck()" />
					</div>
				</div>
				<div>
					<label for="accountType">Account Type</label>
					<div>
						<form:input placeholder="Enter Your Account Type"
							path="accountType" name="accountType" onchange="validate()"
							pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
							title="Please enter only character in Account Type"
							required="true" onblur="accountTypeCheck()" />
					</div>
				</div>
				<div>
					<label for="employeeId">Market Id</label>
					<div>
						<form:input placeholder="Enter Your Market Id" path="employeeId"
							name="employeeId" onchange="validate()" pattern="^[0-9]+$"
							title="Please Enter Only Number In marketer Id" required="true"
							readonly="true" />
					</div>
				</div>
				<div>
					<label for="leadThroughChannel">Lead Though Channel</label>
					<div>
						<form:input placeholder="Enter Your Lead Though Channel"
							path="leadThroughChannel" onchange="validate()"
							name="leadThroughChannel" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
							title="Please enter only character in Channel"
							onblur="leadThroughChannelCheck()" />
					</div>
				</div>
				<div>
					<label for="customerJoinDate">Customer Join Date</label>
					<div>
						<form:input type="date" placeholder="Enter Your Joining Date"
							path="customerJoinDate" readonly="true" required="true"
							name="customerJoinDate" onblur="companyNameCheck()" />
					</div>
				</div>
				<div>
					<label for="territoryId">Territory Name : </label>
					<form:select path="territoryId">
						<c:forEach var="allTerritory" items="${allTerritory}">
							<form:option value="${allTerritory.territoryId}"
								label="${allTerritory.territoryName}" />
						</c:forEach>
					</form:select>
				</div>
				<div>
					<form:button id="button">Add New</form:button>
				</div>
			</form:form>
		</div>
	</div>

	<div>${result}</div>

</body>
</html>