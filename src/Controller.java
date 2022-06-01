
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    Model Model;
    View View;

    public String pilid, pilnamab, pilnama, piljumlah, pilhargas, pildiskon;
    public Controller(Model Model, View View) {
        this.Model = Model;
        this.View = View;

        if (Model.getBanyakData()!=0) {
            String[][] dataTransaksi = Model.Transaction();
            View.table.setModel((new JTable(dataTransaksi, View.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        View.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                String id = View.getId();
                String namab = View.getNamaB();
                String nama = View.getNama();
                String jumlah = View.getJumlah();
                String hargas = View.getHargas();
                String diskon = View.getDiskon();
                double hargad = View.getHargad();
                Model.insert(id, namab, nama, jumlah, hargas, diskon, hargad);

                String[][] dataTransaksi = Model.Transaction();
                View.table.setModel((new JTable(dataTransaksi, View.namaKolom)).getModel());
            }

        });

        View.btnUpdate.addActionListener(ae -> {
            String id = View.getId();
            String namab = View.getNamaB();
            String nama = View.getNama();
            String jumlah = View.getJumlah();
            String hargas = View.getHargas();
            String diskon = View.getDiskon();
            double hargad = View.getHargad();

            Model.updateTransaksi(id, namab, nama, jumlah, hargas, diskon, hargad);

            String[][] dataTransaksi = Model.Transaction();
            View.table.setModel((new JTable(dataTransaksi, View.namaKolom)).getModel());
        });
        View.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                String id = View.getId();
                int input = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus transaksi dengan id " + id + "?", "Pilih opsi..", JOptionPane.YES_NO_OPTION);
                if(input == 0){
                    Model.delete(id);
                    String[][] dataTransaksi = Model.Transaction();
                    View.table.setModel((new JTable(dataTransaksi, View.namaKolom)).getModel());
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak jadi menghapus");
                }
            }

        });
        View.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                View.tfId.setText("");
                View.tfNamaB.setText("");
                View.tfNama.setText("");
                View.tfJumlah.setText("");
                View.tfHargas.setText("");
                View.tfDiskon.setText("");
            }

        });

        View.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = View.table.getSelectedRow();

                pilid = View.table.getValueAt(baris, 0).toString();
                pilnamab = View.table.getValueAt(baris, 1).toString();
                pilnama = View.table.getValueAt(baris, 2).toString();
                piljumlah = View.table.getValueAt(baris, 3).toString();
                pilhargas = View.table.getValueAt(baris, 4).toString();
                pildiskon = View.table.getValueAt(baris, 5).toString();

                View.tfId.setText(pilid);
                View.tfNamaB.setText(pilnamab);
                View.tfNama.setText(pilnama);
                View.tfJumlah.setText(piljumlah);
                View.tfHargas.setText(pilhargas);
                View.tfDiskon.setText(pildiskon);
            }
        });



    }

}
