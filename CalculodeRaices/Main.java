/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculodeRaices;

import javax.script.ScriptEngine;
import static java.lang.Math.abs;
import java.text.DecimalFormat;
import javax.script.ScriptEngineManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Hope
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }
    public void Metodo1(){
        int valoractual = 0;
        double resultado = 0;
        double resultadoant = 0;
        boolean test = false;
        boolean dos2 = false;
        byte dos = 0;
        double error = 0;
        double errordeseado = Double.parseDouble(txtError.getText());
        boolean fin = false;
        try{
            valoractual = Integer.parseInt(txtCampo.getText());
            resultado = valoractual;
            if(valoractual > 0){
                test = true;
            }else{
                JOptionPane.showMessageDialog(this, "Introcuce un valor positivo");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Introcuce un valor entero");
        }
        /*if(test == false){
            resultado = ((resultado + (valoractual/resultado)) * 1/2);
            resultadoant = resultado;
            System.out.println(resultado);
            resultado = ((resultado + (valoractual/resultado)) * 1/2);
            DecimalFormat df = new DecimalFormat("#.####");
            resultado = Double.valueOf(df.format(resultado));
            System.out.println(resultado);
            error = abs((resultado - resultadoant)/resultado) * 100;
            DecimalFormat errorp = new DecimalFormat("#.###");
            error = Double.valueOf(errorp.format(error));
            System.out.println(error);
        }*/
        if(test == true){
            int i = 0;
            while(fin == false || i == 200){
                System.out.println("-");
                System.out.println("Interaccion "+i);
                resultado = ((resultado + (valoractual/resultado)) * 1/2);
                DecimalFormat df = new DecimalFormat(txtDecimales.getText());
                resultado = Double.valueOf(df.format(resultado));  
                System.out.println("Resultado : "+resultado);
                if(dos2 = true){
                    error = abs((resultado - resultadoant)/resultado) * 100;
                    DecimalFormat errorp = new DecimalFormat("#.###");
                    error = Double.valueOf(errorp.format(error));
                    System.out.println("Error "+error);
                    if(error <= errordeseado){
                        fin = true;
                    }
                }else{
                    dos2 = true;
                }
                resultadoant = resultado;
                i++;
            }
            if(i == 200){
                System.out.println("Se llego al limite de interacciones");
            }
            txtResultado.setText(String.valueOf(resultado));
        }
    }
    
    public void Metodo2(){
        int valori = 0;
        int decimales = Integer.parseInt(txtDecimales.getText());
        boolean comp = false;
        try{
            valori = Integer.parseInt(txtCampo.getText());
            if(valori > 0 && decimales <= 11){
                comp = true;
                
            }else if (valori < 0){
                JOptionPane.showMessageDialog(this, "Introcuce un valor positivo");
            }
            else{
                JOptionPane.showMessageDialog(this, "Introcuce menos decimales");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Introcuce un valor entero");
        }
        if(comp == true){
            String deci = "#.";
            for (int i = 0; i < decimales; i++) {
                deci = deci.concat("#");
            } 
            txtDecimales.setText(deci);
        }
        double valormenor = 0;
        double valormayor = 0;
        boolean temp = false;
        for (int i = 0; temp == false; i++) {
            if(Math.pow(i, 2) > valori){
                temp = true;
                //System.out.println(i);
                valormenor = i -1;
                valormayor = i;
            }
        }
        temp = false;
        boolean temp2 = false;
        boolean test = false;
        double puntom = 0;
        double puntoant = 0;
        double error = 0;
        double errordeseado = Double.parseDouble(txtError.getText());
        int k = 1;
        while(temp == false && comp == true){
            System.out.println("Interaccion "+k);
            System.out.println(valormenor+" + "+valormayor+"/2 = ");
            puntom = (valormenor + valormayor)/2;
            DecimalFormat df = new DecimalFormat(txtDecimales.getText());
            puntom = Double.valueOf(df.format(puntom));  
            System.out.println(puntom);
            test = false;
            if(Math.pow(valormenor, 2) < valori && Math.pow(puntom, 2) < valori){
                valormenor = puntom;
                //System.out.println(valormayor);
            }else{
                valormayor = puntom;
                //System.out.println(valormenor);
            }
            if(temp2 == true){
                error = abs((puntom - puntoant)/puntom) * 100;
                    DecimalFormat errorp = new DecimalFormat("#.##");
                    error = Double.valueOf(errorp.format(error));
                    System.out.println("Error "+error+"%");
                    if(error <= errordeseado){
                        temp = true;
                    }
            }else{
                temp2 = true;
            }
            puntoant = puntom;
            k++;
        }
    }
    
    public void Metodo3(){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine interprete = manager.getEngineByName("js");
        try{
            String formula ="X^3-X-1";
            interprete.put("X",-1);
            System.out.println(interprete.eval(formula));
        }catch(Exception ex){
            System.out.println("kaka");
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

        txtCampo = new javax.swing.JTextField();
        btnPrincipal = new javax.swing.JToggleButton();
        txtResultado = new javax.swing.JLabel();
        txtDecimales = new javax.swing.JTextField();
        txtError = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCampo.setText("Introduce un numero INT");

        btnPrincipal.setText("Calcular");
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });

        txtDecimales.setText("#.###");

        txtError.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtError)
                            .addComponent(txtDecimales)
                            .addComponent(btnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(txtResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDecimales, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        Metodo2();
    }//GEN-LAST:event_btnPrincipalActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnPrincipal;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JTextField txtDecimales;
    private javax.swing.JTextField txtError;
    private javax.swing.JLabel txtResultado;
    // End of variables declaration//GEN-END:variables
}
