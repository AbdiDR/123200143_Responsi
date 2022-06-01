import javax.swing.*;
import java.sql.*;
import java.sql.SQLException;
public class Model {
    String DBurl    = "jdbc:mysql://localhost/trans_db";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public Model(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");

        }catch (Exception e) {
            System.out.println("Koneksi gagal, " + e.getMessage());
        }
    }
    public String[][] Transaction() {
        try {
            int jmlData = 0;

            String[][] data = new String[getBanyakData()][7];

            String query = "Select * from transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[jmlData][0] = resultSet.getString("id_trans");
                data[jmlData][1] = resultSet.getString("nama_barang");
                data[jmlData][2] = resultSet.getString("nama_kasir");
                data[jmlData][3] = resultSet.getString("qty");
                data[jmlData][4] = resultSet.getString("price_per_qty");
                data[jmlData][5] = resultSet.getString("discount");
                data[jmlData][6] = resultSet.getString("price_total");
                jmlData++;
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insert(String id, String namab, String nama, String jumlah, String hargas, String diskon, double hargad){
        int jmlData = 0;
        double fharga = Float.parseFloat(hargas);
        double fjumlah = Float.parseFloat(jumlah);
        double fdiskon = Float.parseFloat(diskon);
        try {
            String query = "Select * from transactions WHERE id_trans='" + id + "'";
            System.out.println(id + " " + namab + " " + nama + " " + fjumlah + " " + fharga + " " + fdiskon + " " + hargad);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            if (jmlData == 0){
                query = "INSERT INTO transactions VALUES('"+id+"','"+namab+"','"+nama+"','"+jumlah+"','"+hargas+"','"+diskon+"','"+hargad+"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void updateTransaksi(String id, String namab, String nama, String jumlah, String hargas, String diskon, double hargad) {
        int jmlData = 0;
        double fharga = Float.parseFloat(hargas);
        double fjumlah = Float.parseFloat(jumlah);
        double fdiskon = Float.parseFloat(diskon);
        try {
            String query = "Select * from transactions WHERE id_trans='" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 1) {
                query = "UPDATE transactions SET nama_barang='" + namab + "', nama_kasir='" + nama + "', qty='" + fjumlah + "', price_per_qty='" + fharga + "', discount='" + fdiskon + "', price_total='" + hargad + "' WHERE id_trans='" + id + "'";
                statement = koneksi.createStatement();
                statement.execute(query);
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void delete(String id){
        try {
            String query = "DELETE FROM transactions WHERE id_trans = '"+id+"'";
            statement = koneksi.createStatement();
            statement.execute(query);
            System.out.println("Berhasil dihapus");
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData() {
        int jmlData = 0;
        try {
            statement = koneksi.createStatement();
            String query = "Select * from transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return 0;
        }
    }

}

