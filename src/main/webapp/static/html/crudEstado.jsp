<div id="main" class="container-fluid">
	<h3 class="page-header">Crud Estado</h3>
</div>

<div ng-controller="EstadoController as ctrl">

	<form action="#" method="post">

		<div class="row">

			<div class="form-group col-md-2">
				<label for="cep">Nome</label> 
				<input type="text"	class="form-control" id="nome" ng-model="ctrl.estado.nome">
			</div>

			<div class="form-group col-md-2">
				<label for="cep">Sigla</label> 
				<input type="text" class="form-control" id="sigla" ng-model="ctrl.estado.sigla">
			</div>

		</div>
		
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="reset" class="btn btn-default">Cancelar</button>
			</div>
		</div>

		<div class="tablecontainer">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Sigla</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="p in ctrl.estados">
						<td><span ng-bind="p.id"></span></td>
						<td><span ng-bind="p.nome"></span></td>
						<td><span ng-bind="p.sigla"></span></td>
						<td>
							<button type="button" ng-click="ctrl.edit(p.id)"
								class="btn btn-success custom-width">Editar</button>
							<button type="button" ng-click="ctrl.remove(p.id)"
								class="btn btn-danger custom-width">Remover</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>


	</form>
	
</div>	