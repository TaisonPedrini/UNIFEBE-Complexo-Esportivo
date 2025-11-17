package com.complexo.UNIFEBE_Complexo_Esportivo.controller;

import com.complexo.UNIFEBE_Complexo_Esportivo.dao.Login;

public class ValidarLogin {

    // Atributos
    private Login login = new Login();

    public ValidarLogin() {
    }

    // Validar a entrada do usuário
    public boolean validarEntrada(int matricula, String senha){
        if (login.validarLogin(matricula, senha)){
            return true;
        }else{
            return false;
        }
    }

}
