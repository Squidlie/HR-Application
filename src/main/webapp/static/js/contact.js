function buildTable() {
    $.getJSON("/api/contact/", {
        ajax: 'true'
    }, function (data) {
        $.each(data, function(index, single) {
            var fullName = single.person.firstName + " " + single.person.lastName;
            if(single.element.id > 5 && single.element.id < 9){
                $('#contact-table').find('tbody')
                    .append(
                        "<tr class='active'>" +
                        "<td>" + single.id + "</td>" +
                        "<td>" + fullName + "</td>" +
                        "<td>Email</td>" +
                        "<td>" + single.element.elementName + "</td>" +
                        "<td>" + single.emailAddress + "</td>" +
                        "<td>" + "<button class='btn btn-primary' onclick='editContact(" + single.id + ")'>Edit</button>" + "</td>" +
                        "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='" + single.id + "' class='btn btn-warning'>Delete</button>" + "</td>" +
                        "</tr>");
            } else if (single.element.id > 8 && single.element.id < 12) {
                $('#contact-table').find('tbody')
                    .append(
                        "<tr>" +
                        "<td>" + single.id + "</td>" +
                        "<td>" + fullName + "</td>" +
                        "<td>Phone</td>" +
                        "<td>" + single.element.elementName + "</td>" +
                        "<td>" + single.phoneNumber + "</td>" +
                        "<td>" + "<button class='btn btn-primary' onclick='editContact(" + single.id + ")'>Edit</button>" + "</td>" +
                        "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='" + single.id + "' class='btn btn-warning'>Delete</button>" + "</td>" +
                        "</tr>");
            } else {
                $('#contact-table').find('tbody')
                    .append(
                        "<tr>" +
                        "<td>" + single.id + "</td>" +
                        "<td>" + fullName + "</td>" +
                        "<td>[Unknown]</td>" +
                        "<td>[Unknown]</td>" +
                        "<td>[Unknown}</td>" +
                        "<td>" + "<button class='btn btn-primary' onclick='editContact(" + single.id + ")'>Edit</button>" + "</td>" +
                        "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='" + single.id + "' class='btn btn-warning'>Delete</button>" + "</td>" +
                        "</tr>");
            }
        });
    });
}

function insertContactEmail() {
    $('#contactId').val("");
    $('#version').val("");
    $('#inputPerson').val(0);
    $('#inputElement').val(0);
    $('#inputEmail').val("");
    $('#contactEmailModal').modal('show')
}

function insertContactPhone() {
    $('#contactId').val("");
    $('#version').val("");
    $('#inputPersonPhone').val(0);
    $('#inputElementPhone').val(0);
    $('#inputPhone').val(null);
    $('#contactPhoneModal').modal('show')
}

function insertLists() {
    $.getJSON("/api/employee/", {
        ajax: 'true'
    }, function (data) {
        $.each(data, function(index, single) {
            var fullName = single.firstName + " " + single.lastName;
            $('#personListHere').find('select')
                .append("<option value=" + single.id + " >" + fullName + "</option>");
            $('#personListHereToo').find('select')
                .append("<option value=" + single.id + " >" + fullName + "</option>");
            $('#personListHereAsWell').find('select')
                .append("<option value=" + single.id + " >" + fullName + "</option>");
        });
    });
}

function saveContactEmail() {
    var id = $('#contactId').val();
    var version = $('#version').val();
    var element = $('#inputElement').val();
    var person = $('#inputPerson').val();
    var email = $('#inputEmail').val();

    var contact = {
        id: id,
        version: version,
        phoneNumber: 0,
        emailAddress: email,
        person: {
            id: person
        },
        element: {
            id: element
        },
    };
    console.log(contact);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        data: JSON.stringify(contact),
        url: "/api/contact/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        }
    })
}

function saveContactPhone() {
    var id = $('#contactId').val();
    var version = $('#version').val();
    var element = $('#inputElementPhone').val();
    var person = $('#inputPersonPhone').val();
    var number = $('#inputPhone').val();

    var contact = {
        id: id,
        version: version,
        phoneNumber: number,
        emailAddress: "null",
        person: {
            id: person
        },
        element: {
            id: element
        },
    };
    console.log(contact);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        data: JSON.stringify(contact),
        url: "/api/contact/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        }
    })
}

function editContact(id){
    $.getJSON('/api/contact/' + id, {
        ajax: 'true'
    }, function(contact) {
        console.log(contact);
        $('#contactId').val(contact.id);
        $('#version').val(contact.version);
        if(contact.element.id > 5 && contact.element.id < 9){
            $('#inputPerson').val(contact.person.id);
            $('#inputEmail').val(contact.emailAddress);
            $('#inputElement').val(contact.element.id);
            $('#contactEmailModal').modal('show');
        } else if(contact.element.id > 8 && contact.element.id < 12){
            $('#inputPersonPhone').val(contact.person.id);
            $('#inputPhone').val(contact.phoneNumber);
            $('#inputElementPhone').val(contact.element.id);
            $('#contactPhoneModal').modal('show');
        } else {
            $('#inputPhone').val("Enter Contact");
            $('#inputEmail').val("Enter Contact");
        }
    })
}

function deleteModal(){
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e){
        var $modaldiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        $.ajax({
            type: "delete",
            url: "/api/contact/" + id,
            async: true,
            dataType: "json",
            success: function() {
                window.location.reload();
            },
            error: function() {
                alert("Error Deleting Contact!")
            }
        })
    });
    $('#confirmDeleteModal').on('show.bs.modal', function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    })
}