/**
 * 
 */
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