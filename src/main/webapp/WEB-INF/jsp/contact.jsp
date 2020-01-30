<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<c:url value="/static/js/contact.js" var="contact"/>
<script src="${contact}"></script>
<script>
    $(document).ready(function () {
        buildTable();
        insertLists();
        deleteModal();
    })
</script>

<div class="container">
    <h2>Contact List</h2>

    <button onclick="insertContactEmail()" class="btn btn-default" style="margin-top: 10px; margin-bottom: 10px;">Add New Email</button>
    <button onclick="insertContactPhone()" class="btn btn-default" style="margin-top: 10px; margin-bottom: 10px; margin-left: 10px;">Add New Phone</button>
    <table id="contact-table" class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Person</th>
            <th>Type</th>
            <th>Details</th>
            <th>Contact</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    <div id="contactEmailModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Email Details</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <fieldset>
                            <hidden id="contactId"/>
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
                                <label for="inputElement" class="col-lg-2 control-label">Type</label>
                                <div class="col-lg-10">
                                    <select class="form-control selectElement" id="inputElement">
                                        <option selected value="0">(Select Type)</option>
                                        <option  value="6">Work</option>
                                        <option  value="7">Personal</option>
                                        <option  value="8">Delegated</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                                </div>
                            </div>

                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveContactEmail()">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <div id="contactPhoneModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Phone Details</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <fieldset>
                            <hidden id="contactId"/>
                            <hidden id="version"/>

                            <div class="form-group">
                                <label for="inputPersonPhone" class="col-lg-2 control-label">Employee</label>
                                <div class="col-lg-10" id="personListHereToo">
                                    <select class="form-control selectPerson" id="inputPersonPhone">
                                        <option selected value="0">(Select Employee)</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputElementPhone" class="col-lg-2 control-label">Type</label>
                                <div class="col-lg-10">
                                    <select class="form-control selectElement" id="inputElementPhone">
                                        <option selected value="0">(Select Type)</option>
                                        <option value="9">Home</option>
                                        <option value="10">Work</option>
                                        <option value="11">Cell</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputPhone" class="col-lg-2 control-label">Phone</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputPhone" placeholder="Phone">
                                </div>
                            </div>

                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveContactPhone()">Save changes</button>
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
                    <p>Are you sure you want to delete this Contact? This cannot be undone!</p>
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