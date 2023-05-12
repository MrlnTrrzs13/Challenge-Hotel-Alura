package views;

import controller.UsuarioController;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import model.Usuario;

public class Capturista extends javax.swing.JFrame {

    String user;
    int session_user;
    private final UsuarioController userController;
    public static int userSession;
    
    public Capturista() {
        initComponents();
        user = Login.user;
        session_user = Administrador.session_user;
        this.userController = new UsuarioController();
        userSession = 1;
        setSize(700, 550);
        setResizable(false);
        setTitle("Capturista - Sesión de " + user);
        setLocationRelativeTo(null);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icon);
        this.repaint();

        ImageIcon log = new ImageIcon("src/images/recepcion.png");
        Icon icon_log = new ImageIcon(log.getImage().getScaledInstance(label_log.getWidth(),
                label_log.getHeight(), Image.SCALE_DEFAULT));
        label_log.setIcon(icon_log);
        this.repaint();

        if (session_user == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        NameUsers();
    }
    
    private List<Usuario> NameUser() {
        return this.userController.SearchNameAdmin(user);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/Icon-40px.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_background = new javax.swing.JLabel();
        label_log = new javax.swing.JLabel();
        label_userName = new javax.swing.JLabel();
        btn_register = new javax.swing.JButton();
        label_register = new javax.swing.JLabel();
        btn_reservation = new javax.swing.JButton();
        label_register1 = new javax.swing.JLabel();
        btn_manage = new javax.swing.JButton();
        label_manage = new javax.swing.JLabel();
        btn_information = new javax.swing.JButton();
        label_information = new javax.swing.JLabel();
        label_footer = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ha-100px.png"))); // NOI18N
        getContentPane().add(label_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 100, 100));

        label_log.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 400, 320));

        label_userName.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        label_userName.setForeground(new java.awt.Color(255, 255, 255));
        label_userName.setText("User");
        getContentPane().add(label_userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btn_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 120, 100));

        label_register.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        label_register.setForeground(new java.awt.Color(255, 255, 255));
        label_register.setText("Reservación");
        getContentPane().add(label_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        btn_reservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reservation.png"))); // NOI18N
        btn_reservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reservationActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 120, 100));

        label_register1.setBackground(new java.awt.Color(255, 255, 255));
        label_register1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        label_register1.setForeground(new java.awt.Color(255, 255, 255));
        label_register1.setText("Registrar Huésped");
        getContentPane().add(label_register1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, -1, -1));

        btn_manage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        btn_manage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageActionPerformed(evt);
            }
        });
        getContentPane().add(btn_manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 120, 100));

        label_manage.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        label_manage.setForeground(new java.awt.Color(255, 255, 255));
        label_manage.setText("Gestionar Huésped");
        getContentPane().add(label_manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        btn_information.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informacion.png"))); // NOI18N
        btn_information.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_information.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_informationActionPerformed(evt);
            }
        });
        getContentPane().add(btn_information, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 120, 100));

        label_information.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        label_information.setForeground(new java.awt.Color(255, 255, 255));
        label_information.setText("Información");
        getContentPane().add(label_information, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, -1, -1));

        label_footer.setBackground(new java.awt.Color(102, 102, 102));
        label_footer.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        label_footer.setForeground(new java.awt.Color(102, 102, 102));
        label_footer.setText("Desarrollado por Marlon Torres © 2023");
        getContentPane().add(label_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 520, 242, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_informationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_informationActionPerformed
        Informacion information = new Informacion();
        information.setVisible(true);
    }//GEN-LAST:event_btn_informationActionPerformed

    private void btn_manageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageActionPerformed
        GestionarHuesped gestionsGuests = new GestionarHuesped();
            gestionsGuests.setVisible(true);
    }//GEN-LAST:event_btn_manageActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        RegistroHuesped guest = new RegistroHuesped(0);
        guest.setVisible(true);
    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_reservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reservationActionPerformed
        RegistroReservas reservation = new RegistroReservas();
        reservation.setVisible(true);
    }//GEN-LAST:event_btn_reservationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            java.awt.EventQueue.invokeLater(() -> {
                new Capturista().setVisible(true);
            });
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_information;
    private javax.swing.JButton btn_manage;
    private javax.swing.JButton btn_register;
    private javax.swing.JButton btn_reservation;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel label_footer;
    private javax.swing.JLabel label_information;
    private javax.swing.JLabel label_log;
    private javax.swing.JLabel label_manage;
    private javax.swing.JLabel label_register;
    private javax.swing.JLabel label_register1;
    private javax.swing.JLabel label_userName;
    private javax.swing.JLabel label_wallpaper;
    // End of variables declaration//GEN-END:variables

    private void NameUsers() {
        List <Usuario> users = NameUser();
        try {
            for(Usuario user_Name : users) {
                String user_name = user_Name.getName();
                label_userName.setText("Bienvenido " + user_name);
            }
        } catch (Exception e) {
        }
    }
}
