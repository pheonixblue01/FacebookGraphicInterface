package facebook_GraphicInterface;

// This is the FacebookPerson_Graphics class
// Dr. Xiaolin Hu
// 04/05/2011

//This is the Facebook_Graphics class
//Dr. Xiaolin Hu
//04/05/2011

import java.awt.*;
import jpb.*;

public class Facebook_Graphics{

private String name;
private String content;
DrawableFrame df;
private Graphics g;

public Facebook_Graphics(String nm){
    content = "undefined";
    name = nm;


}

public void setContent(String newContent){
	content = newContent;
     if(content.equalsIgnoreCase("happy")){

         // display mood
         String currentDisplay = (name+"'s mood is:"+ "happy.");
     }
     else if((content.equalsIgnoreCase("mad")||content.equalsIgnoreCase("angry"))){

         // display mood
         String currentDisplay = (name+"'s mood is:"+ "mad.");
     }
     else if(content.equalsIgnoreCase("sad")){

         // display mood
         String currentDisplay = (name+"'s mood is:"+ "sad.");
     }
     else{
    	 
    	 String currentDisplay = (name+"'s mood is set to default.");
     }
     // Repaint frame
   }

public String getContent(){
	return content;
}



}