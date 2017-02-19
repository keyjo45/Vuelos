angular.module('vuelos').controller("homeController" , function($scope, $cookies, localStorageService, auth){
    	
	$scope.logout = function() {
    	
		localStorage.removeItem('usuario');
		auth.logout();
	};
});