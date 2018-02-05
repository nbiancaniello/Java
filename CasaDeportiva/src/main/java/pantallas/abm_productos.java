/*
 * abm_productos.java
 *
 * Created on 7 de noviembre de 2008, 19:46
 */

package pantallas;

import clases.CasaDeportiva;
import clases.Marcas;
import clases.Productos;
import clases.Rubros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author  Ni
 */
public final class abm_productos extends javax.swing.JFrame implements ActionListener{
    // Propiedades declaradas para el formulario y la clase principal
    private DefaultTableModel modelo;
    private String proceso;
    /** Creates new form abm_productos */
    public abm_productos() {
        initComponents();
        try{
            // Declaración del título del form y de los campos de la tabla
            this.setTitle(CasaDeportiva.getTitle() + " - Productos");
            Object []columnas = {"Código","Descripcion","Marca","Rubro","Stock A","Stock M","Precio L","Precio V","Estado"};
            modelo = new DefaultTableModel(columnas,0);
            Productos.traerProductos(modelo);
            tbl_productos.setModel(modelo);
            ArrayList<Rubros> datosRubros = new ArrayList<Rubros>();
            this.cbo_rubro.removeAllItems();
            datosRubros = Rubros.traerRubros();
            for (Rubros rubro : datosRubros){
                this.cbo_rubro.addItem(rubro);
            }
            ArrayList<Marcas> datosMarcas = new ArrayList<Marcas>();    
            this.cbo_marca.removeAllItems();
            datosMarcas = Marcas.traerMarcas();
            for (Marcas marca : datosMarcas){
                this.cbo_marca.addItem(marca);
            }
            btn_agregar.addActionListener(this);
            btn_cancelar.addActionListener(this);
            btn_eliminar.addActionListener(this);
            btn_guardar.addActionListener(this);
            btn_modificar.addActionListener(this);
            deshabilitarDatos();
            habilitarBotones();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jlbl_etproducto = new javax.swing.JLabel();
        jlbl_prlista = new javax.swing.JLabel();
        jlbl_marca = new javax.swing.JLabel();
        jlbl_rubro = new javax.swing.JLabel();
        jlbl_stactual = new javax.swing.JLabel();
        jlbl_stmin = new javax.swing.JLabel();
        jlbl_prventa = new javax.swing.JLabel();
        lbl_cod_producto = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        txt_stactual = new javax.swing.JTextField();
        txt_stmin = new javax.swing.JTextField();
        txt_prventa = new javax.swing.JTextField();
        txt_prlista = new javax.swing.JTextField();
        cbo_marca = new javax.swing.JComboBox();
        cbo_rubro = new javax.swing.JComboBox();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(80, 250, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_productos);

        btn_agregar.setText("Agregar");

        btn_modificar.setText("Modificar");

        btn_eliminar.setText("Habilitar / Deshabilitar");

        jlbl_etproducto.setText("Producto");

        jlbl_prlista.setText("Precio Lista");

        jlbl_marca.setText("Marca");

        jlbl_rubro.setText("Rubro");

        jlbl_stactual.setText("Stock Actual");

        jlbl_stmin.setText("Stock Minimo");

        jlbl_prventa.setText("Precio Venta");

        btn_guardar.setText("Guardar");

        btn_cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbl_etproducto)
                            .addComponent(jlbl_stactual)
                            .addComponent(jlbl_stmin)
                            .addComponent(jlbl_prlista)
                            .addComponent(jlbl_rubro)
                            .addComponent(jlbl_marca))
                        .addGap(19, 19, 19)
                        .addComponent(lbl_cod_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_marca, 0, 115, Short.MAX_VALUE)
                            .addComponent(cbo_rubro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txt_stactual, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(txt_prventa)
                            .addComponent(txt_stmin, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(txt_prlista)))
                    .addComponent(jlbl_prventa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlbl_etproducto)
                        .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_cod_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_marca)
                    .addComponent(cbo_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_rubro)
                    .addComponent(cbo_rubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_stactual)
                    .addComponent(txt_stactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbl_stmin)
                    .addComponent(txt_stmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_prventa)
                    .addComponent(txt_prventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_prlista)
                    .addComponent(txt_prlista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar))
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void tbl_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productosMouseClicked
// TODO add your handling code here:
    try{
        /* Lo que se selecciona de la tabla, se copiara en las cajas
         */
        int fila = tbl_productos.getSelectedRow();
        
        lbl_cod_producto.setText(modelo.getValueAt(fila,0).toString());
        txt_descripcion.setText((String) modelo.getValueAt(fila,1));
        cbo_marca.setSelectedIndex(buscarIndiceMarca(fila));
        cbo_rubro.setSelectedIndex(buscarIndiceRubro(fila));
        txt_stactual.setText((String) modelo.getValueAt(fila,4));
        txt_stmin.setText((String) modelo.getValueAt(fila,5));
        txt_prlista.setText((String) modelo.getValueAt(fila,6));
        txt_prventa.setText((String) modelo.getValueAt(fila,7));
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }    
}//GEN-LAST:event_tbl_productosMouseClicked

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    // Indica que se puede instanciar una nueva ventana.
    try{
        System.gc();
        CasaDeportiva.setProductos(1);
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox cbo_marca;
    private javax.swing.JComboBox cbo_rubro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbl_etproducto;
    private javax.swing.JLabel jlbl_marca;
    private javax.swing.JLabel jlbl_prlista;
    private javax.swing.JLabel jlbl_prventa;
    private javax.swing.JLabel jlbl_rubro;
    private javax.swing.JLabel jlbl_stactual;
    private javax.swing.JLabel jlbl_stmin;
    private javax.swing.JLabel lbl_cod_producto;
    private javax.swing.JTable tbl_productos;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_prlista;
    private javax.swing.JTextField txt_prventa;
    private javax.swing.JTextField txt_stactual;
    private javax.swing.JTextField txt_stmin;
    // End of variables declaration//GEN-END:variables

    public void habilitarBotones(){
        btn_agregar.setEnabled(true);
        btn_modificar.setEnabled(true);
        btn_eliminar.setEnabled(true);
        btn_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
    }
    
    public void deshabilitarBotones(){
        btn_agregar.setEnabled(false);
        btn_modificar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        btn_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);
    }
    
    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public void deshabilitarDatos() throws Exception{
        try {
            txt_descripcion.setEnabled(false);
            cbo_marca.setEnabled(false);
            cbo_rubro.setEnabled(false);
            txt_stactual.setEnabled(false);
            txt_stmin.setEnabled(false);
            txt_prlista.setEnabled(false);
            txt_prventa.setEnabled(false);
            limpiarCajas();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void habilitarDatos(){
        txt_descripcion.setEnabled(true);
        cbo_marca.setEnabled(true);
        cbo_rubro.setEnabled(true);
        txt_stactual.setEnabled(true);
        txt_stmin.setEnabled(true);
        txt_prlista.setEnabled(true);
        txt_prventa.setEnabled(true);
    }
    
    public void limpiarCajas() throws Exception{
        try{
            lbl_cod_producto.setText("");
            txt_descripcion.setText("");
            cbo_marca.setSelectedIndex(0);
            cbo_rubro.setSelectedIndex(0);
            txt_stactual.setText("");
            txt_stmin.setText("");
            txt_prlista.setText("");
            txt_prventa.setText("");
        }
        catch(Exception e){
            throw e;
        }  
    }
    
    public int verificarDatos() throws Exception{
        /* Verifica la consistencia de datos.
         * valores de retorno:
         * 0 = texto vacío
         * -1 = dato inválido
         * -2 = valor fuera de rango
         * 1 = datos OK
         */
        try{
            if (txt_descripcion.getText().trim().length()==0) return 0;
            if (txt_descripcion.getText().trim().length()>25) return -2;
            if (txt_stactual.getText().trim().length()==0) return 0;
            if (CasaDeportiva.verificarNumeroEntero(txt_stactual.getText().trim())==0) return -1;
            if (Integer.valueOf(txt_stactual.getText().trim())<0||Integer.valueOf(txt_stactual.getText().trim())>32000) return -2;           
            if (txt_stmin.getText().trim().length()==0) return 0;
            if (CasaDeportiva.verificarNumeroEntero(txt_stmin.getText().trim())==0)return -1;
            if (Integer.valueOf(txt_stmin.getText().trim())<0||Integer.valueOf(txt_stmin.getText().trim())>32000) return -2;
            if (txt_prlista.getText().trim().length()==0) return 0;
            if (CasaDeportiva.verificarNumeroDecimal(txt_prlista.getText().trim())==0) return -1;
            if (Float.valueOf(txt_prlista.getText().trim())<1||Float.valueOf(txt_prlista.getText().trim())>5000) return -2;
            if (txt_prventa.getText().trim().length()==0) return 0;
            if (CasaDeportiva.verificarNumeroDecimal(txt_prventa.getText().trim())==0) return -1;
            if (Float.valueOf(txt_prventa.getText().trim())<1||Float.valueOf(txt_prventa.getText().trim())>5000) return -2;
        }catch(Exception e){
            throw e;
        }       
        return 1;
    }
    
    public void actualizarTabla(int fila) throws Exception{
        // Actualiza la tabla una vez que finalizó la transacción
        try{
            modelo.setValueAt(txt_descripcion.getText(),fila,1);
            modelo.setValueAt(cbo_marca.getSelectedItem(),fila,2);
            modelo.setValueAt(cbo_rubro.getSelectedItem().toString(),fila,3);
            modelo.setValueAt(txt_stactual.getText(),fila,4);
            modelo.setValueAt(txt_stmin.getText(),fila,5);
            modelo.setValueAt(txt_prlista.getText(),fila,6);
            modelo.setValueAt(txt_prventa.getText(),fila,7);
        }catch(Exception e){
            throw e;
        }        
    }
    
    public int buscarIndiceMarca(int fila) throws Exception{
        // Devuelve la posición en el combo, del elemento del registro
        // seleccionado
        try{
            for(int i=0;i<cbo_marca.getItemCount();i++){
                if (cbo_marca.getItemAt(i).toString().compareTo(modelo.getValueAt(fila, 2).toString())==0){
                    fila = i;
                    break;
                }
            }
        }catch(Exception e){
            throw e;
        }
        return fila;
    }
    
    public int buscarIndiceRubro(int fila) throws Exception{
        // Devuelve la posición en el combo, del elemento del registro
        // seleccionado
        try{
            for(int i=0;i<cbo_rubro.getItemCount();i++){
                if (cbo_rubro.getItemAt(i).toString().compareTo(modelo.getValueAt(fila, 3).toString())==0){
                    fila = i;
                    break;
                }
            }
        }catch(Exception e){
            throw e;
        }
        return fila;
    }

    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource().equals(btn_guardar)) {
                saveProduct();
            }
            if (e.getSource().equals(btn_agregar)) {
                limpiarCajas();
                habilitarDatos();
                deshabilitarBotones();
                setProceso("A");
                tbl_productos.setEnabled(false);
                lbl_cod_producto.setVisible(false);
                lbl_cod_producto.setText("0");
            }
            if (e.getSource().equals(btn_cancelar)) {
                deshabilitarDatos();
                habilitarBotones();
                tbl_productos.setEnabled(true);
            }
            if (e.getSource().equals(btn_eliminar)) {
                deleteProduct();
            }
            if (e.getSource().equals(btn_modificar)) {
                if (tbl_productos.getSelectedRowCount() == 0||lbl_cod_producto.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una fila antes de modificar","Atención",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                habilitarDatos();
                deshabilitarBotones();
                setProceso("M");
                tbl_productos.setEnabled(false);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    
    public void saveProduct() throws Exception{
        try{
            int error = verificarDatos();
            switch (error){
                case 0:
                    JOptionPane.showMessageDialog(new JFrame(), "Complete los casilleros primero","Atención",JOptionPane.INFORMATION_MESSAGE);
                    return;
                case -1:
                    JOptionPane.showMessageDialog(new JFrame(), "Caracter no válido. Reintente","Atención",JOptionPane.INFORMATION_MESSAGE);
                    return;
                case -2:
                    JOptionPane.showMessageDialog(new JFrame(), "El dato ingresado está fuera de rango","Atención",JOptionPane.INFORMATION_MESSAGE);
                    return;
                default:
                    break;
          }
            // Se recupera el valueMember de lo que selecciona del comboBox
            Marcas marca = (Marcas) cbo_marca.getSelectedItem();
            int codMarca = marca.getCodMarca();
            Rubros rubro = (Rubros) cbo_rubro.getSelectedItem();
            int codRubro = rubro.getCodRubro();
            //
            Productos prod = new Productos(Integer.valueOf(lbl_cod_producto.getText()),txt_descripcion.getText(),Float.valueOf(txt_prlista.getText()),codMarca,codRubro,Integer.valueOf(txt_stmin.getText()),Integer.valueOf(txt_stactual.getText()),Float.valueOf(txt_prventa.getText()));  
            if (getProceso().compareTo("A")==0){
                prod.insertProducto();
                Object[] datos = {prod.getCodProducto(), txt_descripcion.getText(), cbo_marca.getSelectedItem().toString(),cbo_rubro.getSelectedItem().toString(),txt_stmin.getText(),txt_stactual.getText(),txt_prlista.getText(), txt_prventa.getText(),"Habilitado"};
                modelo.addRow(datos);
            }else{
                prod.updateProducto();
                int fila = tbl_productos.getSelectedRow();            
                actualizarTabla(fila);            
            } 
            // se limpian las cajas, se las deshabilita y se habilitan los botones.
            limpiarCajas();
            deshabilitarDatos();
            habilitarBotones();
            tbl_productos.setEnabled(true);
            lbl_cod_producto.setVisible(true);
        }catch(Exception e){
            throw e;
        }
    }
    
    public void deleteProduct(){
        try{
            if (tbl_productos.getSelectedRowCount() == 0||lbl_cod_producto.getText().trim().length()==0){
                JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una fila antes de Habilitar/Deshabilitar","Atención",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Marcas marca = (Marcas) cbo_marca.getSelectedItem();
            int codMarca = marca.getCodMarca();
            Rubros rubro = (Rubros) cbo_rubro.getSelectedItem();
            int codRubro = rubro.getCodRubro();
               
            String estado = new String(tbl_productos.getValueAt(tbl_productos.getSelectedRow(), 8).toString().compareTo("Habilitado")==0?"D":"H");
            Productos prod = new Productos(Integer.valueOf(lbl_cod_producto.getText()),txt_descripcion.getText(),Float.valueOf(txt_prlista.getText()),codMarca,codRubro,Integer.valueOf(txt_stactual.getText()),Integer.valueOf(txt_stmin.getText()),Float.valueOf(txt_prventa.getText()),estado);
            prod.updateProducto();
            int fila = tbl_productos.getSelectedRow(); 
            actualizarTabla(fila);
            modelo.setValueAt(estado.compareTo("D")==0?"Deshabilitado":"Habilitado",fila, 8);
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
}
