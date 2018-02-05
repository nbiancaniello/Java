function validarForma(forma){
    var usuario = forma.usuario;
    if (usuario.value == "" || usuario.value == "Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    if (password.value == "" || password.value.lenght < 3){
        alert("Debe proporcionar un password de al menos 3 caracteres");
        password.focus();
        password.select();
        return false;
    }
    
    var tecnologias = forma.tecnologias;
    var checkSeleccionado = false;
    
    for (i=0; i<tecnologias.length; i++){
        if (tecnologias[i].checked){
            checkSeleccionado = true;
        }
    }
    if (!checkSeleccionado) {
        alert("Debe proporcionar una Tecnologia");
        return false;
    }
    
    var generos = forma.genero;
    var radioSeleccionado = false;
    
    for (i=0; i< generos.length;i++){
        if (generos[i].checked){
            radioSeleccionado = true;
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleccionar el Genero");
    }
    
    var ocupacion = forma.ocupacion;
    if(ocupacion.valuer == ""){
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    
    alert("Formulario valudo, enviando datos...");
    return true;
}