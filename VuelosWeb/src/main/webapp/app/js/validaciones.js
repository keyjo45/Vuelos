function cuenta(){ 
	var cuenta=190;
      	document.forms[0].caracteres.text=cuenta-document.forms[0].descripcion.value.length 
} 

function soloNumeros(e){
	var key = window.Event ? e.which : e.keyCode
	return (key >= 48 && key <= 57)
}