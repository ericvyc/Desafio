'use strict';
 
App.controller('PessoaController', ['$scope', 'PessoaService', function($scope, PessoaService) {
          var self = this;
          self.pessoa={id:'',nome:'',dataNascimento:'',sexo:'',cpf:''};
          self.pessoas=[];
               
          self.fetchAllUsers = function(){
        	  PessoaService.fetchAllUsers()
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
              PessoaService.criarPessoa(pessoa)
                      .then(
                      self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Erro ao criar pessoa.');
                              } 
                  );
          };
          
          self.submit = function() {
              if(self.pessoa.id === null  || self.pessoa.id === undefined || self.pessoa.id === ''){
                  console.log('Salvando novo usuário', self.pessoa);    
                  self.criarPessoa(self.pessoa);
              }

          };
            
          self.fetchAllUsers();
 
      }]);