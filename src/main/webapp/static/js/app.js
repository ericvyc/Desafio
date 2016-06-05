'use strict';
 
var App = angular.module('meuApp',['ui.router']);

App.config(['$stateProvider','$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/');
    
    $stateProvider
        
        .state('estado', {
            url: '/estado',
            templateUrl: 'static/html/crudEstado.jsp'
        })
        
        .state('endereco', {
        	url: '/endereco',
            templateUrl: 'static/html/crudEndereco.jsp'      
        });
        
}]);