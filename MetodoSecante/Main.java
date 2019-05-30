/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoSecante;

import Reglafalsa.*;
import static java.lang.Math.abs;
import java.text.DecimalFormat;

/**
 *
 * @author Kevinchatmajo
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }
    public void Metodo(){
        int inter = Integer.parseInt(intervalo1.getText());
        int iner2 = Integer.parseInt(intervalo2.getText());
        double error = 0;
        double errord = 0.0005;
        double xr = 0;
        double xrn = 0;
        boolean fin = false;
        double fx0 = ( Math.pow(inter, 6) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 0)))) )+ 
                (Math.pow(inter, 5) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 1)))) )+
                (Math.pow(inter, 4) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 2))))) +
                (Math.pow(inter, 3) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 3)))) )+
                (Math.pow(inter, 2) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 4))))) +
                (inter * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 5)))) )+
                (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6))));
        double fx1 = (Math.pow(iner2, 6) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 0))))) + 
                (Math.pow(iner2, 5) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 1)))) )+
                (Math.pow(iner2, 4) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 2)))) )+
                (Math.pow(iner2, 3) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 3)))) )+
                (Math.pow(iner2, 2) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 4))))) +
                (iner2 * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 5))))) +
                (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6)))) ;
        //xr = ((fx0 * iner2) - (fx1 * inter))/(fx0 - fx1);
        xr = iner2 - ((fx1 *(inter - iner2))/(fx0 - fx1));
        System.out.println("Primer valor");
        System.out.println(xr);
        double ximinus = iner2;
        double xi = xr;
        fx0 = ( Math.pow(xi, 6) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 0)))) )+ 
                (Math.pow(xi, 5) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 1)))) )+
                (Math.pow(xi, 4) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 2))))) +
                (Math.pow(xi, 3) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 3)))) )+
                (Math.pow(xi, 2) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 4))))) +
                (xi * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 5)))) )+
                (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6))));
        fx1 = ( Math.pow(ximinus, 6) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 0)))) )+ 
                (Math.pow(ximinus, 5) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 1)))) )+
                (Math.pow(ximinus, 4) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 2))))) +
                (Math.pow(ximinus, 3) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 3)))) )+
                (Math.pow(ximinus, 2) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 4))))) +
                (ximinus * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 5)))) )+
                (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6))));
        System.out.println("X0"+ximinus);
            System.out.println("XI"+xi);
        int i = 0;
        while(fin == false){
            
            DecimalFormat errorp = new DecimalFormat("#.####");
            System.out.println("Interaccion "+(i+2)+" - - - - - - - - ");
            //xrn = iner2 - (((fx1 * xr) - (fx1 * iner2))/(fx0 - fx1));
            System.out.println(xi +" - ("+fx0+"("+ximinus+" - "+xi+")/("+fx1+" - "+fx0+")");
            try{
                xrn = xi - ((fx0 *(ximinus - xi))/(fx1 - fx0));
                xrn = Double.valueOf(errorp.format(xrn));
                error = abs((xrn - xi) / xrn) * 100;
                error = Double.valueOf(errorp.format(error));
            }catch(NumberFormatException e){
                fin = true;
            }
            
            System.out.println(xrn);
            System.out.println("> Xr"+(i+2));
            System.out.println(">>"+xrn);
            System.out.println("Error " + error + "%");
            if (error <= errord || i == 500) {
                fin = true;
            }
            i++;
            ximinus = xi;
            xi = xrn;
            fx0 = ( Math.pow(xi, 6) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 0)))) )+ 
                (Math.pow(xi, 5) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 1)))) )+
                (Math.pow(xi, 4) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 2))))) +
                (Math.pow(xi, 3) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 3)))) )+
                (Math.pow(xi, 2) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 4))))) +
                (xi * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 5)))) )+
                (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6))));
            fx1 = ( Math.pow(ximinus, 6) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 0)))) )+ 
                (Math.pow(ximinus, 5) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 1)))) )+
                (Math.pow(ximinus, 4) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 2))))) +
                (Math.pow(ximinus, 3) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 3)))) )+
                (Math.pow(ximinus, 2) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 4))))) +
                (ximinus * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 5)))) )+
                (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6))));
            try{
                fx0 = Double.valueOf(errorp.format(fx0));
                fx1 = Double.valueOf(errorp.format(fx1));
            }catch(NumberFormatException e){
                fin = true;
            }
            
            System.out.println("fx0"+fx0);
            System.out.println("fx1"+fx1);
            System.out.println("X0"+ximinus);
            System.out.println("XI"+xi);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        intervalo1 = new javax.swing.JTextField();
        intervalo2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "x^6", "x^5", "x^4", "x^3", "x^2", "x", "#"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        intervalo1.setText("Intervalo 1");

        intervalo2.setText("Intervalo 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(intervalo1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(intervalo2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(intervalo1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(intervalo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(134, 134, 134))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Metodo();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField intervalo1;
    private javax.swing.JTextField intervalo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
