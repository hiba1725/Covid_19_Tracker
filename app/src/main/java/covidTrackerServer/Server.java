package covidTrackerServer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
public class Server {
    public static int beirut;
    public static int byblos;
    public static int barja;
    public static int baalbak;
    public static int tyre;
    public static int tripoli;
    public static void main(String args[]) throws Exception {
        ServerSocket sersock = new ServerSocket(7000);
        System.out.println("Server ready........");
        Socket sock = sersock.accept( );

        OutputStream ostream = sock.getOutputStream();
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(ostream));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/covid19Tracker","root","");
            // select stuff from the database
            String beirut_sql = "SELECT * FROM infected_tracking WHERE Beirut = '1'";
            java.sql.PreparedStatement beips = conn.prepareStatement(beirut_sql);
            java.sql.ResultSet beirs = beips.executeQuery();
            beirut = 0;
            while (beirs.next()) {
                beirut = beirut+1;
            }

            String byblos_sql = "SELECT * FROM infected_tracking WHERE Byblos = '1'";
            java.sql.PreparedStatement bybps = conn.prepareStatement(byblos_sql);
            java.sql.ResultSet bybrs = bybps.executeQuery();
            byblos = 0;
            while (bybrs.next()) {
                byblos = byblos+1;
            }


            String barja_sql = "SELECT * FROM infected_tracking WHERE Barja = '1'";
            java.sql.PreparedStatement barps = conn.prepareStatement(barja_sql);
            java.sql.ResultSet barrs = barps.executeQuery();
            barja = 0;
            while (barrs.next()) {
                barja = barja+1;
            }

            String baalbak_sql = "SELECT * FROM infected_tracking WHERE Baalbeck = '1'";
            java.sql.PreparedStatement balps = conn.prepareStatement(baalbak_sql);
            java.sql.ResultSet balrs = balps.executeQuery();
            baalbak = 0;
            while (barrs.next()) {
                baalbak = baalbak+1;
            }


            String tri_sql = "SELECT * FROM infected_tracking WHERE Tripoli = '1'";
            java.sql.PreparedStatement trirps = conn.prepareStatement(tri_sql);
            java.sql.ResultSet trirs = trirps.executeQuery();
            tripoli = 0;
            while (trirs.next()) {
                tripoli = tripoli+1;
            }


            String tyre_sql = "SELECT * FROM infected_tracking WHERE Tyre = '1'";
            java.sql.PreparedStatement tyrps = conn.prepareStatement(tyre_sql);
            java.sql.ResultSet tyrrs = tyrps.executeQuery();
            tyre = 0;
            while (tyrrs.next()) {
                tyre = tyre+1;
            }

        } catch (Exception e1) {
            System.out.print(e1);
        };
        String bei_str = String.valueOf(beirut);
        String byb_str = String.valueOf(byblos);
        String bar_str = String.valueOf(barja);
        String bal_str = String.valueOf(baalbak);
        String tri_str = String.valueOf(tripoli);
        String tyr_str = String.valueOf(tyre);

        String test = "Baalbeck: " + bal_str + ", "
                + "Barja: " + bar_str + ", "
                + "Beirut: " + bei_str + ", "
                + "Byblos: " + byb_str + ", "
                + "Tyre: " + tyr_str + ", "
                + "Tripoli: " + tri_str;
        bw1.write(test);

        bw1.close();    ostream.close();   sock.close();   sersock.close( );
    }
}