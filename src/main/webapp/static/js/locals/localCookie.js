function setLocal(id) {
    alert(id);
    var localName = $(".localName-" + id).val();
    $.cookie("cookie_localName", localName, {expires:10000});
     var cookie = $.cookie("cookie_localName");
    alert("cookie-" + cookie);
    
}