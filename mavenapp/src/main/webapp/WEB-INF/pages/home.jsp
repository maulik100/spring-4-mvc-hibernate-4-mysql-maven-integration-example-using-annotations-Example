<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         <link rel="stylesheet" href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href=" https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
       <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src=" https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
         <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
    <link rel="stylesheet" href=" https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href=" https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
       <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src=" https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
         <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script>
    $(document).ready(function() {
    $('#example').DataTable();
} );
</script>
</head>
<body>
	
		<h1 align="center">Show Database</h1>
		
			<h3> <a href="new1">New Sign-up</a></h3>
		
		<hr/>
		
		 <table id="example" class="table table-striped table-bordered" width="100%" cellspacing="0">
       
			 <thead>

			<th> Id</th>
			<th> Name</th>
			<th> Password</th>
			<th> Email</th>
			<th> Address</th>
			<th> Telephone</th>
			<th> Profile Pic</th>
			<th> Action</th>
			
			</thead>
			<tbody>
			
			<c:forEach var="emp" items="${list}">
			<tr>
			
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.password}</td>
					<td>${emp.email}</td>
					<td>${emp.address}</td>
					<td>${emp.telephone}</td>
					<td>${emp.profile_pic}</td>
					
					<td style="width: 160px;">
					<a class = "btn btn-info" href="editData?id=${emp.id}">Edit</a>&nbsp;&nbsp;&nbsp;
					<a class = "btn btn-danger" href="deleteData?id=${emp.id}" onclick="return confirm('Are You Sure??');">Delete</a>
                
					</td>
					
			</tr>
			</c:forEach>
			</tbody>
		</table>
		

</body>
</html>