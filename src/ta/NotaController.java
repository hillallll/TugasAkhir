/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hillal
 */
public class NotaController implements Initializable {

    @FXML
    private Button btntotalhw;
    @FXML
    private TextField datatotal;
    @FXML
    private TextField kembalian;
    @FXML
    private TextField pembayaran;

    String bayar, ttl;
    int kembali;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setdata(int total) {
        
        datatotal.setText(String.valueOf(total));
        bayar=pembayaran.getText();
       
    }
    @FXML
    void total(ActionEvent event) {
        if(pembayaran.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Pembayaran tidak boleh kosong!");
        }
        bayar = pembayaran.getText();
        ttl = datatotal.getText();
        kembali = Integer.parseInt(bayar) - Integer.parseInt(ttl);
        kembalian.setText(String.valueOf(kembali));
    }
    @FXML
    void backnota(ActionEvent event) throws IOException {
            ((Node) (event.getSource())).getScene().getWindow().hide();
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Perawatan.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),350, 200);
                
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Hewan");
                stage.show();
    }
}
