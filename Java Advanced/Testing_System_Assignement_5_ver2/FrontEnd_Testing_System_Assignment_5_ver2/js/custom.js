// link api
var apiDepartmentURL = "http://localhost:8181/api/v1/departments/"
var apiAccountURL = "http://localhost:8181/api/v1/accounts/"

// load header, main and footer
$(function() {
    $(".header").load("templates/header.html");
    $(".main").load("templates/main.html");
    $(".footer").load("templates/footer.html");
});

// đi đến trang chủ
function viewHome() {
    $(".main").load("templates/main.html");
}

// đến trang quản lý department
function viewDeparment() {
    $(".main").load("department/main.html", function() {
        initDepartmentTable();
    });
}

// đến trang quản lý account
function viewAccount() {
    $(".main").load("account/main.html", function() {
        initAccountTable()

    });
}

// ẩn modal tạo mới
function hideAddNewModal() {
    $("#myModal").modal("hide");
}

// thông báo 
function showAlertSuccess() {
    $("#alert-success").fadeTo(3000, 200).slideUp(2000, function() {
        $("#alert-success").slideUp(3000);
    });
}

// 1. FOR DEPARTMENT ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

// Lấy danh sách cho bảng Department
function openAddNewDepartmentModal() {
    $("#myModal").modal("show");
    resetDepartmentModal();
}

function resetDepartmentModal() {
    document.getElementById("department-id").value = "";
    document.getElementById("department-name").value = "";
}

function initDepartmentTable() {
    $('tbody').empty();
    $.ajax({
        url: apiDepartmentURL,
        type: 'GET',
        success: function(result) {
            result.forEach(function(item) {
                $('tbody').append(
                    '<tr>' +
                    '<td>' + item.departmentID + '</td>' +
                    '<td>' + item.departmentName + '</td>' +
                    '<td>' +
                    '<a class="edit" title="Edit" data-toggle="tooltip" onclick ="opendUpdateDepartmentModal(' + item.departmentID + ')"><i class="material-icons">&#xE254;</i></a>' +
                    '<a class="delete" title="Delete" data-toggle="tooltip" onclick ="deleteDepartment(' + item.departmentID + ')"><i class="material-icons">&#xE872;</i></a>' +
                    '</td>' +
                    '</tr>'
                )
            });
        }
    });
}

// save department (create new department or update department)
function saveDepartment() {
    var departmentID = document.getElementById("department-id").value;

    if (departmentID == null || departmentID == "") {
        createNewDepartment();
    } else {
        updateDepartment(departmentID);
    }
    showAlertSuccess();
}

// tạo mới department
function createNewDepartment() {
    var name = document.getElementById("department-name").value;

    var department = {
            departmentName: name
        }
        // gọi api thêm mới nhân viên
    $.ajax({
        url: apiDepartmentURL,
        type: 'POST',
        data: JSON.stringify(department), // body
        contentType: "application/json",
        async: false,
        success: function(result) {}
    });

    initDepartmentTable();
    hideAddNewModal();
}

// hiện modal update department
function opendUpdateDepartmentModal(departmentID) {
    openAddNewDepartmentModal();
    // gọi api lấy phòng ban theo id
    $.ajax({
        url: apiDepartmentURL + departmentID,
        type: 'GET',
        success: function(result) {
            //fill data
            document.getElementById("department-id").value = result.departmentID;
            document.getElementById("department-name").value = result.departmentName;
        }
    });
}

// update department
function updateDepartment(departmentID) {
    var name = document.getElementById("department-name").value;

    var department = {
            departmentName: name
        }
        // gọi api để cập nhật phòng ban theo id
    $.ajax({
        url: apiDepartmentURL + departmentID,
        type: 'PUT',
        data: JSON.stringify(department), // body
        contentType: "application/json",
        async: false,
        success: function(result) {

        }
    });
    initDepartmentTable();
    hideAddNewModal();
}

// xóa department
function deleteDepartment(departmentID) {
    var result = confirm("có chắc chắn xóa không?");
    if (result == true) {
        $.ajax({
            url: apiDepartmentURL + departmentID,
            type: 'DELETE',
            async: false,
            success: function(result) {

            }
        });

        initDepartmentTable();
        showAlertSuccess();
    }
}

// 1. THE END OF DEPARTMENT ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑





// 2. FOR ACCOUNT ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

