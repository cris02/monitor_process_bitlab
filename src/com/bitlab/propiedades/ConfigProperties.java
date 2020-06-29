/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.propiedades;

import java.io.InputStream;

/**
 * clase pivote para cargar los flujos de las propiedades
 * @author Aguilar
 */
public class ConfigProperties {
     public static InputStream getResourceAsInputStream(String clave) {
        return ConfigProperties.class.getResourceAsStream(clave);
    }
}
