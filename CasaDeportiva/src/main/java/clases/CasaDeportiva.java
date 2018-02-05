/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ni
 */
public abstract class CasaDeportiva {
    private static int marcas = 1;
    private static int productos = 1;
    private static int vendedores = 1;
    private static int rubros = 1;
    private static int ventas = 1;
    private static int reporte_ventas = 1;
    private static String title = "Casa Deportiva";
    private static String sqlPath = "jdbc:oracle:thin:@localhost/1521:XE";
    private static String user = "root";
    private static String passw = "root";
    private static String driver = "oracle.jdbc.driver.OracleDriver";

    public static String getTitle(){
        return title;
    }
    
    public static int getMarcas() {
        return marcas;
    }

    public static void setMarcas(int aMarcas) {
        marcas = aMarcas;
    }

    public static int getProductos() {
        return productos;
    }

    public static void setProductos(int aProductos) {
        productos = aProductos;
    }

    public static int getVendedores() {
        return vendedores;
    }

    public static void setVendedores(int aVendedores) {
        vendedores = aVendedores;
    }

    public static int getRubros() {
        return rubros;
    }

    public static void setRubros(int aRubros) {
        rubros = aRubros;
    }

    public static int getVentas() {
        return ventas;
    }

    public static void setVentas(int aVentas) {
        ventas = aVentas;
    }
    
    public static int getReporteVentas() {
        return reporte_ventas;
    }

    public static void setReporteVentas(int aReporteVentas) {
        reporte_ventas = aReporteVentas;
    }
    
    public static String getSQLPath(){
        return sqlPath;
    }
    
    public static void setSQLPath(String aSQLPath){
        sqlPath=aSQLPath;
    }
    
    public static String getUser(){
        return user;
    }
    
    public static void setUser(String aUser){
        user=aUser;
    }
    
    public static String getPassword(){
        return passw;
    }
    
    public static void setPassword(String aPassw){
        passw=aPassw;
    }
    
    public static String getDriver(){
        return driver;
    }
    
    public static void setDriver(String aDriver){
        driver=aDriver;
    }
    
    public static int verificarNumeroEntero(String texto){
        Pattern patron = Pattern.compile("[0-9]");
        try{
            for(int i=0;i<texto.length();i++){
                Matcher encaja = patron.matcher(texto.substring(i, i+1));
                if(!encaja.find()){                
                    return 0;
                }
            }
        }catch(Exception e){
            return 0;
        }
        return 1;
    }
    
    public static int verificarNumeroDecimal(String texto){
        Pattern patron = Pattern.compile("[0-9]");
        try{
            for(int i=0;i<texto.length();i++){
                Matcher encaja = patron.matcher(texto.substring(i, i+1));
                if(!encaja.find()){
                    if (texto.substring(i, i+1).compareTo(".")!=0) return 0;
                }
            }
        }catch(Exception e){
            return 0;
        }
        return 1;
    }
    
    public static int verificarTexto(String texto){
        Pattern patron = Pattern.compile("[A-Z][a-z][:space:]");
        try{
            for(int i=0;i<texto.length();i++){
                Matcher encaja = patron.matcher(texto.substring(i, i+1));
                if(encaja.find()){
                    return 0;
                }
            }
        }catch(Exception e){
            return 0;
        }
        return 1;
    }
}
