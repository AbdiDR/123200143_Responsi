import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    Model Model;
    View View;

    public String pilihanData;

    public Controller(Model Model, View View) {
        this.Model = Model;
        this.View = View;

        if (Model.getBanyakData()!=0) {
            //String dataMovie[][] = Model.MovieList();
            //View.table.setModel((new JTable(dataMovie, View.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        View.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kode = View.getKode();
                String nama = View.getNama();
                String kategori = View.getKategori();
                String harga = View.getHarga();
                String jumlah = View.getJumlah();
                //Model.updateMovie(kode, nama, kategori, harga, jumlah);

                //String dataMovie[][] = Model.MovieList();
                //View.table.setModel((new JTable(dataMovie, View.namaKolom)).getModel());
            }
        });

        View.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = View.table.getSelectedRow();

                pilihanData = View.table.getValueAt(baris, 0).toString();
                System.out.println(pilihanData);
            }
        });



    }
}
