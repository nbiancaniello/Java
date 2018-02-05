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
public class Marcas {
    private int codMarca;
    private String descripcion;
    private String estado;
    
    public Marcas()
    {
        codMarca = 0;
        descripcion = "";
        estado = "H";
    }
    
    public Marcas(int codMarca, String descripcion, String estado)
    {
        this.codMarca = codMarca;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    public Marcas(int codMarca, String descripcion){
        this.codMarca = codMarca;
        this.descripcion = descripcion;
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int cod_marca) {
        this.codMarca = cod_marca;
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
    
    public void insertMarca() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                   
            CallableStatement cs = (CallableStatement) con.prepareCall("{call agregar_marca(?)}");
            cs.setString(1, descripcion);            
            ResultSet rs = cs.executeQuery();
            rs.first();
            this.setCodMarca(rs.getInt(1));
            JOptionPane.showMessageDialog(new JFrame(), "Marca Agregada Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            cs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void updateMarca() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                   
            CallableStatement cs = (CallableStatement) con.prepareCall("{call modificar_marca(?,?,?)}");
            cs.setInt(1, codMarca);
            cs.setString(2, descripcion);
            cs.setString(3, estado);
            cs.execute();
            JOptionPane.showMessageDialog(new JFrame(), "Marca Modificada Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            cs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void deleteMarca() throws Exception{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();                  
            CallableStatement cs = (CallableStatement) con.prepareCall("{call eliminar_marca(?)}");
            cs.setInt(1, codMarca);
            cs.execute();
            cs.close();
            JOptionPane.showMessageDialog(new JFrame(), "Marca Eliminada Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }

    @SuppressWarnings("empty-statement")
    public static void traerMarcas(DefaultTableModel tabla) throws Exception{
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_marcas}");
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
    
    public static ArrayList<Marcas> traerMarcas() throws Exception{
        Marcas objetoMarca;
        ArrayList<Marcas> marcas = new ArrayList<Marcas>();
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_marcas}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    if (rs.getString(3).compareTo("Habilitado")==0){                                     
                        objetoMarca = new Marcas();
                        objetoMarca.setCodMarca(rs.getInt(1));
                        objetoMarca.setDescripcion(rs.getString(2));
                        marcas.add(objetoMarca);
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
        return marcas;
    }

    public static void traerMarcas(JList lista) throws Exception{
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_marcas}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    Object []datos = {rs.getInt(1)+"-"+rs.getString(2)};
                    modelo.addElement(datos[0]);
                }while(rs.next());
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay marcas cargadas");
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
