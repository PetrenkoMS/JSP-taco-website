function goRegistr() {
    var nl = document.getElementById("newLogin").value;
    var np = document.getElementById("newPassword").value;
    var nlp = nl + "," + np;

    $.ajax({
      type: "POST",
      url: "/registr",
      data: nlp,
      success: function(){
        alert('Успешная авторизация');
      },
      error: function(result){
        alert('Такой логин уже есть');
        console.log(result);
      }

    });

}