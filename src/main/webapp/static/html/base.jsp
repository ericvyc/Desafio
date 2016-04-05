<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Crud</title>
<style>
.nome.ng-valid {
	background-color: lightgreen;
}

.nome.ng-dirty.ng-invalid-required {
	background-color: red;
}

.nome.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.18/angular-ui-router.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/pessoa.service.js' />"></script>
	<script src="<c:url value='/static/js/controller/pessoa.controller.js' />"></script>
	<script src="<c:url value='/static/js/service/endereco.service.js' />"></script>
	<script src="<c:url value='/static/js/controller/endereco.controller.js' />"></script>
</head>
<body ng-app="meuApp" class="ng-cloak">

<div class="container">

<h1>Crud's</h1>

<a ui-sref="pessoa" class="btn btn-primary">Crud de Pessoa</a>
<a ui-sref="endereco" class="btn btn-primary">Crud de Endereço</a>

<div ui-view></div>

</div>

</body>
</html>