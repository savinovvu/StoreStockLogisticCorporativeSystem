function getAll() {
    send("/local/all", "GET");
}


function putUser(id) {
    var data = {};
    if (id > 0) {
        data["id"] = id;
    } else {
        data["id"] = $("#localId").val();
    }

    data["userName"] = $("#name").val();
    data["roles"] = $("#roles").val();
    data["active"] = $("#active").val();


    send("/local", "PUT", data);
    addBlock('none');


}

function deleteLocal(id) {
    alert("удаляем" + id);
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
        output += "<input type=\"text\"  name=\"localId\" id=\"id-" + val.localId + "\" value=\"" + val.id + "\" readonly />";
        output += "</td>";

        output += "<td>";
        output += "<input type=\"text\"  name=\"localName\" id=\"userName-" + val.localId + "\" value=\"" + val.localName + "\"  readonly/>";
        output += "</td>";


        output += "<td>" +
            "<input type=\"button\" value=\"Удалить\" class=\"btn btn-danger\" onclick=\"deleteLocal(" + val.id + ")\">" +
            "</td>";


        output += '<td>' +
            '<button type="button" class="btn btn-success" onclick="setLocal(' + val.localId + ')"  data-toggle="modal"  data-target="#myModal"' +
            '>Обновить</button>' +
            '</td>';

        output += "</form> " +
            "</tr>";

        $("#LocalT").append(output);


    });
}
