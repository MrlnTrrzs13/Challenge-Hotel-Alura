package views;

import controller.UsuarioController;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author mrln
 */
public class RestaurarPassword extends javax.swing.JFrame {

    private final int id_UserUp;
    private final UsuarioController userController;

    /**
     * Creates new form RestaurarPassword
     */
    public RestaurarPassword() {
        initComponents();
        
        this.id_UserUp = GestionarUsuarios.id_UserUp;
        this.userController = new UsuarioController();

        setSize(360, 260);
        setResizable(false);
        setTitle("Cambio de usuario para " + id_UserUp);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icon);
        this.repaint();
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

        label_titleInfo = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        label_confirmPassword = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        txt_confirmPassword = new javax.swing.JPasswordField();
        btn_password = new javax.swing.JButton();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titleInfo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        label_titleInfo.setForeground(new java.awt.Color(255, 255, 255));
        label_titleInfo.setText("Cambio de Password");
        getContentPane().add(label_titleInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 10, 230, -1));

        label_password.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_password.setForeground(new java.awt.Color(255, 255, 255));
        label_password.setText("Nuevo Password:");
        getContentPane().add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 55, 127, -1));

        label_confirmPassword.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_confirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        label_confirmPassword.setText("Confirmar Password:");
        getContentPane().add(label_confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 120, 153, -1));

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 75, 210, -1));

        txt_confirmPassword.setBackground(new java.awt.Color(153, 153, 255));
        txt_confirmPassword.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_confirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        txt_confirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_confirmPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 140, 210, -1));

        btn_password.setBackground(new java.awt.Color(153, 153, 255));
        btn_password.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btn_password.setForeground(new java.awt.Color(255, 255, 255));
        btn_password.setText("Restaurar Password");
        btn_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(btn_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 195, 210, 40));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_passwordActionPerformed
        btn_password.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UpdatePassword();
            }
        });
    }//GEN-LAST:event_btn_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            java.awt.EventQueue.invokeLater(() -> {
                new RestaurarPassword().setVisible(true);
            });
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_password;
    private javax.swing.JLabel label_confirmPassword;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_titleInfo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JPasswordField txt_confirmPassword;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables

    private void UpdatePassword() throws HeadlessException {
        String password, confirmpassword;
        
        password = txt_password.getText().trim();
        confirmpassword = txt_confirmPassword.getText().trim();
        
        if (!password.equals("") && !confirmpassword.equals("")) {
            if (password.equals(confirmpassword)) {
                try {
                    this.userController.UpdatePassword(password, id_UserUp);
                    
                    txt_password.setBackground(Color.green);
                    txt_confirmPassword.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Restauracion Exitosa.");
                    this.dispose();
                    
                } catch (HeadlessException e) {
                    System.err.println("ERROR en restaurar password " + e);
                }
            } else {
                txt_confirmPassword.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            }
            
        } else {
            txt_password.setBackground(Color.red);
            txt_confirmPassword.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "No se admiten contraseñas vacias.");
        }
    }
}
