<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Incluir Pessoa</title>
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
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/pessoa.service.js' />"></script>
	<script src="<c:url value='/static/js/controller/pessoa.controller.js' />"></script>
</head>
<body ng-app="meuApp" class="ng-cloak">

	<div id="main" class="container-fluid">
		<h3 class="page-header">Crud Pessoa</h3>
	</div>
	
	<div ng-controller="PessoaController as ctrl">

	<form action="adicionarPessoa" method="post">
		<!-- area de campos do form -->

		<div class="row">
			<div class="form-group col-md-4">
				<label for="nomePessoa">Nome</label> 
				<input type="text" class="form-control" id="nome" ng-model="ctrl.pessoa.nome">
			</div>

			<div class="form-group col-md-2">
				<label for="dataNascimento">Data Nascimento</label>
				<input type="date" class="form-control" id="dataNascimento">
			</div>

			<div class="form-group col-md-2">
				<label for="sexo">Sexo</label> <br />
				<select id="sexo" class="form-control">
					<option value="F">Feminino</option>
					<option value="M">Masculino</option>
				</select>
			</div>
		</div>


		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary">Salvar</button>
				<a href="index.html" class="btn btn-default">Cancelar</a>
			</div>
		</div>
	</form>
	
	<div class="tablecontainer">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Data de Nascimento</th>
					<th>Sexo</th>
					<th>CPF</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="p in ctrl.pessoas">
					<td><span ng-bind="p.nome"></span></td>
                    <td><span ng-bind="p.dataNascimento"></span></td>
                    <td><span ng-bind="p.sexo"></span></td>
                    <td><span ng-bind="p.cpf"></span></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	</div>
	
</body>
</html>