/*
 * MenuPrincipal.java
 *
 * Created on 22 de noviembre de 2008, 11:13
 */

package pantallas;

import clases.CasaDeportiva;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import clases.PoolConexionesOracle;
import java.sql.*;

/**
 *
 * @author  MAQUINA 12
 */
public final class MenuPrincipal extends JFrame implements ActionListener{
    // Items de Menu
    JMenuBar mbarra=new JMenuBar(); 
    JMenu mfile=new JMenu("Archivo"); 
    JMenuItem mexit=new JMenuItem("Salir");
    JMenu mtables=new JMenu("Tablas"); 
    JMenuItem mbrands=new JMenuItem("Marcas");
    JMenuItem mcategories=new JMenuItem("Categorias"); 
    JMenuItem msellers=new JMenuItem("Vendedores"); 
    JMenuItem mproducts=new JMenuItem("Productos");
    JMenu moperations=new JMenu("Operaciones"); 
    JMenuItem msales=new JMenuItem("Ventas");
    JMenu mqueries=new JMenu("Consultas"); 
    JMenuItem msalesbyseller=new JMenuItem("Ventas por vendedor");
    JMenu medit=new JMenu("Editar");
    JMenuItem mcut=new JMenuItem("Cortar"); 
    JMenuItem mcopy=new JMenuItem("Copiar"); 
    JMenuItem mpaste=new JMenuItem("Pegar");
    // Instancias de ventanas
    ventas v;
    reporte_ventas rv;
    abm_marcas b;
    abm_productos p;
    abm_rubros r;
    abm_vendedores av;
    
    /** Creates new form MenuPrincipal */
    public MenuPrincipal() {
        initComponents();
        try{
            this.setTitle(CasaDeportiva.getTitle() + " - Menu Principal");
            setSize(800,600);
            Dimension pantalla, cuadro;
            pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            cuadro = this.getSize();
            this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);
            setLayout(null);
            this.setEnabled(true);
            armarMenu();
            rv = null;
            v = null;
            b = null;
            p = null;
            r = null;
            av = null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void actionPerformed(ActionEvent e) {
        try{            
            if (e.getSource().equals(msales)) {
                if(v == null){
                    v = new ventas();
                    v.setVisible(true);
                    repaint();			
		}
		else{
                    JOptionPane.showMessageDialog(new JFrame(), "La ventana ya se encuentra abierta");
		}
            }
            if (e.getSource().equals(msalesbyseller)) {
                if(rv == null){
                    rv = new reporte_ventas();
                    rv.setVisible(true);
                    repaint();			
		}
		else{
                    JOptionPane.showMessageDialog(new JFrame(), "La ventana ya se encuentra abierta");
		}
            }
            if (e.getSource().equals(mbrands)){
                if(b == null){
                    b = new abm_marcas();
                    b.setVisible(true);
                    repaint();			
		}
		else{
                    JOptionPane.showMessageDialog(new JFrame(), "La ventana ya se encuentra abierta");
		}
            }
            if (e.getSource().equals(mcategories)){
                if(r == null){
                    r = new abm_rubros();
                    r.setVisible(true);
                    repaint();			
		}
		else{
                    JOptionPane.showMessageDialog(new JFrame(), "La ventana ya se encuentra abierta");
		}
            } 
            if (e.getSource().equals(msellers)){
                if(av == null){
                    av = new abm_vendedores();
                    av.setVisible(true);
                    repaint();			
		}
		else{
                    JOptionPane.showMessageDialog(new JFrame(), "La ventana ya se encuentra abierta");
		}
            }
            if (e.getSource().equals(mproducts)){
                if(p == null){
                    p = new abm_productos();
                    p.setVisible(true);
                    repaint();			
		}
		else{
                    JOptionPane.showMessageDialog(new JFrame(), "La ventana ya se encuentra abierta");
		}
            }
            if (e.getSource().equals(mexit)) {
                System.gc();
                System.exit(0);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        
    }

  /*  public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }*/
    
    public static void main(String args[]) throws SQLException {
        try{
            Connection conn = PoolConexionesOracle.getConexion();
            PreparedStatement stmt = conn.prepareStatement("SELECT 1 FROM DUAL");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println("Conexion exitosa");
            }
            conn.close();
        } catch (SQLException ex) {
        }
    }

    public void armarMenu(){
        try{
            // Menu Archivo
            mfile.add(mexit);
            // Menu Editar
            medit.add(mcut); 
            medit.add(mcopy); 
            medit.add(mpaste);
            // Menu Tablas
            mtables.add(mbrands);
            mtables.add(mcategories);
            mtables.add(msellers);
            mtables.add(mproducts);
            // Menu Operaciones
            moperations.add(msales);
            // Menu Consultas
            mqueries.add(msalesbyseller);
            // Armado del menu
            mbarra.add(mfile);
            mbarra.add(medit);
            mbarra.add(mtables);
            mbarra.add(moperations);
            mbarra.add(mqueries);
            //Añadimos la barra al JFrame
            setJMenuBar(mbarra); 
            mexit.addActionListener(this);
            mbrands.addActionListener(this);
            mcategories.addActionListener(this);
            msellers.addActionListener(this);
            mproducts.addActionListener(this);
            msales.addActionListener(this);
            msalesbyseller.addActionListener(this);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
