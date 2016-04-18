package facebook_GraphicInterface;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Scanner;


public class Facebook_GUI {
	
	Scanner sc = new Scanner(System.in);

	
	public static void main (String [] args){
Frame faceBook = new FaceBookFrame ("Facebook");
faceBook.setSize(450,300);
faceBook.setVisible(true);

	}

}

class FaceBookFrame extends Frame {
	
	
	// creates necessary labels
	
	public static Vector<FacebookPerson_Graphics> facebookPeople = new Vector(5);
	
	private Label name = new Label ("Name:");
	private Label newMood = new Label ("New Mood:");
	private Label moodInfo = new Label ("There is no user, or the mood is currently set to default.",Label.CENTER);

	// creates the text fields to be entered
	private TextField nameSpace = new TextField(10);
	private TextField moodSpace = new TextField(10);
		
	// creates the buttons needed
	public List nameList = new List();
	
	public Panel topPanel = new Panel ();
	public Panel bottomPanel = new Panel ();
	public Panel leftPanel = new Panel();
	public Panel centerPanel = new Panel ();
	public int indexNum =0;
	public String moodChange;
	public String userName;
	
	public FaceBookFrame (String title){
		super(title);
		setLayout (new BorderLayout());
		// add panels
		add("North", topPanel);
		add("West", leftPanel);
		add("South", bottomPanel);
		add("Center", centerPanel);


		
		// add to the top panel
		Button nameCheck = new Button("Add Person");
		topPanel.add(name);
		topPanel.add(nameSpace);
		topPanel.add(nameCheck);
		topPanel.setBackground(Color.GRAY);
		nameCheck.addActionListener(new NameAddition());
		
		
		// adding to the bottom panel
		Button moodCheck = new Button ("Change Mood");
		bottomPanel.add(newMood);
		bottomPanel.add(moodSpace);
		bottomPanel.add(moodCheck);
		bottomPanel.setBackground(Color.GRAY);
		moodCheck.addActionListener(new MoodChange());
		
		// adding to the left panel;
		leftPanel.setLayout(new GridLayout());
		leftPanel.add(nameList);
		nameList.addActionListener(new ItemSelection());
		
		
		// editing the center panel
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add("Center", moodInfo);

		addWindowListener(new WindowCloser());
				
	}
	class NameAddition implements ActionListener{
		public void actionPerformed(ActionEvent nameAdded){
		String newName = nameSpace.getText();
		FacebookPerson_Graphics newPerson = new FacebookPerson_Graphics(newName);
		facebookPeople.addElement(newPerson);
		nameList.add(newName);
		nameSpace.setText("");
		
			
		}
	}
	class MoodChange implements ActionListener{
		public void actionPerformed(ActionEvent moodChanged){
			moodChange = moodSpace.getText();
			facebookPeople.elementAt(indexNum).setMood(moodChange);
			
			if (moodChange.equalsIgnoreCase("happy")){
				centerPanel.setBackground(Color.GREEN);
				userName = facebookPeople.elementAt(indexNum).getName();
				moodInfo.setBackground(Color.GREEN);
				moodInfo.setText(userName +" is happy!");
			}
			else if (moodChange.equalsIgnoreCase("sad")){
				centerPanel.setBackground(Color.blue);
				userName = facebookPeople.elementAt(indexNum).getName();
				moodInfo.setBackground(Color.blue);
				moodInfo.setText(userName +" is sad. :( ");
				
			}
			else if ((moodChange.equalsIgnoreCase("mad")) || (moodChange.equalsIgnoreCase("angry"))){
				centerPanel.setBackground(Color.red);
				userName = facebookPeople.elementAt(indexNum).getName();
				moodInfo.setBackground(Color.red);
				moodInfo.setText(userName +" is angry! ");
				
			}
			else{
				centerPanel.setBackground(Color.lightGray);
				moodInfo.setBackground(Color.lightGray);
				moodInfo.setText("Default.");
				
			}
			moodSpace.setText("");
		}
	}
	class ItemSelection implements ActionListener{
		public void actionPerformed(ActionEvent itemSelect){
			indexNum = nameList.getSelectedIndex();
						
			if (facebookPeople.elementAt(indexNum).getMood().equalsIgnoreCase("happy")){
			centerPanel.setBackground(Color.GREEN);
			moodInfo.setBackground(Color.GREEN);
			userName = facebookPeople.elementAt(indexNum).getName();
			moodInfo.setText(userName +" is happy!");	

			}
			else if (facebookPeople.elementAt(indexNum).getMood().equalsIgnoreCase("sad")){
				centerPanel.setBackground(Color.blue);
				userName = facebookPeople.elementAt(indexNum).getName();
				moodInfo.setBackground(Color.blue);
				moodInfo.setText(userName +" is sad. :( ");
			}
			else if ((facebookPeople.elementAt(indexNum).getMood().equalsIgnoreCase("mad")) || (facebookPeople.elementAt(indexNum).getMood().equalsIgnoreCase("angry"))){
				centerPanel.setBackground(Color.red);
				userName = facebookPeople.elementAt(indexNum).getName();
				moodInfo.setBackground(Color.red);
				moodInfo.setText(userName +" is angry! ");
				
			}
			else{
				centerPanel.setBackground(Color.lightGray);
				moodInfo.setBackground(Color.lightGray);
				moodInfo.setText("Default.");
			}
		}
		
	}
	class WindowCloser extends WindowAdapter {
		 public void windowClosing(WindowEvent evt) {
		   System.exit(0);
		 }
	}

}
