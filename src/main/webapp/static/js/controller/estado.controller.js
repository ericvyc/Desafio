'use strict';
 
App.controller('EstadoController', ['$scope', 'EstadoService', function($scope, EstadoService) {
          var self = this;
          self.estado={id:'',nome:'',dataNascimento:'',sexo:'',cpf:''};
          self.estados=[];
               
          self.fetchAllUsers = function(){
        	  EstadoService.fetchAllUsers()
                  .then(
                               function(d) {
                                    self.pessoas = d;
                               },
                                function(errResponse){
                                    console.error('Erro ao buscar pessoas');
                                }
                       );
          };
          
          self.criarPessoa = function(pessoa){
              EstadoService.criarPessoa(pessoa)
                      .then(
                      self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Erro ao criar pessoa.');
                              } 
                  );
          };
          
          self.updatePessoa = function(pessoa, id){
              EstadoService.updatePessoa(pessoa, id)
                      .then(
                              self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Erro ao atualizar pessoa.');
                              } 
                  );
          };
          
          self.deletePessoa = function(id){
              EstadoService.deletePessoa(id)
                      .then(
                              self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Erro ao deletar pessoa.');
                              } 
                  );
          };
          

		 self.deletarTodos = function() {
				EstadoService.deletarTodos().then(self.fetchAllUsers,
						function(errResponse) {
							console.error('Erro ao deletar todas as pessoas.');
						});
			};
          
          self.submit = function() {
              if(self.pessoa.id === null  || self.pessoa.id === undefined || self.pessoa.id === ''){
                  console.log('Salvando novo usuário', self.pessoa);    
                  self.criarPessoa(self.pessoa);
              }else{
                  self.updatePessoa(self.pessoa, self.pessoa.id);
                  console.log('Pessoa atualizada com o id ', self.pessoa.id);
              }
              self.reset();

          };
          
          self.edit = function(id){
              console.log('id para ser editado', id);
              for(var i = 0; i < self.pessoas.length; i++){
                  if(self.pessoas[i].id === id) {
                     self.pessoa = angular.copy(self.pessoas[i]);
                     break;
                  }
              }
          };
          
          self.remove = function(id){
              console.log('id para ser deletado', id);
              if(self.pessoa.id === id) {
                 self.reset();
              }
              self.deletePessoa(id);
          };
          
          self.reset = function(){
              self.pessoa={id:'',nome:'',dataNascimento:'',sexo:'',cpf:''};
              $scope.meuForm.$setPristine();
          };
            
          self.fetchAllUsers();
 
      }]);