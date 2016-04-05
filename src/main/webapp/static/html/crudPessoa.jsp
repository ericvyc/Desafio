	<div id="main" class="container-fluid">
		<h3 class="page-header">Crud Pessoa</h3>
	</div>
	
	<div ng-controller="PessoaController as ctrl">

	<form method="post" ng-submit="ctrl.submit()">
		<!-- area de campos do form -->

		<div class="row">
			<div class="form-group col-md-4">
				<label for="nomePessoa">Nome</label> 
				<input type="text" class="form-control" id="nome" ng-model="ctrl.pessoa.nome" ng-required="required">
			</div>

			<div class="form-group col-md-2">
				<label for="dataNascimento">Data Nascimento</label>
				<input type="text" class="form-control" id="dataNascimento" ng-model="ctrl.pessoa.dataNascimento" ng-required="required">
			</div>

			<div class="form-group col-md-2">
				<label for="sexo">Sexo</label>
				<select id="sexo" class="form-control" ng-model="ctrl.pessoa.sexo" ng-required="required">
					<option value="F">Feminino</option>
					<option value="M">Masculino</option>
				</select>
			</div>
			
			<div class="form-group col-md-4">
				<label for="cpf">CPF</label> 
				<input type="text" class="form-control" id="cpf" ng-model="ctrl.pessoa.cpf" ng-required="required" ui-mask="999.999.999-99">
			</div>
			
			
		</div>


		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="reset" class="btn btn-default">Cancelar</button>
			</div>
		</div>
	</form>
	
	<div class="tablecontainer">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Data de Nascimento</th>
					<th>Sexo</th>
					<th>CPF</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="p in ctrl.pessoas">
					<td><span ng-bind="p.id"></span></td>
					<td><span ng-bind="p.nome"></span></td>
                    <td><span ng-bind="p.dataNascimento"></span></td>
                    <td><span ng-bind="p.sexo"></span></td>
                    <td><span ng-bind="p.cpf"></span></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	</div>