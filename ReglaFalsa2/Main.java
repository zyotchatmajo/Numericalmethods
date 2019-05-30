/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReglaFalsa2;

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

    double parse(String ratio) {
    if (ratio.contains("/")) {
        String[] rat = ratio.split("/");
        return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
    } else {
        return Double.parseDouble(ratio);
    }
}
    
    public void Metodo(){
        double inter = 0;
        double iner2 = 0;
        if(PiE.isSelected()){
            inter = Math.PI * parse(intervalo1.getText());
            iner2 = Math.PI * parse(intervalo2.getText());
        }else{
            inter = Double.parseDouble(intervalo1.getText());
            iner2 = Double.parseDouble(intervalo2.getText());
        }
        double error = 0;
        double errord = 0.005;
        double xr = 0;
        double xrn = 0;
        boolean fin = false;
        if(GradosE.isSelected()){
            inter = Math.toRadians(Double.parseDouble(intervalo1.getText()));
            iner2 = Math.toRadians(Double.parseDouble(intervalo2.getText()));
        }
        
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
        if(Cos.isSelected()){
            fx0 = Math.cos(fx0);
            fx1 = Math.cos(fx1);
        }else if(Seno.isSelected()){
            fx0 = Math.sin(fx0);
            fx1 = Math.sin(fx1);
        }else if(Tang.isSelected()){
            fx0 = Math.tan(fx0);
            fx1 = Math.tan(fx1);
        }
        xr = ((fx0 * iner2) - (fx1 * inter))/(fx0 - fx1);
        System.out.println("Primer valor");
        if(RadDec.isSelected()){
                System.out.print("Mostrado en radianes decimales: ");
                System.out.println(xr);
            }else if(Grados.isSelected()){
                System.out.print("Mostrado en Grados: ");
                System.out.println(Math.toDegrees(xr)+"°");
            }
        int i = 0;
        while(fin == false){
            fx0 = ( Math.pow(xr, 6) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 0)))) )+ 
                (Math.pow(xr, 5) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 1)))) )+
                (Math.pow(xr, 4) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 2))))) +
                (Math.pow(xr, 3) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 3)))) )+
                (Math.pow(xr, 2) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 4))))) +
                (xr * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 5)))) )+
                (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6))));
            if(Cos.isSelected()){
                fx0 = Math.cos(fx0);
            }else if(Seno.isSelected()){
                fx0 = Math.sin(fx0);
            }else if(Tang.isSelected()){
                fx0 = Math.tan(fx0);
            }
            DecimalFormat errorp = new DecimalFormat("#.####");
            fx0 = Double.valueOf(errorp.format(fx0));
            System.out.println("Interaccion "+(i+2)+" - - - - - - - - ");
            xrn = iner2 - (((fx1 * xr) - (fx1 * iner2))/(fx0 - fx1));
            xrn = Double.valueOf(errorp.format(xrn));
            System.out.println("Xr"+(i+2));
            if(RadDec.isSelected()){
                System.out.println("FX0 "+fx0);
                System.out.println("FX1 "+fx1);
                System.out.print("Mostrado en radianes decimales: ");
                System.out.println(xrn);
            }else if(Grados.isSelected()){
                System.out.print("Mostrado en Grados: ");
                System.out.println(Math.toDegrees(xrn)+"°");
            }
            error = abs((xrn - xr) / xrn) * 100;
            error = Double.valueOf(errorp.format(error));
            System.out.println("Error " + error + "%");
            if (error <= errord || i == 500) {
                fin = true;
            }
            i++;
            xr = xrn;
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
        Seno = new javax.swing.JRadioButton();
        Cos = new javax.swing.JRadioButton();
        Tang = new javax.swing.JRadioButton();
        Grados = new javax.swing.JRadioButton();
        RadDec = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        GradosE = new javax.swing.JRadioButton();
        RadianE = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        PiE = new javax.swing.JRadioButton();

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

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        intervalo1.setText("Intervalo 1");

        intervalo2.setText("Intervalo 2");

        Seno.setText("Seno (x)");

        Cos.setText("Cos (x)");

        Tang.setText("Tg (x)");

        Grados.setText("Grados sexagesimales");

        RadDec.setText("Radianes Decimales");

        jLabel1.setText("- Salida");

        GradosE.setText("Grados sexagesimales");

        RadianE.setText("Radianes Decimales");

        jLabel2.setText("- Entrada");

        PiE.setText("Funcion de pi radian");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Seno)
                                .addGap(18, 18, 18)
                                .addComponent(Cos)
                                .addGap(18, 18, 18)
                                .addComponent(Tang))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Grados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RadDec))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(GradosE)
                                            .addComponent(intervalo1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(intervalo2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RadianE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PiE)))))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seno)
                    .addComponent(Cos)
                    .addComponent(Tang))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(intervalo1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(intervalo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GradosE)
                    .addComponent(RadianE)
                    .addComponent(jLabel2)
                    .addComponent(PiE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Grados)
                    .addComponent(RadDec)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
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
    private javax.swing.JRadioButton Cos;
    private javax.swing.JRadioButton Grados;
    private javax.swing.JRadioButton GradosE;
    private javax.swing.JRadioButton PiE;
    private javax.swing.JRadioButton RadDec;
    private javax.swing.JRadioButton RadianE;
    private javax.swing.JRadioButton Seno;
    private javax.swing.JRadioButton Tang;
    private javax.swing.JTextField intervalo1;
    private javax.swing.JTextField intervalo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
