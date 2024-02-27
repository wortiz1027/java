package co.com.sistema.sistemainformacion.view;

import co.com.sistema.sistemainformacion.domain.views.SecurityView;
import co.com.sistema.sistemainformacion.service.dao.SecurityServiceDao;
import co.com.sistema.sistemainformacion.service.impl.SecurityServiceDaoImpl;
import co.com.sistema.sistemainformacion.utils.Util;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;

public class FormLogin extends javax.swing.JInternalFrame {
    
    private static SecurityView security;
    
    private SecurityServiceDao securityServiceDao;
    
    public FormLogin(SecurityServiceDao securityServiceDao) {
        initComponents();
        this.securityServiceDao = securityServiceDao;
        security = new SecurityView();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedor = new javax.swing.JPanel();
        jlUsuario = new javax.swing.JLabel();
        jlPassword = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jpwContrasena = new javax.swing.JPasswordField();
        jbLimpiar = new javax.swing.JButton();
        jbAceptar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Login");
        setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jlUsuario.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jlUsuario.setText("Usuario:");

        jlPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jlPassword.setText("Contraseña:");

        jtUsuario.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jpwContrasena.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jbLimpiar.setMnemonic('L');
        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbAceptar.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jbAceptar.setMnemonic('A');
        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpContenedorLayout = new javax.swing.GroupLayout(jpContenedor);
        jpContenedor.setLayout(jpContenedorLayout);
        jpContenedorLayout.setHorizontalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContenedorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPassword)
                    .addComponent(jlUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContenedorLayout.createSequentialGroup()
                        .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpwContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jpContenedorLayout.setVerticalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContenedorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpwContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        jtUsuario.setText("");
        jpwContrasena.setText("");
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        
        String usuario = jtUsuario.getText();
        String contrasena = String.valueOf(jpwContrasena.getPassword());
        
        if (!usuario.equalsIgnoreCase("") && !contrasena.equalsIgnoreCase("")){
            security = securityServiceDao.validateUser(usuario, Util.Encriptar(contrasena));
            
            if (security != null){
                JOptionPane.showMessageDialog(this, String.format("Bievenido %s %s",security.getUsuario().getNombres(), security.getUsuario().getApellidos()), "Acceso", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, String.format("Error, usuario %s no registrado", usuario), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Error, Digite los datos de ingreso...","Error Datos de Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAceptarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPanel jpContenedor;
    private javax.swing.JPasswordField jpwContrasena;
    private javax.swing.JTextField jtUsuario;
    // End of variables declaration//GEN-END:variables
}
