/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author prarthana
 */
public class TabletshareController implements Initializable {

    @FXML
    public TextField locationField;
    public String home;
    @FXML
    private WebView webview;
    private WebEngine engine;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        engine = webview.getEngine();

    }

    @FXML
    private void onFacebook(ActionEvent event) throws URISyntaxException, IOException {
        engine.load("http://wwww.facebook.com");
        webview.setVisible(true);

    }

    @FXML
    private void onTwitter(ActionEvent event) throws URISyntaxException, IOException {
        engine.load("https://twitter.com");
        webview.setVisible(true);
    }

    @FXML
    private void onGoogle(ActionEvent event) throws URISyntaxException, IOException {
        engine.load("http://plus.google.com");
        webview.setVisible(true);

    }

    @FXML
    private void onEmail(ActionEvent event) throws URISyntaxException, IOException {

        engine.load("http://mail.live.com");
        webview.setVisible(true);

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
