<div id="main" class="container-fluid">
	<h3 class="page-header">Crud Endereco</h3>
</div>

<div ng-controller="EnderecoController as ctrl">

	<form action="#" method="post">

		<div class="row">

			<div class="form-group col-md-2">
				<label for="cep">CEP</label> 
				<input type="text"	class="form-control" id="cep" ng-model="ctrl.endereco.cep" ng-blur="ctrl.getEndereco(ctrl.endereco.cep)">
			</div>
			
			<div class="form-group col-md-2">
				<label for="numero">Número</label> 
				<input type="text" class="form-control" id="numero" ng-model="ctrl.endereco.numero">
			</div>
			
			<div class="form-group col-md-4">
				<label for="logradouro">Endereço</label> 
				<input type="text"	class="form-control" id="logradouro" ng-model="ctrl.endereco.logradouro">
			</div>
			
			<div class="form-group col-md-4">
				<label for="complemento">Complemento</label> 
				<input type="text"	class="form-control" id="complemento" ng-model="ctrl.endereco.complemento">
			</div>

		</div>
		
		<div class="row">
		
			<div class="form-group col-md-4">
				<label for="bairro">Bairro</label> 
				<input type="text" class="form-control" id="bairro" ng-model="ctrl.endereco.bairro">
			</div>
			
			<div class="form-group col-md-4">
				<label for="localidade">Cidade</label> 
				<input type="text" class="form-control" id="localidade" ng-model="ctrl.endereco.localidade">
			</div>
			
			<div class="form-group col-md-2">
				<label for="uf">Estado</label> 
				<input type="text" class="form-control" id="uf" ng-model="ctrl.endereco.uf">
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

</div>
