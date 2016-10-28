
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author prarthana
 */
public class Tablet2Controller implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private Label Location;
    TabletlocationController loc;
    @FXML
    private Label date;
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
    static Stage pageStage;
    //private final ObservableList<String> data = FXCollections.observableArrayList("Stratford", "Mile End");
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
    private Label day1, day2, day3, day4;
    @FXML
    private Label temp1, temp2, temp3, temp4;
    @FXML
    private Label condition1, condition2, condition3, condition4;
    @FXML
    private ImageView images;
    WeatherAPI2 weather;
    @FXML
    private ImageView mon, back;
    @FXML
    private ImageView img1, img2, img3, img4, img;
    @FXML
    private Label no1, no2, no3, no4, no5, no6, no7, no8, no9, no10, no11, no12;
    @FXML
    private Label humids;
    @FXML
    private Label Loki;
    @FXML
    int theplace;
    @FXML
    String theid;
    @FXML Label event;
    
    private String homeLocation;
  
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

      
        //Display date and time in date label
        Date dNow = new Date();
        SimpleDateFormat getTime = new SimpleDateFormat("E H:mm");//shows current time/date
        date.setText(getTime.format(dNow));

        SetTime time=new SetTime();//sets the time for 12 hour forcast to show current 12 hours
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
      
        
        switch (theplace) {
            case 1:
                theid = "22493702";//wembley
                break;
            case 2:
                theid = "23508630";//hyde park
                break;
            case 3:
                theid = "23508622";//victoria park
                break;
            default:
                break;

        }
        setTemp("44418");

    }

    @FXML
    public void afterSearch(ActionEvent e) throws IOException {// on search it displays the weather and event information for that location
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SavedEvents.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        SavedEventsController controller = loader.<SavedEventsController>getController();
        String h = controller.getEvent3();
        System.out.println(h);
       
        if(searchField.getText().equals("Wembley")|| searchField.getText().equals("FA final")){
            theplace=1;
            event.setText(controller.getEvent3());
        }
        else if(searchField.getText().equals("Victoria Park")||searchField.getText().equals("LoveBox")){
            theplace=3;
            event.setText(controller.getEvent2());
        }
        else if(searchField.getText().equals("Hyde Park")|| searchField.getText().equals("Wireless Festival")){
          theplace=2;  
          event.setText(controller.getEvent());
        }
        else{
            Loki.setText(searchField.getText());
            event.setText("");
        }
        setlocation();
        stage.hide();
    }
    
    @FXML
     private void setlocation()//sets the yahoo WOID of the searched locations
     {
           switch (theplace) {
                    case 1:
                        theid="22493702";//wembley
                        setTemp(theid);
                        Image image2 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/wembley.gif"));
                        back.setImage(image2);
                        break;
                    case 2:
                       theid="23508630";//hyde park
                       setTemp(theid);
                       Image image8 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/hyde.gif"));
                        back.setImage(image8);
                        break;
                    case 3:
                        theid="23508622";//victoria park
                        setTemp(theid);
                         Image image9 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/hyde.gif"));
                        back.setImage(image9);
                        break;            
                    default:
                        break; 
       }
       
     }

    @FXML
    private void setTemp(String place) {//sets weather information for 5 day forcast
        weather = new WeatherAPI2(place);

        mtemp.setText(weather.weatherForecastList.get(0).highTemp);
        conditions.setText(weather.weatherForecastList.get(0).conditionss);
        
        day1.setText(weather.weatherForecastList.get(1).days);
        day2.setText(weather.weatherForecastList.get(2).days);
        day3.setText(weather.weatherForecastList.get(3).days);
        day4.setText(weather.weatherForecastList.get(4).days);

        temp1.setText(weather.weatherForecastList.get(1).highTemp);
        temp2.setText(weather.weatherForecastList.get(2).highTemp);
        temp3.setText(weather.weatherForecastList.get(3).highTemp);
        temp4.setText(weather.weatherForecastList.get(4).highTemp);

        condition1.setText(weather.weatherForecastList.get(1).conditionss);
        condition2.setText(weather.weatherForecastList.get(2).conditionss);
        condition3.setText(weather.weatherForecastList.get(3).conditionss);
        condition4.setText(weather.weatherForecastList.get(4).conditionss);

        WeatherAPIconditions weathera = new WeatherAPIconditions(place, "<yweather:astronomy");
        sun.setText(weathera.weatherForecastList.get(0).setsun);

        WeatherAPIconditions weatherb = new WeatherAPIconditions(place, "<yweather:wind");
        wind.setText(weatherb.weatherForecastList.get(0).windspeed + "mph");

        WeatherAPIconditions weatherc = new WeatherAPIconditions(place, "<yweather:atmosphere");
        vis.setText(weatherc.weatherForecastList.get(0).visible + " mi");

        WeatherAPIconditions weathere = new WeatherAPIconditions(place, "<yweather:atmosphere");
        humids.setText(weathere.weatherForecastList.get(0).humid + " %");

        WeatherAPIconditions weatherd = new WeatherAPIconditions(place, "<yweather:location");
        Loki.setText(weatherd.weatherForecastList.get(0).location);

        weathericon(place);
        setback(place);
    }

    private void weathericon(String location) {//sets icons for the 5 day forcast based on yahoo weather information
        weather = new WeatherAPI2(location);

        for (int i = 1; i <= 4; i++) {
            if (weather.weatherForecastList.get(i).conditionss.equals("Cloudy")) {
                Image image1 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/cloud.png"));
                switch (i) {
                    case 1:
                        img1.setImage(image1);
                        break;
                    case 2:
                        img2.setImage(image1);
                        break;
                    case 3:
                        img3.setImage(image1);
                        break;
                    case 4:
                        img4.setImage(image1);
                        break;
                    default:
                        break;
                }
            } else if (weather.weatherForecastList.get(i).conditionss.equals("Rain/Wind") || weather.weatherForecastList.get(i).conditionss.equals("Rain") || weather.weatherForecastList.get(i).conditionss.equals("Light Rain")) {
                Image image1 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/rain.png"));
                switch (i) {
                    case 1:
                        img1.setImage(image1);
                        break;
                    case 2:
                        img2.setImage(image1);
                        break;
                    case 3:
                        img3.setImage(image1);
                        break;
                    case 4:
                        img4.setImage(image1);
                        break;
                    default:
                        break;
                }

            } else if (weather.weatherForecastList.get(i).conditionss.equals("Mostly Cloudy") || weather.weatherForecastList.get(i).conditionss.equals("Partly Cloudy") || weather.weatherForecastList.get(i).conditionss.equals("Mostly Sunny")) {
                Image image1 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/cloudsun.png"));
                switch (i) {
                    case 1:
                        img1.setImage(image1);
                        break;
                    case 2:
                        img2.setImage(image1);
                        break;
                    case 3:
                        img3.setImage(image1);
                        break;
                    case 4:
                        img4.setImage(image1);
                        break;
                    default:
                        break;
                }

            } else if (weather.weatherForecastList.get(i).conditionss.equals("sunny") || weather.weatherForecastList.get(i).conditionss.equals("")) {
                Image image1 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/sun.png"));
                switch (i) {
                    case 1:
                        img1.setImage(image1);
                        break;
                    case 2:
                        img2.setImage(image1);
                        break;
                    case 3:
                        img3.setImage(image1);
                        break;
                    case 4:
                        img4.setImage(image1);
                        break;
                    default:
                        break;
                }

            } else if (weather.weatherForecastList.get(i).conditionss.equals("heavy snow") || weather.weatherForecastList.get(i).conditionss.equals("scattered snow showers") || weather.weatherForecastList.get(i).conditionss.equals("snow showers")) {
                Image image1 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/snow.png"));
                switch (i) {
                    case 1:
                        img1.setImage(image1);
                        break;
                    case 2:
                        img2.setImage(image1);
                        break;
                    case 3:
                        img3.setImage(image1);
                        break;
                    case 4:
                        img4.setImage(image1);
                        break;
                    default:
                        break;
                }

            } else if (weather.weatherForecastList.get(i).conditionss.equals("Mostly Clear") || weather.weatherForecastList.get(i).conditionss.equals("Sunny")) {
                Image image1 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/sun.png"));
                switch (i) {
                    case 1:
                        img1.setImage(image1);
                        break;
                    case 2:
                        img2.setImage(image1);
                        break;
                    case 3:
                        img3.setImage(image1);
                        break;
                    case 4:
                        img4.setImage(image1);
                        break;
                    default:
                        break;
                }

            } else {
                Image image1 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/cloud.png"));
                switch (i) {
                    case 1:
                        img1.setImage(image1);
                        break;
                    case 2:
                        img2.setImage(image1);
                        break;
                    case 3:
                        img3.setImage(image1);
                        break;
                    case 4:
                        img4.setImage(image1);
                        break;
                    default:
                        break;
                }
            }

        }
    }

    private void setback(String location) {// shows the large image to compliment the current days weather and also sets the background
        weather = new WeatherAPI2(location);
        if (weather.weatherForecastList.get(0).conditionss.equals("Mostly Clear")) {
            Image image2 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/london.gif"));
            back.setImage(image2);
            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/01.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("Rain") || weather.weatherForecastList.get(0).conditionss.equals("Rain/Wind") || weather.weatherForecastList.get(0).conditionss.equals("Light Rain")) {
            Image image2 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/london.gif"));
            back.setImage(image2);

            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/12.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("Cloudy")) {
            Image image2 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/london.gif"));
            back.setImage(image2);
            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/11.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("Sunny")) {
            Image image2 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/london.gif"));
            back.setImage(image2);
            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/01.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("Mostly Cloudy") || weather.weatherForecastList.get(0).conditionss.equals("Partly Cloudy") || weather.weatherForecastList.get(0).conditionss.equals("Mostly Sunny")) {
            Image image2 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/london.gif"));
            back.setImage(image2);
            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/03.png"));
            img.setImage(image3);

        } else if (weather.weatherForecastList.get(0).conditionss.equals("heavy snow") || weather.weatherForecastList.get(0).conditionss.equals("scattered snow showers") || weather.weatherForecastList.get(0).conditionss.equals("snow showers") || weather.weatherForecastList.get(0).conditionss.equals("Rain/Snow")) {
            Image image2 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/london.gif"));
            back.setImage(image2);
            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/20.png"));
            img.setImage(image3);

        }
        else{
            
           Image image2 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/london.gif"));
            back.setImage(image2);
            Image image3 = new Image(Tablet2Controller.class.getResourceAsStream("imgy/11.png"));
            img.setImage(image3);
        }

    }

    public void onSearch(ActionEvent e) {

        if (!searchField.isVisible()) {
            searchField.setVisible(true);
        } else if (searchField.isVisible()) {
            searchField.setVisible(false);
        }

    }

    public void getPage(MouseEvent e) throws IOException {// shows the next page when you click on the page

        share.setOnAction(e1 -> {
            try {
                ((Node)e.getSource()).getScene().getWindow().hide();
                getSharePage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        saved.setOnAction(e2 -> {
            try {
                ((Node)e.getSource()).getScene().getWindow().hide();
                getSavedPage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        warnings.setOnAction(e3 -> {
            try {
                ((Node)e.getSource()).getScene().getWindow().hide();
                getWarningPage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        edit.setOnAction(e4 -> {
            try {
                ((Node)e.getSource()).getScene().getWindow().hide();
                getEditPage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        info.setOnAction(e5 -> {
            try {
                ((Node)e.getSource()).getScene().getWindow().hide();
                getInfoPage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void getInfoPage() throws IOException {
        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tabletinfo.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();

    }

    public void getEditPage() throws IOException {
        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tabletlocation.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();

    }

    public void getWarningPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tabletwarning.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        TabletwarningController controller = loader.<TabletwarningController>getController();
        controller.setHome(homeLocation);
        stage.show();

    }

    public void getSharePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tabletshare.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        TabletshareController controller = loader.<TabletshareController>getController();
        controller.setHome(homeLocation);
        stage.show();

    }

    public void getSavedPage() throws IOException {
        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tabletsavedevents.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();

    }

    public static void closeStage() {
        pageStage.hide();

    }
    
  
    @FXML
    public void changeScreen(ActionEvent e) throws IOException {
        ((Node)e.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GoWeatherMobileApp.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        GoWeatherMobileAppController controller = loader.<GoWeatherMobileAppController>getController();
        controller.setHome(homeLocation);
        stage.show();
    }
    
    @FXML
    public void locationButton(ActionEvent e) throws IOException {//runs code to set home location
        Loki.setText(homeLocation);
        System.out.println(homeLocation);
    }
    
     @FXML
    public void setHome(String homeloc) {
        homeLocation = homeloc;
    }

}
