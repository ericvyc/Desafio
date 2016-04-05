<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Incluir Pessoa</title>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="../static/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/angularjs/angular.js"></script>
<link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<div id="main" class="container-fluid">
		<h3 class="page-header">Incluir Pessoa</h3>
	</div>

	<form action="adicionarPessoa" method="post">
		<!-- area de campos do form -->

		<div class="row">
			<div class="form-group col-md-4">
				<label for="nomePessoa">Nome</label> 
				<input type="text" class="form-control" id="nomePessoa">
			</div>

			<div class="form-group col-md-4">
				<label for="dataNascimento">Data Nascimento</label>
				<input type="date" class="form-control" id="dataNascimento">
			</div>

			<div class="form-group col-md-4">
				<label for="sexo">Sexo</label> 
				<select>
					<option value="feminino">Feminino</option>
					<option value="masculino">Masculino</option>
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

</body>
</html>