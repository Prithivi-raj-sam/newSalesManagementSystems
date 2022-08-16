/**
 * 
 */
var territoryNameCheck = function() {
	var nameRegex = new RegExp("^[a-zA-z\s]+$");
	if (!document.form.territoryName.value.match(nameRegex)) {
		if (alert("Company Name can't be empty and must contain only alphabets")) {
			document.form.territoryName.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}

var customerCountCheck = function() {
	var nameRegex = new RegExp("^[0-9]+$");
	if (!document.form.noOfCustomer.value.match(nameRegex)) {
		if (alert("Customer count can't be empty and must contain only alphabets")) {
			document.form.noOfCustomer.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}