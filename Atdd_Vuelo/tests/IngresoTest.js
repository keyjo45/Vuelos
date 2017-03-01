var assert = require('assert'), tmpResult;

module.exports = function(){

    this.Given(/^ir a la pagina "([^"]*)"$/, function(url) {
        browser.url(url);
    });
    
    this.When(/^ingreso el email "([^"]*)"$/, function(email){
    	browser.setValue('#email', email);
    });
    
    this.When(/^ingreso el password "([^"]*)"$/, function(password){
    	browser.setValue('#password', password);
    });
    
    this.When('presiono el boton Autenticar', function(){
    	browser.click('#botonEnvio');
    });
    
    this.Then(/^muestra pagina de bienvenida con el usuario "([^"]*)"$/,function(usuario){
    	
    	var usuarioObtenido = $('#usuario');
    	assert.equal(usuarioObtenido.getText(), usuario);
    });

};