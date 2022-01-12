<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Distributed Systems Class Clicker</title>
</head>
<body>
<h1>Distributed Systems Class Clicker</h1><br/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%
    if (request.getAttribute("result") != null) {
%>
<%=request.getAttribute("result")%> <br>
<%}%><br>
Submit your answer to the current question:<br>
<form action="submit" method="POST">
    <p>
        <input type="radio" name="answer" value="A"/>A
        <br>
        <input type="radio" name="answer" value="B"/>B
        <br>
        <input type="radio" name="answer" value="C"/>C
        <br><input type="radio" name="answer" value="D"/>D
        <br>
        <br>
    </p>
    <input type="submit" value="Submit">
</form>
</body>
</html>