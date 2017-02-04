angular.module("vuelos").service("reservaService",  function($http){
	
	this.consultarReserva=function(idUsuario){
		return $http({
			method: 'GET',
			url: 'rest/reserva/consultarReservas/'+ idUsuario			
		});
	}
});