/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import clases.CasaDeportiva;
import clases.Vendedores;
import csvreader.CsvWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nico
 */
public class reporte_ventas extends javax.swing.JFrame implements ActionListener{

    public reporte_ventas(){
        initComponents();
        try{        
            this.setTitle(CasaDeportiva.getTitle() + " - Reporte de Ventas");
            Vendedores.traerVendedores(this.lst_vendedores_list);
            this.lst_vendedores_rep.setModel(new DefaultListModel());
            tbl_resultado.setModel(new DefaultTableModel());
            btn_vendedor_agregar.addActionListener(this);
            btn_vendedor_eliminar.addActionListener(this);
            btn_aceptar_reporte_ventas.addActionListener(this);
            btn_exportar.addActionListener(this);
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_vendedor = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        jScrollPane6 = new javax.swing.JScrollPane();
        lst_vendedores_list = new javax.swing.JList();
        jScrollPane9 = new javax.swing.JScrollPane();
        lst_vendedores_rep = new javax.swing.JList();
        btn_aceptar_reporte_ventas = new javax.swing.JButton();
        btn_vendedor_agregar = new javax.swing.JButton();
        btn_vendedor_eliminar = new javax.swing.JButton();
        lbl_marca1 = new javax.swing.JLabel();
        lbl_marca2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_resultado = new javax.swing.JTable();
        btn_exportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbl_vendedor.setText("Vendedor:");

        lst_vendedores_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_vendedores_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(lst_vendedores_list);

        lst_vendedores_rep.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_vendedores_rep.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane9.setViewportView(lst_vendedores_rep);

        btn_aceptar_reporte_ventas.setText("Aceptar");

        btn_vendedor_agregar.setText(">>");

        btn_vendedor_eliminar.setText("<<");

        lbl_marca1.setText("Fecha Desde:");

        lbl_marca2.setText("Fecha Desde:");

        tbl_resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_resultado.setEnabled(false);
        jScrollPane1.setViewportView(tbl_resultado);

        btn_exportar.setText("Exportar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_vendedor)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_vendedor_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_vendedor_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_marca2)
                            .addComponent(lbl_marca1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_exportar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_aceptar_reporte_ventas)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_marca1)
                        .addGap(28, 28, 28)
                        .addComponent(lbl_marca2)
                        .addGap(105, 105, 105)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_vendedor)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_vendedor_agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_vendedor_eliminar)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_exportar)
                    .addComponent(btn_aceptar_reporte_ventas))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource().equals(btn_vendedor_agregar)) { 
                if (!this.lst_vendedores_list.isSelectionEmpty()){
                    if (!((DefaultListModel) this.lst_vendedores_rep.getModel()).contains(this.lst_vendedores_list.getSelectedValue()))
                        ((DefaultListModel) this.lst_vendedores_rep.getModel()).addElement(this.lst_vendedores_list.getSelectedValue());
                }
                else
                    JOptionPane.showMessageDialog(new JFrame(), "Debe seleccionar una fila primero","Atención",JOptionPane.INFORMATION_MESSAGE);
            }
            if (e.getSource().equals(btn_vendedor_eliminar)) {
                if (!this.lst_vendedores_rep.isSelectionEmpty())
                    ((DefaultListModel) this.lst_vendedores_rep.getModel()).removeElementAt(this.lst_vendedores_rep.getSelectedIndex());
            }
            if (e.getSource().equals(btn_aceptar_reporte_ventas)) {
                tbl_resultado.setModel(mostrarResultado((DefaultListModel)this.lst_vendedores_rep.getModel()));
            }
            if (e.getSource().equals(btn_exportar)) {
                if (tbl_resultado.getRowCount() > 0)
                    exportar_excel();
                else
                    JOptionPane.showMessageDialog(new JFrame(), "No hay registros para exportar","Atención",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try{
            System.gc();
            CasaDeportiva.setReporteVentas(1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing
    
    private void exportar_excel(){
        try{
            CsvWriter archivo;
            archivo = new CsvWriter("C:\\Users\\Nico\\Documents\\NetBeansProjects\\prueba.csv");
            try {
                Class.forName(CasaDeportiva.getDriver());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(abm_productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection(CasaDeportiva.getSQLPath(),
                                                                      CasaDeportiva.getUser(),
                                                                      CasaDeportiva.getPassword());
            Statement com = (Statement) con.createStatement();
            DefaultTableModel modelo = (DefaultTableModel) tbl_resultado.getModel();
            String query;
            query = "select * from deportes.marcas where descripcion='"+modelo.getValueAt(0,0).toString()+"';";
            
            CallableStatement cs;
            cs = (CallableStatement) con.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    String datos;
                    datos = rs.getString(2);
                    archivo.write(datos);
                    archivo.flush();
                }while(rs.next());
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay marcas cargadas");
            }
            rs.close();
            com.close();
            con.close();
            archivo.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }
    
    private DefaultTableModel mostrarResultado(DefaultListModel Vendedores){
        // Trae los datos para realizar el ABM, los carga en el modelo,
        // y a través de la vinculación con el componente
        // se mostrarán los datos.
        DefaultTableModel modelo;
        Object [] columnas = {"Vendedor","Fecha","Marca","Producto","Cantidad","Total"};
        modelo = new DefaultTableModel(columnas,0);
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
            String query;
            query = armarQuery(Vendedores);
            /*
            CallableStatement cs;
            cs = (CallableStatement) con.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            if (rs.first()){
                do {
                    Object []datos = {rs.getString(1), rs.getDate(2),rs.getString(3),rs.getString(4),rs.getInt(5),
                                      rs.getLong(6)};
                    modelo.addRow(datos);
                }while(rs.next());
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "No hay datos para mostrar");
            }
            rs.close();
            com.close();
            con.close();*/
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
        return modelo;
    }
    
    private String armarQuery(DefaultListModel Vendedores) {
        String filter = null;
        String query = null;
        try{
            if (Vendedores.getSize()>0){
                filter = "AND ven.cod_vendedor in (";
                for (int i=0;i<Vendedores.getSize();i++){
                    if (i>0){
                        filter = filter + ",";
                    }
                    filter = filter + Vendedores.getElementAt(i).toString().substring(0,1); 
                }
                filter = filter + ")";
            }

            query = "SELECT ven.nombre, vta.fecha, mar.descripcion, prd.descripcion,dvt.cantidad, dvt.precio_unitario "+
                    "FROM ventas vta, detalle_ventas dvt, marcas mar, productos prd, vendedores ven "+
                    "WHERE vta.nro_factura = dvt.nro_factura "+
                    "AND vta.cod_vendedor = ven.cod_vendedor "+
                    "AND dvt.cod_producto = prd.cod_producto "+
                    "AND prd.cod_marca = mar.cod_marca ";
            if (Vendedores.getSize()>0){
                query = query + filter;
            }
            query = query + "ORDER BY nombre";
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
        return query;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar_reporte_ventas;
    private javax.swing.JButton btn_exportar;
    private javax.swing.JButton btn_vendedor_agregar;
    private javax.swing.JButton btn_vendedor_eliminar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbl_marca1;
    private javax.swing.JLabel lbl_marca2;
    private javax.swing.JLabel lbl_vendedor;
    private javax.swing.JList lst_vendedores_list;
    private javax.swing.JList lst_vendedores_rep;
    private javax.swing.JTable tbl_resultado;
    // End of variables declaration//GEN-END:variables


}
