function addProducts() {
    var temp = $('#text_input').val();
    console.log(temp);
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