/*
 * abm_rubros.java
 *
 * Created on 19 de noviembre de 2008, 17:05
 */

package pantallas;

import clases.CasaDeportiva;
import clases.Rubros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Chona
 */
public class abm_rubros extends javax.swing.JFrame implements ActionListener{
    // Propiedades declaradas para el formulario y la clase principal
    private DefaultTableModel modelo;
    private int ABM; // GUARDO UN NRO Q INDICA SI ENTRO A AGREGAR MODIFICAR O ELIMINAR

    /** Creates new form abm_rubros */
    public abm_rubros() {
        initComponents();
        try{        
            this.setTitle(CasaDeportiva.getTitle() + " - Rubros");
            Object [] columnas = {"Código","Descripcion","Estado"};
            modelo= new DefaultTableModel(columnas,0);
            Rubros.traerRubros(modelo);
            tabla_rubro.setModel(modelo);
            btn_agregar_rubro.addActionListener(this);
            btn_cancelar_rubro.addActionListener(this);
            btn_guardar_rubro.addActionListener(this);
            btn_hab_deshab_rubro.addActionListener(this);
            btn_modificar_rubro.addActionListener(this);
            deshabilitarDatos();
            habilitarBotones();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_descripcion_rubro = new javax.swing.JLabel();
        lbl_codigo = new javax.swing.JLabel();
        txt_descripcion_rubro = new javax.swing.JTextField();
        lbl_codigo_rubro = new javax.swing.JLabel();
        btn_cancelar_rubro = new javax.swing.JButton();
        btn_hab_deshab_rubro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_rubro = new javax.swing.JTable();
        btn_guardar_rubro = new javax.swing.JButton();
        btn_modificar_rubro = new javax.swing.JButton();
        btn_agregar_rubro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 250, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lbl_descripcion_rubro.setText("Descripcion:");

        lbl_codigo.setText("Codigo:");

        lbl_codigo_rubro.setText("0");

        btn_cancelar_rubro.setText("Cancelar");

        btn_hab_deshab_rubro.setText("Habilitar / Deshabilitar");

        tabla_rubro.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_rubro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_rubroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_rubro);

        btn_guardar_rubro.setText("Guardar");

        btn_modificar_rubro.setText("Modificar");

        btn_agregar_rubro.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cancelar_rubro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar_rubro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_hab_deshab_rubro)
                            .addComponent(btn_modificar_rubro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_agregar_rubro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_descripcion_rubro)
                        .addGap(39, 39, 39)
                        .addComponent(txt_descripcion_rubro, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_codigo)
                        .addGap(60, 60, 60)
                        .addComponent(lbl_codigo_rubro)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo)
                    .addComponent(lbl_codigo_rubro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_descripcion_rubro)
                    .addComponent(txt_descripcion_rubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_agregar_rubro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar_rubro)
                        .addGap(4, 4, 4)
                        .addComponent(btn_hab_deshab_rubro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar_rubro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_rubro))
                    .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tabla_rubroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_rubroMouseClicked
