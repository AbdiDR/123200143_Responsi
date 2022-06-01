
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

    JLabel lId = new JLabel("Id");
    JLabel lNamaB = new JLabel("Nama Barang");
    JLabel lNama = new JLabel("Nama Kasir");
    JLabel lJumlah = new JLabel("Jumlah");
    JLabel lHargas = new JLabel("Harga satuan");
    JLabel lDiskon = new JLabel("Diskon");



    public JTextField tfId = new JTextField();
    public JTextField tfNamaB = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfJumlah = new JTextField();
    public JTextField tfHargas = new JTextField();

    public JTextField tfDiskon = new JTextField();


    public JButton btnAdd = new JButton("Add");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnClear = new JButton("Clear");

    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object[] namaKolom = {"Id", "Nama Barang", "Nama Kasir", "Jumlah", "Harga Satuan", "Diskon (%)", "Harga set diskon"};

    public View() {
        dtm = new DefaultTableModel(namaKolom, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);

        setTitle("Data Transaksi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700, 600);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 650, 300);

        add(lId);
        lId.setBounds(20, 320, 90, 20);
        add(tfId);
        tfId.setBounds(20, 340, 120, 20);

        add(lNamaB);
        lNamaB.setBounds(150, 320, 90, 20);
        add(tfNamaB);
        tfNamaB.setBounds(150, 340, 120, 20);

        add(lNama);
        lNama.setBounds(280, 320, 90, 20);
        add(tfNama);
        tfNama.setBounds(280, 340, 120, 20);

        add(lJumlah);
        lJumlah.setBounds(410, 320, 90, 20);
        add(tfJumlah);
        tfJumlah.setBounds(410, 340, 120, 20);

        add(lHargas);
        lHargas.setBounds(540, 320, 90, 20);
        add(tfHargas);
        tfHargas.setBounds(540, 340, 120, 20);

        add(lDiskon);
        lDiskon.setBounds(280, 360, 90, 20);
        add(tfDiskon);
        tfDiskon.setBounds(280, 380, 120, 20);


        add(btnAdd);
        btnAdd.setBounds(150, 420, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(250, 420, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(350, 420, 90, 20);

        add(btnClear);
        btnClear.setBounds(250, 460, 90, 20);

    }

    public String getId() {
        return tfId.getText();
    }

    public String getNamaB() {
        return tfNamaB.getText();
    }

    public String getNama() {
        return tfNama.getText();
    }

    public String getJumlah() {
        return tfJumlah.getText();
    }

    public String getHargas() {
        return tfHargas.getText();
    }

    public String getDiskon() {
        return tfDiskon.getText();
    }

    public double getHargad(){
        String harga = getHargas();
        String jumlah = getJumlah();
        String diskon = getDiskon();
        double fharga = Float.parseFloat(harga);
        double fjumlah = Float.parseFloat(jumlah);
        double fdiskon = Float.parseFloat(diskon);
        double total = fharga * fjumlah;
        double totald = fdiskon * total / 100;

        return total - totald;
    }



}
