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
public class Productos {
    
    private int codProducto;
    private String descripcion;
    private float precioLista;
    private int codMarca;
    private int codRubro;
    private int stockMinimo;
    private int stockActual;
    private float precioVenta;
    private String estado;
    
    public Productos()
    {
      codProducto = 0;
      descripcion = "";
      precioLista = 0;
      codMarca = 0;
      codRubro = 0;
      stockMinimo = 0;
      stockActual = 0;
      precioVenta = 0;
      estado = "";
    }
    
    public Productos(int codProducto, String descripcion, float precioLista, int codMarca, int codRubro,
                     int stockMinimo, int stockActual, float precioVenta, String estado)
    {
      this.codProducto = codProducto;
      this.descripcion = descripcion;
      this.precioLista = precioLista;
      this.codMarca = codMarca;
      this.codRubro = codRubro;
      this.stockMinimo = stockMinimo;
      this.stockActual = stockActual;
      this.precioVenta = precioVenta;
      this.estado = estado;
    }
    
    public Productos(int codProducto, String descripcion, float precioLista, int codMarca, int codRubro,
                     int stockMinimo, int stockActual, float precioVenta)
    {
      this.codProducto = codProducto;
      this.descripcion = descripcion;
      this.precioLista = precioLista;
      this.codMarca = codMarca;
      this.codRubro = codRubro;
      this.stockMinimo = stockMinimo;
      this.stockActual = stockActual;
      this.precioVenta = precioVenta;
    }
    
    public Productos(int codProducto, String descripcion){
      this.codProducto = codProducto;
      this.descripcion = descripcion;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(float precioLista) {
        this.precioLista = precioLista;
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public int getCodRubro() {
        return codRubro;
    }

    public void setCodRubro(int codRubro) {
        this.codRubro = codRubro;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
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
    
    public void insertProducto() throws Exception{
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call agregar_producto(?,?,?,?,?,?,?)}");
            cs.setString(1, descripcion);
            cs.setFloat(2, precioLista);
            cs.setInt(3, codMarca);
            cs.setInt(4, codRubro);
            cs.setInt(5, stockActual);
            cs.setInt(6, stockMinimo);
            cs.setFloat(7, precioVenta);
            ResultSet rs = cs.executeQuery();
            rs.first();
            this.setCodProducto(rs.getInt(1));
            JOptionPane.showMessageDialog(new JFrame(), "Producto Agregado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            rs.close();
            cs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void updateProducto() throws Exception{
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call modificar_producto(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, codProducto);
            cs.setString(2, descripcion);
            cs.setFloat(3, precioLista);
            cs.setInt(4, codMarca);
            cs.setInt(5, codRubro);
            cs.setInt(6, stockActual);
            cs.setInt(7, stockMinimo);
            cs.setFloat(8, precioVenta);
            cs.setString(9, estado);
            cs.execute();
            JOptionPane.showMessageDialog(new JFrame(), "Producto Modificado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            cs.close();
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void deleteProducto() throws Exception{
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call eliminar_producto(?)}");
            cs.setInt(1, codProducto);
            cs.execute();
            cs.close();
            JOptionPane.showMessageDialog(new JFrame(), "Producto Eliminado Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            com.close();
            con.close();
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ArrayList<Productos> traerProductos() throws Exception{
        Productos objetoProducto;
        ArrayList<Productos> productos = new ArrayList<Productos>();
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_productos2}");
            ResultSet rs = cs.executeQuery();            
            if (rs.first()){
                do {
                    objetoProducto = new Productos();
                    objetoProducto.setCodProducto(rs.getInt(1));
                    objetoProducto.setDescripcion(rs.getString(2));
                    objetoProducto.setStockActual(rs.getInt(5));
                    objetoProducto.setPrecioVenta(rs.getFloat(8));
                    productos.add(objetoProducto);
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
        return productos;
    }
    
    public static void traerProductos(DefaultTableModel tabla) throws Exception{
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
            java.sql.Statement com = (java.sql.Statement) con.createStatement();            
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_productos}");
            ResultSet rs = cs.executeQuery();
             if (rs.first()){
                do {
                    Object []datos = {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                                      rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                                      rs.getString(9)};
                    tabla.addRow(datos);
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
    }
    
    public static void traerProductosVenta(DefaultTableModel productos) throws Exception{
        // Trae los datos para realizar la venta, los carga en el modelo,
        // y a través de la vinculación con el componente
        // se mostrarán los datos.
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_productos2}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    Object []datos = {rs.getInt(1),rs.getInt(5),rs.getFloat(8)};
                    productos.addRow(datos);
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
    }
    
    public static void traerProductos(JList lista) throws Exception{
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
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_productos}");
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    Object []datos = {rs.getInt(1)+"-"+rs.getString(2)};
                    modelo.addElement(datos[0]);
                }while(rs.next());
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay productos cargados");
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
