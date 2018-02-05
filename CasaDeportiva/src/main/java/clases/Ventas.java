/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MAQUINA 12
 */
public abstract class Ventas {
     protected int nroFactura;
     private java.util.Date fecha;
     private int codVendedor;
     private String estado;
     
     public Ventas()
     {
         nroFactura=0;
         fecha = new java.util.Date();
         codVendedor=0;
         estado = "E";
     }
     
     public Ventas(int codVendedor)
     {
         try{
            nroFactura=0;
            fecha = new java.util.Date();
            this.codVendedor = codVendedor;
            estado = "E";
         }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
         }         
     }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nro_factura) {
        this.nroFactura = nro_factura;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int cod_vendedor) {
        this.codVendedor = cod_vendedor;
    }
    
}
