angular.module('vuelos').controller("homeController" , function($scope, $cookies, localStorageService, auth, usuarioService){
    	$scope.usuario=JSON.parse($cookies.get('usuario'));
	$scope.logout = function() {
		usuarioService.logout($scope.usuario)
		 .success(function (data) {
				auth.logout();
	        }).error(function (data, status, headers) {
	        	sweetAlert("Oops...!", "Existe un cerrar sesion: "+ headers("ERR_DESC"), "error");
	        });
	};
});