/**
 * 
 */
let employeeNameCheck = function() {
		let nameRegex = `^[a-zA-z\s]+$`;
		if (!document.form.employeeName.value.match(nameRegex)) {
			if (alert("Employee Name can't be empty and must contain only alphabets")) {
				document.form.employeeName.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	
	let emailCheck = function() {
		let nameRegex = `^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$`;
		if (!document.form.email.value.match(nameRegex)) {
			if (alert("Email not in the correct format")) {
				document.form.email.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}

	let passwordCheck = function() {
		let nameRegex = `^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$`;
		if (!document.form.password.value.match(nameRegex)) {
			if (alert("Password must begin with letter and contain atleast one number and must have atleast 8 characters")) {
				document.form.password.focus();
			} else
				document.activeElement.blur();
		} else {
			return false;
		}

	}
	let employeePhoneCheck = function() {
		let nameRegex =/^\d{10}$/;
		if (!document.form.employeePhone.value.match(nameRegex)) {
			if (alert("Phone number must have 10 digits")) {
				document.form.employeePhone.focus();
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