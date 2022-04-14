function goRegistr() {
    var nl = document.getElementById("newLogin").value;
    var np_w = document.getElementById("newPassword").value;
    if ((nl.length >= 3) & (np_w.length >= 3)) {
        var simvoli = ",\"\'/|\\<>;()"
        var flag_s=0;
        var flag_w=0;
        var rus_w='йцукенгшщзхъфывапролджэячсмитьбюё';
        for (var i = 0; i < simvoli.length; i++) {
            if ((nl.includes(simvoli[i])) | (np_w.includes(simvoli[i]))){
                flag_s = 1;
            }
        }
        for (var i = 0; i < rus_w.length; i++) {
            if (nl.includes(rus_w[i])){
                flag_w = 1;
            }
        }
        if (flag_s == 0) {
            if (flag_w == 0) {
                function hashCode(s) {
                    for(var i = 0, h = 0; i < s.length; i++)
                        h = Math.imul(31, h) + s.charCodeAt(i) | 0;
                    return h;
                }
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
                    alert('Такой логин уже есть');
                  }
                });
            }
            else {
                alert("Логин может содержать только английские буквы");
            }
        }
        else {
            alert("Логин и/или пароль содержит запрещенные спец. символы");
        }
    }
    else {
        alert("Логин и/или пароль должны содержать как минимум 3 символа");
    }
};