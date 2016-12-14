/*$('#serializedForm').on('button', 'click', function () {
    $(this).closest('form').preventDefault(); //Предотвращаем выполнение функций, предусмотренных стандартным поведением формы;
    var formData = $('#serializedForm input').serialize();
    alert("sldfkj");
});*/


function sendForm() {
    alert("data");
    //var data = $.('#serializedForm').serializeArray();
    var data = "какие то данные";
    send("/orders", "PUT", data);
}

/*$("#serializedForm").submit(function () {
    alert("sldfj");
});*/

/*$("#serializedForm").submit(function (event) {
    alert($(this).serializeArray);
    event.preventDefault();
});*/

/*

$( "#serializedForm" ).submit(function( event ) {
    alert("sldfkjsldfj");
    //alert( $("#serializedForm" ).serializeArray() );

    event.preventDefault();
});
*/




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

    alert("добавлено")

}
