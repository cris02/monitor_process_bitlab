/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.procesos;

import com.bitlab.propiedades.ConfigProperties;
import com.bitlab.utilidades.EncriptacionTexto;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Aguilar
 */
public class MonitorProcess {
    //declaramos una cosntante para involar los registros del logger
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorProcess.class); //pasamos el contexto de nuestra clase
    private static final String ARCHIVO_PROPS = "config.properties";
    
    public static void main(String[] args) {
        LOGGER.debug("Obtener la informacion del sistema");
        SystemInfo sys = new SystemInfo();
        Properties propertiesSys = new Properties();
        
        try {
            LOGGER.debug("cargando las propiedades de la aplicacion ");
            propertiesSys.load(ConfigProperties.getResourceAsInputStream(ARCHIVO_PROPS));
            LOGGER.debug("Propiedades cargadas exitosamente");
            
            LOGGER.debug("Enviando el correo electronico con la informacion");
            enviarCorreo(sys.info(), propertiesSys);
            
            
        } catch (IOException ex) {
            LOGGER.error("Ha ocurrido una excepcion en la lectura de las propiedades de la aplicacion");
        } catch (EmailException ex) {
            LOGGER.error("Ha ocurrido una excepcion en el envio del correo electronico");
        }
    }

    private static void enviarCorreo(String info, Properties properties) {
        Email email = new SimpleEmail();
        EncriptacionTexto encriptacionTexto = new EncriptacionTexto();
    }
}
