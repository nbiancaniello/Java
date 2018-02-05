/*
 * abm_marcas.java
 *
 * Created on 12 de noviembre de 2008, 23:46
 */

package pantallas;

import clases.CasaDeportiva;
import clases.Marcas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Chona
 */
public final class abm_marcas extends javax.swing.JFrame implements ActionListener{
    // Propiedades declaradas para el formulario y la clase principal 
    private DefaultTableModel modelo;
    private int ABM; // GUARDO UN NRO Q INDICA SI ENTRO A AGREGAR MODIFICAR O ELIMINAR
    
    /** Creates new form abm_marcas */
    public abm_marcas() {
        initComponents();
        try{        
            this.setTitle(CasaDeportiva.getTitle() + " - Marcas");
            Object [] columnas = {"Código","Descripcion","Estado"};
            modelo= new DefaultTableModel(columnas,0);
            Marcas.traerMarcas(modelo);
            tabla_marcas.setModel(modelo);
            btn_agregar_marca.addActionListener(this);
            btn_cancelar_marca.addActionListener(this);
            btn_guardar_marca.addActionListener(this);
            btn_hab_deshab.addActionListener(this);
            btn_modificar_marca.addActionListener(this);
            deshabilitarDatos();
            habilitarBotones();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_codigo = new javax.swing.JLabel();
        lbl_codigo_marca = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        txt_descripcion_marca = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_marcas = new javax.swing.JTable();
        btn_agregar_marca = new javax.swing.JButton();
        btn_modificar_marca = new javax.swing.JButton();
        btn_guardar_marca = new javax.swing.JButton();
        btn_cancelar_marca = new javax.swing.JButton();
        btn_hab_deshab = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 250, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lbl_codigo.setText("Codigo:");

        lbl_codigo_marca.setText("0");

        lbl_descripcion.setText("Descripcion:");

        tabla_marcas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_marcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_marcasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_marcas);

        btn_agregar_marca.setText("Agregar");

        btn_modificar_marca.setText("Modificar");

        btn_guardar_marca.setText("Guardar");

        btn_cancelar_marca.setText("Cancelar");

        btn_hab_deshab.setText("Habilitar / Deshabilitar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_codigo)
                            .addComponent(lbl_descripcion))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_codigo_marca)
                            .addComponent(txt_descripcion_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cancelar_marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_hab_deshab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_agregar_marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_modificar_marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar_marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo)
                    .addComponent(lbl_codigo_marca))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_descripcion)
                    .addComponent(txt_descripcion_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_agregar_marca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_marca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hab_deshab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_marca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_marca))
                    .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    // Indica que se puede instanciar una nueva ventana.
    try{
        System.gc();
        CasaDeportiva.setMarcas(1);
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_formWindowClosed

private void tabla_marcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_marcasMouseClicked
// TODO add your handling code here:
    // Vuelca los datos del registro en los componentes del formulario
    try{
        int fila = tabla_marcas.getSelectedRow();
        lbl_codigo_marca.setText(tabla_marcas.getValueAt(fila, 0).toString());
        txt_descripcion_marca.setText((String) tabla_marcas.getValueAt(fila, 1));
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_tabla_marcasMouseClicked
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_marca;
    private javax.swing.JButton btn_cancelar_marca;
    private javax.swing.JButton btn_guardar_marca;
    private javax.swing.JButton btn_hab_deshab;
    private javax.swing.JButton btn_modificar_marca;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo_marca;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JTable tabla_marcas;
    private javax.swing.JTextField txt_descripcion_marca;
    // End of variables declaration//GEN-END:variables
    
    public int verificarDatos(){
     // Verifica la consistencia de datos.
        try{
            if (txt_descripcion_marca.getText().trim().length()==0) return 0;
            if (txt_descripcion_marca.getText().trim().length()>25) return -2;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return 1;
    }  
    
    public void habilitarBotones(){
        btn_agregar_marca.setEnabled(true);
        btn_modificar_marca.setEnabled(true);
        btn_hab_deshab.setEnabled(true);
        btn_guardar_marca.setEnabled(false);
        btn_cancelar_marca.setEnabled(false);
    }
    
    public void deshabilitarBotones(){
        btn_agregar_marca.setEnabled(false);
        btn_modificar_marca.setEnabled(false);
        btn_hab_deshab.setEnabled(false);
        btn_guardar_marca.setEnabled(true);
        btn_cancelar_marca.setEnabled(true);
    }

    public void deshabilitarDatos(){
        txt_descripcion_marca.setEnabled(false);
        limpiarCajas();
    }
    
    public void habilitarDatos(){
        txt_descripcion_marca.setEnabled(true);
    }
    
    public void limpiarCajas(){
        lbl_codigo_marca.setText("");
        txt_descripcion_marca.setText("");
    }

    public int getABM() {
        return ABM;
    }

    public void setABM(int ABM) {
        this.ABM = ABM;
    }

    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource().equals(btn_hab_deshab)||e.getSource().equals(btn_modificar_marca)) {
                if (tabla_marcas.getSelectedRowCount() == 0||lbl_codigo_marca.getText().trim().length()==0){
                    if (e.getSource().equals(btn_modificar_marca))
                        JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una fila antes de modificar","Atención",JOptionPane.INFORMATION_MESSAGE);
                    if (e.getSource().equals(btn_hab_deshab))
                        JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una fila antes de Habilitar/Deshabilitar","Atención",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (e.getSource().equals(btn_modificar_marca)){
                    modifyBrand();
                }
                if (e.getSource().equals(btn_hab_deshab)){
                    enableBrand();
                }
            }
            if (e.getSource().equals(btn_agregar_marca)) {
                limpiarCajas();
                habilitarDatos();
                deshabilitarBotones();
                setABM(1);
                tabla_marcas.setEnabled(false);
                lbl_codigo_marca.setVisible(false);
                lbl_codigo_marca.setText("0");
            }
            if (e.getSource().equals(btn_cancelar_marca)) {
                deshabilitarDatos();
                habilitarBotones();
                tabla_marcas.setEnabled(true);
            }
            if (e.getSource().equals(btn_guardar_marca)) {
                saveBrand();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    
    public void saveBrand(){
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
            Marcas marca = new Marcas(Integer.valueOf(lbl_codigo_marca.getText()),txt_descripcion_marca.getText());
            if(getABM()==1){
                marca.insertMarca();
                Object[] datos = {marca.getCodMarca(),marca.getDescripcion(),"Habilitado"};
                modelo.addRow(datos);
            }else{
                String estado = new String(tabla_marcas.getValueAt(tabla_marcas.getSelectedRow(), 2).toString().compareTo("Habilitado")==0?"D":"H");
                marca.setEstado(estado);
                marca.updateMarca();
                int fila = tabla_marcas.getSelectedRow();
                modelo.setValueAt(txt_descripcion_marca.getText(), fila, 1);
            }
            limpiarCajas();
            deshabilitarDatos();
            habilitarBotones();
            tabla_marcas.setEnabled(true);
            lbl_codigo_marca.setVisible(true);
         }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
         }
    }
    
    public void enableBrand(){
        try{     
            String estado = new String(tabla_marcas.getValueAt(tabla_marcas.getSelectedRow(), 2).toString().compareTo("Habilitado")==0?"D":"H");        
            Marcas marca = new Marcas(Integer.valueOf(lbl_codigo_marca.getText()),txt_descripcion_marca.getText(),estado);
            marca.updateMarca();
            modelo.setValueAt(estado.compareTo("D")==0?"Deshabilitado":"Habilitado",tabla_marcas.getSelectedRow(), 2);
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    public void modifyBrand(){
        try{
            habilitarDatos();
            deshabilitarBotones();
            setABM(2);
            tabla_marcas.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
}
