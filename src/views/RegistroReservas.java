package views;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import controller.HuespedController;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import controller.ReservaController;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import model.Reserva;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTextField;
import static javax.swing.border.BevelBorder.RAISED;
import javax.swing.border.SoftBevelBorder;
import model.Huesped;

public class RegistroReservas extends javax.swing.JFrame {

    public static JDateChooser txt_checkin, txt_checkout;
    public static int id_registroUp;
    private final ReservaController reservationController;
    private final HuespedController guestController;
    int session_user = 0, userSession = 0, id_huesped = 0, id, IdOfReservation, Id_huesped = 0;;
    private String name_guest, last_name;

    public RegistroReservas() {
        this.reservationController = new ReservaController();
        this.guestController = new HuespedController();
        userSession = Capturista.userSession;
        session_user = Administrador.session_user;
        id_huesped = InformacionHuesped.id;
        initComponents();

        setSize(600, 670);
        setResizable(false);
        setTitle("Registro de Huéspedes");
        setLocationRelativeTo(null);

        ImageIcon background = new ImageIcon("src/images/reservas-img-3.png");
        Icon icon_background = new ImageIcon(background.getImage().getScaledInstance(
                label_background.getWidth(), label_background.getHeight(), Image.SCALE_DEFAULT));
        label_background.setIcon(icon_background);
        this.repaint();

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icon);
        this.repaint();

