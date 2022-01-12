<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--References
    1. https://stackoverflow.com/questions/4587397/how-to-use-if-else-option-in-jstl
    2. https://stackoverflow.com/questions/1835683/how-to-loop-through-a-hashmap-in-jsp --%>

<!DOCTYPE html>
<html>
<head>
    <title>Distributed Systems Class Clicker</title>
</head>
<body>
<h1>Distributed Systems Class Clicker</h1>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:choose>
    <%-- If there are no answers, display no submissions message --%>
    <%--@elvariable id="totalCount" type="int"--%>
    <c:when test="${totalCount == 0}">
        <h3>There are currently no submissions</h3>
    </c:when>
    <c:otherwise>
        <h3>The results from the survey are as follows:</h3>
        <%--@elvariable id="answerMap" type="Map<String, Integer>"--%>
        <c:forEach items="${answerMap}" var="answer">
            ${answer.key}: ${answer.value}<br>
        </c:forEach>
    </c:otherwise>
</c:choose>

</body>
</html>
