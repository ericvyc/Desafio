'use strict';
 
App.factory('EnderecoService', ['$http', '$q', function($http, $q){
 
    return {
            getEndereco: function(cep) {
                    return $http.get('https://viacep.com.br/ws/' + cep + '/json')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Erro ao pesquisar cep');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
    };
}]);