'use strict';
 
var App = angular.module('meuApp',['ui.router']);

App.config(['$stateProvider','$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/');
    
    $stateProvider
        
        .state('pessoa', {
            url: '/pessoa',
            templateUrl: 'static/html/crudPessoa.jsp'
        })
        
        .state('endereco', {
        	url: '/endereco',
            templateUrl: 'static/html/crudEndereco.jsp'      
        });
        
}]);