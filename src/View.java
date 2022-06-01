import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    JLabel lKode = new JLabel("Kode");
    JLabel lNama = new JLabel("Nama");
    JLabel lKategori = new JLabel("Kategori");
    JLabel lHarga = new JLabel("Harga");
    JLabel lJumlah = new JLabel("Jumlah");

    public JTextField tfKode = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfKategori = new JTextField();
    public JTextField tfHarga = new JTextField();
    public JTextField tfJumlah = new JTextField();

    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnClear = new JButton("Clear");

    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Kode", "Nama", "Kategori", "Harga", "Jumlah"};

    public View() {
        dtm = new DefaultTableModel(namaKolom, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);

        setTitle("Data Petshop");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700, 400);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(lKode);
        lKode.setBounds(510, 20, 90, 20);
        add(tfKode);
        tfKode.setBounds(510, 40, 120, 20);

        add(lNama);
        lNama.setBounds(510, 60, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 80, 120, 20);

        add(lKategori);
        lKategori.setBounds(510, 100, 90, 20);
        add(tfKategori);
        tfKategori.setBounds(510, 120, 120, 20);

        add(lHarga);
        lHarga.setBounds(510, 140, 90, 20);
        add(tfHarga);
        tfHarga.setBounds(510, 160, 120, 20);

        add(lJumlah);
        lJumlah.setBounds(510, 180, 90, 20);
        add(tfJumlah);
        tfJumlah.setBounds(510, 200, 120, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 260, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510, 290, 90, 20);

        add(btnClear);
        btnClear.setBounds(510, 320, 90, 20);
    }

    public String getKode() {
        return tfKode.getText();
    }

    public String getNama() {
        return tfNama.getText();
    }

    public String getKategori() {
        return tfKategori.getText();
    }

    public String getHarga() {
        return tfHarga.getText();
    }

    public String getJumlah() {
        return tfJumlah.getText();
    }
}
