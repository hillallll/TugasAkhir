/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hillal
 */
public class LoginController implements Initializable {

    @FXML
    private TextField use;

    @FXML
    private PasswordField pw;

    @FXML
    private Button login;

    @FXML
    private void log(ActionEvent event) throws IOException,SQLException {
        Connection connection;
        PreparedStatement ps;
        try{
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ta", "root","");
            ps= connection.prepareStatement("SELECT * FROM `login` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, use.getText());
            ps.setString(2, pw.getText());
            ResultSet result = ps.executeQuery();
        if(result.next()){
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Benar!");     
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("perawatan.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 350, 200);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("TA");
            stage.show();
        }else if(use.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong!");
        }else if(pw.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong!");
        }else if(use.getText().equals("") && pw.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong!");
        }else{
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Salah!");
            pw.setText("");
            use.requestFocus();
        }
    }catch(SQLException ex){
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, "Gagal!");
        
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}
