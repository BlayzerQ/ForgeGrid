<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Site.com</title>

    <!-- Bootstrap core CSS -->
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/webjars/fontawesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="/pages/css/styles.css" rel="stylesheet"/>

    <!-- Bootstrap core JS -->
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- Templates loading JS -->
    <script>
        $(function () {
            $("#navmenuContent").load("/pages/templates/nav_menu.jsp");
            $("#modalsContent").load("/pages/templates/modals.jsp");
            $("#footerContent").load("/pages/templates/footer.jsp");
        });
    </script>

</head>

<body>

<!-- Nav Menu -->
<div id="navmenuContent"></div>

<div class="container nav-correction">
    <div class="jumbotron" style="margin-top: 20px;">

        <!-- Current page main code -->
        <div class="content">

            <h1 class="px-3 pb-4 text-center">Личный кабинет</h1>

            <ul class="nav justify-content-center account-menu">
                <li class="nav-item px-3">
                    <a class="nav-link" href="/account">Личные данные</a>
                </li>
                <li class="nav-item px-3">
                    <a class="nav-link active" href="/account/purchases">Список покупок</a>
                </li>
                <li class="nav-item px-3">
                    <a class="nav-link " href="/account/balance">Пополнение счета</a>
                </li>
            </ul>

            <div class="separator mt-2 mb-5"></div>

            <div class="d-flex justify-content-center">
                <table class="table table-hover table-small">
                    <thead>
                    <tr>
                        <th style="min-width:165px;">Данные покупки</th>
                        <th>Ссылка</th>
                        <th>Стоимость, ₽</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Modals -->
        <div id="modalsContent"></div>

    </div>

    <!-- Modals -->
    <div id="footerContent"></div>

</div>

</body>
</html>