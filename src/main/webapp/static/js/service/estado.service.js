'use strict';
 
App.factory('EstadoService', ['$http', '$q', function($http, $q){
 
    return {
            fetchAllUsers: function() {
            	debugger;
                    return $http.get('http://localhost:8080/desafio/estados/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Erro ao recuperar estados');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
    
            criarestado: function(estado){
            	debugger;
            		return $http.post('http://localhost:8080/desafio/estado/', estado)
                    		.then(
                    				function(response){
                    					return response.data;
                    				}, 
                    				function(errResponse){
                    					console.error('Erro ao criar estado');
                    					return $q.reject(errResponse);
                    				}
                    		);
    },
    
    updateestado: function(estado, id){
    	debugger;
            return $http.put('http://localhost:8080/desafio/estado/'+id, estado)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Erro ao atualizar estado');
                                return $q.reject(errResponse);
                            }
                    );
    },
     
    deleteestado: function(id){
    	debugger;
            return $http.delete('http://localhost:8080/desafio/estado/'+id)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Erro ao deletar estado');
                                return $q.reject(errResponse);
                            }
                    );
    },
    deletarTodos: function() {
    	debugger;
    	return $http.delete('http://localhost:8080/desafio/estado/')
    			.then(
    					function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Erro ao deletar todas as estados');
                            return $q.reject(errResponse);
                        }
    			
    			);
    }
    };
}]);