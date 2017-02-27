angular.module("vuelos").service("usuarioService",  function($http){
	
	this.addUsuario=function(usuario){
		return $http({
			method: 'PUT',
			url: 'rest/usuario/saveUsuario',
			data: usuario			
		});
	}
	
	this.login=function(usuario, password){
		return $http({
			method: 'POST',
			url: 'rest/usuario/login/' + usuario + '/' + password
		});
	}
	
	this.logout=function(usuario){
		return $http({
			method: 'PUT',
			url: 'rest/usuario/logout/',
			data: usuario
		});
	}
	
	this.consultProduct=function(){
		return $http({
			method: 'GET',
			url: 'rest/product/consultProduct'			
		});
	}
	
	this.consultProductByName=function(name){
		return $http({
			method: 'GET',
			url: 'rest/product/consultByName/' + name		
		});
	}
	
});