function deleteProduct(obj) {
    var thisProductClass = obj.className.split(' ')[0];
    var thisProductAndBtn = document.getElementsByClassName(thisProductClass);
    var productDel = thisProductAndBtn[0].value;
    var kk = document.getElementsByClassName(thisProductClass)[2].id;
    $.ajax({
        type: "POST",
        url: "/delbasket",
        data: kk,
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
    var cart_number = document.getElementById("cart_number").value;
    var cart_name = document.getElementById("cart_name").value;
    var time_number = document.getElementById("time_number").value;
    var sumpay = document.getElementById("sum_pay0");
    if (sumpay.value != "Итого: 0 rub") {
        if ((cart_number.length >= 7) & (cart_name.length >= 2 )& (time_number.length >=3)) {
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
        else {
            alert('Введите, пожалуйста, корректные данные');
        }
    }
    else {
        alert("Вы ничего не заказали");
    }
}

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
            id_id = withAllPrice[2].split(";");
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
                btn.setAttribute('id', id_id[i]);
                btn.className = i + "btn" + " new_btn";
                btn.setAttribute("onclick",'deleteProduct(this)');

                var parent = document.getElementById("spisok_basket");
                parent.appendChild(input);
                parent.appendChild(pinput);
                parent.appendChild(btn);
                parent.appendChild(br);
            }
            var itog = "Итого: " + withAllPrice[1] + " rub";
            $('#sum_pay0').val(itog);
            function getCookie(name) {
                    let match = document.cookie.split('; ').find(row => row.startsWith(`${name}=`));
                    return match ? match.split('=')[1] : undefined;
                }
                var cookies= document.cookie;
                cookieValue = getCookie("user");
                if (cookieValue) {
                    var vhod = document.getElementById("vhod3");
                    vhod.style.display = "none";
                    var vihod = document.getElementById("vihod3");
                    var yourLog = document.getElementById("yourLog3");
                    vihod.style.display="block";
                    yourLog.style.display="block";
                    yourLog.value = cookieValue;
                }
        },
        error: function(){
            alert('Что-то пошло не так');
        }
    });
};

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


