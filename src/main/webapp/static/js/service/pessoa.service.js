'use strict';
 
App.factory('PessoaService', ['$http', '$q', function($http, $q){
 
    return {
            fetchAllUsers: function() {
                    return $http.get('http://localhost:8080/desafio/pessoas/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Erro ao recuperar pessoas');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
    
            criarPessoa: function(pessoa){
            		return $http.post('http://localhost:8080/desafio/pessoa/', pessoa)
                    		.then(
                    				function(response){
                    					return response.data;
                    				}, 
                    				function(errResponse){
                    					console.error('Erro ao criar pessoa');
                    					return $q.reject(errResponse);
                    				}
                    		);
    }
    };
}]);