        if (session_user == 1 || userSession == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        txt_checkin = new JDateChooser();
        txt_checkin.setBackground(new java.awt.Color(204, 204, 255));
        txt_checkin.setForeground(java.awt.SystemColor.activeCaption);
        txt_checkin.getCalendarButton().setIcon(new ImageIcon(
                RegistroHuesped.class.getResource("/images/icon-reservas.png")));
        txt_checkin.getCalendarButton().setBackground(SystemColor.textHighlight);
        txt_checkin.getCalendarButton().setFont(new java.awt.Font("Roboto", 1, 12));
        txt_checkin.getCalendarButton().setBounds(250, 0, 21, 28);
        txt_checkin.setBorder(new SoftBevelBorder(RAISED));
        txt_checkin.setDateFormatString("yyyy-MM-dd");
        txt_checkin.setFont(new java.awt.Font("Roboto", 1, 18));
        getContentPane().add(txt_checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(
                30, 330, 250, 30));

        txt_checkout = new JDateChooser();
        txt_checkout.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            calculateValue(txt_checkin, txt_checkout);
        });
        txt_checkout.setBackground(new java.awt.Color(204, 204, 255));
        txt_checkout.setForeground(java.awt.SystemColor.activeCaption);
        txt_checkout.getCalendarButton().setIcon(new ImageIcon(
                RegistroHuesped.class.getResource("/images/icon-reservas.png")));
        txt_checkout.getCalendarButton().setBackground(SystemColor.textHighlight);
        txt_checkout.getCalendarButton().setFont(new java.awt.Font("Roboto", 1, 12));
        txt_checkout.getCalendarButton().setBounds(250, 0, 21, 28);
        txt_checkout.setBorder(new SoftBevelBorder(RAISED));
        txt_checkout.setDateFormatString("yyyy-MM-dd");
        txt_checkout.setFont(new java.awt.Font("Roboto", 1, 18));
        getContentPane().add(txt_checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(
                30, 390, 250, 30));

        Guest();
        txt_idGuest.setText(name_guest + " " + last_name);
    }

    private List<Huesped> SearchGuests() {
        return this.guestController.SearchId(id_huesped);
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

        label_log = new javax.swing.JLabel();
        label_title = new javax.swing.JLabel();
        txt_idGuest = new javax.swing.JTextField();
        label_idGuest = new javax.swing.JLabel();
        label_checkin = new javax.swing.JLabel();
        label_checkout = new javax.swing.JLabel();
        label_payreservation = new javax.swing.JLabel();
        txt_payreservation = new javax.swing.JTextField();
        label_payment = new javax.swing.JLabel();
        jcb_payment = new javax.swing.JComboBox<>();
        label_register = new javax.swing.JLabel();
        btn_register = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        label_footer = new javax.swing.JLabel();
        label_background = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ha-100px.png"))); // NOI18N
        getContentPane().add(label_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 100, 100));

        label_title.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        label_title.setForeground(new java.awt.Color(255, 255, 255));
        label_title.setText("Sistema de Reservas");
        getContentPane().add(label_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 130, 228, -1));

        txt_idGuest.setEditable(false);
        txt_idGuest.setBackground(new java.awt.Color(204, 204, 255));
        txt_idGuest.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_idGuest.setForeground(java.awt.SystemColor.activeCaption);
        txt_idGuest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_idGuest, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, -1));

        label_idGuest.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_idGuest.setForeground(java.awt.SystemColor.activeCaptionText);
        label_idGuest.setText("Huesped");
        getContentPane().add(label_idGuest, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        label_checkin.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_checkin.setForeground(java.awt.SystemColor.activeCaptionText);
        label_checkin.setText("Fecha de Entrada:");
        getContentPane().add(label_checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        label_checkout.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_checkout.setForeground(java.awt.SystemColor.activeCaptionText);
        label_checkout.setText("Fecha de Salida:");
        getContentPane().add(label_checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        label_payreservation.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_payreservation.setForeground(java.awt.SystemColor.activeCaptionText);
        label_payreservation.setText("Precio por Reservacion:");
        getContentPane().add(label_payreservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        txt_payreservation.setEditable(false);
        txt_payreservation.setBackground(new java.awt.Color(204, 204, 255));
        txt_payreservation.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_payreservation.setForeground(java.awt.SystemColor.activeCaption);
        txt_payreservation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_payreservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 250, -1));

        label_payment.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_payment.setForeground(java.awt.SystemColor.activeCaptionText);
        label_payment.setText("Método de Pago:");
        getContentPane().add(label_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        jcb_payment.setBackground(new java.awt.Color(204, 204, 255));
        jcb_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta de Credito", "Tarjeta de Debiito", "Dinero en Efectivo" }));
        getContentPane().add(jcb_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 250, -1));

        label_register.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_register.setForeground(java.awt.SystemColor.activeCaptionText);
        label_register.setText("Registrar");
        getContentPane().add(label_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 540, -1, -1));

        btn_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_register.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 120, 100));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar-usuario.png"))); // NOI18N
        btn_add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 120, 100));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.activeCaptionText);
        jLabel1.setText("Agregar a Huesped");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));

        label_footer.setBackground(new java.awt.Color(102, 102, 102));
        label_footer.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        label_footer.setForeground(new java.awt.Color(102, 102, 102));
        label_footer.setText("Desarrollado por Marlon Torres © 2023");
        getContentPane().add(label_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 640, 242, -1));

        label_background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_background.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 381, 419));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        btn_register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ((txt_checkin.getDate() != null && txt_checkout.getDate() != null)) {
                    Save();
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                }
            }
        });
    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        btn_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ((txt_checkin.getDate() != null && txt_checkout.getDate() != null)) {
                    SaveToGuest();

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                }
            }
        });
    }//GEN-LAST:event_btn_addActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            java.awt.EventQueue.invokeLater(() -> {
                new RegistroReservas().setVisible(true);
            });
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JComboBox<String> jcb_payment;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel label_checkin;
    private javax.swing.JLabel label_checkout;
    private javax.swing.JLabel label_footer;
    private javax.swing.JLabel label_idGuest;
    private javax.swing.JLabel label_log;
    private javax.swing.JLabel label_payment;
    private javax.swing.JLabel label_payreservation;
    private javax.swing.JLabel label_register;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_wallpaper;
    public static javax.swing.JTextField txt_idGuest;
    public static javax.swing.JTextField txt_payreservation;
    // End of variables declaration//GEN-END:variables

    private void Save() {
        try {
            String checkIn = ((JTextField) txt_checkin.getDateEditor().getUiComponent()).getText();
            String checkOut = ((JTextField) txt_checkout.getDateEditor().getUiComponent()).getText();
                        
            Reserva newReservation = new Reserva(java.sql.Date.valueOf(checkIn),
                    java.sql.Date.valueOf(checkOut), txt_payreservation.getText(),
                    jcb_payment.getSelectedItem().toString(), Id_huesped);
            reservationController.Save(newReservation);

            JOptionPane.showMessageDialog(null, "Registro Guardado con éxito " + newReservation.getId());

            RegistroHuesped guests = new RegistroHuesped(newReservation.getId());
            guests.setVisible(true);
            dispose();
        } catch (HeadlessException e) {
            throw e;
        }
    }

    private void SaveToGuest() {
        try {
            String checkIn = ((JTextField) txt_checkin.getDateEditor().getUiComponent()).getText();
            String checkOut = ((JTextField) txt_checkout.getDateEditor().getUiComponent()).getText();
            
            Reserva newReservation = new Reserva(java.sql.Date.valueOf(checkIn),
                    java.sql.Date.valueOf(checkOut), txt_payreservation.getText(),
                    jcb_payment.getSelectedItem().toString(), id);
            reservationController.Save(newReservation);
            
            JOptionPane.showMessageDialog(null, "Registro Guardado con éxito " + newReservation.getId());
            
            IdOfReservation = newReservation.getId();
            
            try {
                if(IdOfReservation != 0){
                    guestController.UpdateReservation(IdOfReservation, id);
                    JOptionPane.showMessageDialog(null, "Huesped " + name_guest + " " + last_name);
                } else{
                }
            } catch (HeadlessException evt) {
                System.err.println("ERROR al registrar." + evt);
            }
        } catch (HeadlessException e) {
            throw e;
        }
    }

    private void Guest() {
        List<Huesped> guests = SearchGuests();
        try {
            for (Huesped guest : guests) {
                name_guest = guest.getName();
                last_name = guest.getLastName();
                id = guest.getId();
            }
        } catch (Exception e) {
        }
    }

    private void calculateValue(JDateChooser checkIn, JDateChooser checkOut) {
        if (checkIn.getDate() != null && checkOut.getDate() != null) {
            Calendar inicio = checkIn.getCalendar();
            Calendar fin = checkOut.getCalendar();
            int dias = -1; // Usamos -1 para contar a partir del dia siguiente
            int diaria = 500;
            int valor;

            while (inicio.before(fin) || inicio.equals(fin)) {
                dias++;
                inicio.add(Calendar.DATE, 1); //dias a ser aumentados
            }
            valor = dias * diaria;
            txt_payreservation.setText("$" + valor);
        }
    }
}
