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
            
          self.fetchAllUsers();
 
      }]);