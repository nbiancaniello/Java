/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author VMNico
 */
public class Conversiones {
    
    private static final String FORMATO_FECHA = "dd-MM-yyyy";
    
    public static String format(Date fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
    
    public static String format(String fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
}
