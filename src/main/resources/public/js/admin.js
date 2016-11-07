function getAll() {
    send("/AllUsers", "GET");
}



function putUser() {
    var data = {};
    data["id"] = $("#userId").val();
    data["userName"] = $("#name").val();
    data["roles"] = $("#roles").val();
    data["active"] = $("#active").val();

   //var data= '{"id":1000,"roles":"ADMIN","active":true,"userName":"name1"}'
    send("/putUser", "PUT", data);
}

/*function sendJson(url, type, data) {
    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (data) {
            alert("обновляем");
            getAll();

        },
        error: function (x) {
            alert("обновляем");
            getAll();
        }

    });
    return false;
}*/


function send(url, type, jsonData) {
    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (data) {

            view(JSON.parse(data));

        },
        error: function (x) {
            alert("обновляем");
            getAll();
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
        output += "<input type=\"text\" name=\"productName\" id=\"productName-" + val.id + "\" value=\"" + val.userName + "\"  readonly/>";
        output += "</td>";

        output += "<td>";
        output += "<input type=\"text\" name=\"price\" id=\"price-" + val.id + "\" value=\"" + val.roles + "\"  readonly/>";
        output += "</td>";



        if (val.active == true) {
            output += "<td>" +
                "<input type=\"button\" value=\"Уволить\" class=\"deleteButton btn\" onclick=\"dismissal(" + val.id + ")\">" +
                "</td>";
        }

        if (val.active == false) {
            output += "<td>" +
                "<input type=\"button\" value=\"Восстановить\" class=\"editButton btn\" onclick=\"recover(" + val.id + ")\">" +
                "</td>";
        }
        output += "</form> " +
            "</tr>";


        $("#userT").append(output);


    });
}