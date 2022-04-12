function addProducts() {
    var temp = $('#text_input').val();


//    if ($('#chicken').checked==true) {
//        var temp = {chicken:1,
//                salad:0, cheese:1};
//            console.log(temp);
//    }
//------------------------------------------
//    var temp = {chicken: $('#chicken').val(),
//        salad: $('#salad').val()};
//    console.log(temp);
//-> temp - словарик
//---> запрос
//--> надо сервлет
    $.ajax({
      type: "POST",
      url: "/zakaz",
      data: temp,
      success: function(){
          alert('Заказ успешно сформирован');
        },
        error: function(){
          alert('Что-то пошло не так');
        }
    });

}