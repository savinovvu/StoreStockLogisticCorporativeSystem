function deletePriceDuringDate() {
    var data = {};
    data["id"] = 0;
    data["productName"] = $("#deleteName").val();
    data["validFrom"] = $("#deleteDateFrom").val();
    data["validTo"] = $("#deleteDateTo").val();
    alert("отклик");
    sendJson("/deletePriceDuringDate", "POST", data);

}


function setPriceDuringDate() {
    var data = {};
    data["id"] = 0;
    data["productName"] = $("#setName").val();
    data["productPrice"] = $("#setPrice").val();
    data["validFrom"] = $("#setDateFrom").val();
    data["validTo"] = $("#setDateTo").val();

    sendJson("/setPriceDuringDate", "POST", data);

}


function findByNameAndDate() {
    var data = $('#findByNameAndDate').serialize();
    send("/findByNameAndDate", "GET", data);
}


function findByName() {
    var data = $('#findByName').serialize();
    send("/findByName", "GET", data);
}


function getAll() {
    send("/getAll", "POST");
}

function remove(id) {
    id = "id=" + id;
    send("/remove", "GET", id);
}


function send(url, type, data) {
    $.ajax({

        url: url,
        type: type,
        contentType: 'application/text',
        data: data,
        success: function (data) {
            view(JSON.parse(data));

        },
        error: function (x) {

        }

    });
    return false;
}

function sendJson(url, type, data) {
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
}


/*@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @JsonProperty("id")
 private int id;


 @Column(name = "userName")
 @JsonProperty("userName")
 private String name;


 @Enumerated(EnumType.STRING)
 @Column(name = "roles")
 @JsonProperty("roles")
 private Role roles;

 @JsonProperty("active")
 @Column(name = "active")
 private boolean active;*/


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


        output += "<td>";
        output += "<input type=\"text\" name=\"price\" id=\"price-" + val.id + "\" value=\"" + val.active + "\"  readonly/>";
        output += "</td>";

        if(val.active == true) {
            output += "<td>" +
                "<input type=\"button\" value=\"Уволить\" class=\"deleteButton btn\" onclick=\"remove(" + val.id + ")\">" +
                "</td>";
        }

        if(val.active == false) {
            output += "<td>" +
                "<input type=\"button\" value=\"Восстановить\" class=\"Button btn\" onclick=\"remove(" + val.id + ")\">" +
                "</td>";
        }
        output += "</form> " +
            "</tr>";


        $("#userT").append(output);


    });
}