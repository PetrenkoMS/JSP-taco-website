<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../CSS/css/bootstrap.css">
    <link rel="stylesheet" href="../CSS/catalogStyle.css">


    <title>Каталог</title>

    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

    <script src="../js/ingr.js"></script>




    <script>

        jQuery(function($) {
        var $text = $('#text_input'), $box = $('.prod');

        $box.on('click change', function() {
            var values = [];

            $box.filter(':checked').each(function() {
                values.push(this.value);
            });

            $text.val(values.join(','));

            });
        });



    </script>

</head>
<body>
    <!--Меню -->
    <div class="navbar navbar-inverse fixed-top navbar-expand-md">
        <div class="container navi">
            <a class="navbar-brand logotip" href="/">Sombrero</a>
            <a class="btn btn-navbar" data-bs-toggle="collapse" data-bs-target=".navbar-collapse">
                <span class="navbar-toggler-icon"></span>
            </a>
            <div class="navbar-collapse collapse"> <!--Меню сворачивается в выпадающий btn-->
                <ul class="navbar-nav"> <!--меню, которое будет придвинуто к правой стороне -->
                    <li class="nav-item"><a onclick="location.href='/catalog'" class="nav-link nav_li">Каталог</a></li>
                    <li class="nav-item"><a href="#hit" class="nav-link nav_li">Хит продаж</a></li>
                    <li class="nav-item"><a href="#discount" class="nav-link nav_li">Акции</a></li>
                    <li class="nav-item"><a onclick="location.href='/basket'" class="nav-link nav_li">Корзина</a></li>
                    <li class="nav-item"><a href="#info" class="nav-link nav_li">О нас</a></li>
                </ul>
            </div>

            <input type="submit" value="Войти" onclick="location.href='/logOn'" class="list-group-item list-group-item-success btn btn-large btn-success" >

        </div>
    </div>


    <!--Заголовок-->
    <!--<form action="BtnServlet" method="GET"> -->
    <div class="container">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-10" id="heading">
                <div id="about">
                    <h3> Каталог </h3>
                    <p> Здесь Вы можете выбрать ингредиенты для Вашего тако.
                    Для этого просто поставьте галочку напротив нужного ингредиента.
                    Помните, при выборе большого количества ингредиентов, их общее количество в тако уменьшается.
                    После выбора ингредиентов нажмите на кнопку "Добавить в заказ".
                    Затем в меню нажмите на "Корзина" для того, чтобы оформить заказ. </p>
            </div>
            <div class="col-1"></div>


            <div class="divider"></div>


            <fieldset>
                <legend>В какой тортилье делать?</legend>
                <input type="radio" name="tortilia" id="corn" value="Kykyryznaya tortilla" class="prod" checked> Кукурузная тортилья
                <br>
                <input type="radio" name="tortilia" id="wheat" value="Wheat tortilla" class="prod"> Пшеничная тортилья
            </fieldset>


            <div class="divider"></div>

            <input type="hidden" id="text_input" name="text_input"  />
            <div class="row">
                <div class="col-1"></div>
                <div class="col-4">
                    <table border="2" cellspacing="0" cellpadding="2" width="100%" align="center" class="spisok">

                        <tr>
                           <td> Курица </td>
                           <td> <input type="checkbox" name="choice" id="chicken" value="Chicken" class="prod"> </td>
                        </tr>
                        <tr>
                           <td>  Говядина (стейк) </td>
                           <td><input type="checkbox" name="choice" id="beef" value="Steak beef" class="prod" ></td>
                        </tr>
                        <tr>
                           <td>  Свинина (стейк) </td>
                           <td><input type="checkbox" name="choice" id="pig" value="Steak pig" class="prod" ></td>
                        </tr>
                        <tr>
                           <td>  Говядина (фарш) </td>
                           <td><input type="checkbox" name="choice" id="beef_f" value="Mince beef" class="prod"></td>
                        </tr>
                        <tr>
                           <td>  Свинина (фарш) </td>
                           <td><input type="checkbox" name="choice" id="pig_f" value="Mince pig" class="prod"></td>
                        </tr>
                        <tr>
                           <td>  Бекон </td>
                           <td><input type="checkbox" name="choice" id="bacon" value="Bacon" class="prod"></td>
                        </tr>
                        <tr>
                           <td>  Салат(зеленый) </td>
                           <td><input type="checkbox" name="choice" id="salad" value="Salad" class="prod"></td>
                        </tr>
                        <tr>
                           <td> Базилик </td>
                           <td><input type="checkbox" name="choice" id="basil" value="Basil" class="prod"></td>
                        </tr>
                        <tr>
                           <td>  Петрушка </td>
                           <td><input type="checkbox" name="choice" id="parsley" value="Parsley" class="prod"></td>
                        </tr>
                        <tr>
                           <td>  Укроп </td>
                           <td><input type="checkbox" name="choice" id="dill" value="Dill" class="prod"></td>
                        </tr>
                        <tr>
                           <td>  Огурец </td>
                           <td><input type="checkbox" name="choice" id="cucumber" value="Cucumber" class="prod"></td>
                        </tr>
                        <tr>
                           <td>  Маринованный огурец </td>
                           <td><input type="checkbox" name="choice" id="cucumber_m" value="Pickled cucumber" class="prod"></td>
                        </tr>
                        <tr>
                           <td>  Помидор </td>
                           <td><input type="checkbox" name="choice" id="tomato" value="Tomato" class="prod"></td>
                        </tr>

                    </table>
                </div>
                <div class="col-2"></div>

                <div class="col-4">
                    <table border="2" cellspacing="0" cellpadding="2" width="100%" align="center" class="spisok">
                        <tr>
                           <td>Сыр</td>
                           <td><input type="checkbox" name="choice" id="cheese" value="Cheese" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Лук (репчатый)</td>
                            <td><input type="checkbox" name="choice" id="onion" value="Onion" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Лук (зеленый)</td>
                            <td><input type="checkbox" name="choice" id="s_onion" value="String onion" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Болгарский перец</td>
                            <td><input type="checkbox" name="choice" id="pepper_b" value="Bulg pepper" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Перец чили</td>
                            <td><input type="checkbox" name="choice" id="pepper_c" value="Chili pepper" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Перец каролинский жнец</td>
                            <td><input type="checkbox" name="choice" id="pepper_k" value="Very hot pepper" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Фасоль</td>
                            <td><input type="checkbox" name="choice" id="bean" value="Bean" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Кинза</td>
                            <td><input type="checkbox" name="choice" id="kinza" value="Kinza" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Чеснок</td>
                            <td><input type="checkbox" name="choice" id="garlic" value="Garlic" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Имбирь</td>
                            <td><input type="checkbox" name="choice" id="ginger" value="Ginger" class="prod"> </td>
                        </tr>
                        <tr>
                            <td>Ананас</td>
                            <td><input type="checkbox" name="choice" id="pineapple" value="Pineapple" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Картошка</td>
                            <td><input type="checkbox" name="choice" id="potato" value="Potato" class="prod"></td>
                        </tr>
                        <tr>
                            <td>Авокадо</td>
                            <td><input type="checkbox" name="choice" id="avocado" value="Avocado" class="prod"></td>
                        </tr>

                    </table>
                </div>
                <div class="col-1"></div>

            </div>
            <br>
            <div class="row">
                <div class="col-5"></div>
                <div class="col-2">
                    <input id="basket" type="submit" value="Добавить в заказ" onclick="addProducts()" class="list-group-item list-group-item-success btn btn-large btn-success">
                </div>
                <div class="col-5"></div>
            </div>
        </div>


    </div>
    <!--</form>-->





    <script src="../js/js/bootstrap.js"></script>

</body>

</html>