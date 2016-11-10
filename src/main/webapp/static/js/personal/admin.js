function changeActive(id, active) {
    var data = {};

    data["id"] = $("#id-" + id).val();
    data["userName"] = $("#userName-" + id).val();
    data["roles"] = $("#roles-" + id).val();
    data["active"] = active;
    send("/users", "POST", data);
    changeAllToActiveButton();
}


function getAll() {
    send("/users/all", "GET");
    changeAllToActiveButton();
}

function changeAllToActiveButton() {
    $("#showUser").remove();
    var output = '<form id="showUser"  action="javascript:void(null);" onsubmit="getActive()">';
    output += '<input type="submit" id="showUsers" value="Показать активных пользователей"></form> ';
    $(".showUserDiv").append(output);
}

function getActive() {
    send("/users", "GET");
    changeActiveToALLButton();
}

function changeActiveToALLButton() {
    $("#showUser").remove();
    var output = '<form id="showUser"  action="javascript:void(null);" onsubmit="getAll()">';
    output += '<input type="submit" id="showUsers" value="Показать всех пользователей"></form> ';
    $(".showUserDiv").append(output);
}


function putUser() {
    var data = {};
    data["id"] = $("#userId").val();
    data["userName"] = $("#name").val();
    data["roles"] = $("#roles").val();
    data["active"] = $("#active").val();


    send("/users", "PUT", data);
    changeActiveToALLButton();

}


function send(url, type, jsonData) {

    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (data) {

            view(data);

        },
        error: function (x) {
            alert("error");

        }

    });
    return false;
}


function view(data) {

    $(".data").remove();
    $.each(data, function (key, val) {

        var output = "";

        output = "<tr class='data'>" +
            "<form id=\"form-" + val.id + "\">";

        output += "<td>";
        output += "<input type=\"text\" name=\"id\" id=\"id-" + val.id + "\" value=\"" + val.id + "\" readonly />";
        output += "</td>";

        output += "<td>";
        output += "<input type=\"text\" name=\"userName\" id=\"userName-" + val.id + "\" value=\"" + val.userName + "\"  readonly/>";
        output += "</td>";

        output += "<td>";
        output += "<input type=\"text\" name=\"roles\" id=\"roles-" + val.id + "\" value=\"" + val.roles + "\"  readonly/>";
        output += "</td>";


        if (val.active == true) {
            output += "<td>" +
                "<input type=\"button\" value=\"Запретить\" class=\"deleteButton btn\" onclick=\"changeActive(" + val.id + " , false)\">" +
                "</td>";
        }

        if (val.active == false) {
            output += "<td>" +
                "<input type=\"button\" value=\"Разрешить\" class=\"editButton btn\" onclick=\"changeActive(" + val.id + ", true)\">" +
                "</td>";
        }
        output += "</form> " +
            "</tr>";


        $("#userT").append(output);


    });
}
