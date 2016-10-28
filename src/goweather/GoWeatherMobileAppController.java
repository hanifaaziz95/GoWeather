/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hanifaaziz
 */
public class GoWeatherMobileAppController implements Initializable {

    @FXML
    private TextField search;

    @FXML
    private Label day, event;

    @FXML
    private HBox hb;

    @FXML
    private ListView<String> listView;

    private String homeLocation;

    @FXML
    private Label time;

    @FXML
    private Parent root;

    @FXML
    private Date dt;

    @FXML
    private ImageView iView;

    @FXML
    private MenuButton menu;
    @FXML
    MenuItem share;
    @FXML
    MenuItem saved;
    @FXML
    MenuItem warnings;
    @FXML
    MenuItem edit;
    @FXML
    MenuItem info;
    @FXML
    private Label mtemp;
    @FXML
    private Label conditions;
    @FXML
    private Label sun;
    @FXML
    private Label wind;
    @FXML
    private Label vis;
    @FXML
    private Label humids;

    @FXML
    private Label city;
    @FXML
    int count;
    static Stage pageStage;
    @FXML
    private Label no1, no2, no3, no4, no5, no6, no7, no8, no9, no10, no11, no12;
    @FXML
    private ComboBox cb;
    @FXML
    int theplace;
    @FXML
    String theid;

    @FXML
    private ImageView img;
    WeatherAPI weather;

    private Stage primaryStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        time.setText(sdf.format(cal.getTime()));

        Image image = new Image("/goweather/Images/london.gif");
        iView.setImage(image);