// Lấy danh sách cho bảng Account
function openAddNewAccountModal() {
    $("#myModal").modal("show");
    resetAccountModal();

    // khởi tạo danh sách department cho drop box của account
    initDapartmentList();
}

// reset account modal
function resetAccountModal() {
    document.getElementById("account-id").value = "";
    document.getElementById("full-name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("password").value = "";
    document.getElementById("confirm-password").value = "";
    document.getElementById("department-select").value = "";
}

// khởi tạo danh sách department cho drop box của account
function initDapartmentList() {
    $('#department-select').empty();
    $.ajax({
        url: apiDepartmentURL,
        type: 'GET',
        success: function(result) {
            result.forEach(function(item) {
                $('#department-select').append(
                    '<option value="' + item.departmentID + '">' + item.departmentName + '</option>'
                )
            });
        }
    });

}

// lấy danh sách account
function initAccountTable() {
    $('tbody').empty();
    $.ajax({
        url: apiAccountURL,
        type: 'GET',
        success: function(result) {
            result.forEach(function(item) {
                $('tbody').append(
                    '<tr>' +
                    '<td>' + item.accountID + '</td>' +
                    '<td>' + item.email + '</td>' +
                    '<td>' + item.fullName + '</td>' +
                    '<td>' + item.phone + '</td>' +
                    '<td>' + item.department.departmentName + '</td>' +
                    '<td>' +
                    '<a class="edit" title="Edit" data-toggle="tooltip" onclick ="opendUpdateAccountModal(' + item.accountID + ')"><i class="material-icons">&#xE254;</i></a>' +
                    '<a class="delete" title="Delete" data-toggle="tooltip" onclick ="deleteAccount(' + item.accountID + ')"><i class="material-icons">&#xE872;</i></a>' +
                    '</td>' +
                    '</tr>'
                )
            });
        }
    });
}

// tạo mới account
function createNewAccount() {
    var fullName = document.getElementById("full-name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;
    var phone = document.getElementById("phone").value;
    var departmentID = $('#department-select').find(":selected").val();


    var account = {
            fullName: fullName,
            email: email,
            password: password,
            confirmPassword: confirmPassword,
            department: {
                departmentID: departmentID
            },
            phone: phone
        }
        // gọi api thêm mới account
    $.ajax({
        url: apiAccountURL,
        type: 'POST',
        data: JSON.stringify(account), // body
        contentType: "application/json",
        async: false,
        success: function(result) {}
    });

    initAccountTable();
    hideAddNewModal();
}

// lưu account (update account or create new account)
function saveAccount() {
    var accountID = document.getElementById("account-id").value;

    if (accountID == null || accountID == "") {
        createNewAccount();
    } else {
        updateAccount(accountID);
    }
    showAlertSuccess();
}

// hiện modal update account
function opendUpdateAccountModal(accountID) {
    openAddNewAccountModal();
    // gọi api lấy account ban theo id
    $.ajax({
        url: apiAccountURL + accountID,
        type: 'GET',
        async: false,
        success: function(result) {
            //fill data
            document.getElementById("department-select").value = result.departmentID;
            document.getElementById("account-id").value = result.accountID;
            document.getElementById("full-name").value = result.fullName;
            document.getElementById("email").value = result.email;
            document.getElementById("password").value = result.password;
            document.getElementById("confirm-password").value = result.confirmPassword;
            document.getElementById("phone").value = result.phone;
        }
    });
}

// update account
function updateAccount(accountID) {
    var fullName = document.getElementById("full-name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;
    var phone = document.getElementById("phone").value;
    var departmentID = $('#department-select').find(":selected").val();

    var account = {
            fullName: fullName,
            email: email,
            password: password,
            confirmPassword: confirmPassword,
            department: {
                departmentID: departmentID
            },
            phone: phone
        }
        // gọi api để cập nhật phòng ban theo id
    $.ajax({
        url: apiAccountURL + accountID,
        type: 'PUT',
        data: JSON.stringify(account), // body
        contentType: "application/json",
        async: false,
        success: function(result) {

        }
    });
    initAccountTable();
    hideAddNewModal();
}

// xóa account
function deleteAccount(accountID) {
    var result = confirm("có chắc chắn xóa không?");
    if (result == true) {
        $.ajax({
            url: apiAccountURL + accountID,
            type: 'DELETE',
            async: false,
            success: function(result) {

            }
        });

        initAccountTable();
        showAlertSuccess();
    }
}

// 2. THE END OF ACCOUNT ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