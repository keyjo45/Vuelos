angular.module("vuelos").service("vuelosService",  function($http){
	
	this.buscar=function(ciudadOrigen, ciudadDestino){
		return $http({
			method: 'GET',
			url: 'rest/vuelo/consultarVuelos/' + ciudadOrigen + '/' + ciudadDestino
		});
	}	
});