// TODO add your handling code here:
    // Vuelca los datos del registro en los componentes del formulario
    try{
        int fila = tabla_rubro.getSelectedRow();
        lbl_codigo_rubro.setText(tabla_rubro.getValueAt(fila, 0).toString());
        txt_descripcion_rubro.setText((String) tabla_rubro.getValueAt(fila, 1));
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_tabla_rubroMouseClicked

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:
    // Indica que se puede instanciar una nueva ventana.
    try{
        System.gc();
        CasaDeportiva.setRubros(1);
    }catch(Exception e){
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
    }
}//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_rubro;
    private javax.swing.JButton btn_cancelar_rubro;
    private javax.swing.JButton btn_guardar_rubro;
    private javax.swing.JButton btn_hab_deshab_rubro;
    private javax.swing.JButton btn_modificar_rubro;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo_rubro;
    private javax.swing.JLabel lbl_descripcion_rubro;
    private javax.swing.JTable tabla_rubro;
    private javax.swing.JTextField txt_descripcion_rubro;
    // End of variables declaration//GEN-END:variables

    public int verificarDatos(){
        // Verifica la consistencia de datos.
        try{
            if (txt_descripcion_rubro.getText().trim().length()==0) return 0;
            if (txt_descripcion_rubro.getText().trim().length()>25) return -2;
            if (CasaDeportiva.verificarTexto(txt_descripcion_rubro.getText().trim())==0) return -1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }        
        return 1; 
    } 
    
    public void habilitarBotones(){
        btn_agregar_rubro.setEnabled(true);
        btn_modificar_rubro.setEnabled(true);
        btn_hab_deshab_rubro.setEnabled(true);
        btn_guardar_rubro.setEnabled(false);
        btn_cancelar_rubro.setEnabled(false);
    }
    
    public void deshabilitarBotones(){
        btn_agregar_rubro.setEnabled(false);
        btn_modificar_rubro.setEnabled(false);
        btn_hab_deshab_rubro.setEnabled(false);
        btn_guardar_rubro.setEnabled(true);
        btn_cancelar_rubro.setEnabled(true);
    }

    public void deshabilitarDatos(){
        txt_descripcion_rubro.setEnabled(false);
        limpiarCajas();
    }
    
    public void habilitarDatos(){
        txt_descripcion_rubro.setEnabled(true);
    }
    
    public void limpiarCajas(){
        lbl_codigo_rubro.setText("");
        txt_descripcion_rubro.setText("");
    }

    public int getABM() {
        return ABM;
    }

    public void setABM(int ABM) {
        this.ABM = ABM;
    }

    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource().equals(btn_hab_deshab_rubro)||e.getSource().equals(btn_modificar_rubro)) {
                if (tabla_rubro.getSelectedRowCount() == 0||lbl_codigo_rubro.getText().trim().length()==0){
                    if (e.getSource().equals(btn_modificar_rubro))
                        JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una fila antes de modificar","Atención",JOptionPane.INFORMATION_MESSAGE);
                    if (e.getSource().equals(btn_hab_deshab_rubro))
                        JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una fila antes de Habilitar/Deshabilitar","Atención",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (e.getSource().equals(btn_modificar_rubro)){
                    modifyCategory();
                }
                if (e.getSource().equals(btn_hab_deshab_rubro)){
                    enableCategory();
                }
            }
            if (e.getSource().equals(btn_agregar_rubro)) {
                limpiarCajas();
                habilitarDatos();
                deshabilitarBotones();
                setABM(1);
                tabla_rubro.setEnabled(false);
                lbl_codigo_rubro.setVisible(false);
                lbl_codigo_rubro.setText("0");
            }
            if (e.getSource().equals(btn_cancelar_rubro)) {
                deshabilitarDatos();
                habilitarBotones();
                tabla_rubro.setEnabled(true);
            }
            if (e.getSource().equals(btn_guardar_rubro)) {
                saveCategory();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    
    public void saveCategory(){
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
            Rubros rubro = new Rubros(Integer.valueOf(lbl_codigo_rubro.getText()),txt_descripcion_rubro.getText());
            if(getABM()==1){
                rubro.insertRubro();
                Object[] datos = {rubro.getCodRubro(),rubro.getDescripcion(),"Habilitado"};
                modelo.addRow(datos);
            }else{
                String estado = new String(tabla_rubro.getValueAt(tabla_rubro.getSelectedRow(), 2).toString().compareTo("Habilitado")==0?"D":"H");
                rubro.setEstado(estado);
                rubro.updateRubro();
                int fila = tabla_rubro.getSelectedRow();
                modelo.setValueAt(txt_descripcion_rubro.getText(), fila, 1);
            }
            limpiarCajas();
            deshabilitarDatos();
            habilitarBotones();
            tabla_rubro.setEnabled(true);
            lbl_codigo_rubro.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    public void enableCategory(){
        try{     
            String estado = new String(tabla_rubro.getValueAt(tabla_rubro.getSelectedRow(), 2).toString().compareTo("Habilitado")==0?"D":"H");        
            Rubros rubro = new Rubros(Integer.valueOf(lbl_codigo_rubro.getText()),txt_descripcion_rubro.getText(),estado);
            rubro.updateRubro();
            modelo.setValueAt(estado.compareTo("D")==0?"Deshabilitado":"Habilitado",tabla_rubro.getSelectedRow(), 2);
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    public void modifyCategory(){
        try{
            habilitarDatos();
            deshabilitarBotones();
            setABM(2);
            tabla_rubro.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
}
