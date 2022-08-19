/**
 * 
 */
let amountCheck = function() {
	let nameRegex = new RegExp("^[0-9]+(.[0-9]*)?$");
	if (!document.form.amount.value.match(nameRegex)) {
		if (alert("Amount can't be empty and must contain Number Only")) {
			document.form.amount.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}
let employeeIdCheck = function() {
	let nameRegex = new RegExp("^[0-9]{1,10}$");
	if (!document.form.employeeId.value.match(nameRegex)) {
		if (alert("SellerId can't be empty and must contain Number Only")) {
			document.form.employeeId.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}