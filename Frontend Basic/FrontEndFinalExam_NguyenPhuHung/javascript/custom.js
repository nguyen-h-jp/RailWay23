var listApi = "https://61ed2688f3011500174d22ea.mockapi.io/api/v1/groups";

getList();
// get list
function getList() {
    $.ajax({
        // async: false,
        url: listApi,
        type: "GET",
        success: function(result) {
            var table = "<table id='myTable' =><tr><th><input type='checkbox' id='checkAll'></th><th>STT</th><th>Group Name</th><th>Member</th><th>Creator</th><th>Create Date</th></tr>";
            var count = 0;
            result.forEach(element => {
                myDate = new Date(1000 * element.createDate);
                var rows = "";
                count++;
                rows += "<tr>";
                rows += "<td><input type='checkbox' name='checkInput' id='" + element.stt + "'></td>";
                rows += "<td>" + count + "</td>";
                rows += "<td>" + '<a href="#" style="text-decoration: none; color:blue" onclick = "showDetail(' + element.stt + ')">' + element.groupName + "</a></td >";
                rows += "<td>" + element.member + "</td>";
                rows += "<td>" + element.creator + "</td>";
                rows += "<td>" + myDate.toLocaleString() + "</td>";
                rows += "<tr>";
                table += rows;
            });
            table += "</table>";
            $("#group-list-table").html(table);
        }


    })

}

// kiểm tra trùng tên group khi thêm/sửa
function checkGroupNameDuplication(groupName) {
    var check = false;
    $.ajax({
        async: false,
        url: listApi,
        type: 'GET',
        success: function(result) {
            result.forEach(element => {
                if (element.groupName == groupName) {
                    check = true;
                }
            });

        }
    })
    return check;
}

// show detail group





// search by group name
$("#search-group-name").click(function() {
    searchByGroupName();

});

// refresh button 
$("#refresh-button").click(function() {
    getList();
});

// create button
$("#addGroupBtn").click(function() {
    $("#createGroupForm").show();
})

// cancel button
$("#noToEdit").click(function() {
    $("#editGroupNameForm").hide();
})

// hide group detail

$("#hideButton").click(function() {
    $("#detailGroup").hide();
})

// check all





// save button

$("#saveCreateGroupForm").click(function() {

    var groupName = $("#groupNameInput").val();
    var check = checkGroupNameDuplication(groupName);
    if (check == false) {
        createGroup(groupName);
        $("#notification-success").text("Tạo thành công");
        $("#notification-success").show();
        $("#createGroupForm").hide();
        setTimeout(() => {
            $("#notification-success").hide();
        }, 3000);
    } else {
        document.getElementById("existedMessage").innerHTML = "Nhóm này đã tồn tại, vui lòng nhập lại";
        setTimeout(() => {
            document.getElementById("existedMessage").innerHTML = "";
        }, 3000);

    }
})

// show edit group name popup
$("#showUpdateModal").click(function() {
    $("#editGroupNameForm").show();


})


// save update
$("#yesToEdit").click(function() {
    var groupName = $("#inputNewGroupName").val();
    var id = document.getElementById("groupId").textContent;

    $("#notification-success").text("Sửa tên nhóm thành công");
    $("#notification-success").show();
    $("#editGroupNameForm").hide();
    setTimeout(() => {
        $("#notification-success").hide();
    }, 3000);
    // var id = $("#groupId").val();
    editGroup(id, groupName);

})


// show detail
function showDetail(id) {
    $("#detailGroup").show();
    $("#groupId").text(id);
    $("#detailGroup").show();
    $.ajax({
        url: listApi + "/" + id,
        type: 'GET',
        success: function(result) {
            myDate = new Date(1000 * result.createDate);
            // $("#idOfGroup").text(result.stt);
            $("#groupName").text("Group Name: " + result.groupName);
            $("#creatorName").text("Creator Name: " + result.creator == undefined ? '' : "Creator Name: " + result.creator);
            $("#createDate").text("Create Date: " + myDate.toLocaleString());
            $("#member").text("Member: " + result.member);
        }
    })
}


