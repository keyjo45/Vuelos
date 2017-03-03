angular.module('vuelos',['LocalStorageModule', 'ui.router', 'ngCookies'])

.config(['localStorageServiceProvider', function(localStorageServiceProvider){
	localStorageServiceProvider.setPrefix('ls');
}])
.config(function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise('signin');
		
	 $stateProvider
     .state('signin', {
    	 url:'/signin',      	 
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
     .state('home.tarifa', {
    	 url:'/tarifa',
    	 templateUrl: 'app/views/consultarTarifa.html',
         controller: 'vuelosController'
    })
     .state('home.estado', {
    	 url:'/estado',
    	 templateUrl: 'app/views/consultarEstado.html',
         controller: 'vuelosController'
    })
     .state('registro', {
    	 url:'/registro',
    	 templateUrl: 'app/views/registro.html',
         controller: 'usuarioController'
    })
})
.run(function($rootScope, auth){
       
    $rootScope.$on('$stateChangeStart', function () {
    	auth.checkStatus();
    	
    })
})
