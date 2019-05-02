<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% String contextPath = request.getContextPath(); %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<c:url value="/css/app/home.css" var="appCss"/>
<link href="${appCss}" rel="stylesheet"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<html>
<body>
<c:if test="${not status}">
    <h3>${errorMessage}</h3>
    Please try again later !
</c:if>
<c:if test="${status}">
    <h3>Hi ${fullName}, your appointment has been successfully scheduled. Please note the confirmation code below</h3>
    <p><h3>Confirmation code: ${confirmationCode}</h3></p>
</c:if>
<a href="${contextPath}/welcome"> Home Page</a>
</body>

</html>