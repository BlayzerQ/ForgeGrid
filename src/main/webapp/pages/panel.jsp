<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

            <h1 class="px-3 pb-4 text-center">Панель разработчика</h1>

            <ul class="nav justify-content-center account-menu">
                <li class="nav-item px-3">
                    <a class="nav-link " href="/panel">Маркет</a>
                </li>
                <li class="nav-item px-3">
                    <a class="nav-link " href="/panel/tasks">Фриланс</a>
                </li>
            </ul>

            <div class="separator mt-2 mb-5"></div>

            <div class="d-flex justify-content-center">
                <div class="col-4 border rounded px-3 pt-3">
                    <c:if test="${empty mode}">
                        <p>Пожалуйста, выберите вкладку выше</p>
                    </c:if>
                    <sec:authorize access="!hasAnyAuthority('DEVELOPER', 'ADMIN')">
                        <p>У вас нет доступа к этой странице</p>
                    </sec:authorize>
                    <sec:authorize access="hasAnyAuthority('DEVELOPER', 'USER')">
                        <button type="button" class="btn btn-block btn-primary mb-3" data-toggle="modal"
                                data-target="#addModal">Добавить
                        </button>
                        <button type="button" class="btn btn-block btn-primary mb-3" data-toggle="modal"
                                data-target="#editModal">Редактировать
                        </button>

                        <!-- Add Modal Window -->
                        <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-sm" role="document">
                                <div class="modal-content">
                                    <div class="modal-header text-center">
                                        <h4 class="modal-title w-100 font-weight-bold modal-correction">
                                            Добавление</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <br>
                                    <div class="container">
                                        <c:if test="${mode == 'products'}">
                                            <form:form method="POST"
                                                       action="${pageContext.request.contextPath}/panel/addproduct"
                                                       modelAttribute="data">
                                                <div class="form-group">
                                                    <form:input path="title" class="form-control md-form"
                                                                placeholder="Название продукта" required="required"/>
                                                    <small><form:errors path="title" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <form:input path="description" class="form-control md-form"
                                                                placeholder="Описание продукта" required="required"/>
                                                    <small><form:errors path="description" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <form:input path="productVersion" class="form-control md-form"
                                                                placeholder="Версия продукта" required="required"/>
                                                    <small><form:errors path="productVersion" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <form:input path="mcVersion" class="form-control md-form"
                                                                placeholder="Версия игры" required="required"/>
                                                    <small><form:errors path="mcVersion" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <form:input path="type" class="form-control md-form"
                                                                placeholder="Тип товара" required="required"
                                                                value="MOD"/>
                                                    <small><form:errors path="type" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <form:input path="price" class="form-control md-form"
                                                                placeholder="Цена" required="required"/>
                                                    <small><form:errors path="price" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <div class="submit-button">
                                                        <hr>
                                                        <input class="btn btn-primary button-correction" type="submit"
                                                               value="Сохранить"/>
                                                    </div>
                                                </div>
                                            </form:form>
                                        </c:if>
                                        <c:if test="${mode == 'tasks'}">
                                            <form:form method="POST"
                                                       action="${pageContext.request.contextPath}/panel/addtask"
                                                       modelAttribute="data">
                                                <div class="form-group">
                                                    <form:input path="title" class="form-control md-form"
                                                                placeholder="Название задачи" required="required"/>
                                                    <small><form:errors path="title" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <form:input path="description" class="form-control md-form"
                                                                placeholder="Описание задачи" required="required"/>
                                                    <small><form:errors path="description" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <form:input path="link" class="form-control md-form"
                                                                placeholder="Ссылка на ресурсы"/>
                                                    <small><form:errors path="link" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <form:input path="price" class="form-control md-form"
                                                                placeholder="Цена" required="required"/>
                                                    <small><form:errors path="price" class="errors"/></small>
                                                </div>
                                                <div class="form-group">
                                                    <div class="submit-button">
                                                        <hr>
                                                        <input class="btn btn-primary button-correction" type="submit"
                                                               value="Сохранить"/>
                                                    </div>
                                                </div>
                                            </form:form>
                                        </c:if>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Edit Item Modal Window -->
                        <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header text-center">
                                        <h4 class="modal-title w-100 font-weight-bold modal-correction">
                                            Редактирование</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <br>
                                    <div class="container">
                                        <c:if test="${empty alldata}">
                                            <center>
                                                <h4>Данные не найдены</h4></center>
                                            <br>
                                        </c:if>
                                        <c:if test="${mode == 'products'}">
                                            <c:forEach var="item" items='${alldata}'>
                                                <div class="jumbotron-new jumbotron-correction">

                                                    <div class="ItemShort">
                                                        <center><p>Название: ${item.title} |
                                                            Версия: ${item.productVersion} | Цена: ${item.price}</p>
                                                        </center>
                                                        <button class="btn btn-success button-correction"
                                                                id="displayItemFull${item.id}"
                                                                onClick="showEdit(${item.id})">Развернуть
                                                        </button>
                                                    </div>

                                                    <div id="ItemFull${item.id}" style="display:none;">
                                                        <br>
                                                        <form:form method="POST"
                                                                   action="${pageContext.request.contextPath}/panel/editproduct"
                                                                   modelAttribute="data">
                                                            <form:input path="id" class="form-control md-form mb-4-new"
                                                                        value="${item.id}" type="hidden"/>
                                                            <div class="form-group">
                                                                <form:label path="title">Название продукта</form:label>
                                                                <form:input path="title"
                                                                            class="form-control md-form mb-4-new"
                                                                            placeholder="Название продукта"
                                                                            value="${item.title}" required="required"/>
                                                                <small><form:errors path="title"
                                                                                    class="errors"/></small>
                                                            </div>
                                                            <div class="form-group">
                                                                <form:label
                                                                        path="description">Описание продукта</form:label>
                                                                <form:input path="description"
                                                                            class="form-control md-form mb-4-new"
                                                                            placeholder="Описание продукта"
                                                                            value="${item.description}"
                                                                            required="required"/>
                                                                <small><form:errors path="description"
                                                                                    class="errors"/></small>
                                                            </div>
                                                            <div class="form-group">
                                                                <form:label
                                                                        path="productVersion">Версия продукта</form:label>
                                                                <form:input path="productVersion"
                                                                            class="form-control md-form mb-4-new"
                                                                            placeholder="Версия продукта"
                                                                            value="${item.productVersion}"
                                                                            required="required"/>
                                                                <small><form:errors path="productVersion"
                                                                                    class="errors"/></small>
                                                            </div>
                                                            <div class="form-group">
                                                                <form:label path="mcVersion">Версия игры</form:label>
                                                                <form:input path="mcVersion"
                                                                            class="form-control md-form mb-4-new"
                                                                            placeholder="Версия игры"
                                                                            value="${item.mcVersion}"
                                                                            required="required"/>
                                                                <small><form:errors path="mcVersion"
                                                                                    class="errors"/></small>
                                                            </div>
                                                            <div class="form-group">
                                                                <form:label path="type">Тип товара</form:label>
                                                                <form:input path="type"
                                                                            class="form-control md-form mb-4-new"
                                                                            placeholder="Тип товара"
                                                                            value="${item.type}" required="required"/>
                                                                <small><form:errors path="type" class="errors"/></small>
                                                            </div>
                                                            <div class="form-group">
                                                                <form:label path="price">Цена</form:label>
                                                                <form:input path="price"
                                                                            class="form-control md-form mb-4-new"
                                                                            placeholder="Цена" value="${item.price}"
                                                                            required="required"/>
                                                                <small><form:errors path="price"
                                                                                    class="errors"/></small>
                                                            </div>
                                                            <input class="btn btn-primary button-correction"
                                                                   type="submit" value="Изменить"/>
                                                        </form:form>
                                                        <form action="/panel/deleteproduct/${item.id}" method="post">
                                                            <input type="hidden" name="${_csrf.parameterName}"
                                                                   value="${_csrf.token}"/>
                                                            <button class="btn btn-danger button-correction"
                                                                    type="submit">Удалить
                                                            </button>
                                                            <br>
                                                        </form>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${mode == 'tasks'}">
                                            <c:forEach var="item" items='${alldata}'>
                                                <div class="jumbotron-new jumbotron-correction">

                                                    <div class="ItemShort">
                                                        <center><p>Название: ${item.title} | Цена: ${item.price}</p>
                                                        </center>
                                                        <button class="btn btn-success button-correction"
                                                                id="displayItemFull${item.id}"
                                                                onClick="showEdit(${item.id})">Развернуть
                                                        </button>
                                                    </div>

                                                    <div id="ItemFull${item.id}" style="display:none;">
                                                        <br>
                                                        <form:form method="POST"
                                                                   action="${pageContext.request.contextPath}/panel/edittask"
                                                                   modelAttribute="data">
                                                            <form:input path="id" class="form-control md-form mb-4-new"
                                                                        value="${item.id}" type="hidden"/>
                                                            <div class="form-group">
                                                                <form:label path="title">Название задачи</form:label>
                                                                <form:input path="title" class="form-control md-form"
                                                                            placeholder="Название задачи"
                                                                            value="${item.title}" required="required"/>
                                                                <small><form:errors path="title"
                                                                                    class="errors"/></small>
                                                            </div>
                                                            <div class="form-group">
                                                                <form:label
                                                                        path="description">Описание задачи</form:label>
                                                                <form:input path="description"
                                                                            class="form-control md-form"
                                                                            placeholder="Описание задачи"
                                                                            value="${item.description}"
                                                                            required="required"/>
                                                                <small><form:errors path="description"
                                                                                    class="errors"/></small>
                                                            </div>
                                                            <div class="form-group">
                                                                <form:label path="link">Ссылка на ресурсы</form:label>
                                                                <form:input path="link" class="form-control md-form"
                                                                            placeholder="Ссылка на ресурсы"
                                                                            value="${item.link}"/>
                                                                <small><form:errors path="link" class="errors"/></small>
                                                            </div>
                                                            <div class="form-group">
                                                                <form:label path="price">Цена</form:label>
                                                                <form:input path="price" class="form-control md-form"
                                                                            placeholder="Цена" value="${item.price}"
                                                                            required="required"/>
                                                                <small><form:errors path="price"
                                                                                    class="errors"/></small>
                                                            </div>
                                                            <input class="btn btn-primary button-correction"
                                                                   type="submit" value="Изменить"/>
                                                        </form:form>
                                                        <form action="/panel/deletetask/${item.id}" method="post">
                                                            <input type="hidden" name="${_csrf.parameterName}"
                                                                   value="${_csrf.token}"/>
                                                            <button class="btn btn-danger button-correction"
                                                                    type="submit">Удалить
                                                            </button>
                                                            <br>
                                                        </form>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </sec:authorize>
                </div>
            </div>
        </div>

        <!-- Modals -->
        <div id="modalsContent"></div>

    </div>

    <!-- Modals -->
    <div id="footerContent"></div>

</div>

<script>
    var curpage = window.location.pathname;
    var addPages = ['/panel/addproduct', '/panel/addtask'];
    var editPages = ['/panel/editproduct', '/panel/edittask']
    if (addPages.includes(curpage)) {
        $("#addModal").modal();
    } else if (editPages.includes(curpage)) {
        $("#editModal").modal();
    }
</script>

<script type="text/javascript">
    function showEdit(item_id) {
        var item = $('#ItemFull' + item_id);
        var button = $('#displayItemFull' + item_id);
        item.slideToggle();
        if (button.text() == 'Развернуть') {
            button.text('Свернуть');
        } else {
            button.text('Развернуть');
        }
    }
</script>

</body>
</html>