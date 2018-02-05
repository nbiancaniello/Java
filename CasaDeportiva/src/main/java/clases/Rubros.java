/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pantallas.abm_productos;

/**
 *
 * @author MAQUINA 12
 */
public class Rubros {
    private int codRubro;
    private String descripcion;
    private String estado;
    
    public Rubros()
    {
        codRubro = 0;
        descripcion = "";
        estado = "H";
    }
    
    public Rubros(int codRubro, String descripcion)
    {
        this.codRubro = codRubro;
        this.descripcion = descripcion;
    }
    
    public Rubros(int codRubro, String descripcion, String estado)
    {
        this.codRubro = codRubro;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getCodRubro() {
        return codRubro;
    }

    public void setCodRubro(int cod_rubro) {
        this.codRubro = cod_rubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return descripcion;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void insertRubro() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Rubros.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                   
            CallableStatement cs = (CallableStatement) con.prepareCall("{call agregar_rubro(?)}");
            cs.setString(1, descripcion);            
            ResultSet rs = cs.executeQuery();
            rs.first();
            this.setCodRubro(rs.getInt(1));
            JOptionPane.showMessageDialog(new JFrame(), "Rubro Agregado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            cs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void updateRubro() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Rubros.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                   
            CallableStatement cs = (CallableStatement) con.prepareCall("{call modificar_rubro(?,?,?)}");
            cs.setInt(1, codRubro);
            cs.setString(2, descripcion);
            cs.setString(3,getEstado());
            cs.execute();
            JOptionPane.showMessageDialog(new JFrame(), "Rubro Modificado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            cs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void deleteRubro() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Rubros.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                  
            CallableStatement cs = (CallableStatement) con.prepareCall("{call eliminar_rubro(?)}");
            cs.setInt(1, codRubro);
            cs.execute();
            cs.close();
            JOptionPane.showMessageDialog(new JFrame(), "Rubro Eliminado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
            //JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    public static void traerRubros(DefaultTableModel tabla) throws Exception{
        // Trae los datos para realizar el ABM, los carga en el modelo,
        // y a través de la vinculación con el componente
        // se mostrarán los datos.
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(abm_productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();            
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_rubros}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    Object []datos = {rs.getInt(1),rs.getString(2),rs.getString(3)};
                    tabla.addRow(datos);
                }while(rs.next());
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay marcas cargadas");
            }
            rs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ArrayList<Rubros> traerRubros() throws Exception{
        Rubros objetoRubro;
        ArrayList<Rubros> rubros = new ArrayList<Rubros>();
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Rubros.class.getName()).log(Level.SEVERE, null, ex);
            }
            /* Se crea la conexión, el comando y luego el reader de consultas
             * Por cada registro que recupera, dentro de un do-while
             * se crea una instancia de Object, se lo carga con los datos leidos
             * y se lo asigna al modelo, que contiene está relacionada con la 
             * tabla del form
             */
            
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_rubros}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    if (rs.getString(3).compareTo("Habilitado")==0){
                        objetoRubro = new Rubros();
                        objetoRubro.setCodRubro(rs.getInt(1));
                        objetoRubro.setDescripcion(rs.getString(2));
                        rubros.add(objetoRubro);
                    }
                } while(rs.next());
            }else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay registros cargados");
            }
            rs.close();
            com.close();
            con.close();     
        }catch(Exception e){
            throw e;
        }
        return rubros;
    }
    
    public static void traerRubros(JList lista) throws Exception{
        // Trae los datos para realizar el ABM, los carga en el modelo,
        // y a través de la vinculación con el componente
        // se mostrarán los datos.
        DefaultListModel modelo = new DefaultListModel();
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(abm_productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            java.sql.Statement com = (java.sql.Statement) con.createStatement();            
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_rubros}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    Object []datos = {rs.getInt(1)+"-"+rs.getString(2)};
                    modelo.addElement(datos[0]);
                }while(rs.next());
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay rubros cargados");
            }
            rs.close();
            com.close();
            con.close();
            lista.setModel(modelo);
        }catch(Exception e){
            throw e;
        }
    }
}
