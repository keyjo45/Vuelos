angular.module('vuelos').controller("vuelosController", function($scope, vuelosService) {
			$scope.vuelos = [];
			$scope.buscarVuelosSegunTarifa = function() {
				vuelosService.buscar($scope.ciudadOrigen, $scope.ciudadDestino)
						.success(function(data) {
							$scope.vuelos = data;
							$scope.vuelos.sort(function(a, b) {
								if (a.tarifa > b.tarifa) {
									return 1;
								}
								if (a.tarifa < b.tarifa) {
									return -1;
								}
								return 0;
							});
						}).error(
								function(headers) {
									sweetAlert("Oops...!",
											"Existe un problema al buscar las tarifas: "
													+ headers("ERR_DESC"),
											"error");
								});
			};
			
			$scope.buscarVueloSegunEstado = function(){
				alert("Llego vuelo...");
			}
		});
