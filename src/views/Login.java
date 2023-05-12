package views;

import controller.UsuarioController;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

public class Login extends javax.swing.JFrame {

    public static String user = "";
    private String password = "";
    private final UsuarioController userController;

    public Login() {
        initComponents();
        this.userController = new UsuarioController();

        setSize(910, 539);
        setResizable(false);
        setTitle("Acceso al Sistema");
        setLocationRelativeTo(null);

        ImageIcon log_hotel = new ImageIcon("src/images/hotel-login.png");
        Icon icon_logHotel = new ImageIcon(log_hotel.getImage().getScaledInstance(label_logHotel.getWidth(),
                label_logHotel.getHeight(), Image.SCALE_DEFAULT));
        label_logHotel.setIcon(icon_logHotel);
        this.repaint();

        ImageIcon background = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icon_background = new ImageIcon(background.getImage().getScaledInstance(label_background.getWidth(),
                label_background.getHeight(), Image.SCALE_DEFAULT));
        label_background.setIcon(icon_background);
        this.repaint();

        ImageIcon wallpaper = new ImageIcon("src/images/menu-img.png");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icon);
        this.repaint();
    }

    private List<Usuario> SearchUser() {
        return this.userController.SearchUserId(user, password);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/Icon-40px.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_logHotel = new javax.swing.JLabel();
        label_user = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        label_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        label_log = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();
        label_footer = new javax.swing.JLabel();
        label_background = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(label_logHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 240, 240));

        label_user.setText("Usuario:");
        getContentPane().add(label_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txt_user.setBackground(new java.awt.Color(204, 204, 255));
        txt_user.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt_user.setForeground(java.awt.SystemColor.activeCaption);
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(null);
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 240, 40));

        label_password.setText("Contraseña:");
        getContentPane().add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        txt_password.setBackground(new java.awt.Color(204, 204, 255));
        txt_password.setForeground(java.awt.SystemColor.activeCaption);
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(null);
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 240, 40));

        btn_login.setBackground(new java.awt.Color(204, 204, 255));
        btn_login.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btn_login.setForeground(java.awt.SystemColor.activeCaption);
        btn_login.setText("Acceder");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 100, 40));

        label_log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ha-100px.png"))); // NOI18N
        label_log.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 100, 100));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regresar.png"))); // NOI18N
        btn_exit.setBorder(null);
        btn_exit.setContentAreaFilled(false);
        btn_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 440, -1, -1));

        label_footer.setBackground(new java.awt.Color(102, 102, 102));
        label_footer.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        label_footer.setForeground(new java.awt.Color(102, 102, 102));
        label_footer.setText("Desarrollado por Marlon Torres © 2023");
        getContentPane().add(label_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 520, 242, -1));
        getContentPane().add(label_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 539));

        label_wallpaper.setBackground(new java.awt.Color(12, 138, 199));
        label_wallpaper.setForeground(new java.awt.Color(12, 138, 199));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 610, 539));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        user = txt_user.getText().trim();
        password = txt_password.getText().trim();

        if (!user.equals("") || !password.equals("")) {
            Search();
        } else {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos.");
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        if (evt.getSource() == btn_exit) {
            int i = JOptionPane.showConfirmDialog(this, "¿Desea regresar?");
            if (i == 0) {
                Principal principal = new Principal();
                principal.setVisible(true);
                dispose();
            } else if (i == 1) {
                JOptionPane.showMessageDialog(this, "Gracias. Continuemos con su Ingreso.");
            }
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    public static void main(String args[]) {
        try {
            java.awt.EventQueue.invokeLater(() -> {
                new Login().setVisible(true);
            });
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel label_footer;
    private javax.swing.JLabel label_log;
    private javax.swing.JLabel label_logHotel;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_user;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables

    private void Search() {
        List<Usuario> userName = SearchUser();
        try {
            for (Usuario usersName : userName) {
                String levelType = usersName.getLevelType();
                String status = usersName.getStatus();

                if (levelType.equalsIgnoreCase("Administrador") && status.equalsIgnoreCase("Activo")) {
                    dispose();
                    new Administrador().setVisible(true);
                } else if (levelType.equalsIgnoreCase("Capturista") && status.equalsIgnoreCase("Activo")) {
                    dispose();
                    new Capturista().setVisible(true);
                } else {
                }
            }
        } catch (HeadlessException e) {
            throw e;
        }
    }
}
