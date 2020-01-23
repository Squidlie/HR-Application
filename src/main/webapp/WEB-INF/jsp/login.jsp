<%@include file="./includes/header.jsp" %>

<div class="container blueBackground">
    <div class="col-sm-6">
        <img src="https://s3-us-west-2.amazonaws.com/aston-public-data/public_images/logos/aston-technologies-logo.svg">
    </div>
    <br/>
    <div class="col-sm-4">
        <form action="<c:url value='/login.do'/>" id="form" method="post">

            <c:if test="${not empty param.err}">
                <div class="msg-container error text-green">
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                </div>
            </c:if>
            <c:if test="${not empty param.out}">
                <div class="msg-container logout text-green">
                    You've logged out successfully.
                </div>
            </c:if>
            <c:if test="${not empty param.time}">
                <div class="msg-container time text-green">
                    You've been logged out due to inactivity.
                </div>
            </c:if>

            <span class="text-bold">Username:</span>
            <input type="text" name="username" value="" class="form-control"/>
            <br><br>
            <span class="text-bold">Password:</span>
            <input type="password" name="password" value="" class="form-control"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br/>
            <br/>

            <input value="Login" name="submit" type="submit" class="btn btn-default"/>

        </form>
    </div>

</div>