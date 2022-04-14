function goRegistr() {
    var nl = document.getElementById("newLogin").value;
    function hashCode(s) {
        for(var i = 0, h = 0; i < s.length; i++)
            h = Math.imul(31, h) + s.charCodeAt(i) | 0;
        return h;
    }

    var np_w = document.getElementById("newPassword").value;
    var np = hashCode(np_w);
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