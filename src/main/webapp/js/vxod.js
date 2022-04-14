function vhodIn() {
    var login = $('#login').val();
    function hashCode(s) {
        for(var i = 0, h = 0; i < s.length; i++)
            h = Math.imul(31, h) + s.charCodeAt(i) | 0;
        return h;
    }
    var password_w = $('#password').val();
    var password = hashCode(password_w);
    var temp=login +"," + password;
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
            if (cookieValue) {
                if (cookieValue == "main") {
                    window.location.href="/";
                }
                else {
                    window.location.href="/"+cookieValue;
                }
            }
        },
        error: function(result){
            alert('Неверно введен логин или пароль!');
        }
    });
};

