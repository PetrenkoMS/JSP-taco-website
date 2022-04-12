window.onload = function() {
    var producti = new Array();
    var allprod = new Array();
    $.ajax({
        type: "GET",
        url: "/prbasket",
        success: function(result){
            withAllPrice = result.split("|");
            allprod = withAllPrice[0].split("%");
            producti = allprod[0].split(';');
            cena = allprod[1].split(";");
            producti.pop();
            for (let i = 0; i < producti.length; i++){
                var input = document.createElement("input");
                var pinput = document.createElement("input");
                var br = document.createElement("br");
                var btn = document.createElement("input");
                input.setAttribute('type', 'text');
                input.setAttribute("readonly", 'true');
                input.setAttribute('value', producti[i]);
                input.className = i +"btn"+" new_inputs" + " forStatus" ;

                pinput.setAttribute('type', 'text');
                pinput.setAttribute("readonly", 'true');
                pinput.setAttribute('value', cena[i]);
                pinput.className = i +"btn"+" new_pinputs";

                btn.setAttribute('type', 'submit');
                btn.setAttribute('value'," ");
                btn.className = i + "btn" + " new_btn";
                //                    btn.setAttribute("onclick",'window.location.reload()');
                btn.setAttribute("onclick",'deleteProduct(this)');
                var parent = document.getElementById("spisok_basket");
                parent.appendChild(input);
                parent.appendChild(pinput);
                parent.appendChild(btn);
                parent.appendChild(br);

            }
            document.getElementById("sum_pay").value = "Итого: " + withAllPrice[1] + " rub";

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
            alert('Заказ удален');
            location.reload();
        },
        error: function(){
            alert('Что-то пошло не так');
        }
    });

};

function pay() {
    var payBtn = document.getElementById("payInfo");
    var payBtnOld = document.getElementById("pay");
    payBtn.style.display = "block";
    payBtnOld.style.display="none";
}

function payNow() {
    var payBtn = document.getElementById("payInfo");
    var payBtnOld = document.getElementById("pay");
    var elProducts = document.getElementsByClassName("forStatus");
    var products = new Array();
    for (let i = 0; i < elProducts.length; i++) {
        products.push(elProducts[i].value);
    }
    productsOne=products.join(";");
    payBtn.style.display = "none";
    payBtnOld.style.display="block";
    $.ajax({
        type: "POST",
        data: productsOne,
        url: "/status",
        success: function(result){
            alert('Спасибо за покупку! Теперь я съем Ваш заказ!');
            document.location.href="/";
        },
        error: function(){
            alert('Что-то пошло не так');
        }
    });
}


