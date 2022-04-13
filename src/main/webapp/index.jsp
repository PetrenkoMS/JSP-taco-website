<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--<!DOCTYPE html>-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="CSS/css/bootstrap.css">
    <link rel="stylesheet" href="CSS/style.css">
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
                    <li class="nav-item"><a href="#hit" class="nav-link nav_li">Хит продаж</a></li>
                    <li class="nav-item"><a href="#discount" class="nav-link nav_li">Акции</a></li>
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


    <!-- header -->
    <div>
    <br><br><br><br>
    </div>


    <script src="js/main.js"></script>
    <script src="js/vxod.js"></script>
    <script src="js/js/bootstrap.js"></script>
</body>
</html>



