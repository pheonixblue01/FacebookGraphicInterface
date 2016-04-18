package facebook_GraphicInterface;

//This is the FacebookPerson_Graphics class
//Dr. Xiaolin Hu
//04/05/2011

public class FacebookPerson_Graphics{

private String myName;
private String myMood;
private Facebook_Graphics myfacebook;
private String name;
private String content;

public FacebookPerson_Graphics(String name){
   myName = name;
   myMood = ("default mood");
   myfacebook = new Facebook_Graphics(myName);
}

public String getName(){
   return myName;
}

public void setMood(String newMood){
  myMood = newMood;
  myfacebook.setContent(myMood);
}

public String getMood(){
   return myMood;
   
}
public void setContent(String newContent){
	content = newContent;
     if(content.equals("happy")){

         // display mood
         String currentDisplay = (name+"'s mood is:"+ "happy");
     }
     else{
    	 
    	 String currentDisplay = (name+"'s mood is " +content);
     }
     // Repaint frame
   }
public String getContent(){
	return content;
}
public void Facebook_Graphics(String nm){
    content = "undefined";
    name = nm;


}


}