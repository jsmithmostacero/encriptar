
package presentacion;

import datos.Encriptar;
import javax.swing.JOptionPane;


public class Formulario extends javax.swing.JFrame {
    Encriptar c = null;
    public Formulario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTexto = new javax.swing.JPasswordField();
        txtDesencriptar = new javax.swing.JTextField();
        txtEncriptado = new javax.swing.JTextField();
        btnDesin = new javax.swing.JLabel();
        btnEncrip = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEncriptado1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTexto.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        txtTexto.setBorder(null);
        txtTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTextoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 200, 30));

        txtDesencriptar.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtDesencriptar.setBorder(null);
        getContentPane().add(txtDesencriptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 210, 30));

        txtEncriptado.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtEncriptado.setBorder(null);
        txtEncriptado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEncriptadoMouseClicked(evt);
            }
        });
        getContentPane().add(txtEncriptado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 210, 30));

        btnDesin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDesinMouseClicked(evt);
            }
        });
        getContentPane().add(btnDesin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 200, 30));

        btnEncrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEncripMouseClicked(evt);
            }
        });
        getContentPane().add(btnEncrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 200, 30));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 40, 40));

        txtEncriptado1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtEncriptado1.setBorder(null);
        txtEncriptado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEncriptado1MouseClicked(evt);
            }
        });
        getContentPane().add(txtEncriptado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 210, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fonfo.png"))); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTextoActionPerformed

    private void btnEncripMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncripMouseClicked

            if(txtTexto.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Ingrese texto","Error",2);
            }else{
                c = new Encriptar(txtTexto.getText(),txtEncriptado1.getText());
            txtEncriptado.setText(c.getCifrado());
            }

    }//GEN-LAST:event_btnEncripMouseClicked

    private void btnDesinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesinMouseClicked
        try{
            txtDesencriptar.setText(c.getDescifrado(JOptionPane.showInputDialog(null,"Ingrese clave")));
         
        }catch( Exception ex){
            JOptionPane.showMessageDialog(null,"Ingrese texto","Error",2);
        }
        
    }//GEN-LAST:event_btnDesinMouseClicked

    private void txtEncriptadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEncriptadoMouseClicked
       
    }//GEN-LAST:event_txtEncriptadoMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try{
            JOptionPane.showMessageDialog(null,c.getCifrado(),"Mensaje cifrado",1);
        }catch( Exception ex){
            JOptionPane.showMessageDialog(null,"No hay texto cifrado","Error",2);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtEncriptado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEncriptado1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEncriptado1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDesin;
    private javax.swing.JLabel btnEncrip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtDesencriptar;
    private javax.swing.JTextField txtEncriptado;
    private javax.swing.JTextField txtEncriptado1;
    private javax.swing.JPasswordField txtTexto;
    // End of variables declaration//GEN-END:variables
}
