function vhodIn() {
    var login = $('#login').val();
    var password = $('#password').val();
    temp=login +"," + password;
    $.ajax({
        type: "POST",
        url: "/inLog",
        data: temp,
        success: function(){
            alert('Авторизация прошла успешно! \n Привет ' + login +"!");
            document.getElementById("login").value="";
            document.getElementById("password").value="";
            window.location.href='/';
//            var vhod = getElementsByClassName("vhod");
//            vhod.style.display = "none";
//            var vihod = getElementsByClassName("vihod");
//            var yourLog = getElementsByClassName("yourLog");
//            vihod.style.display="block";
//            yourLog.style.display="block";
        },
        error: function(result){
            alert('Неверно введен логин или пароль!');
        }
    });


}