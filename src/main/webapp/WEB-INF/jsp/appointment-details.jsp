<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<c:url value="/css/app/home.css" var="appCss"/>
<link href="${appCss}" rel="stylesheet"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<html>
<body>
<h3>Welcom back, ${user.firstName}, ${user.lastName}. Below are your appointment details</h3>
<table>
    <tr>
        <td>Full Name:</td>
        <td>${user.firstName}, ${user.lastName}</td>
    </tr>
    <tr>
        <td>Confirmation Code:</td>
        <td>${user.appointment.confirmationCode}</td>
    </tr>
    <tr>
        <td>Appointment Date and Time:</td>
        <td>${user.appointment.appointmentDate}</td>
    </tr>
</table>
</body>

</html>