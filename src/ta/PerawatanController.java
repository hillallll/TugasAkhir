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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hillal
 */
public class PerawatanController implements Initializable {
    @FXML
    private Button hewan;
    @FXML
    private Button tumbuhan;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    void hewan(ActionEvent event) throws IOException {
        
                ((Node) (event.getSource())).getScene().getWindow().hide();
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MasalahHewan.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),500, 570);
                
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Hewan");
                stage.show();
            

    }

    @FXML
    void tumbuhaaan(ActionEvent event) throws IOException {
       
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MasalahTumbuhan.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),500, 570);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Tumbuhan");
                stage.show();
            

    }

    
}
