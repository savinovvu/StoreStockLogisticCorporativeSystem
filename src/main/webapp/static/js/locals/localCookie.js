function setLocal(id) {
  
    var localName = $("#localName-" + id).val();
    $.cookie("cookie_localName", localName, {expires:10000});
    readCookie();
    
}

function readCookie() {
    var cookie = $.cookie("cookie_localName");
    alert("Вы выбрали: " + cookie);
}
