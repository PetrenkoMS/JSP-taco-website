function vhodIn() {
    var login = $('#login').val();
    var password = $('#password').val();
    temp=login +"," + password;
    $.ajax({
        type: "POST",
        url: "/inLog",
        data: temp,
        success: function(result){
            alert('Аутентификация прошла успешно! \n Привет ' + login +"!");
                document.getElementById("login").value="";
                document.getElementById("password").value="";

                function getCookie(name) {
                    let match = document.cookie.split('; ').find(row => row.startsWith(`${name}=`));
                    return match ? match.split('=')[1] : undefined;
                }

                var cookies= document.cookie;
                cookieValue = getCookie("sait");
                console.log("cookiesVal: " + cookieValue);
                console.log(typeof cookieValue);
                if (cookieValue) {
                    if (cookieValue == "main") {
                        window.location.href="/";
                    }
                    else {
                        window.location.href="/"+cookieValue;
                    }

                }
//                window.location.reload();
        },
        error: function(result){
            alert('Неверно введен логин или пароль!');
        }
    });

}

