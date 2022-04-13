window.onload = function(){
    $.ajax({
        type: "GET",
        url: "/sombrero",
        success: function(){
        },
        error: function(){
        }
    });

    function getCookie(name) {
      let match = document.cookie.split('; ').find(row => row.startsWith(`${name}=`));

      return match ? match.split('=')[1] : undefined;
    }

    var cookies= document.cookie;
    cookieValue = getCookie("user");
    console.log("cookiesVal: " + cookieValue);
    console.log(typeof cookieValue);
    if (cookieValue) {
        var vhod = document.getElementById("vhod");
        vhod.style.display = "none";
        var vihod = document.getElementById("vihod");
        var yourLog = document.getElementById("yourLog");
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


