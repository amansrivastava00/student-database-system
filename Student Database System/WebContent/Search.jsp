<%@page import="studentService.StudentServiceimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Search</title>
<script>
	function searchdata(a) {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			document.getElementById("res").innerHTML = xmlhttp.responseText;
		}

		xmlhttp.open("POST", "ViewServlet?q="+a,true);
		xmlhttp.send();

	}
</script>
</head>
<body>
	<%
		String str = request.getParameter("q") + "%";
		StudentServiceimpl service = new StudentServiceimpl();
		String name = service.showStudentsLike(str);
	%>
	<tr>
		<td><%=name%></td>
	</tr>
</body>
</html>