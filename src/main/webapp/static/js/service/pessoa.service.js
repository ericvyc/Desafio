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
    },
    
    updatePessoa: function(pessoa, id){
            return $http.put('http://localhost:8080/desafio/pessoa/'+id, pessoa)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Erro ao atualizar pessoa');
                                return $q.reject(errResponse);
                            }
                    );
    },
     
    deletePessoa: function(id){
            return $http.delete('http://localhost:8080/desafio/pessoa/'+id)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Erro ao deletar pessoa');
                                return $q.reject(errResponse);
                            }
                    );
    },
    deletarTodos: function() {
    	return $http.delete('http://localhost:8080/desafio/pessoa/')
    			.then(
    					function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Erro ao deletar todas as pessoas');
                            return $q.reject(errResponse);
                        }
    			
    			);
    }
    };
}]);