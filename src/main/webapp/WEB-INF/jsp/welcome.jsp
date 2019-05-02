<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String contextPath = request.getContextPath(); %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<c:url value="/css/app/home.css" var="jstlCss"/>
<link href="${jstlCss}" rel="stylesheet"/>
<c:url value="/js/app/welcome.js" var="jstlJs"/>
<script src="${jstlJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<div class="page left">
    <div class="centered">
        <h3>Schedule an Appointment</h3>
        <form:form method="post" commandName="user" action="${pageContext.request.contextPath}/appointment/create">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><form:input path="firstName" type="text" id="firstName" placeholder="First Name"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName" type="text" id="lastName" placeholder="Last Name"/></td>
                </tr>
                <tr>
                    <td>Date of Birth</td>
                    <td><form:input path="dob" type="text" id="dob" placeholder="mm/dd/yyyy"/></td>
                </tr>
                <tr>
                    <td>Appointment Date & Time</td>
                    <td><form:input path="appointment.appointmentDate" type="text" id="appointmentDate"
                                    placeholder="mm/dd/yyyy"/></td>
                    <td><form:input path="appointment.appointmentTime" type="text" id="appointmentTime"
                                    placeholder="HH - 24 Hour Format"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
<div class="page right">
    <div class="centered">
        <h3>Scheduled Appointment Details</h3>
        <form:form method="get" commandName="appointment" action="${pageContext.request.contextPath}/appointment/get">
            <tr>
                <td>Confirmation Code</td>
                <td><form:input path="confirmationCode" type="text" id="confirmationCode"
                                placeholder="Confirmation Code"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </form:form>
    </div>
</div>
<div style="clear:both"></div>


