angular.module('vuelos').controller("homeController" , function($scope, $cookies, localStorageService, auth, usuarioService){
    	
	$scope.logout = function() {
		usuarioService.logout($cookies.usuarioPrueba)
		 .success(function (data) {
				localStorage.removeItem('usuario');
				auth.logout();
	        }).error(function (data, status, headers) {
	        	sweetAlert("Oops...!", "Existe un cerrar sesion: "+ headers("ERR_DESC"), "error");
	        });
	};
});