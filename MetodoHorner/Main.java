/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoHorner;

import Reglafalsa.*;
import static java.lang.Math.abs;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Kevinchatmajo
 */
public class Main extends javax.swing.JFrame {
    ArrayList<Double> Val = new ArrayList<Double>();
    ArrayList<Double> Val2 = new ArrayList<Double>();
    ArrayList<Double> Pd = new ArrayList<Double>();
    ArrayList<Double> Pd2 = new ArrayList<Double>();
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }
    public void define(){
        boolean getFirstv = false;
        int valor = 6;
        while(!getFirstv){
            if(Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6 - valor))) != 0){
                valor--;
            }else{
                getFirstv = true;
            }
        }
        while(valor != -1){
            Val.add(Double.parseDouble(String.valueOf(tabla.getValueAt(0, 6 - valor))));
            valor--;
        }
    }
    
    public double divs(double divisor){
        Val2.clear();
        double temp = 0;
        for (int i = 0; i < Val.size(); i++) {
            if(i == 0){
                temp = Val.get(i);
            }else{
                temp = (temp * divisor) + Val.get(i);
            }
            Val2.add(temp);
            //System.out.println(temp);
        }
        return temp;
    }
    
    public double divsR(double divisor){
        double temp = 0;
        for (int i = 0; i < Val2.size() - 1; i++) {
            if(i == 0){
                temp = Val2.get(i);
            }else{
                temp = (temp * divisor) + Val2.get(i);
            }
            //System.out.println(temp);
        }
        return temp;
    }
    
    public double getError(double enew, double eant){
        DecimalFormat errorp = new DecimalFormat("#.####");
        double error;
        error = abs((enew - eant) / enew) * 100;
        error = Double.valueOf(errorp.format(error));
        return error;
    }
    public void metodo2(){
        define();
        double inter = Double.parseDouble(intervalo1.getText());
        double inter2 = Double.parseDouble(intervalo2.getText());
        System.out.println(divs(inter2));
        System.out.println(divs(inter));
        boolean endo = false;
        if(divs(inter) * divs(inter2) < 0 && !checkInt.isSelected()){
            System.out.println("Si es valido");
        }else{
            System.out.println("Se buscara un intervalo");
            boolean found = false;
            double c = Double.parseDouble(String.valueOf(tabla.getValueAt(0, 6)));
            if(c < 0){
                c = c * -1;
            }
            for (double i = 1; i <= c; i++) {
                if(c % i == 0 ){
                    Pd.add(i);
                    Pd2.add(i * -1 );
                }
            }
            Collections.reverse(Pd2);
            for (int i = 0; i < Pd.size(); i++) {
                Pd2.add(Pd.get(i));
            }
            System.out.println(Pd2);
            boolean end = false;
            for (int i = 1; i < Pd2.size() && end == false; i++) {
                double dato0 = divs(Pd2.get(i - 1));
                double dato1 = divs(Pd2.get(i));
                if(dato0 * dato1 > 0){
                    System.out.println("No es valido");
                }else if(dato0 * dato1 == 0){
                    System.out.println("Se encontro la raiz exacta");
                    end = true;
                    endo = true;
                }else if(dato0 * dato1 < 0){
                    System.out.println("Se encontro");
                    inter = Pd2.get(i - 1);
                    inter2 = Pd2.get(i);
                    end = true;
                }
                System.out.println("Intervalo 1 : "+Pd2.get(i - 1)+" : "+dato0 );
                System.out.println("Intervalo 2 : "+Pd2.get(i)+" : "+dato1 );
            }
        }
        double pm = (inter + inter2)/2;
        double R;
        double Ra;
        double res;
        System.out.println("PM "+pm);
        double resant = pm;
        double error;
        int i = 1;
        while(!endo){
            R = divs(resant);
            Ra = divsR(resant);
            res = resant - (R/Ra);
            error = getError(res, resant);
            System.out.println("------------------------------");
            System.out.println("Interaccion : "+i);
            System.out.println("R : "+R);
            System.out.println("R* : "+Ra);
            System.out.println("Resultado : "+res);
            System.out.println("Error : "+error);
            if(error < 0.0005){
                endo = true;
            }
            resant = res;
            i++;
        }
    }
    public void Metodo(){
        int inter = Integer.parseInt(intervalo1.getText());
        int iner2 = Integer.parseInt(intervalo2.getText());
        double error = 0;
        double errord = 0.005;
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
        xr = ((fx0 * iner2) - (fx1 * inter))/(fx0 - fx1);
        System.out.println("Primer valor");
        System.out.println(xr);
        int i = 0;
        while(fin == false){
            fx0 = ( Math.pow(xr, 6) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 0)))) )+ 
                (Math.pow(xr, 5) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 1)))) )+
                (Math.pow(xr, 4) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 2))))) +
                (Math.pow(xr, 3) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 3)))) )+
                (Math.pow(xr, 2) * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 4))))) +
                (xr * (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 5)))) )+
                (Integer.parseInt(String.valueOf(tabla.getValueAt(0, 6))));
            DecimalFormat errorp = new DecimalFormat("#.####");
            fx0 = Double.valueOf(errorp.format(fx0));
            System.out.println("Interaccion "+(i+2)+" - - - - - - - - ");
            xrn = iner2 - (((fx1 * xr) - (fx1 * iner2))/(fx0 - fx1));
            xrn = Double.valueOf(errorp.format(xrn));
            System.out.println("Xr"+(i+2));
            System.out.println(xrn);
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
        checkInt = new javax.swing.JCheckBox();

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

        checkInt.setText("Sacar intervalo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)
                        .addComponent(checkInt))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(checkInt))
                .addGap(134, 134, 134))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        metodo2();
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
    private javax.swing.JCheckBox checkInt;
    private javax.swing.JTextField intervalo1;
    private javax.swing.JTextField intervalo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
