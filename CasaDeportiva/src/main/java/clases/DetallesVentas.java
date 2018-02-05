/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.sql.*;
import oracle.jdbc.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ni
 */
public class DetallesVentas extends Ventas{
     private int codProducto;
     private int cantidad;
     private float precioUnitario;
     
     public DetallesVentas()
     {
         super();
         codProducto=0;
         cantidad=0;
         precioUnitario=0;
     }
     
     public DetallesVentas(int codProducto, int cantidad, float precioUnitario)
     {
         super();
         this.codProducto = codProducto;
         this.cantidad = cantidad;
         this.precioUnitario = precioUnitario;
     }
     
     public DetallesVentas(int codVendedor)
     {
         super(codVendedor);
         codProducto=0;
         cantidad=0;
         precioUnitario=0;
     }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int cod_producto) {
        this.codProducto = cod_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precio_unitario) {
        this.precioUnitario = precio_unitario;
    }
    
    public void insertVenta(DefaultTableModel lista) throws SQLException{
        try{
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query = new String();
            OracleConnection con = (OracleConnection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();
            CallableStatement cs = (CallableStatement) con.prepareCall("{call traer_nroventa}");
            ResultSet rs = cs.executeQuery();
            rs.first();
            this.setNroFactura(rs.getInt(1));
            con.setAutoCommit(false);
            com.addBatch("BEGIN");
            query = "INSERT INTO ventas (fecha,cod_vendedor) VALUES (NOW()," + super.getCodVendedor() +")";
            com.addBatch(query);
            for (int i=0;i<lista.getRowCount();i++){
                query = devolverQueryInsert((Integer)lista.getValueAt(i, 0),(Integer)lista.getValueAt(i, 2),(Float)lista.getValueAt(i, 3));
                com.addBatch(query);
                query = devolverQueryUpdate((Integer)lista.getValueAt(i, 0),(Integer)lista.getValueAt(i, 2));
                com.addBatch(query);
            }
            com.addBatch("COMMIT");
            com.executeBatch();
            JOptionPane.showMessageDialog(new JFrame(), "Venta Registrada Satisfactoriamente","Transacción Realizada",JOptionPane.INFORMATION_MESSAGE);
            com.close();
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    public String devolverQueryInsert(int codProducto, int cantidad, float precioUnitario){
        String query = new String();
        try{
            int nro = this.getNroFactura() + 1;
            query = "INSERT INTO detalle_ventas VALUES (" + nro + "," + codProducto +"," + cantidad +"," + precioUnitario +");";
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
            return "";
        }
        return query;
    }
    
    public String devolverQueryUpdate(int codProducto, int cantidad){
        String query = new String();
        try{
            query = "UPDATE productos SET stock_actual = stock_actual - " + cantidad + " WHERE cod_producto = " + codProducto;
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
            return "";
        }
        return query;
    }
    
}
