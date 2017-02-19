angular.module('vuelos').controller("usuarioController" , function($scope, usuarioService, $http, $rootScope, localStorageService, $state, auth){
	$scope.usuario={};
	
	 $scope.guardarUsuario = function(form) {
		 
		 	usuarioService.addUsuario($scope.usuario)

	        .success(function (data, status) {
	        	
	        	swal({
	        		  title: "Buen trabajo!",
	        		  text: "Registro realizado satisfactoriamente!",
	        		  type: "success",
	        		  timer: 5000,
	        		  showConfirmButton: true
	        		});
	        	$state.go('signin');

	        }).error(function (data, status, headers) {
	        	sweetAlert("Oops...!", "Existe un problema al registrar el usuario! Por favor vuelva a intentar mas tarde: "+ headers("ERR_DESC"), "error");
	        });

	    };
	    
	    $scope.login = function(){
	    	usuarioService.login($scope.userName, $scope.password)
	            .success(function (data, status) {
	            	  $http.defaults.headers.common.token = data.token;
	            	  localStorage.setItem('usuario',JSON.stringify(data));
	                  $rootScope.usuario = JSON.parse(localStorage.getItem('usuario'));
	                  auth.login($rootScope.usuario);
		        }).error(function (data, status, headers) {
		        	sweetAlert("Oops...!", "Existe un problema al ingresar en el sisitema! "+ headers("ERR_DESC"), "error");
		        });
	    };	    	    
});
