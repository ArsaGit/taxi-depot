function populateDriverTable(drivers) {
    $('#driverTableBody').empty();
    for (var i = 0; i < drivers.length; i++) {
        addDriverRow(drivers[i]);
    }

    // Edit button click handler
    $('.edit-btn').click(function() {
        var driver = $(this).data('driver');
        $('#id').val(driver._id);
        $('#rev').val(driver._rev);
        $('#fullname').val(driver.fullName);
        $('#birthdate').val(driver.birthdate);
        $('#birthplace').val(driver.birthplace);
        $('#issueDate').val(driver.issueDate);
        $('#expirationDate').val(driver.expirationDate);
        $('#issuedBy').val(driver.issuedBy);
        $('#code').val(driver.code);
        $('#residence').val(driver.residence);
        $('#categories').val(driver.categories);
        $('#editModal').modal('show');
    });

    // Save changes button click handler
    $('.save-btn').click(async function() {
        var driver = {
            _id: $('#id').val(),
            _rev: $('#rev').val(),
            fullName: $('#fullname').val(),
            birthdate: $('#birthdate').val(),
            birthplace: $('#birthplace').val(),
            issueDate: $('#issueDate').val(),
            expirationDate: $('#expirationDate').val(),
            issuedBy: $('#issuedBy').val(),
            code: $('#code').val(),
            residence: $('#residence').val(),
            categories: $('#categories').val()
        };

        let response = await fetch('/drivers/' + $('#id').val(), {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(driver)
            }
        );

        getLicenses().then(data => {
            populateDriverTable(data);
        });
    });

    // Delete button click handler
    $('.delete-btn').click(async function() {
        var id = $(this).data('id');

//        if (confirm('Are you sure you want to delete this record?')) {
        let response = await fetch('/drivers/' + id, { method: 'DELETE' });
//        }

        getLicenses().then(data => {
          populateDriverTable(data);
        });
    });

    // Add new driver button click handler
    $('#addDriverBtn').click(function() {
        clearDriverForm();
        $('#driverModal').modal('show');
    });

    // Submit new driver form handler
    $('.btnbtn−primary').click(async function() {
//        event.preventDefault();
        var driver = {
            fullName: $('#fullname2').val(),
            birthdate: $('#birthdate2').val(),
            birthplace: $('#birthplace2').val(),
            issueDate: $('#issueDate2').val(),
            expirationDate: $('#expirationDate2').val(),
            issuedBy: $('#issuedBy2').val(),
            code: $('#code2').val(),
            residence: $('#residence2').val(),
            categories: $('#categories2').val()
        };

        let response = await fetch('/drivers', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(driver)
            }
        );

        clearDriverForm();
//        $('#driverModal').modal('hide');
        getLicenses().then(data => {
          populateDriverTable(data);
        });
    });
}

async function getLicenses() {
  try {
    let response = await fetch('/drivers');
    let data = await response.json();
    return data;
  } catch (error) {
    console.log(error);
  }
}

function formatDate(date) {
    const dt = Date.parse(date);
    return new Intl.DateTimeFormat('ru-RU').format(dt);
}

//add modal form

function clearDriverForm() {
    $('#fullname').val('');
    $('#birthdate').val('');
    $('#birthplace').val('');
    $('#issueDate').val('');
    $('#expirationDate').val('');
    $('#issuedBy').val('');
    $('#code').val('');
    $('#residence').val('');
    $('#categories').val('');
}

function addDriverRow(driver) {
    var row = $('<tr>');
    row.append($('<td>').text(driver._id));
    row.append($('<td>').text(driver.fullName));
    row.append($('<td>').text(formatDate(driver.birthdate)));
    row.append($('<td>').text(driver.birthplace));
    row.append($('<td>').text(formatDate(driver.issueDate)));
    row.append($('<td>').text(formatDate(driver.expirationDate)));
    row.append($('<td>').text(driver.issuedBy));
    row.append($('<td>').text(driver.code));
    row.append($('<td>').text(driver.residence));
    row.append($('<td>').text(driver.categories));
    var btnGroup = $('<div class="btn-group">');
    btnGroup.append($('<button class="btn btn-primary edit-btn">Edit</button>').data('driver', driver));
    btnGroup.append($('<button class="btn btn-danger delete-btn">Delete</button>').data('id', driver._id));
    row.append($('<td>').append(btnGroup));
    $('#driverTableBody').append(row);
}


getLicenses().then(data => {
  populateDriverTable(data);
});


