package views;

import com.toedter.calendar.JDateChooser;
import controller.ReservaController;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static javax.swing.border.BevelBorder.RAISED;
import javax.swing.border.SoftBevelBorder;
import model.Reserva;
import model.Huesped;
import java.sql.Date;
import controller.HuespedController;

public class InformacionReserva extends javax.swing.JFrame {

    String user;
    private int Update = 0, session_user = 0, userSession = 0, idHuesped;
    private static int id;
    private String name, lastname, price, paymentMethod;
    private Date entryDate,deparureDate;
    private final ReservaController reservationController;
    private final HuespedController guestController;
    public static JDateChooser txt_checkin, txt_checkout;
    
    /**
     * Creates new form InformacionEquipo
     */
    public InformacionReserva() {
        this.reservationController = new ReservaController();
        this.guestController = new HuespedController();
        Update = GestionarReservas.id_reservaUp;
        Update = InformacionHuesped.IdReservation;
        session_user = Administrador.session_user;
        userSession = Capturista.userSession;
        initComponents();
        user = Login.user;
        
        setTitle("Reservas de " + name + " " + lastname);
        setSize(670, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icon);
        this.repaint();
        
        ImageIcon background = new ImageIcon("src/images/actualizacion.png");
        Icon icon_background = new ImageIcon(background.getImage().getScaledInstance(label_background.getWidth(),
                label_background.getHeight(), Image.SCALE_DEFAULT));
        label_background.setIcon(icon_background);
        this.repaint();
        
        if (session_user == 1 || userSession == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        txt_checkin = new JDateChooser();
        txt_checkin.setBackground(Color.WHITE);
        txt_checkin.getCalendarButton().setIcon(new ImageIcon(RegistroHuesped.class.getResource("/images/icon-reservas.png")));
        txt_checkin.getCalendarButton().setBackground(SystemColor.textHighlight);
        txt_checkin.getCalendarButton().setFont(new java.awt.Font("Roboto", 1, 12));
        txt_checkin.getCalendarButton().setBounds(250, 0, 21, 28);
        txt_checkin.setBorder(new SoftBevelBorder(RAISED));
        txt_checkin.setDateFormatString("yyyy-MM-dd");
        txt_checkin.setFont(new java.awt.Font("Roboto", 1, 18));
        getContentPane().add(txt_checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 210, 30));

        txt_checkout = new JDateChooser();
        txt_checkout.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            calculateValue(txt_checkin, txt_checkout);
        });
        txt_checkout.setBackground(Color.WHITE);
        txt_checkout.getCalendarButton().setIcon(new ImageIcon(RegistroHuesped.class.getResource("/images/icon-reservas.png")));
        txt_checkout.getCalendarButton().setBackground(SystemColor.textHighlight);
        txt_checkout.getCalendarButton().setFont(new java.awt.Font("Roboto", 1, 12));
        txt_checkout.getCalendarButton().setBounds(250, 0, 21, 28);
        txt_checkout.setBorder(new SoftBevelBorder(RAISED));
        txt_checkout.setDateFormatString("yyyy-MM-dd");
        txt_checkout.setFont(new java.awt.Font("Roboto", 1, 18));
        getContentPane().add(txt_checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 210, 30));
                
        ToListFormulary();
        
        
    }

    private List<Reserva> SearchReservation() {
        return this.reservationController.SearchId(Update);
    }
    
    private List<Huesped> SearchGuests() {
        return this.guestController.SearchIdReservation(Update);
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

        label_title = new javax.swing.JLabel();
        label_log = new javax.swing.JLabel();
        label_name = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        label_entryDate = new javax.swing.JLabel();
        label_departureDate = new javax.swing.JLabel();
        label_payment = new javax.swing.JLabel();
        txt_payment = new javax.swing.JTextField();
        label_paymentMethod = new javax.swing.JLabel();
        jcb_paymentMethod = new javax.swing.JComboBox<>();
        label_nNumber = new javax.swing.JLabel();
        txt_nNumber = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        label_background = new javax.swing.JLabel();
        label_footer = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_title.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        label_title.setForeground(new java.awt.Color(255, 255, 255));
        label_title.setText("Información de Reservas");
        getContentPane().add(label_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 275, -1));

        label_log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ha-100px.png"))); // NOI18N
        getContentPane().add(label_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 100, 100));

        label_name.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_name.setForeground(new java.awt.Color(255, 255, 255));
        label_name.setText("Nombre del Huésped:");
        getContentPane().add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txt_name.setEditable(false);
        txt_name.setBackground(new java.awt.Color(204, 204, 255));
        txt_name.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_name.setEnabled(false);
        getContentPane().add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, -1));

        label_entryDate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_entryDate.setForeground(new java.awt.Color(255, 255, 255));
        label_entryDate.setText("Fecha de Entrada:");
        getContentPane().add(label_entryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        label_departureDate.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_departureDate.setForeground(new java.awt.Color(255, 255, 255));
        label_departureDate.setText("Fecha de Salida:");
        getContentPane().add(label_departureDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        label_payment.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_payment.setForeground(new java.awt.Color(255, 255, 255));
        label_payment.setText("Precio a Pagar:");
        getContentPane().add(label_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        txt_payment.setEditable(false);
        txt_payment.setBackground(new java.awt.Color(204, 204, 255));
        txt_payment.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txt_payment.setForeground(new java.awt.Color(255, 255, 255));
        txt_payment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_payment.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_payment.setEnabled(false);
        getContentPane().add(txt_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 210, -1));

        label_paymentMethod.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_paymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        label_paymentMethod.setText("Forma de Pago:");
        getContentPane().add(label_paymentMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jcb_paymentMethod.setBackground(new java.awt.Color(204, 204, 255));
        jcb_paymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta de Credito", "Tarjeta de Debiito", "Dinero en Efectivo" }));
        getContentPane().add(jcb_paymentMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 210, -1));

        label_nNumber.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label_nNumber.setForeground(new java.awt.Color(255, 255, 255));
        label_nNumber.setText("Numero de Reserva:");
        getContentPane().add(label_nNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        txt_nNumber.setEditable(false);
        txt_nNumber.setBackground(new java.awt.Color(204, 204, 255));
        txt_nNumber.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txt_nNumber.setForeground(new java.awt.Color(255, 255, 255));
        txt_nNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nNumber.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nNumber.setEnabled(false);
        getContentPane().add(txt_nNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 210, -1));

        btn_update.setBackground(new java.awt.Color(153, 153, 255));
        btn_update.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Actualizar Reserva");
        btn_update.setBorder(null);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 210, 35));

        btn_delete.setBackground(new java.awt.Color(153, 153, 255));
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Eliminar");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));
        getContentPane().add(label_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 320, 300));

        label_footer.setBackground(new java.awt.Color(102, 102, 102));
        label_footer.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        label_footer.setForeground(new java.awt.Color(102, 102, 102));
        label_footer.setText("Desarrollado por Marlon Torres © 2023");
        getContentPane().add(label_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 520, 242, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        btn_update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ((txt_checkin.getDate() != null && txt_checkout.getDate() != null)) {
                    UpdateReservation();
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                }
            }
        });
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        btn_delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                reservationController.Delete(id);
                JOptionPane.showMessageDialog(null, "Eliminación Exitosa.");
                System.exit(0);
            }
        });
    }//GEN-LAST:event_btn_deleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            java.awt.EventQueue.invokeLater(() -> {
                new InformacionReserva().setVisible(true);
            });
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    public static javax.swing.JComboBox<String> jcb_paymentMethod;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel label_departureDate;
    private javax.swing.JLabel label_entryDate;
    private javax.swing.JLabel label_footer;
    private javax.swing.JLabel label_log;
    private javax.swing.JLabel label_nNumber;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_payment;
    private javax.swing.JLabel label_paymentMethod;
    private javax.swing.JLabel label_title;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField txt_nNumber;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_payment;
    // End of variables declaration//GEN-END:variables

    private void UpdateReservation() {
        
        Date checkIn = (Date) txt_checkin.getDate();
        Date checkOut =(Date) txt_checkout.getDate();
        String payment = txt_payment.getText().trim();
        String payment_method = (String) jcb_paymentMethod.getSelectedItem().toString();
        int Id = Integer.getInteger(txt_nNumber.getText());
        
        this.reservationController.Update(checkIn, checkOut, payment, payment_method, Id);
        
        txt_name.setBackground(Color.green);
        txt_nNumber.setBackground(Color.green);
        txt_checkin.setBackground(Color.green);
        txt_checkout.setBackground(Color.green);
        txt_payment.setText(user);

        JOptionPane.showMessageDialog(null, "Actualización exitosa ");
    }
    
    private void ToListFormulary() {
        List<Reserva> reservation = SearchReservation();
	try {
            for (Reserva reservations : reservation) {
                
                id = reservations.getId();
                entryDate = reservations.getEntryDate();
                deparureDate = reservations.getDepartureDate();
                price = reservations.getPrice();
                paymentMethod = reservations.getmethodPayment();
                idHuesped = reservations.getId_huesped();
            }
	} catch (Exception e) {
            throw e;
	}
        List <Huesped> guests = SearchGuests();
        try {
            for (Huesped guest : guests) {
                name = guest.getName();
                lastname = guest.getLastName();
            }
        } catch (Exception e) {
            throw e;
        }
        
        txt_name.setText(name + " " + lastname);
        txt_checkin.setDate(entryDate);
        txt_checkout.setDate(deparureDate);
        txt_payment.setText(price);
        jcb_paymentMethod.setSelectedItem(paymentMethod);
        txt_nNumber.setText(String.valueOf(id));
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
            txt_payment.setText("$" + valor);
        }
    }
}
