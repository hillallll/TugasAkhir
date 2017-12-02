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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hillal
 */
public class MasalahHewanController implements Initializable {

  @FXML
    private Button penyakit;

    @FXML
    private Button tips;

    @FXML
    private TextArea solusi;

    @FXML
    private TextField baranghw;

    @FXML
    private TextField jumlahhw;

    @FXML
    private TextField hargahw;

    @FXML
    private Button btntotalhw;

    
    String barang,jumlah,harga;
    int total,kembali;
     
    void Kirim(){
        if(baranghw.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong!");
        }else if(hargahw.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harga Barang tidak boleh kosong!");
        }else if(jumlahhw.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Jumlah Barang tidak boleh kosong!");
        }
        barang = baranghw.getText();
        jumlah = jumlahhw.getText();
        harga = hargahw.getText();
        total = Integer.parseInt(harga) * Integer.parseInt(jumlah);
    }
    @FXML
    void klikhw(ActionEvent event) throws IOException {
        Kirim();
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Nota.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 389, 343);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("TA");
            stage.show();
            
            NotaController Data = new NotaController();
            Data = fxmlLoader.getController();
            
            Data.setdata(total);
    }

    @FXML
    void merawat(ActionEvent event) {
String a4=("Pada dasarnya Cara merawat hewan peliharaan tentunya di sesuaikan\n"
                + " dengan hewan apa yang dijadikan peliharaan , karena caranya akan lebih\n"
                + " spesifik khusus untuk hewan tersebut.\n");
        String a5=("1. membersihkan tempat tinggalnya secara teratur\n" +
"2. menyediakan makanan yang sesuai dengan hewan, secara cukup tidak berlebihan\n" +
"3. kesehatan hewan juga di perhatikan, mulai dari di mandikan, dibersihkan dari kotoran\n" +
"4. jangan malas membersihkan kotoran hewan tersebut");
        String hasil= a4 + a5;
        solusi.setText(" "+hasil);
    }

    @FXML
    void sakit(ActionEvent event) {
         String a2=("Penyakit-penyakit yang sering menyerang hewan ternak\n");
        String a3=("1. Newcastle Disease atau NCD yaitu biasa dikenal dengan\n"
                + " penyakit sampar ayam atau Tetelo. Penyakit ini adalah \n"
                + "penyakit yang disebabkan oleh virus NCD dari golongan \n"
                + "Paramyxovirus. Virus ini menyerang alat pernafasan, \n"
                + "alat reproduksi, jaringan syaraf, dan sebagainya.\n" +
                "2. Rabies yaitu disebabkan oleh virus neurotropik. \n"
                + "Rabies menyerang sistem syaraf pusat hewan dengan \n"
                + "berdarah panas. Hewan yang terserang virus ini dapat \n"
                + "menjadi lebih ganas dan menyerang manusia.\n" +
                "3. Papillomatosis atau kutil pada sapi yaitu disebabkan oleh \n"
                + "virus BPV atau Bovine Papilloma Virus. Biasanya menyerang pada \n"
                + "hidung, putiing, gland penis, leher, kepala, saluran pencernaan, \n"
                + "dan vesika urinaria.\n" +
                "Penyakit Tetelo yaitu disebabkan oleh virus NCDV atau New Castle \n"
                + "Disease Virus. Penyakit ini menyerang hewan unggas khususnya \n"
                + "pada ayam.\n" +
                "Penyakit kuku dan mulut yaitu virus menyerang hewan yang berkuku \n"
                + "seperti sapi, kerbau, kambing, babi, dan lainnya");
        String hasil= a2 + a3;
        solusi.setText(" "+hasil);
    
    }

    @FXML
    void backhw(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Perawatan.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),350, 200);
                
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Hewan");
                stage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
    }

}
     