/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author prarthana
 */
public class TabletwarningController implements Initializable {

   @FXML
    public TextField locationField;
    public String home;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void backButton(ActionEvent e) throws IOException {
        ((Node)e.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tablet2.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        Tablet2Controller controller = loader.<Tablet2Controller>getController();
        controller.setHome(home);
        stage.show();     
    }
    
    @FXML
    public void setHome(String homeloc) {
        home = homeloc;
    }
    
}
