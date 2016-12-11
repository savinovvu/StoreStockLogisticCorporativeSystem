function getActive() {
    send("/orders", "GET");
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

    $(".order").remove();

    var output = '<div class="lustran-container">';


    $.each(data, function (key, order) {

/*form for navigation get pdf*/
        output += '<div class="displayNone">' +
            ' <form action="orders/page/'+order.order_id+'.pdf" method="get">' +
            '<input id="getPdf-'+order.order_id+'"  class="btn btn-primary" class="btn" type="submit" name="viewAllUsers">' +
            '</form>' +
            '</div>';

         output += '<article class="order">' +
            '<header class="order-header">' +
            '<a href="#" onclick="getNavigation(\'getPdf-\'+'+order.order_id+')"><div class="order-id">заказ<span>'+order.order_id+'</span></div></a>' +
            '<div class="order-basket">'+order.products.length +'</div>' +
            '<a href="#order-add" class="btn btn-sm order-add"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>' +
            '</header>';



        $.each(order.products, function (productKey, product) {

           output +='<section class="order-body">' +
            '<ul class="order-list">';
            output += '<li class="order-list-item">' +



             '<header class="order-list-item-header"><span class="badge badge-pur">2</span>' +
                '<span class="order-date sep-dot">11.12.16</span><span class="order-name sep-dot">Название товара</span>' +
                '<span class="order-count sep-dot"><i>1</i> шт</span> <span class="order-float-date">16.12.16</span>' +
                '<a href="#" class="btn btn-success btn-xs" data-toggle="open-log">История действий</a>' +
                '<a href="#" class="remove-order-status" data-toggle="remove-order"></a></header>' +
                '<div class="container-fluid">' +
                '<ul class="order-status-list row">';


            $.each(product.actualStatus, function (statusKey, statusValue){
                output +='<li class="col-sm-2">' +
                '<div class="order-status">' +
                '<div class="order-status-body">' +
                '<div class="status-top"><span class="status">Дозвон</span>' +
                '<span class="status-date">12.12.16</span></div>' +
                '<div class="status-bottom"><span>Фамилия Имя Отчество</span></div>' +
                '</div>' +
                '<a href="#" class="order-status-edit"></a>' +
                '</div>' +
                '</li>' ;

                });

            output +='</ul>' +
                '</div>' +
                '</li>' +
                '</ul>' +
                '</section>';

        });

        output +='</article>';

    });
    output += '</div>';

    $(".lustran-container").append(output);

}
