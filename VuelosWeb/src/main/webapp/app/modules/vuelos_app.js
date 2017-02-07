angular.module('vuelos',['angularCSS', 'LocalStorageModule', 'ui.router'])
.config(['localStorageServiceProvider', function(localStorageServiceProvider){
	localStorageServiceProvider.setPrefix('ls');
}])
.config(function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise('signin/');
		
	 $stateProvider
     .state('signin', {
    	 url:'/signin/',      	 
    	 templateUrl: 'app/views/login.html',	
    	 controller: 'usuarioController'
    })
    .state('home', {
    	 url:'/home',
    	 templateUrl: 'app/views/main.html',
         controller: 'homeController'
    })
    .state('home.misreservas', {
    	 url:'/misreservas',
    	 templateUrl: 'app/views/consultarMisReservas.html',
         controller: 'reservaController'
    })
     .state('registro', {
    	 url:'/registro',
    	 templateUrl: 'app/views/registro.html',
         controller: 'usuarioController'
    })
});