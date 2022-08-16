/**
 * 
 */
var managerCommentCheck = function() {
	var nameRegex = new RegExp("^[a-zA-z\s]+$");
	if (!document.form.managerComment.value.match(nameRegex)) {
		if (alert("Company Name can't be empty and must contain only alphabets")) {
			document.form.managerComment.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}
var employeeIdCheck = function() {
	var nameRegex = new RegExp("^[0-9]{1,10}$");
	if (!document.form.employeeId.value.match(nameRegex)) {
		if (alert("Empllyee ID can't be empty and must contain Number Only")) {
			document.form.employeeId.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}
var plannedTargetCheck = function() {
	var nameRegex = new RegExp("^[0-9]{1,10}$");
	if (!document.form.plannedTarget.value.match(nameRegex)) {
		if (alert("planned Target can't be empty and must contain Number Only")) {
			document.form.plannedTarget.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}