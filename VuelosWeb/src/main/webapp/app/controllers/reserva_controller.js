angular.module('vuelos').controller("reservaController" , function($scope, $rootScope, reservaService, $window, $http, localStorageService){
	//$scope.login={};
	$scope.reserva={};
	//$scope.login=localStorageService.get('usuario');
	 		$scope.consultarReserva = function() {
		 	reservaService.consultarReserva($rootScope.usuario.id)
	        .success(function (data, status) {
	        	cargarReserva(data);
	        }).error(function (data, status, headers) {
	        	sweetAlert("Oops...!", "Existe un problema al consultar mis reservas! Por favor vuelva a intentar mas tarde: "+ headers("ERR_DESC"), "error");
	        });

	    };
	    
	   function cargarReserva(data){
	    	var length = data.length;
        	for (i = 0; i < length; i++) {
        		$scope.reserva.id=data[i].id;
        		$scope.reserva.fechaReserva=data[i].fechaReserva;
        	};  
        	
	    };
	    
	    
});
