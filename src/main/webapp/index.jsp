<!DOCTYPE>
<html>
<head></head>
<body>
<ul>
<li><a href="restful-services/sampleService/hello">GET Text Response</a></li>
<li><a href="restful-services/sampleService/employees">GET XML Response</a></li>
<li><a href="restful-services/sampleService/json/employees/">GET JSON Response</a></li>
<li><a href="restful-services/sampleService/employee/111">GET XML Response By Id</a></li>
<li><a href="restful-services/sampleService/json/employee/222">GET JSON Response By Id</a></li>
</ul>

<h1>Below is POST example</h1>
<form action="restful-services/sampleService/postEmployee" method="post">
Enter Id:<input type="text" name="id"/><br/><br/>
Enter Name:<input type="text" name="name"/><br/><br/>  
Enter Job:<input type="text" name="job"/><br/><br/>
<input type="submit" value="Post Employee">
</form>
<h3>------------</h3>
<form action="restful-services/sampleService/postJsonEmployeeResponse" method="post">
Enter Id:<input type="text" name="id"/><br/><br/>
Enter Name:<input type="text" name="name"/><br/><br/>  
Enter Job:<input type="text" name="job"/><br/><br/>
<input type="submit" value="Post Json Employee Response">
</form>
<h3>------------</h3>
<form action="restful-services/sampleService/postXMLEmployeeResponse" method="post">
Enter Id:<input type="text" name="id"/><br/><br/>
Enter Name:<input type="text" name="name"/><br/><br/>  
Enter Job:<input type="text" name="job"/><br/><br/>
<input type="submit" value="Post XML Employee Response">
</form>
<h3>------------</h3>

<form name="employeeForm">
Enter Id:<input type="text" name="id" id="jsonId"/><br/><br/>
Enter Name:<input type="text" name="name" id="jsonName"/><br/><br/>  
Enter Job:<input type="text" name="job" id="jsonJob"/><br/><br/>
<input type="button" value="Consume Json Request" onclick="submitJsonRequest()">
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
function submitJsonRequest(){
	var empId = document.getElementById("jsonId").value;
	var empName = document.getElementById("jsonName").value;
	var empJob = document.getElementById("jsonJob").value;
	
	$.ajax({
        type: "POST",
        url: "restful-services/sampleService/postForConsumeJSONRequest", 
        contentType: "application/json",
        data: JSON.stringify({"employee":{"employeeId":empId,"employeeName":empName,"employeeJob":empJob}}),
        dataType: "json",
        success: function(response){
            for(var i in response){
            	alert("Employee Id ==  "+response[i].employeeId);
            	alert("Employee Name ==  "+response[i].employeeName);
            	alert("Employee Job ==   "+response[i].employeeJob);
            }
        }
  });
};
	
</script>

</body>
</html>
