<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>

<script>
    $(document).ready(function() {
        $('.remove_button').click(function(){
            console.log(this.name);
            window.location = '/admin/vehicle/delete/' + this.name;
        });
    });
</script>
<div class="wrapper">
    <%@ include file="vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">
            <c:set var="idx" value="0" scope="page" />
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>License Plate</th>
                    <th>VIN</th>
                    <th>Year</th>
                    <th>Color</th>
                    <th>Purchase Price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
            <form:form cssClass="form-horizontal testClass" modelAttribute="vehicleVO" action="" method="post">
                <fieldset>
                    <c:forEach var="vehicle" items="${vehicleList}">
                        <tr>
                            <form:hidden path="pageId" value="${idx}"/>
                            <td>${vehicle.id}</td>
                            <td>
                                <form:select name="selectMake" class="form-control" path="newVehicleMake">
                                    <c:forEach var="vehicleMake" items="${makeList}">
                                        <c:choose>
                                            <c:when test="${vehicle.vehicleModel.vehicleMake.id == vehicleMake.id}">
                                                <option selected value="${vehicleMake.id}">${vehicleMake.vehicleMakeName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${vehicleMake.id}">${vehicleMake.vehicleMakeName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select name="selectModel" class="form-control" path="newVehicleModel">
                                    <c:forEach var="vehicleModel" items="${modelList}">
                                        <c:choose>
                                            <c:when test="${vehicle.vehicleModel.id == vehicleModel.id}">
                                                <option selected value="${vehicleModel.id}">${vehicleModel.vehicleModelName}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${vehicleModel.id}">${vehicleModel.vehicleModelName}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td><form:input path="newLicensePlate" cssClass="form-control" id="inputNewLicensePlate" value="${vehicle.licensePlate}"/></td>
                            <td><form:input path="newVIN" cssClass="form-control" id="inputNewVIN" value="${vehicle.VIN}"/></td>
                            <td><form:input path="newYear" type="text" cssClass="form-control" id="inputNewYear" value="${vehicle.year}"/></td>
                            <td><form:input path="newColor" type="text" cssClass="form-control" id="inputNewColor" value="${vehicle.color}"/></td>
                            <td><form:input path="newPurchasePrice" type="text" cssClass="form-control" id="inputNewPurchasePrice"  value="${vehicle.purchasePrice}"/></td>
                            <td>
                                <form:button class="btn btn-secondary remove_button" type="button" name="${vehicle.id}">
                                    Delete
                                </form:button>
                            </td>
                        </tr>
                        <c:set var="idx" value="${idx + 1}" scope="page" />
                    </c:forEach>
                </fieldset>
                </tbody>
            </table>
            <form:button class="btn btn-primary update_button col-sm-3" name="${vehicle.id}" style="margin-bottom: 40px;">
                Update
            </form:button>
            </form:form>

        </div>
    </div>

</div>

<%@ include file="../../includes/footer.jsp" %>