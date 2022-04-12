function goRegistr() {
    var nl = document.getElementById("newLogin").value;
    var np = document.getElementById("newPassword").value;
    var nlp = nl + "," + np;

    $.ajax({
      type: "POST",
      url: "/registr",
      data: nlp,
      success: function(){
        alert('Вы успешно зарегистрировались');
        document.getElementById("newLogin").value = "";
        document.getElementById("newPassword").value = "";

      },
      error: function(result){
        alert('Такой логин уже есть, или Вы использовали не буквы английского алфавита, или Вы использовали особые символы  (< \" \' > , )');
      }

    });

}