        setTemp("44418");
        setback("44418");
        SetTime time = new SetTime();
        no1.setText(time.setHours(0) + ":00");
        no2.setText(time.setHours(1) + ":00");
        no3.setText(time.setHours(2) + ":00");
        no4.setText(time.setHours(3) + ":00");
        no5.setText(time.setHours(4) + ":00");
        no6.setText(time.setHours(5) + ":00");
        no7.setText(time.setHours(6) + ":00");
        no8.setText(time.setHours(7) + ":00");
        no9.setText(time.setHours(8) + ":00");
        no10.setText(time.setHours(9) + ":00");
        no11.setText(time.setHours(10) + ":00");
        no12.setText(time.setHours(11) + ":00");
    }

    @FXML
    private void setTemp(String place) {
        WeatherAPI weather = new WeatherAPI(place);

        mtemp.setText(weather.weatherForecastList.get(0).highTemp + "°");
        conditions.setText(weather.weatherForecastList.get(0).conditionss);

        WeatherAPIconditions weathera = new WeatherAPIconditions(place, "<yweather:astronomy");
        sun.setText(weathera.weatherForecastList.get(0).setsun);

        WeatherAPIconditions weatherb = new WeatherAPIconditions(place, "<yweather:wind");
        wind.setText(weatherb.weatherForecastList.get(0).windspeed + " mph");

        WeatherAPIconditions weatherc = new WeatherAPIconditions(place, "<yweather:atmosphere");
        vis.setText(weatherc.weatherForecastList.get(0).visible + " mi");
        humids.setText(weatherc.weatherForecastList.get(0).humid + " %");
        
        WeatherAPIconditions weatherd = new WeatherAPIconditions(place, "<yweather:location");
        city.setText(weatherd.weatherForecastList.get(0).location);
        //setback("44418");
    }

    //Method to set background based on event or weather conditions
    @FXML
    private void setback(String location) {
        weather = new WeatherAPI(location);
        if (weather.weatherForecastList.get(0).conditionss.equals("Mostly Clear")) {

            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/01.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("Rain") || weather.weatherForecastList.get(0).conditionss.equals("Rain/Wind") || weather.weatherForecastList.get(0).conditionss.equals("Light Rain")) {

            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/12.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("Cloudy")) {

            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/11.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("Sunny")) {

            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/01.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("Mostly Cloudy") || weather.weatherForecastList.get(0).conditionss.equals("Partly Cloudy") || weather.weatherForecastList.get(0).conditionss.equals("Mostly Sunny")) {

            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/03.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("heavy snow") || weather.weatherForecastList.get(0).conditionss.equals("scattered snow showers") || weather.weatherForecastList.get(0).conditionss.equals("snow showers") || weather.weatherForecastList.get(0).conditionss.equals("Rain/Snow")) {

            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/20.png"));
            img.setImage(image3);

        } else {
            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/11.png"));
            img.setImage(image3);
        }

    }

    //Set search visible when clicked and hides search when clicked again
    @FXML
    public void searchButton(ActionEvent e) {
        if (!search.isVisible()) {
            search.setVisible(true);
        } else if (search.isVisible()) {
            search.setVisible(false);
        }
    }

    //Sets home location for user
    @FXML
    public void locationButton(ActionEvent e) throws IOException {
        city.setText(homeLocation);
        System.out.println(homeLocation);
    }

    //Gets scene for menu option clicked by user 
    @FXML
    public void getPage(MouseEvent e) throws IOException {

        share.setOnAction(e1 -> {
            try {
                ((Node) e.getSource()).getScene().getWindow().hide();
                getSharePage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        saved.setOnAction(e2 -> {
            try {
                ((Node) e.getSource()).getScene().getWindow().hide();
                getSavedPage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        warnings.setOnAction(e3 -> {
            try {
                ((Node) e.getSource()).getScene().getWindow().hide();
                getWarningPage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        edit.setOnAction(e4 -> {
            try {
                ((Node) e.getSource()).getScene().getWindow().hide();
                getEditPage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        info.setOnAction(e5 -> {
            try {
                ((Node) e.getSource()).getScene().getWindow().hide();
                getInfoPage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void getInfoPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Information.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        InformationController controller = loader.<InformationController>getController();
        controller.setHome(homeLocation);
        stage.show();
    }

    public void getEditPage() throws IOException {
        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Location.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();
    }

    public void getWarningPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WeatherWarning.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        WeatherWarningController controller = loader.<WeatherWarningController>getController();
        controller.setHome(homeLocation);
        stage.show();
    }

    public void getSharePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Share.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        ShareController controller = loader.<ShareController>getController();
        controller.setHome(homeLocation);
        stage.show();
    }

    public void getSavedPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SavedEvents.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        SavedEventsController controller = loader.<SavedEventsController>getController();
        controller.setHome(homeLocation);
        stage.show();
    }

    @FXML
    public void changeScreen(ActionEvent e) throws IOException {
        ((Node) e.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tablet2.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        Tablet2Controller controller = loader.<Tablet2Controller>getController();
        controller.setHome(homeLocation);
        stage.show();
    }

    @FXML
    public void setHome(String homeloc) {
        homeLocation = homeloc;
    }

    @FXML
    public void getNextDay(MouseEvent e) {
        count = count + 1;
        if (count == 6) {
            day.setText("Today");
            count = 0;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, count);
            SimpleDateFormat sdf = new SimpleDateFormat("E");
            day.setText(sdf.format(cal.getTime()));
        }
        if (e.getClickCount() == 1) {
            System.out.println(e.getClickCount());
            setNextTemp(1);
        } else if (e.getClickCount() == 2) {
            System.out.println(e.getClickCount());
            setNextTemp(2);
        } else if (e.getClickCount() == 3) {
            System.out.println(e.getClickCount());
            setNextTemp(3);
        } else if (e.getClickCount() == 4) {
            System.out.println(e.getClickCount());
            setNextTemp(4);
        } else {
            System.out.println(e.getClickCount());
            setTemp("44418");
        }
    }

    @FXML
    private void setNextTemp(int day) {
        WeatherAPI weather = new WeatherAPI("44418");

        mtemp.setText(weather.weatherForecastList.get(day).highTemp + "°");
        conditions.setText(weather.weatherForecastList.get(day).conditionss);
    }

    //once the user clicks enter on their search, if it is a saved event the weather and event will be displayed.
    @FXML
    public void afterSearch(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SavedEvents.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        SavedEventsController controller = loader.<SavedEventsController>getController();
        String h = controller.getEvent3();
        System.out.println(h);

        if (search.getText().equals("Wembley") || search.getText().equals("FA final")) {
            theplace = 1;
            event.setText(controller.getEvent3());
        } else if (search.getText().equals("Victoria Park") || search.getText().equals("LoveBox")) {
            theplace = 3;
            event.setText(controller.getEvent2());
        } else if (search.getText().equals("Hyde Park") || search.getText().equals("Wireless Festival")) {
            theplace = 2;
            event.setText(controller.getEvent());
        } else {
            System.out.println(search.getText());
            city.setText(search.getText());
            
        }
        setlocation();
        stage.hide();
    }

    @FXML
    private void setlocation() {
        switch (theplace) {
            case 1:
                theid = "22493702";//wembley
                break;
            case 2:
                theid = "23508630";//hyde park
                break;
            case 3:
                theid = "23508622";
                break;
            default:
                break;
        }
        setTemp(theid);
    }
}
