/**
 * 
 */

let probabilityCheck = function() {
	let nameRegex = /^\d+(.\d*)?$/;
	if (!document.form.propability.value.match(nameRegex)) {
		if (alert("Probability can't be empty and must contain Number Only")) {
			document.form.propability.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}
let employeeIdCheck = function() {
	let nameRegex =/^\d{1,10}$/;
	if (!document.form.employeeId.value.match(nameRegex)) {
		if (alert("SellerId can't be empty and must contain Number Only")) {
			document.form.employeeId.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}