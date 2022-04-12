window.onload = function() {
    var producti = new Array();
    $.ajax({
        type: "GET",
        url: "/prbasket",
        success: function(result){
            alert('Заказ успешно сформирован');
            producti = result.split(';');
            console.log(producti);
            for (let i = 0; i < producti.length; i++){
                var input = document.createElement("input");
                var br = document.createElement("br");
                var btn = document.createElement("input");
                input.setAttribute('type', 'text');
                input.setAttribute("readonly", 'true');
                input.setAttribute('value', producti[i]);
                input.className = i +"btn"+" new_inputs";
                btn.setAttribute('type', 'submit');
                btn.setAttribute('value'," ");
                btn.className = i + "btn " + "new_btn";
                //                    btn.setAttribute("onclick",'window.location.reload()');
                btn.setAttribute("onclick",'deleteProduct(this)');
                var parent = document.getElementById("spisok_basket");
                parent.appendChild(input);
                parent.appendChild(btn);
                parent.appendChild(br);

            }
            //$('#tovar').val(result);   //div поставить. val заменить на html

        },
        error: function(){
            alert('Что-то пошло не так');
        }
    });
};

function deleteProduct(obj) {
    var thisProductClass = obj.className.split(' ')[0];
    var thisProductAndBtn = document.getElementsByClassName(thisProductClass);
    var productDel = thisProductAndBtn[0].value;
//    console.log(productDel);
    $.ajax({
        type: "POST",
        url: "/delbasket",
        data: productDel,
        success: function(result){



}




