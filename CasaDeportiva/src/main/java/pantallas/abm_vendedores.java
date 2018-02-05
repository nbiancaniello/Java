/*
 * abm_vendedores.java
 *
 * Created on 22 de noviembre de 2008, 01:14
 */

package pantallas;

import clases.CasaDeportiva;
import clases.Vendedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Chona
 */
public final class abm_vendedores extends javax.swing.JFrame implements ActionListener{
    // Propiedades declaradas para el formulario y la clase principal
    private DefaultTableModel modelo;
    private int ABM; // GUARDO UN NRO Q INDICA SI ENTRO A AGREGAR MODIFICAR O ELIMINAR

    /** Creates new form abm_vendedores */
    public abm_vendedores() {
        initComponents();
        try{        
            this.setTitle(CasaDeportiva.getTitle() + " - Vendedores");
            Object [] columnas = {"Código","Descripcion"};
            modelo= new DefaultTableModel(columnas,0);
            tabla_vendedor.setModel(modelo);
            Vendedores.traerVendedores(modelo);
            deshabilitarDatos();
            habilitarBotones();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nombre = new javax.swing.JLabel();
        lbl_legajo = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_legajo_vendedor = new javax.swing.JLabel();
        btn_cancelar_vendedor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_vendedor = new javax.swing.JTable();
        btn_guardar_vendedor = new javax.swing.JButton();
        btn_modificar_vendedor = new javax.swing.JButton();
        btn_agregar_vendedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 250, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbl_nombre.setText("Nombre y Apellido:");

        lbl_legajo.setText("Legajo:");

        lbl_legajo_vendedor.setText("0");

        btn_cancelar_vendedor.setText("Cancelar");
        btn_cancelar_vendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelar_vendedorMouseClicked(evt);
            }
        });

        tabla_vendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tabla_vendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_vendedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_vendedor);

        btn_guardar_vendedor.setText("Guardar");
        btn_guardar_vendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardar_vendedorMouseClicked(evt);
            }
        });

        btn_modificar_vendedor.setText("Modificar");
        btn_modificar_vendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modificar_vendedorMouseClicked(evt);
            }
        });

        btn_agregar_vendedor.setText("Agregar");
        btn_agregar_vendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_agregar_vendedorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btn_modificar_vendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(btn_agregar_vendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btn_guardar_vendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_cancelar_vendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_nombre)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_legajo)
                        .addGap(72, 72, 72)
                        .addComponent(lbl_legajo_vendedor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_legajo)
                    .addComponent(lbl_legajo_vendedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_agregar_vendedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_vendedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_vendedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_vendedor))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_cancelar_vendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelar_vendedorMouseClicked
    /* Al cancelar, se habilitan los botones y se anula la transaccion.
     */
    try{
        deshabilitarDatos();
        habilitarBotones();
        tabla_vendedor.setEnabled(true);
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_btn_cancelar_vendedorMouseClicked

private void btn_guardar_vendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardar_vendedorMouseClicked
    /* Al realizar el grabado en la BD, primero verifica la consistencia 
     * de datos en cajas/combos, etc...
     * Luego, evaluando la propiedad ABM, determina la acción a realizar.
     */
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
        Vendedores vendedor = new Vendedores(Integer.valueOf(lbl_legajo_vendedor.getText()),txt_nombre.getText());
        if(getABM()==1){
            vendedor.insertVendedor();
            Object[] datos = {vendedor.getCodVendedor(),vendedor.getNombre(),"Habilitado"};
            modelo.addRow(datos);
        }else{
            vendedor.updateVendedor();
            int fila = tabla_vendedor.getSelectedRow();
            modelo.setValueAt(txt_nombre.getText(), fila, 1);
        }
        limpiarCajas();
        deshabilitarDatos();
        habilitarBotones();
        tabla_vendedor.setEnabled(true);
        lbl_legajo_vendedor.setVisible(true);
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_btn_guardar_vendedorMouseClicked

private void btn_modificar_vendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificar_vendedorMouseClicked
    /*
     */
    try{
        if (tabla_vendedor.getSelectedRowCount() == 0||lbl_legajo_vendedor.getText().trim().length()==0){
            JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una fila antes de modificar","Atención",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        habilitarDatos();
        deshabilitarBotones();
        setABM(2);
        tabla_vendedor.setEnabled(false);
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_btn_modificar_vendedorMouseClicked

private void btn_agregar_vendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar_vendedorMouseClicked
    /*
     */  
    try{
        limpiarCajas();
        habilitarDatos();
        deshabilitarBotones();
        setABM(1);
        tabla_vendedor.setEnabled(false);
        lbl_legajo_vendedor.setText("0");
        lbl_legajo_vendedor.setVisible(false);
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_btn_agregar_vendedorMouseClicked

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    /* Genera el TableModel para la tabla de la pantalla y trae los datos
    */
    
}//GEN-LAST:event_formWindowOpened

private void tabla_vendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_vendedorMouseClicked
// TODO add your handling code here:
    // Vuelca los datos del registro en los componentes del formulario
    try{
        int fila = tabla_vendedor.getSelectedRow();
        lbl_legajo_vendedor.setText(tabla_vendedor.getValueAt(fila, 0).toString());
        txt_nombre.setText((String) tabla_vendedor.getValueAt(fila, 1));
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_tabla_vendedorMouseClicked

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:
    // Indica que se puede instanciar una nueva ventana.
    try{
        System.gc();
        CasaDeportiva.setVendedores(1);
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_vendedor;
    private javax.swing.JButton btn_cancelar_vendedor;
    private javax.swing.JButton btn_guardar_vendedor;
    private javax.swing.JButton btn_modificar_vendedor;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_legajo;
    private javax.swing.JLabel lbl_legajo_vendedor;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JTable tabla_vendedor;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    public int verificarDatos() throws Exception{
        // Verifica la consistencia de datos.
        try{
            if (txt_nombre.getText().trim().length()==0) {
                return 0;
            }
            if (txt_nombre.getText().trim().length()>25) {
                return -2;
            }            
            if (CasaDeportiva.verificarTexto(txt_nombre.getText().trim())==0){
                return -1;
            }
        }catch(Exception e){
            throw e;
        }        
        return 1; 
    } 
    
    public void habilitarBotones(){
        btn_agregar_vendedor.setEnabled(true);
        btn_modificar_vendedor.setEnabled(true);
        btn_guardar_vendedor.setEnabled(false);
        btn_cancelar_vendedor.setEnabled(false);
    }
    
    public void deshabilitarBotones(){
        btn_agregar_vendedor.setEnabled(false);
        btn_modificar_vendedor.setEnabled(false);
        btn_guardar_vendedor.setEnabled(true);
        btn_cancelar_vendedor.setEnabled(true);
    }

    public void deshabilitarDatos(){
        txt_nombre.setEnabled(false);
        limpiarCajas();
    }
    
    public void habilitarDatos(){
        txt_nombre.setEnabled(true);
    }
    
    public void limpiarCajas(){
        lbl_legajo_vendedor.setText("");
        txt_nombre.setText("");
    }

    public int getABM() {
        return ABM;
    }

    public void setABM(int ABM) {
        this.ABM = ABM;
    }

    public void actionPerformed(ActionEvent e) {

    }
    
    
}
