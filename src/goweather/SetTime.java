/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.fxml.FXML;

/**
 *
 * @author abbas
 */
public class SetTime {
     
     public String setHours(int hourno){
     
     SimpleDateFormat sdfStopTime = new SimpleDateFormat("H");
     Calendar c = Calendar.getInstance();
     c.add(Calendar.HOUR, hourno);
     Date d = c.getTime();
     String newStopTime = sdfStopTime.format(d);
      
     return newStopTime;
    
     }
     
    
}
