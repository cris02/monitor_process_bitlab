/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Aguilar
 */
public class EncriptacionTexto {
    //declaramos una cosntante para involar los registros del logger
    private static final Logger LOGGER = LoggerFactory.getLogger(EncriptacionTexto.class); //pasamos el contexto de nuestra clase
    
    private static final String LLAVE_VAL = ""; //mi llave de encriptacion
    BasicTextEncryptor encryptor;
    
    public EncriptacionTexto(String valor) {
        LOGGER.debug("inicializando el encriptador");
        encryptor = new BasicTextEncryptor();
        if (valor == null || valor.length() == 0) {
            valor = LLAVE_VAL;
        }
        
        encryptor.setPassword(valor);
    }
    
    public EncriptacionTexto() {
        LOGGER.debug("Inicializando el encriptador con los valores por defecto");
        encryptor = new BasicTextEncryptor();
        encryptor.setPassword(LLAVE_VAL);
    }
    
    //metodo para encriptar textos
    public String getTextoEncriptado(String texto) {
        LOGGER.debug("Encriptando texto");
        return encryptor.encrypt(texto);
    }
    
    //metodo para desencriptar textos
    public String getTextoDesencriptado(String texto) {
        LOGGER.debug("Desencriptando texto");
        return encryptor.decrypt(texto);
    }
}
