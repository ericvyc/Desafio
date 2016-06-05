'use strict';
 
App.controller('EnderecoController', ['$scope', 'EnderecoService', function($scope, EnderecoService) {
          var self = this;
          self.endereco={cep:'',logradouro:'',complemento:'',bairro:'',localidade:'',uf:'',unidade:'',ibge:'',gia:'', numero:''};
          self.enderecos = [];
          
          self.salvar = function () {
        	  debugger;
        	  self.enderecos.push(self.endereco);
          }
               
          self.getEndereco = function(cep){
        	  EnderecoService.getEndereco(cep)
                  .then(
                               function(d) {
                                    self.endereco = d;
                                    self.enderecos.push(d);
                               },
                                function(errResponse){
                                    console.error('Erro ao pesquisar cep');
                                    self.endereco = {};
                                }
                       );
          };
 
}]);