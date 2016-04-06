	<div id="main" class="container-fluid">
		<h3 class="page-header">Crud Pessoa</h3>
	</div>
	
	<div ng-controller="PessoaController as ctrl">

	<form method="post" ng-submit="ctrl.submit()" name="meuForm" class="form-horizontal">
		<!-- area de campos do form -->
	
		<input type="hidden" ng-model="ctrl.pessoa.id" />
	
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
				<input type="submit"  value="{{!ctrl.pessoa.id ? 'Adicionar' : 'Atualizar'}}" class="btn btn-primary btn-sm" ng-disabled="meuForm.$invalid">
                <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpar Formulário</button>
                <button type="button" ng-click="ctrl.deletarTodos()" class="btn btn-danger btn-sm">Deletar todas as Pessoas</button>
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
					<th width="20%"></th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="p in ctrl.pessoas">
					<td><span ng-bind="p.id"></span></td>
					<td><span ng-bind="p.nome"></span></td>
                    <td><span ng-bind="p.dataNascimento"></span></td>
                    <td><span ng-bind="p.sexo"></span></td>
                    <td><span ng-bind="p.cpf"></span></td>
                    <td>
                      <button type="button" ng-click="ctrl.edit(p.id)" class="btn btn-success custom-width">Editar</button>  
                      <button type="button" ng-click="ctrl.remove(p.id)" class="btn btn-danger custom-width">Remover</button>
                    </td>
				</tr>
			</tbody>
		</table>
	</div>
	
	</div>