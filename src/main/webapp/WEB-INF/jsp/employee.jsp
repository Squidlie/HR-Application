<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<c:url value="/static/js/employee.js" var="employee"/>
<script src="${employee}"></script>
<script>
    $(document).ready(function () {
        buildTable();
        deleteModal();
    })
</script>

<div class="container">
    <h2>Employee List</h2>

    <button onclick="insertEmployee()" class="btn btn-default" style="margin-top: 10px; margin-bottom: 10px;">Add New Employee</button>
    <table id="employee-table" class="table table-striped table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Background</th>
                <th>Projects</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    <div id="employeeModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Employee Details</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <fieldset>
                            <hidden id="employeeId"/>
                            <hidden id="version"/>
                            <div class="form-group">
                                <label for="inputFirstName" class="col-lg-2 control-label">First Name</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputFirstName" placeholder="First Name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputLastName" class="col-lg-2 control-label">Last Name</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputLastName" placeholder="Last Name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputBackground" class="col-lg-2 control-label">Background</label>
                                <div class="col-lg-10">
                                    <textarea class="form-control" rows="3" id="inputBackground"></textarea>
                                </div>
                            </div>

                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveEmployee()" >Save changes</button>
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
                    <p>Are you sure you want to delete this Employee? This cannot be undone!</p>
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