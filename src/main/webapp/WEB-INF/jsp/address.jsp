<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<c:url value="/static/js/address.js" var="address"/>
<script src="${address}"></script>
<script>
    $(document).ready(function () {
        buildTable();
        insertPersonSelect();
        deleteModal();
    })
</script>

<div class="container">
    <h2>Address List</h2>

    <button onclick="insertAddress()" class="btn btn-default" style="margin-top: 10px; margin-bottom: 10px;">Add New Address</button>
    <table id="address-table" class="table table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Number</th>
            <th>Street</th>
            <th>State</th>
            <th>Country</th>
            <th>Person</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    <div id="addressModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Address Details</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <fieldset>
                            <hidden id="addressId"/>
                            <hidden id="version"/>

                            <div class="form-group">
                                <label for="inputPerson" class="col-lg-2 control-label">Employee</label>
                                <div class="col-lg-10" id="personListHere">
                                    <select class="form-control selectPerson" id="inputPerson">
                                        <option selected value="0">(Select Employee)</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputNumber" class="col-lg-2 control-label">Address</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputNumber" placeholder="Address">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputStreet" class="col-lg-2 control-label">Street</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputStreet" placeholder="Street">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputCity" class="col-lg-2 control-label">City</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputCity" placeholder="City">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputState" class="col-lg-2 control-label">State</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputState" placeholder="State">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputCountry" class="col-lg-2 control-label">Country</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputCountry" placeholder="Country">
                                </div>
                            </div>

                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveAddress()">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <div id="confirmDeleteModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Confirm Delete?</h4>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete this Address? This cannot be undone!</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-danger btn-ok" data-dismiss="modal" id="confirmDelete" >Confirm</button>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="includes/footer.jsp" %>