start();

async function start() {
    let tmp = await onload_function(); //await - я за вами
//    set_input_value(tmp); // а я после вас
};

async function onload_function() {
    window.onload = async function() {
    var producti = [];
        $.ajax({
              type: "GET",
              url: "/prbasket",
              success: function(result){
                  alert('Заказ успешно сформирован');
                  let html = '';
                  producti = result.split(';');
                  console.log(result);
                  console.log(producti);
                  for (let i in producti.length()){
                        html += "<input value = "'+ producti[i] + '"readonly>";
                  }
                        $('#spisok_basket').html(html);
//                      $('#tovar').val(result);   //div поставить. val заменить на html

              },
              error: function(){
                    alert('Что-то пошло не так');
              }
        });
//    console.log(producti);
    };
//    console.log(typeof producti)
return producti;

    //    producti че хочу
};





//async function set_input_value(producti){
////    console.log(typeof producti);
//    $('#tovar').val(producti);
//};

//var producti = "";
//
//window.onload = function() {
//    $.ajax({
//          type: "GET",
//          url: "/prbasket",
//          success: function(result){
//                alert('Заказ успешно сформирован');
//                    $('#tovar').val(result);
//                producti=result;
//          },
//          error: function(){
//                alert('Что-то пошло не так');
//          }
//    });
//};



