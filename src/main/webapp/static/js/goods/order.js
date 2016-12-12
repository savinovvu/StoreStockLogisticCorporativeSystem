
function updatePage() {
    getCount();
    getActive();

}

function getAll() {
    send("/orders/all", "GET");
}

function getActive() {
    send("/orders", "GET");
}

function getCount() {
     sendForGetNumber("/orders/analytics" , "GET");
}


function sendForGetNumber(url, type, textData) {

    // return $.ajax({
     return $.ajax({

        url: url,
        type: type,
        //  async:false,
        contentType: 'application/json',
        data: JSON.stringify(textData),
        success: function (data) {
            viewAnalitics(data)


        },
        error: function (x) {
            alert("error viewAnalitics");

        }
     });
   //  }).responseText;
}

function viewAnalitics(data) {

    $(".delnav ").remove();

    var output = '<li  class="navbar-text delnav"><a class="delnav" style="display: inline; background: transparent; color: white;"   class="delnav" href="#" onclick="getAll()">Заказов всего</a><span class="badge badge-pur-light">' + data[0] + '</span></li>' +
        '<li class="navbar-text delnav"><a class="delnav" style="display: inline; background: transparent; color: white; border-color: transparent" class="delnav" href="#" onclick="getActive()">В обработке</a><span class="badge badge-pur-light">' + data[1] + '</span></li>' +
        '<li class="navbar-text delnav">Выдано <span class="badge badge-pur-light">6</span></li>' +
        '<li class="navbar-text delnav">Дефект <span class="badge badge-pur-light">0</span></li>';
    $(".myAddTop").append(output);

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

    $(".order ").remove();
  


    var output = '';
    $.each(data, function (key, order) {





        /*form for navigation get pdf*/


        output += '<article class="order">' +
            '<header class="order-header">' +
            '<a href="#" onclick="getNavigation(\'getPdf-\'+' + order.order_id + ')"><div class="order-id">заказ<span>' + order.order_id + '</span></div></a>' +
            '<div class="order-basket">' + order.products.length + '</div>' +
            '<a href="#order-add" class="btn btn-sm order-add"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>' +
            '</header>';

        output += '<div class="displayNone">' +
            ' <form action="orders/page/' + order.order_id + '.pdf" method="get">' +
            '<input id="getPdf-' + order.order_id + '"  class="btn btn-primary" class="btn" type="submit" name="viewAllUsers">' +
            '</form>' +
            '</div>';


        $.each(order.products, function (productKey, product) {

            output += '<section class="order-body">' +
                '<ul class="order-list">';
            output += '<li class="order-list-item">' +


                /*Ссылка на историю дейтсвий тут*/
                '<header class="order-list-item-header"><span class="badge badge-pur">2</span>' +
                '<span class="order-date sep-dot">' + order.startDate + '</span><span class="order-name sep-dot">' + product.product_name + '</span>' +
                '<span class="order-count sep-dot"><i>' + product.countProducts + '</i> шт</span> <span class="order-float-date">' + product.deliveryProductDate + '</span>' +
                '<a href="#" class="btn btn-success btn-xs" data-toggle="open-log">История действий</a>' +
                '<a href="#" class="remove-order-status" data-toggle="remove-order"></a></header>' +
                '<div class="container-fluid">' +
                '<ul class="order-status-list row">';


            $.each(product.actualStatus, function (statusKey, actualStatus) {
                output += '<li class="col-sm-2">' +
                    '<div class="order-status">' +
                    '<div class="order-status-body">' +
                    '<div class="status-top"><span class="status">' + actualStatus.statusName + '</span>' +
                    '<span class="status-date">' + actualStatus.statusDate + '</span></div>' +
                    '<div class="status-bottom"><span>' + actualStatus.user.userName + '</span></div>' +
                    '</div>' +
                    '<a href="#" class="order-status-edit"></a>' +
                    '</div>' +
                    '</li>';

            });

            output += '</ul>' +
                '</div>' +
                '</li>' +
                '</ul>' +
                '</section>';

        });

        output += '</article>';

    });
    output += '</div>';

    $(".lustran-container").append(output);

}
