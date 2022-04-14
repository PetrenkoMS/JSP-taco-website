function addProducts() {
    var temp = $('#text_input').val();
    $.ajax({
        type: "POST",
        url: "/zakaz",
        data: temp,
        success: function(){
            alert('Заказ успешно сформирован');
//            var inputArr=document.querySelectorAll("input[type=checkbox]");
//            inputArr.forEach(function(el) {
//                el.checked = false;
//            });
//            var corni = document.getElementById("corn");
//            corni.checked = true;
            window.location.reload();
        },
        error: function(){
            alert('Что-то пошло не так');
        }
    });
}


window.onload = function(){
    function getCookie(name) {
        let match = document.cookie.split('; ').find(row => row.startsWith(`${name}=`));

        return match ? match.split('=')[1] : undefined;
    }

    var cookies= document.cookie;
    cookieValue = getCookie("user");
    console.log("cookiesVal: " + cookieValue);
    console.log(typeof cookieValue);
    if (cookieValue) {
        var vhod = document.getElementById("vhod2");
        vhod.style.display = "none";
        var vihod = document.getElementById("vihod2");
        var yourLog = document.getElementById("yourLog2");
        vihod.style.display="block";
        yourLog.style.display="block";
        yourLog.value = cookieValue;
    }
}

function ext() {

    $.ajax({
        type: "GET",
        url: "/ext",
        success: function(result) {
            window.location.href="/";
        },
            error: function(result) {
        }
    });

}