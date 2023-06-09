package views;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import controller.ReservaController;
import model.Reserva;
/**
 *
 * @author mrln
 */
public class GestionarReservas extends javax.swing.JFrame {

    String user;
    int session_user = 0, userSession = 0;
    public static int id_reservaUp = 0;
    DefaultTableModel model = new DefaultTableModel();
    private final ReservaController reservationController;

    /**
     * Creates new form GestionarClientes
     */
    public GestionarReservas() {
        this.reservationController = new ReservaController();
        session_user = Administrador.session_user;
        userSession = Capturista.userSession;
        initComponents();
        user = Login.user;

        setSize(630, 380);
        setTitle("Capturista - Sesión de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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

        table_Reservation = new JTable(model);
        jScrollPane1.setViewportView(table_Reservation);
        model.addColumn(" ");
        model.addColumn("Fecha de entrada");
        model.addColumn("Fecha de salida");
        model.addColumn("Presio a pagar");
        model.addColumn("Forma de pago");
        table_Reservation.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        fillTable();
        
        table_Reservation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row_point = table_Reservation.rowAtPoint(e.getPoint());
                int column_point = 0;

                if (row_point > -1) {
                    id_reservaUp = (int) model.getValueAt(row_point, column_point);
                    InformacionReserva informationReservation = new InformacionReserva();
                    informationReservation.setVisible(true);
                }
            }
        });
    }
    
    private List<Reserva> SearchReservation() {
        return this.reservationController.SearchReservation();
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

        label_titleManageClients = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Reservation = new javax.swing.JTable();
        label_wallpaper = new javax.swing.JLabel();
        label_footer1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titleManageClients.setFont(new java.awt.Font("DejaVuSansMono Nerd Font", 1, 24)); // NOI18N
        label_titleManageClients.setForeground(new java.awt.Color(255, 255, 255));
        label_titleManageClients.setText("Registro de Reservas");
        getContentPane().add(label_titleManageClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 10, 280, -1));

        table_Reservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_Reservation);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        label_wallpaper.setText("jLabel1");
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        label_footer1.setText("Creado Por Marlon Torres");
        getContentPane().add(label_footer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 270, 187, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            java.awt.EventQueue.invokeLater(() -> {
                new GestionarReservas().setVisible(true);
            });
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_footer1;
    private javax.swing.JLabel label_titleManageClients;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTable table_Reservation;
    // End of variables declaration//GEN-END:variables

    private void fillTable() {
        List<Reserva> reservation = SearchReservation();
	try {
            for (Reserva reservations : reservation) {
		model.addRow(new Object[] { reservations.getId(), reservations.getEntryDate(),
                    reservations.getDepartureDate(), reservations.getPrice(), 
                    reservations.getmethodPayment()});
            }
	} catch (Exception e) {
            throw e;
	}
    }

}
