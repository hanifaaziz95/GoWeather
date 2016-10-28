/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author prarthana
 */
public class Tablet1Controller implements Initializable {

    private MediaPlayer player;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        play();

    }

    public void play() {
    final URL resource = getClass().getResource("a.mp3");
    final Media media = new Media(resource.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play();


        //javafx.scene.media.Media media = new javafx.scene.media.Media(Paths.get("/Users/prarthana/Documents/Software Project/NBProjects/SE23/Plookify/src/Master/Working/player/logic/Tracks/" + mediaFile).toUri().toString());
        //player = new MediaPlayer(media);

       // player.play();

    }
}
