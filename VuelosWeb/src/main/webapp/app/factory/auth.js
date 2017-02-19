angular.module('vuelos').factory("auth", function($cookies, $cookieStore, $state) {
			return {
				login : function(usuario) {
					$cookies.usuarioPrueba = usuario, 
					console.log("este es el usuario: "+$cookies.usuarioPrueba.id);
					$state.go('home');
				},
				logout : function() {
					$cookieStore.remove('usuario'), $state.go('signin');
				},
				checkStatus : function() {
					
					var rutasPrivadas = [ 'home', 'home.misreservas',
							'home.tarifa', 'home.estado' ];
					if (this.in_array($state.go(), rutasPrivadas)
							&& typeof ($cookies.usuarioPrueba) == "undefined") {
						$state.go('signin');
					}
					if (this.in_array("signin", rutasPrivadas)
							&& typeof ($cookies.usuarioPrueba) != "undefined") {
						$state.go('home');
					}
				},
				in_array : function(needle, haystack) {
					var key = '';
					for (key in haystack) {
						if (haystack[key] == needle) {
							return true;
						}
					}
					return false;
				}
			}
		});
