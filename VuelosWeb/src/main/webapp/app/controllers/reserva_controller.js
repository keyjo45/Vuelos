angular.module('vuelos').controller("reservaController" , function($scope, $cookies, reservaService, $window, $http, localStorageService){
	$scope.reservas={};
	
	 		$scope.consultarReserva = function() {
	 			
		 	reservaService.consultarReserva($scope.usuario.id)
	        .success(function (data) {
	        	$scope.reservas=data;
	        }).error(function (data, status, headers) {
	        	sweetAlert("Oops...!", "Existe un problema al consultar mis reservas! Por favor vuelva a intentar mas tarde: "+ headers("ERR_DESC"), "error");
	        });

	    };  
});
