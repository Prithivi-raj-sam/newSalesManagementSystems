/**
 * 
 */
let companyNameCheck = function() {
		let nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.companyName.value.match(nameRegex)) {
			if (alert("Company Name can't be empty and must contain only alphabets")) {
				document.form.companyName.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	let contactPersonCheck = function() {
		let nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.contactPerson.value.match(nameRegex)) {
			if (alert("Contact Person can't be empty and must contain only alphabets")) {
				document.form.contactPerson.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	let contactPersonRoleCheck = function() {
		let nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.contactPersonRole.value.match(nameRegex)) {
			if (alert("Contact Person Role can't be empty and must contain only alphabets")) {
				document.form.contactPersonRole.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	let accountTypeCheck = function() {
		let nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.accountType.value.match(nameRegex)) {
			if (alert("Contact Person Role can't be empty and must contain only alphabets")) {
				document.form.accountType.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	let leadThroughChannelCheck = function() {
		let nameRegex = new RegExp("^[a-zA-z\s]+$");
		if (!document.form.leadThroughChannel.value.match(nameRegex)) {
			if (alert("Contact Person Role can't be empty and must contain only alphabets")) {
				document.form.leadThroughChannel.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}

	let emailCheck = function() {
		let nameRegex = new RegExp("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		if (!document.form.email.value.match(nameRegex)) {
			if (alert("Email not in the correct format")) {
				document.form.email.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}

	let contactPersonPhoneCheck = function() {
		let nameRegex = new RegExp("[0-9]{10}");
		if (!document.form.contactPersonPhone.value.match(nameRegex)) {
			if (alert("Phone number must have 10 digits")) {
				document.form.contactPersonPhone.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}
	}
	let addressCheck = function() {
		if (document.form.address.value == "") {
			if (alert("Address cannot be blank")) {
				document.form.address.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}
	}