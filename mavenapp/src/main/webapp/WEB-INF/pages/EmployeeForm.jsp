<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah')
                .attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}</script>
<style type="text/css">
img{
  max-width:190px;
  height:190px;
  margin-top:7px;
}
input{
    margin-top:20px;
}</style>
</head>
<body>
    <div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveEmployee" method="post" modelAttribute="emp">
        <table >
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"  /></td>
            </tr>
            
              <tr>
                <td>Password:</td>
                <td><form:input path="password"  /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><form:input path="telephone" /></td>
            </tr>
             <tr>
                <td>profile_pic:</td>
                <td><form:input type="file" path="profile_pic" onchange="readURL(this);" /></td>
               
            </tr>
            <tr>
            <td></td>
             <td>	<img id="blah" src="" alt="your image" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit"  value="Save"></td>
            </tr>
            
            <tr>
            <td colspan="2" align="center">
            <br/><a href="login">Login Now<a></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>