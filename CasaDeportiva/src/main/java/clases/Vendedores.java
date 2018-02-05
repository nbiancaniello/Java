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
public class Vendedores {
      private int codVendedor;
      private String nombre;
    
    public Vendedores (){
        codVendedor = 0;
        nombre = "";
    }
    
    public Vendedores (int codVendedor, String nombre){
          this.codVendedor = codVendedor;
          this.nombre = nombre;
    }    

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int cod_vendedor) {
        this.codVendedor = cod_vendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    public void insertVendedor() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                   
            CallableStatement cs = (CallableStatement) con.prepareCall("{call agregar_vendedor(?)}");
            cs.setString(1, nombre);            
            ResultSet rs = cs.executeQuery();
            rs.first();
            this.setCodVendedor(rs.getInt(1));
            JOptionPane.showMessageDialog(new JFrame(), "Vendedor Agregado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            cs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void updateVendedor() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                   
            CallableStatement cs = (CallableStatement) con.prepareCall("{call modificar_vendedor(?,?)}");
            cs.setInt(1, codVendedor);
            cs.setString(2, nombre);
            cs.execute();
            JOptionPane.showMessageDialog(new JFrame(), "Vendedor Modificado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            cs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void deleteVendedor() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                  
            CallableStatement cs = (CallableStatement) con.prepareCall("{call eliminar_vendedor(?)}");
            cs.setInt(1, codVendedor);
            cs.execute();
            cs.close();
            JOptionPane.showMessageDialog(new JFrame(), "Vendedor Eliminado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public static void traerVendedores(DefaultTableModel tabla) throws Exception{
        // Trae los datos para realizar el ABM, los carga en el modelo,
        // y a través de la vinculación con el componente
        // se mostrarán los datos.
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(abm_productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();            
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_vendedores}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    Object []datos = {rs.getString(1),rs.getString(2)}; 
                    tabla.addRow(datos);
                }while(rs.next());
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay vendedores cargados");
            }
            rs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ArrayList<Vendedores> traerVendedores() throws Exception{
        Vendedores objetoVendedor;
        ArrayList<Vendedores> vendedores = new ArrayList<Vendedores>();
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Vendedores.class.getName()).log(Level.SEVERE, null, ex);
            }          
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_vendedores}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                  objetoVendedor = new Vendedores();
                  objetoVendedor.setCodVendedor(rs.getInt(1));
                  objetoVendedor.setNombre(rs.getString(2));
                  vendedores.add(objetoVendedor);
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
        return vendedores;
    }
 
    public static void traerVendedores(JList lista) throws Exception{
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
            Statement com = (Statement) con.createStatement();            
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_vendedores}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    Object []datos = {rs.getInt(1)+"-"+rs.getString(2)};
                    modelo.addElement(datos[0]);
                }while(rs.next());
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay vendedores cargados");
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
