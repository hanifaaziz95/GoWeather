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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hanifaaziz
 */
public class SavedEventsController implements Initializable {
    
    public String home;
    @FXML
    private Label location1;

    @FXML
    private Label location2;

    @FXML
    private Label location3;

    @FXML
    private Label event1;

    @FXML
    private Label event2;

    @FXML
    private Label event3;
      @FXML
    private Label locks;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public String getlocation() {
        return location1.getText();
    }
    
    public String getEvent(){
        return event1.getText();
    }
    
    public String getlocation2(){
        return location2.getText();
    }
    
    public String getEvent2(){
       return event2.getText();
    }
    
    public String getlocation3() {
       return location1.getText();
    }
    
    public String getEvent3(){
      return event3.getText();  
    }
    
    @FXML
    public void backButton(ActionEvent e) throws IOException {
        ((Node)e.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GoWeatherMobileApp.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        GoWeatherMobileAppController controller = loader.<GoWeatherMobileAppController>getController();
        controller.setHome(home);
        stage.show();
       
    }
    
    @FXML
    public void setHome(String homeloc) {
        home = homeloc;
    }

}
