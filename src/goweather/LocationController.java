
package goweather;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hanifaaziz
 */
public class LocationController implements Initializable {  

   @FXML
    public TextField locationField,complete;
   
   
    public String home;
    GoWeatherMobileAppController move;
    GoWeatherMobile main;
    Scene scene;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void locationButton(ActionEvent e) throws IOException {

            ((Node)e.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GoWeatherMobileApp.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) loader.load()));
            GoWeatherMobileAppController controller = loader.<GoWeatherMobileAppController>getController();
            controller.setHome(locationField.getText());
            stage.show();
    }
    
    public String getLocation() {
        home = locationField.getText();
        return home;
    }

   
    
}
