<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>

<script>
    $(document).ready(function(){
        $("#successAlert").delay(6000).fadeOut(2000);
        $("#warningAlert").delay(8000).fadeOut(2000);
    });
</script>

<div class="wrapper">

    <%@ include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                <fieldset>
                    <legend>Vehicle Management</legend>
                    <div class="form-group">
                        <label for="inputNewVehicleMake" class="col-lg-2 control-label">Make</label>
                        <div class="col-lg-10">
                            <form:select path="newVehicleMake" cssClass="form-control" id="inputNewVehicleMake">
                                <option value="0">(Select Make)</option>
                                <c:forEach var="vehicleMake" items="${makeList}">
                                    <option value="${vehicleMake.vehicleMakeName}">${vehicleMake.vehicleMakeName}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                    <label for="inputNewVehicleMake" class="col-lg-2 control-label">Model</label>
                        <div class="col-lg-10">
                            <form:select path="newVehicleModel" cssClass="form-control" id="inputNewVehicleModel">
                                <option value="0">(Select Model)</option>
                                <c:forEach var="vehicleModel" items="${modelList}">
                                    <option value="${vehicleModel.vehicleModelName}">${vehicleModel.vehicleModelName}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewLicensePlate" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="newLicensePlate" cssClass="form-control" id="inputNewLicensePlate" placeholder="License Plate"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewYear" class="col-lg-2 control-label">Year</label>
                        <div class="col-lg-10">
                            <form:input path="newYear" type="text" cssClass="form-control" id="inputNewYear" value="2020"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVIN" class="col-lg-2 control-label">VIN</label>
                        <div class="col-lg-10">
                            <form:input path="newVIN" type="text" cssClass="form-control" id="inputNewVIN" placeholder="VIN"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewColor" class="col-lg-2 control-label">Color</label>
                        <div class="col-lg-10">
                            <form:input path="newColor" type="text" cssClass="form-control" id="inputNewColor" placeholder="Color"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewPurchasePrice" class="col-lg-2 control-label">Purchase Price</label>
                        <div class="col-lg-10">
                            <form:input path="newPurchasePrice" type="text" cssClass="form-control" id="inputNewPurchasePrice"></form:input>
                        </div>

                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>
                </fieldset>
            </form:form>

        </div>
        <div class="col-sm-4">
            <div class="${successAlert == null ? "hidden" : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Vehicle successfully added to the database!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>
            <div class="${warningAlert == null ? "hidden" : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>All fields required. Please enter a Vehicle and associated Attributes. <a href="#" class="alert-link">Link</a>.</p>
                </div>
            </div>
            <div class="${errorAlert == null ? "hidden" : errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
                </div>
            </div>
        </div>

    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>