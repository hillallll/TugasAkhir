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
public class MasalahTumbuhanController implements Initializable {

    @FXML
    private Button tum1;
    @FXML
    private Button tum2;
    @FXML
    private TextArea solusi;
    @FXML
    private TextField barangtum;
    @FXML
    private TextField jumlahtum;
    @FXML
    private TextField hargatum;
    @FXML
    private Button btntotaltum;

    String barang,jumlah,harga;
    int total,kembali;
    
     
    void Kirim(){
        if(barangtum.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong!");
        }else if(hargatum.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harga Barang tidak boleh kosong!");
        }else if(jumlahtum.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Jumlah Barang tidak boleh kosong!");
        }
        barang = barangtum.getText();
        jumlah = jumlahtum.getText();
        harga = hargatum.getText();
        total = Integer.parseInt(harga) * Integer.parseInt(jumlah);
        
    }
    
      @FXML
    private void totaltum(ActionEvent event) throws IOException {
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
    private void ac1(ActionEvent event) {
        String a6=("Penyakit-penyakit yang sering menyerang tumbuhan\n");
        String a7=("1. Penyakit mosaik disebabkan oleh Tobacco Mozaic Virus atau virus TMV. \n"
                + "Virus mozaik ini mempunyai hospes (inang) utama yaitu tanaman tembakau. \n"
                + "Akan tetapi karena virus TMV mampu bermutasi, ia juga dapat menginfeksi \n"
                + "tumbuhan lainnya seperti labu, buncis, tebu, mentimun, gandum, kentang, tomat, \n"
                + "kacang kedelai dan sebagainya.\n"
                + "2. Penyakit tungro adalah sejenis penyakit kerdil pada tanaman padi. \n"
                + "Penyakit tungro disebabkan oleh dua jenis virus yang berbeda, yaitu virus tungro batang \n"
                + "atau Rice Tungro Bacilliform Virus (RTBV) dan virus tungro bulat atau Rice Tungro \n"
                + "Spherical Virus (RTSV). Kedua jenis virus ini tidak memiliki hubungan kekerabatan \n"
                + "secara serologi dan dapat menginfeksi tanaman padi secara bersamaan.\n"
                + "3. Degenerasi jeruk disebabkan oleh virus CVPD (Citrus Vein Phloem Degeneration) yang \n"
                + "menyerang pembuluh tapis (floem) dari tanaman jeruk sehingga mengalami malfungsi. \n"
                + "Pembuluh floem adalah pembuluh yang terdapat pada kulit batang, berfungsi untuk \n"
                + "mengangkut zat makanan dari daun menuju seluruh tubuh tumbuhan.\n");
        String hasil= a6 + a7;
        solusi.setText(" "+hasil);
    }

    @FXML
    private void ac2(ActionEvent event) {
        String a8=("Tips-tips merawat tumbuhan\n");
        String a9=("1. Tahu cara menyiram\n" +
                    "Tiap pot pasti memiliki bulatan sebagai tempat keluarnya air. \n"
                + "Siramlah sampai air meluap dan keluar dari lubang tersebut. \n"
                + "Hentikan segera ketika air sudah keluar karena apabila kelebihan \n"
                + "air, tanaman akan membusuk.\n" +
                    "2. Tambah kelembaban\n" +
                "Bagaimana cara mengetahui bahwa tanaman kurang kelembaban? Bintik-bintik \n"
                + "cokelat pada daun merupakan penandanya. Jadi, segera tempatkan di tempat \n"
                + "yang lebih lembab.\n" +
                "3. Pencahayaan\n" +
                "Tak semua tanaman dapat hidup di tempat yang gelap. Beberapa butuh pencahayaan \n"
                + "terang untuk dapat melakukan fotosintesis. Oleh karena itu, tingkat pencahayaan \n"
                + "sinar matahari penting bagi mereka.\n" +
                "4. Ubah tanah\n" +
                "Kadang-kadang tanaman tetap tidak tumbuh maksimal meskipun air dan pencahayaan sudah tepat. \n"
                + "Solusinya dengan mengganti media tanam. Tak harus menggantinya dengan arang atau kristal, \n"
                + "tetapi mengganti dengan tanah baru dapat memerbaharui nutrisi tanaman.\n" +
                "5. Bersihkan tanaman\n" +
                "Selalu ingin terlihat bersih dan terbebas dari kotoran? Tanaman pun juga menginginkan \n"
                + "hal seperti itu. Bersihkan daun demi daun dengan kain halus, atau cukup hindarkan mereka dari debu.\n");
        String hasil= a8 + a9;
        solusi.setText(" "+hasil);
    }

    @FXML
    void backtum(ActionEvent event) throws IOException {
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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}

 