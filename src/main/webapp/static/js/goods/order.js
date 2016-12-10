/*function changeActive(id, active) {
 var data = {};

 data["id"] = $("#id-" + id).val();
 data["userName"] = $("#userName-" + id).val();
 data["roles"] = $("#roles-" + id).val();
 data["active"] = active;
 send("/users", "POST", data);
 changeAllToActiveButton();
 }*/



function getAll() {
    send("/orders/all", "GET");
    /*    changeAllToActiveButton();*/
}

/*
 function changeAllToActiveButton() {
 $("#showUser").remove();
 var output = '<form id="showUser"  action="javascript:void(null);" onsubmit="getActive()">';
 output += '<input type="submit" class="btn btn-lg btn-info custombtn" id="showUsers" value="Показать активных пользователей"></form> ';
 $(".showUserDiv").append(output);
 }

 function getActive() {
 send("/users", "GET");
 changeActiveToALLButton();
 }

 function changeActiveToALLButton() {
 $("#showUser").remove();
 var output = '<form id="showUser"    action="javascript:void(null);" onsubmit="getAll()">';
 output += '<input type="submit" id="showUsers" class="btn btn-lg btn-info custombtn" value="Показать всех пользователей"></form> ';
 $(".showUserDiv").append(output);
 }
 */

/*
 function putUser(id) {
 var data = {};
 if (id > 0) {
 data["id"] = id;
 } else {
 data["id"] = $("#userId").val();
 }

 data["userName"] = $("#name").val();
 data["roles"] = $("#roles").val();
 data["active"] = $("#active").val();


 send("/users", "PUT", data);
 addBlock('none');
 changeActiveToALLButton();


 }*/


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

/*    @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @JsonProperty("product_id")
 private int product_id;

 @Column(name = "product_name")
 @JsonProperty("product_name")
 private String product_name;*/

function view(data) {

    $(".data").remove();
    $.each(data, function (key, order) {

        var output = "";

        output = "<tr class='data'>" +
            "<form id=\"form-" + order.order_id + "\">";

        output += "<td>";
        output += "<input type=\"text\"  name=\"id\" id=\"id-" + order.order_id + "\" value=\"" + order.order_id + "\" readonly />";
        output += "</td>";

        output += "<td>";
        output += "<input type=\"text\"  name=\"startDateTime\" id=\"startDateTime-" + order.order_id + "\" value=\"" + order.startDateTime + "\"  readonly/>";
        output += "</td>";

        output +="<td><table id=\"productT-"+order.order_id+"\" >" +
            " <thead> ";

        output += "<tr>";
        output += "<td>";
        output += "Артикул";
        output += "</td>"

        output += "<td>";
        output += "Товар";
        output += "</td>"

        output += "</tr>";
        output += "</thead>"
        output +="</table></td>";

        $.each(order.products, function (key2, product) {

            var productOutput = "";
            productOutput = "<tr class='dataProduct'>" +
                "<form id=\"formProduct-" + product.product_id+ "\">";

            productOutput += "<tr>";

            productOutput += "<td>";
            productOutput += "<input type=\"text\"  name=\"product_id\" id=\"product_id-" + product.product_id + "\" value=\"" + product.product_id + "\"  readonly/>";
            productOutput += "</td>"

            productOutput += "<td>";
            productOutput += "<input type=\"text\"  name=\"product_name\" id=\"product_name-" + product.product_id + "\" value=\"" + product.product_name + "\"  readonly/>";
            productOutput += "</td>"
            productOutput += "</tr> ";
            productOutput += "</form> " +
                "</tr>";

            $("#productT-"+10003).append(productOutput);

        });


        output += "<td>";
        output += "<input type=\"text\"  name=\"roles\" id=\"roles-" + order.id + "\" value=\"" + order.roles + "\"  readonly/>";
        output += "</td>";


        if (order.active == true) {
            output += "<td>" +
                "<input type=\"button\" value=\"Запретить\" class=\"btn btn-danger\" onclick=\"changeActive(" + order.id + " , false)\">" +
                "</td>";
        }

        if (order.active == false) {
            output += "<td>" +
                "<input type=\"button\" value=\"Разрешить\" class=\"btn btn-success\" onclick=\"changeActive(" + order.id + ", true)\">" +
                "</td>";
        }


        /*  output += "<td>" +
         "<input type=\"button\" value=\"Обновить\" class=\"btn btn-success\" onclick=\"addBlock( 'block'," + val.id + ")\">" +
         "</td>";*/
        output += '<td>' +
            '<button type="button" class="btn btn-success" onclick="addBlock(' + order.id + ')"  data-toggle="modal"  data-target="#myModal"' +
            '>Обновить</button>' +
            '</td>';

        output += "</form> " +
            "</tr>";

        $("#orderT").append(output);


    });
}
