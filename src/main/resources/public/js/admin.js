function getAll() {
    send("/getAll", "POST");
}


function send(url, type, jsonData) {
    $.ajax({

        url: url,
        type: type,
        contentType: 'application/text',
        data: jsonData,
        success: function (data) {

            view(JSON.parse(data));

        },
        error: function (x) {
            alert('error');
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