import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login {

    Model connector = new Model();

    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("LOGIN");

    JLabel lUsername = new JLabel("Username  ");
    JTextField tfUsername = new JTextField();
    JLabel lPassword = new JLabel("Password  ");
    JTextField tfPassword = new JTextField();
    JLabel lLogin = new JLabel("Belum memiliki akun?");
    JButton btnRegister = new JButton("Register");
    JButton btnLogin = new JButton("Login");

    public Login(){
        window.setLayout(null);
        window.setSize(400,200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(lUsername);
        window.add(tfUsername);
        window.add(lPassword);
        window.add(tfPassword);
        window.add(lLogin);
        window.add(btnRegister);
        window.add(btnLogin);

//LABEL
        lUsername.setBounds(80, 20, 120, 25);
        lPassword.setBounds(80, 45, 120, 25);
        lLogin.setBounds(80, 120, 150, 25);

//TEXTFIELD
        tfUsername.setBounds(200, 25, 120, 20);
        tfPassword.setBounds(200, 50, 120, 20);

//BUTTON PANEL
        btnRegister.setBounds(220, 120, 103, 25);
        btnLogin.setBounds(80,80,245,25);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String query = "SELECT * FROM `admin` WHERE username = '" + getUsername() + "' AND password = '" + getPassword() + "'";
                    connector.statement = connector.koneksi.createStatement();
                    ResultSet resultSet = connector.statement.executeQuery(query);
                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(null, "Login Berhasil");

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login gagal, silahkan coba lagi");
                        tfPassword.requestFocus();
                    }
                } catch (SQLException e) {
                    System.out.println("Error");
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

            }
        });
    }

    public String getUsername(){
        return tfUsername.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }

}
