<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--<!DOCTYPE html>-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="CSS/css/bootstrap.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <title>Vamos Tacos! Vamos Tacos!</title>

    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
    <!--Меню -->
    <div class="navbar navbar-inverse fixed-top navbar-expand-md">
        <div class="container navi">
            <a class="navbar-brand logotip" href="#">Sombrero</a>
            <a class="btn btn-navbar" data-bs-toggle="collapse" data-bs-target=".navbar-collapse">
                <span class="navbar-toggler-icon"></span>
            </a>
            <div class="navbar-collapse collapse"> <!--Меню сворачивается в выпадающий btn-->
                <ul class="navbar-nav"> <!--меню, которое будет придвинуто к правой стороне -->
                    <li class="nav-item"><a onclick="location.href='/catalog'" class="nav-link nav_li">Каталог</a></li>
                    <li class="nav-item"><a href="#unhit" class="nav-link nav_li">Хит продаж</a></li>
                    <li class="nav-item"><a href="#undiscount" class="nav-link nav_li">Акции</a></li>
                    <li class="nav-item"><a onclick="location.href='/basket'" class="nav-link nav_li">Корзина</a></li>
                    <li class="nav-item"><a href="#info" class="nav-link nav_li">О нас</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-8">
                    <input type="text" id="yourLog" readonly="true" class="yourLog" style="display:none;">
                </div>
                <div class="col-4">
                    <input type="submit" id="vihod"  style="display:none; margin-right: 200px" value="Выйти" onclick="ext()" style="text-align:center" class="list-group-item list-group-item-action list-group-item-primary btn btn-large vihod">
                    <input type="submit" id="vhod" style="display:block; margin-right: 200px;" value="Войти" onclick="location.href='/logOn'" class="list-group-item list-group-item-success btn btn-large btn-success vhod" >
                </div>
            </div>
        </div>
    </div>

    <div>
    <br><br><br><br>
    </div>

     <div class="container">
        <div id="about">
            <div id ="heading">
                <h1 style="text-align:center;"> Tacos Vamos! </h1>
                <p class="lead" style="font-size:24px;"> Тако - традиционное блюдо мексиканской кухни.
                 Тако состоит из кукурузной или пшеничной тортильи c разнообразной начинкой.
                 Начинку Вы сможете выбрать любую из предложенных, перейдя по вкладе "Каталог" в меню.
                 Заказать тако и просматривать ингредиенты могут <b> только зарегистрированные </b> пользователи.
                 Для регистрации или аутентификации Вы можете нажать кнопку "Войти", сверху в меню.
                 Хотя можете и не заходить, все равно придется зарегистрироваться.
                 Заказывайте тако быстрее и скорее его лопайте... и заказывайте еще :) </p>
            </div>

            <div id="unhit" class="divider"></div>

            <div id="hit">
                <h1> XIT Tacos </h1>
                <p class="lead" style="font-size:24px;"> Здесь Вы сможете увидеть популярные тако с их начинкой.
                 Но сейчас здесь пусть, так как мы только открылись и не хотим Вас обманывать.
                 Здесь будут самые популярные тако, которые у нас заказывают, когда будет продано достаточное количество тако и через какое-то время.
                 Вы можете помочь узнать самый популярный тако! Заказывайте свое любимое тако почаще! Vamos-vamos!</p>
            <div>

            <div id="undiscount" class="divider"></div>

            <div id="discount">
                <h1 > Акции </h1>
                <p class="lead" style="font-size:24px;"> Все любят акции и скидки. Здесь будут проявлять выгодные предложения и другие разные акции. </p>
            </div>
        </div>
    </div>

    <footer id="info">
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col-5 fcol5">
                    <h3>О сайте</h3>
                    <p>Сайт создан для научного интереса и практики. Реальное тако вы здесь не закажете. Поэтому не рекомендую Вам оставлять реальные реквизиты карты, логин и пароль</p>
                </div>
                <div class="col-5 fcol5">
                    <h3>Информация</h3>
                    <p>Подписывайтесь, чтобы получать уведомления об изменениях на сайте</p>
                    <form action="" class="form-inline">
                        <input type="text" class="input-large" placeholder="Email"/>
                        <buttom type="submit" class="btn btn-info">Подписаться</buttom>
                    </form>
                    <p> Также можете отправить отзыв о нашем товаре и сайте к нам на почту <a href="Tacomania@taco.ua"> Tacomania@taco.ua <a><p>
                </div>
                <div class="col">
                </div>
            </div>
            <div class="row" style="padding-top:15px; padding-bottom:35px;" >
                <div class="footer-icons">
                    <p><small>Copyright 2022, ОАО "Sombrero"</small></p>
                    <a href="https://ru.wikipedia.org/wiki/Facebook"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://ru.wikipedia.org/wiki/Твиттер"><i class="fab fa-twitter"></i></a>
                    <a href="https://www.youtube.com"><i class="fab fa-youtube"></i></a>
                </div>
            </div>
        </div>
    </footer>

    <script src="js/main.js"></script>
    <script src="js/vxod.js"></script>
    <script src="js/js/bootstrap.js"></script>
</body>
</html>



