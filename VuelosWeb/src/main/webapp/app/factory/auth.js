angular.module('vuelos').factory(
		"auth",
		function($cookies, $cookieStore, $state) {
			return {
				login : function(usuario) {
					$cookies.put('usuario', JSON.stringify(usuario));
					$state.go('home');
				},
				logout : function() {
					$cookieStore.remove('usuario'),
					  $state.go('signin');
				},
				checkStatus : function() {
					console.log("llego");
					var rutasPrivadas = [ 'home', 'home.tarifa', 'home.estado', 'home.misreservas', 'signin' ];
					if (this.in_array($state.go(), rutasPrivadas)
							&& typeof ($cookies.get('usuario')) == "undefined") {
						$state.go('signin');
					}
					
					if (this.in_array('signin', rutasPrivadas)
							&& typeof ($cookies.get('usuario')) != "undefined") {
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
