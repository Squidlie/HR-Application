<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
    <%@ include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-md-10">
        <div class="col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Make</th>
                    <th>Vehicle Model</th>
                    <th>License Plate</th>
                    <th>VIN</th>
                    <th>Year</th>
                    <th>Color</th>
                    <th>Purchase Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicle" items="${vehicleList}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.vehicleModel.vehicleMake.vehicleMakeName}</td>
                        <td>${vehicle.vehicleModel.vehicleModelName}</td>
                        <td>${vehicle.licensePlate}</td>
                        <td>${vehicle.VIN}</td>
                        <td>${vehicle.year}</td>
                        <td>${vehicle.color}</td>
                        <td>${vehicle.purchasePrice}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<%@ include file="../../includes/footer.jsp" %>