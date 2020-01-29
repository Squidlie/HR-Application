function buildTable() {
    $.getJSON("/api/address/", {
        ajax: 'true'
    }, function (data) {
        $.each(data, function(index, single) {
            var fullName = single.person.firstName + " " + single.person.lastName;
            $('#address-table').find('tbody')
                .append("<tr>" +
                    "<td>" + single.id + "</td>" +
                    "<td>" + single.addressNumber + "</td>" +
                    "<td>" + single.street + "</td>" +
                    "<td>" + single.state + "</td>" +
                    "<td>" + single.country + "</td>" +
                    "<td>" + fullName + "</td>" +
                    "<td>" + "<button class='btn btn-primary' onclick='editAddress(" + single.id + ")'>Edit</button>" + "</td>" +
                    "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='" + single.id + "' class='btn btn-warning'>Delete</button>" + "</td>" +
                    "</tr>");
        });
    });
}

function insertAddress() {
    $('#addressId').val("");
    $('#version').val("");
    $('#inputPerson').val(0);
    $('#inputNumber').val("");
    $('#inputStreet').val("");
    $('#inputCity').val("");
    $('#inputState').val("");
    $('#inputCountry').val("");
    $('#addressModal').modal('show')
}

function insertPersonSelect() {
    $.getJSON("/api/employee/", {
        ajax: 'true'
    }, function (data) {
        $.each(data, function(index, single) {
            var fullName = single.firstName + " " + single.lastName;
            $('#personListHere').find('select')
                .append("<option value=" + single.id + " >" + fullName + "</option>");
        });
    });
}

function saveAddress() {
    var id = $('#addressId').val();
    var version = $('#version').val();
    var person = $('#inputPerson').val();
    var number = $('#inputNumber').val();
    var street = $('#inputStreet').val();
    var city = $('#inputCity').val();
    var state = $('#inputState').val();
    var country = $('#inputCountry').val();

    var address = {
        id: id,
        version: version,
        person: {
            id: person
        },
        addressNumber: number,
        street: street,
        city: city,
        state: state,
        country: country
    };
    console.log(address);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        data: JSON.stringify(address),
        url: "/api/address/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        }
    })
}

function editAddress(id) {
    $.getJSON('/api/address/' + id, {
        ajax: 'true'
    }, function(address) {
        console.log(address);
        $('#addressId').val(address.id);
        $('#version').val(address.version);
        $('#inputPerson').val(address.person.id);
        $('#inputNumber').val(address.addressNumber);
        $('#inputStreet').val(address.street);
        $('#inputCity').val(address.city);
        $('#inputState').val(address.state);
        $('#inputCountry').val(address.country);
        $('#addressModal').modal('show')
    })
}

function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e){
        var $modaldiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        $.ajax({
            type: "delete",
            url: "/api/address/" + id,
            async: true,
            dataType: "json",
            success: function() {
                window.location.reload();
            },
            error: function() {
                alert("Error Deleting Address!")
            }
        })
    });
    $('#confirmDeleteModal').on('show.bs.modal', function (e) {
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    })
}