
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
 * @author prarthana
 */
public class TabletlocationController implements Initializable {

    @FXML
    public TextField locationField;
    public String home;
    Tablet2Controller move;
    static Stage newStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void locationButton(ActionEvent e) throws IOException {
        ((Node)e.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tablet2.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
       Tablet2Controller controller = loader.<Tablet2Controller>getController();
       controller.setHome(locationField.getText());
        stage.show();
       
    }
    
    public String getLocation() {
        home = locationField.getText();
        return home;
    }


  

}