// cancel button
$("#cancelCreateGroupForm").click(function() {
    $("#createGroupForm").hide();
})

// delete button 
$("#delGroupBtn").click(function() {
    $("#confirmForm").show();
    $("#yesToDelete").click(function() {
        deleteGroup();
        $("#confirmForm").hide();

    });
    $("#noToDelete").click(function() {
        $("#confirmForm").hide();
    });

})

// edit group

function editGroup(id, groupName) {
    // khai báo đối tượng
    var group = {
        groupName: groupName
    }

    $.ajax({
        async: false,
        url: listApi + "/" + id,
        type: 'PUT',
        data: group,
        success: function(result) {
            if (result == undefined || result == null) {
                alert("Có lỗi xảy ra!");
                return;
            } else {
                // 
            }
        }
    })
    getList();
}


// create group
function createGroup(groupName) {
    var now = new Date();
    // var inputGroupName = $("#groupNameInput").val();
    var group = {
        "groupName": groupName,
        "createDate": Math.floor(now.getTime() / 1000.0)
    }
    $.ajax({
        async: false,
        url: listApi,
        type: "POST",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(group),
        success: function(result) {
            if (result == undefined || result == null) {
                alert("Có lỗi xảy ra!");
                return;
            } else {
                $("#notification-success").show();
                // $("#notification-success").show();
                setTimeout(() => {
                    $("#notification-success").hide();
                }, 3000);
            }
        }
    })
    getList();

}

// delete group

function deleteGroup() {
    // var checkDel = true;
    $('input[name="checkInput"]:checked').each(function() {
        $.ajax({
            async: false,
            url: listApi + "/" + this.id,
            type: 'DELETE',
            data: null,
            success: function(result) {
                if (result == undefined || result == null) {
                    checkDel = false;
                } else {
                    $("#notification-success").text("Xóa thành công");
                    $("#notification-success").show();
                    // $("#notification-success").show();
                    setTimeout(() => {
                        $("#notification-success").hide();
                    }, 3000);
                }
            }
        })
    });
    getList();
}


function checkGroupNameIsExist(result) {
    var isOk = false;
    var groupNameInput = document.querySelector('input[name = "groupNameInput"]').value;
    var count = 0;

    result.forEach(element => {
        if (element.groupName === groupNameInput) {
            count++;
        } else {
            count += 0;
        }
    });
    if (count != 0) {
        isOk = true;

    } else {
        isOk = false;
    }
    return isOk;
}


function showInformation() {

}

function searchByGroupName() {
    var inputGroupName = $("#search-input").val();
    console.log(inputGroupName);
    $.ajax({
        async: false,
        url: listApi,
        type: 'GET',
        success: function(result) {
            var table = "<table id='myTable' =><tr><th><input type='checkbox' id='checkAll'></th><th>STT</th><th>Group Name</th><th>Member</th><th>Creator</th><th>Create Date</th></tr>";
            var count = 0;
            result.forEach(element => {
                myDate = new Date(1000 * element.createDate);

                if (element.groupName == inputGroupName) {
                    var rows = "";
                    count++;
                    rows += "<tr>";
                    rows += "<td><input type='checkbox' id='" + element.stt + "'></td>";
                    rows += "<td>" + count + "</td>";
                    rows += "<td>" + '<a href="javascript:void(0)" style="text-decoration: none; color:blue" id = "groupName-' + element.stt + '">' + element.groupName + "</a>" + "</td>";
                    rows += "<td>" + element.member + "</td>";
                    rows += "<td>" + element.creator + "</td>";
                    rows += "<td>" + myDate.toLocaleString() + "</td>";
                    rows += "<tr>";
                    table += rows;
                }
            });
            table += "</table>";
            $("#group-list-table").html(table);
        }
    })
}