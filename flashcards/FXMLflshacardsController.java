/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Admin
 */
public class FXMLflshacardsController implements Initializable {
    
    @FXML
    private Label ceskylabel;
    
    @FXML
    private Label anglickylabel;
    
    @FXML
    private Label tlacitkovse;
    
    @FXML
    private Button tlacitkodalsi;
    
    @FXML
    private TextField ceskytextfield;
    
    @FXML
    private TextField anglickytextfield;
    
    int pokus = 1;
    int spravne = 0;
    int k = 0;
    int p = -2;
    int i;   
    String[] polecesky;
    String[] poleanglicky;
    String znovukontrola = "Znovu";
    String znovu; 
    String anj;
    
    @FXML
    private void handletlacitkodalsiAction(ActionEvent event) {
        /*Při zadávání počtu slovíček*/
        if (p == -2){i = Integer.parseInt(ceskytextfield.getText()); ceskylabel.setText("Česky"); anglickylabel.setText("Anglicky"); ceskytextfield.setText(""); polecesky = new String[i]; poleanglicky = new String[i];p = -1;}
        /*při zadávání jednotlivých slovíček*/
        if ( -1 < p){
        String c;
        c = ceskytextfield.getText();
        String a;
        a = anglickytextfield.getText();
        ceskytextfield.setText("");
        anglickytextfield.setText("");
        polecesky [p] = c;
        poleanglicky [p] = a;
            }  
        p++;
        
        /*při zkoušení*/
        if ( p < -9) {
        ceskytextfield.setText("" + polecesky [k]);
        anj = anglickytextfield.getText();
        anglickytextfield.setText("");
        if (anj.equals(poleanglicky[k])){tlacitkovse.setText("Správně");spravne++;}
        else {tlacitkovse.setText("Špatně");}
        if ( p == 10) {tlacitkovse.setText("Vše");}
        k++;}
        
        /*při poslední slovíčku*/
        if ( p == i - 1){tlacitkodalsi.setText("Dopiš a začni");}
        if ( p == i){p = -10; tlacitkodalsi.setText("Další");}
        
        /*při znovu*/
        znovu = tlacitkodalsi.getText();
        if (znovu.equals(znovukontrola)) {p = -10; tlacitkodalsi.setText("Další");k = 0;  ceskylabel.setText("Česky"); anglickylabel.setText("Anglicky");  anglickytextfield.setText(""); pokus++;}
        if ( k == i) {tlacitkodalsi.setText("Znovu"); ceskytextfield.setText(spravne + "/" + i); ceskylabel.setText("Úspěšnost"); anglickylabel.setText("Pokus"); spravne = 0; anglickytextfield.setText("" + pokus);}
        
        /*při prvním zkoušení*/
        if ( p == -10) {anglickytextfield.setText("");ceskytextfield.setText("" + polecesky [k]);p--;}}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
