function getAll() {
    send("/locals/all", "GET");
}


function putLocal(id) {
    var data = {};
    if (id > 0) {
        data["id"] = id;
    } else {
        data["id"] = -1;
    }
    data["localName"] = $("#localName").val();



    send("/locals", "PUT", data);



}

function deleteLocal(id) {
    var data = {};
    data["id"] = id;
    data["localName"] = "name";
    send("/locals", "DELETE", data);
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
        output += "<input type=\"text\"  name=\"localId\" id=\"id-" + val.id + "\" value=\"" + val.id + "\" readonly />";
        output += "</td>";

        output += "<td>";
        output += "<input type=\"text\"  name=\"localName\" id=\"localName-" + val.id + "\" value=\"" + val.localName + "\"  readonly/>";
        output += "</td>";


        output += "<td>" +
            "<input type=\"button\" value=\"Удалить\" class=\"btn btn-danger\" onclick=\"deleteLocal(" + val.id + ")\">" +
            "</td>";


        output += '<td>' +
            '<button type="button" class="btn btn-success" onclick="setLocal(' + val.id + ')"  data-toggle="modal" ' +
            '>Выбрать</button>' +
            '</td>';

        output += "</form> " +
            "</tr>";

        $("#LocalT").append(output);


    });
}
