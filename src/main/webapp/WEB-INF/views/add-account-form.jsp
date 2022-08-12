<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
<style>
text-error {
    color: #e80c4d;
    font-size: 0.9em;
}
</style>
</head>
<script type="text/javascript">
function validate(){
	  var phoneNumber = document.getElementById('contactPersonPhone').value;
	  var companyName = document.getElementById('companyName').value;
	  var contactPersonRole = document.getElementById('contactPersonRole').value;
	  var contactPerson = document.getElementById('contactPerson').value;
	  var email = document.getElementById('email').value;
	  var address = document.getElementById('address').value;
	  var employeeId = document.getElementById('employeeId').value;
	  var accountType = document.getElementById('accountType').value;
	  var leadThroughChannel = document.getElementById('leadThroughChannel').value;
	  var customerJoinDate = document.getElementById('customerJoinDate').value;
	  var territoryId = document.getElementById('territoryId').value;
	  
	  var numberRGEX=^[0-9]+$;
	  var phoneRGEX = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;
	  var StringRGEX =^[a-zA-Z]+(\s[a-zA-Z]+)?$;
	  var emailRGEX=^(?=.{1,64}@)[A-Za-z0-9_-]+(\\d.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$;  
	  var addressRGEX=\d{1,5}\s\w.\s(\b\w*\b\s){1,2}\w*\.;
	  
	  var companyResult=StringRGEX.test(companyName);
	  var roleResult=StringRGEX.test(contactPersonRole);
	  var personResult=StringRGEX.test(contactPerson);
	  var accountTypeResult=StringRGEX.test(accountType);
	  var channelResult=StringRGEX.test(leadThroughChannel);
	  var phoneResult = phoneRGEX.test(phoneNumber);
	  var idResult = numberRGEX.test(territoryId);
	  var emailResult = emailRGEX.test(email);
	  
	  if(phoneResult == false)
	  {
	    alert('Please enter a valid phone number');
	    return false;
	  }

	  else  if(companyResult == false)
	  {
	    alert('Please enter only character in CompanyName');
	    return false;
	  } 
	  else if(roleResult == false)
		  {
		    alert('Please enter  only character in PersonRole');
		    return false;
		  } 
	  else if(personResult == false)
		  {
		    alert('Please enter only character in PersonName');
		    return false;
		  } 
	  else if(accountTypeResult == false)
		  {
		    alert('Please enter only character in AccountType');
		    return false;
		  } 
	  else if(channelResult == false)
		  {
		    alert('Please enter  only character in Channel');
		    return false;
		  }
	  else if(idResult == false)
		  {
		    alert('Please enter only number in territoryId');
		    return false;
		  }
	  else if(emailResult == false)
		  {
		    alert('Please enter a valid Email');
		    return false;
		  }
	  else{
		  
	  }
	  return true;
	}
    </script>

<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addaccount" method="post" modelAttribute="addAccount">
				
				<div>
					<label for="companyName">Company Name</label>
					<div>
						<form:input placeholder="Enter Comapany Name" path="companyName" 
					onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in CompanyName"/>
					</div>
				</div>
				<div>
					<label for="contactPerson">Contact Person</label>
					<div>
						<form:input placeholder="Enter Your Contact Person" path="contactPerson" 
					onchange="validate()"	pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Contactperson"/>
					</div>
				</div>
				<div>
					<label for="contactPersonRole">Contact Person Role</label>
					<div>
						<form:input placeholder="Enter Your Contact Person Role" path="contactPersonRole" 
						onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Contact Person Role"/>
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" placeholder="Enter Your Email" onchange="validate()"
						pattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\d.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
						title="Please Enter Valid Email"/>
					</div>
				</div>
				<div>
					<label for="contactPersonPhone">Contact Person Phone</label>
					<div>
						<form:input placeholder="Enter Your Contact Person Phone Number" path="contactPersonPhone" 
						onchange="validate()" pattern="/^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/" 
						title="Please Enter Phone Number"/>
					</div>
				</div>
				<div>
					<label for="address">Address</label>
					<div>
						<form:input placeholder="Enter Your Address" path="address" 
					onchange="validate()"	pattern="\d{1,5}\s\w.\s(\b\w*\b\s){1,2}\w*\."
					title="Please Enter valid Address"/>
					</div>
				</div>
				<div>
					<label for="accountType">Account Type</label>
					<div>
						<form:input placeholder="Enter Your Account Type" path="accountType" 
					onchange="validate()"	pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Account Type"/>
					</div>
				</div>
				<div>
					<label for="employeeId">Market Id</label>
					<div>
						<form:input placeholder="Enter Your Market Id" path="employeeId" 
					onchange="validate()"	pattern="^[0-9]+$" title="Please Enter Only Number In marketer Id"/>
					</div>
				</div>
				<div>
					<label for="leadThroughChannel">Lead Though Channel</label>
					<div>
						<form:input placeholder="Enter Your Lead Though Channel" path="leadThroughChannel" onchange="validate()"
						pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Channel"/>
					</div>
				</div>
				<div>
					<label for="customerJoinDate">Customer Join Date</label>
					<div>
						<form:input type="date" placeholder="Enter Your Joining Date" path="customerJoinDate" />
					</div>
				</div>
				<div>
				<label for="territoryId">Territory Name : </label> <form:select
                                path="territoryId">
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