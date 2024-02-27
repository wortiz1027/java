package co.com.sistema.sistemainformacion.view;

import co.com.sistema.sistemainformacion.config.ApplicationContext;
import co.com.sistema.sistemainformacion.service.dao.SecurityServiceDao;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Aplicacion extends javax.swing.JFrame {
    
    FormLogin login;
    
    AbstractApplicationContext context;
    
    public Aplicacion() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Iniciando ApplicationContext Spring
        context = new AnnotationConfigApplicationContext(ApplicationContext.class);        
    }
    
    public void center(JInternalFrame frame){
        Dimension tamanoDesktop = jdpContenedor.getSize();
        Dimension tamanoFrame = frame.getSize();
        frame.setLocation((tamanoDesktop.width - tamanoFrame.width)/2, (tamanoDesktop.height- tamanoFrame.height)/2);
        frame.show();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jdpContenedor = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmInicio = new javax.swing.JMenu();
        jmLogin = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmSalir = new javax.swing.JMenuItem();
        jmSeguridad = new javax.swing.JMenu();
        jmiRegistroUsuarios = new javax.swing.JMenuItem();
        jmiConsultarUsuarios = new javax.swing.JMenuItem();
        jmRegistrosVotantes = new javax.swing.JMenu();
        jmiRegistroVotantes = new javax.swing.JMenuItem();
        jmiConsultarVotantes = new javax.swing.JMenuItem();
        jmReportes = new javax.swing.JMenu();
        jmiReportePlanillaControl = new javax.swing.JMenuItem();
        jmiGrupoRenovacion = new javax.swing.JMenuItem();
        jmiReporteVotantes = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();
        jmiAcercaDe = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpContenedor.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jdpContenedorLayout = new javax.swing.GroupLayout(jdpContenedor);
        jdpContenedor.setLayout(jdpContenedorLayout);
        jdpContenedorLayout.setHorizontalGroup(
            jdpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1219, Short.MAX_VALUE)
        );
        jdpContenedorLayout.setVerticalGroup(
            jdpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jmInicio.setMnemonic('I');
        jmInicio.setText("Inicio");
        jmInicio.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jmLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jmLogin.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmLogin.setMnemonic('n');
        jmLogin.setText("Ingresar");
        jmLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLoginActionPerformed(evt);
            }
        });
        jmInicio.add(jmLogin);
        jmInicio.add(jSeparator1);

        jmSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmSalir.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmSalir.setMnemonic('S');
        jmSalir.setText("Salir");
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        jmInicio.add(jmSalir);

        jMenuBar1.add(jmInicio);

        jmSeguridad.setText("Seguridad");
        jmSeguridad.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jmiRegistroUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmiRegistroUsuarios.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmiRegistroUsuarios.setText("Registro Usuarios");
        jmSeguridad.add(jmiRegistroUsuarios);

        jmiConsultarUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmiConsultarUsuarios.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmiConsultarUsuarios.setText("Consulta Usuarios");
        jmSeguridad.add(jmiConsultarUsuarios);

        jMenuBar1.add(jmSeguridad);

        jmRegistrosVotantes.setText("Registros");
        jmRegistrosVotantes.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jmiRegistroVotantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmiRegistroVotantes.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmiRegistroVotantes.setText("Registro Votantes");
        jmRegistrosVotantes.add(jmiRegistroVotantes);

        jmiConsultarVotantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmiConsultarVotantes.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmiConsultarVotantes.setText("Consultar Votantes");
        jmRegistrosVotantes.add(jmiConsultarVotantes);

        jMenuBar1.add(jmRegistrosVotantes);

        jmReportes.setText("Reportes");
        jmReportes.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jmiReportePlanillaControl.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmiReportePlanillaControl.setText("Planilla Control");
        jmReportes.add(jmiReportePlanillaControl);

        jmiGrupoRenovacion.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmiGrupoRenovacion.setText("Grupo Renovación");
        jmiGrupoRenovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGrupoRenovacionActionPerformed(evt);
            }
        });
        jmReportes.add(jmiGrupoRenovacion);

        jmiReporteVotantes.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmiReporteVotantes.setText("Reporte Votantes");
        jmReportes.add(jmiReporteVotantes);

        jMenuBar1.add(jmReportes);

        jmAyuda.setText("Ayuda");
        jmAyuda.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jmiAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jmiAcercaDe.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jmiAcercaDe.setText("Acerca de ...");
        jmiAcercaDe.setToolTipText("");
        jmAyuda.add(jmiAcercaDe);

        jMenuBar1.add(jmAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpContenedor)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdpContenedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLoginActionPerformed
        SecurityServiceDao securityServiceDao = (SecurityServiceDao) context.getBean("securityServiceDao");
        login = new FormLogin(securityServiceDao);
        jdpContenedor.add(login);
        center(login);
    }//GEN-LAST:event_jmLoginActionPerformed

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmSalirActionPerformed

    private void jmiGrupoRenovacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGrupoRenovacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiGrupoRenovacionActionPerformed

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JDesktopPane jdpContenedor;
    private javax.swing.JMenu jmAyuda;
    private javax.swing.JMenu jmInicio;
    private javax.swing.JMenuItem jmLogin;
    private javax.swing.JMenu jmRegistrosVotantes;
    private javax.swing.JMenu jmReportes;
    private javax.swing.JMenuItem jmSalir;
    private javax.swing.JMenu jmSeguridad;
    private javax.swing.JMenuItem jmiAcercaDe;
    private javax.swing.JMenuItem jmiConsultarUsuarios;
    private javax.swing.JMenuItem jmiConsultarVotantes;
    private javax.swing.JMenuItem jmiGrupoRenovacion;
    private javax.swing.JMenuItem jmiRegistroUsuarios;
    private javax.swing.JMenuItem jmiRegistroVotantes;
    private javax.swing.JMenuItem jmiReportePlanillaControl;
    private javax.swing.JMenuItem jmiReporteVotantes;
    // End of variables declaration//GEN-END:variables
}
