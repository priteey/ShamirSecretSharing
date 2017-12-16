package com.share;
/* 
 *  Files: Share.java
 *  Courtesy: Robert Bisewski
 */
 
 //the necessary imports
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

//this is where the class starts
public class Share extends JFrame implements ActionListener {
    ArrayList<Integer> shares1 = new ArrayList<Integer>();
    ArrayList<Integer> shares2 = new ArrayList<Integer>();
    ArrayList<Integer> shares3 = new ArrayList<Integer>();
    ArrayList<Integer> shares4 = new ArrayList<Integer>();
    ArrayList<Integer> shares5 = new ArrayList<Integer>();

    //this string defines the text of the About Program button
    String aboutTxt = "Courtesy: Robert Bisewski, Former ACS Student of University of Winnipeg";
                         
    //this string defines the text of Display Instructions button
    String instructTxt = "Instructions:\n" +
                      "------------------\n\n" +
      
                         "Load/Enter Text: This opens a text\n" +
                         "file that the user selects and dumps\n" +
                         "its contents to the original text box.\n\n" +
                         
                         "Create Shares: This takes the contents\n" +
                         "of the original text box, creates five\n" +
                         "shares, and places them into their boxes.\n\n" +
                          
                         "Reconstruct Original: This takes the\n" +
                         "shares placed in the share boxes and\n" +
                         "uses them to recreate the original text.\n" +
                         "Click the checkboxes to decide which\n" +
                         "shares you wish to use.";

    //the filter that describes what files can be opened
    FileNameExtensionFilter fnef = new FileNameExtensionFilter("Text File", "txt", "TXT");

    //the text-areas and the scrollbars used in this program
    private JTextArea originaltxt = new JTextArea("Original Text");
    private JScrollPane scrBar    = new JScrollPane(originaltxt);
    private JTextArea retxt       = new JTextArea("");
    private JScrollPane RscrBar   = new JScrollPane(retxt);
    private JTextArea share1      = new JTextArea("");
    private JScrollPane scrBar1   = new JScrollPane(share1);
    private JTextArea share2      = new JTextArea("");
    private JScrollPane scrBar2   = new JScrollPane(share2);
    private JTextArea share3      = new JTextArea("");
    private JScrollPane scrBar3   = new JScrollPane(share3);
    private JTextArea share4      = new JTextArea("");
    private JScrollPane scrBar4   = new JScrollPane(share4);
    private JTextArea share5      = new JTextArea("");
    private JScrollPane scrBar5   = new JScrollPane(share5);    
    private JTextArea time        = new JTextArea("");
    private JScrollPane recTime   = new JScrollPane(time);    

    //this specifies the checkboxes used with this program
    final JCheckBox chk1 = new JCheckBox("", false);
    final JCheckBox chk2 = new JCheckBox("", false);
    final JCheckBox chk3 = new JCheckBox("", false);
    final JCheckBox chk4 = new JCheckBox("", false);
    final JCheckBox chk5 = new JCheckBox("", false);

    //this buttons used in this program
    final JButton bttLoad    = new JButton("Load Text from File");
    final JButton bttCreate  = new JButton("Create Shares");
    final JButton bttRecon   = new JButton("Reconstruct Original");
    final JButton bttDisplay = new JButton("Display Instructions");
    final JButton bttAbout   = new JButton("About Program");
    final JButton bttQuit    = new JButton("Quit Program");
  
  //the default constructor for this program
  public Share() {
  
    //defines the details of the scrollbars
    originaltxt.setLineWrap(true);
    originaltxt.setWrapStyleWord(true);
    scrBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    scrBar1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share1.setLineWrap(true);
    share1.setWrapStyleWord(true);
    
    scrBar2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share2.setLineWrap(true);
    share2.setWrapStyleWord(true);
    
    scrBar3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share3.setLineWrap(true);
    share3.setWrapStyleWord(true);
    
    scrBar4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share4.setLineWrap(true);
    share4.setWrapStyleWord(true);
    
    scrBar5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    share5.setLineWrap(true);
    share5.setWrapStyleWord(true);
    
    RscrBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    retxt.setLineWrap(true);
    retxt.setWrapStyleWord(true);
    
    recTime.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    time.setLineWrap(true);
    time.setWrapStyleWord(true);
    
    //defines the size of several objects
    scrBar.setPreferredSize(new Dimension(170,160));
    scrBar1.setPreferredSize(new Dimension(170,160));
    chk1.setPreferredSize(new Dimension(175,15));
    scrBar2.setPreferredSize(new Dimension(170,160));
    chk2.setPreferredSize(new Dimension(175,15));
    scrBar3.setPreferredSize(new Dimension(170,160));
    chk3.setPreferredSize(new Dimension(175,15));
    scrBar4.setPreferredSize(new Dimension(170,160));
    chk4.setPreferredSize(new Dimension(175,15));
    scrBar5.setPreferredSize(new Dimension(170,160));
    chk5.setPreferredSize(new Dimension(175,15));
    RscrBar.setPreferredSize(new Dimension(170,160));
    recTime.setPreferredSize(new Dimension(170,160));

    bttLoad.setPreferredSize(new Dimension(170,25));
    bttCreate.setPreferredSize(new Dimension(170,25));
    bttRecon.setPreferredSize(new Dimension(170,25));
    bttDisplay.setPreferredSize(new Dimension(170,25));       
    bttAbout.setPreferredSize(new Dimension(170,25));
    bttQuit.setPreferredSize(new Dimension(170,25));
  
    //defines the panels used in this program
    JPanel menu = new JPanel(); menu.setBorder(BorderFactory.createTitledBorder("Menu Options:"));
    menu.setPreferredSize(new Dimension(200,220));   
    JPanel originalPan = new JPanel(); originalPan.setBorder(BorderFactory.createTitledBorder("Original Text:"));
    originalPan.setPreferredSize(new Dimension(200,220));
    JPanel share1Pan = new JPanel(); 
    share1Pan.setBorder(BorderFactory.createTitledBorder("Share Text 1:"));
    share1Pan.setPreferredSize(new Dimension(200,220));
    JPanel share2Pan = new JPanel();
    share2Pan.setBorder(BorderFactory.createTitledBorder("Share Text 2:"));
    share2Pan.setPreferredSize(new Dimension(200,220));
    JPanel share3Pan = new JPanel();
    share3Pan.setBorder(BorderFactory.createTitledBorder("Share Text 3:"));
    share3Pan.setPreferredSize(new Dimension(200,220));
    JPanel share4Pan = new JPanel();
    share4Pan.setBorder(BorderFactory.createTitledBorder("Share Text 4:"));
    share4Pan.setPreferredSize(new Dimension(200,220));
    JPanel share5Pan = new JPanel();
    share5Pan.setBorder(BorderFactory.createTitledBorder("Share Text 5:"));
    share5Pan.setPreferredSize(new Dimension(200,220));
    JPanel rePan = new JPanel();
    rePan.setBorder(BorderFactory.createTitledBorder("Reconstructed Text:"));
    rePan.setPreferredSize(new Dimension(200,220));
    JPanel timePan = new JPanel();
    timePan.setBorder(BorderFactory.createTitledBorder("Time:"));
    timePan.setPreferredSize(new Dimension(200,220));
    //defines the layouts of the Content Pane
    getContentPane().setLayout(new FlowLayout());
    
   //adds the panels to the Content Pane
   menu.add(bttLoad);
  menu.add(bttCreate);
   menu.add(bttRecon);
   menu.add(bttDisplay);
   menu.add(bttAbout);
   menu.add(bttQuit);
   originalPan.add(scrBar);
   rePan.add(RscrBar);
   share1Pan.add(scrBar1);
   share1Pan.add(chk1);
   share2Pan.add(scrBar2);
   share2Pan.add(chk2);
   share3Pan.add(scrBar3);
   share3Pan.add(chk3);
   share4Pan.add(scrBar4);
   share4Pan.add(chk4);
   share5Pan.add(scrBar5);
   share5Pan.add(chk5);
   timePan.add(recTime);
   getContentPane().add(originalPan);
   getContentPane().add(share1Pan);
   getContentPane().add(share2Pan);
   getContentPane().add(share3Pan);
   getContentPane().add(rePan);
   getContentPane().add(share4Pan);
   getContentPane().add(share5Pan);
   getContentPane().add(timePan);

   getContentPane().add(menu);
   
   //adds ActionListeners to this program's components
   bttLoad.addActionListener(this);
   bttCreate.addActionListener(this);
   bttRecon.addActionListener(this);
   bttDisplay.addActionListener(this);
   bttAbout.addActionListener(this);
   bttQuit.addActionListener(this);
   
   //this sets essential values of the GUI
   setTitle("ICSI-426 Assignment #3: Text Secret Sharing");
   setSize(990,780);
   setResizable(true);
   addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
  }

  ////////////////////////////////////////////////////////
  //Basic Program Functions for Input/Output Starts Here// 
  ////////////////////////////////////////////////////////
  
  //this opens a file via the JFileChooser, returns file name & location
  public String SelectFile() {
  
    //variable declaration
    String path = null;
  
    //this creates a JFileChooser gui in order to select a file
    JFileChooser jfc = new JFileChooser();
    jfc.setFileFilter(fnef);
    int buttonClicked = jfc.showOpenDialog(new JLabel("Open File"));
    
    //this checks which button was pressed on the JFileChooser GUI
    if (buttonClicked == JFileChooser.APPROVE_OPTION) {
      path = "" + jfc.getCurrentDirectory() + "\\"
               + (jfc.getSelectedFile().getName()).toLowerCase();
    }
    return path;
  }

  //this reads the contents of the text area to a text file
  public void txtRead(String file) {
   
   //this buffers, then reads the file
    StringBuffer s = new StringBuffer();
    try {
      BufferedReader input = new BufferedReader(new FileReader(file));
      try {
        String line = "";
        while ((line = input.readLine()) != null) {s.append(line + "\n");}
      }
      finally {input.close();}
     }
     catch (Exception x){JOptionPane.showMessageDialog(null, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);}
    
   //this display the text
   originaltxt.setText(s.toString());
  }

  //this divides the original text into 5 separate shares
  public void txtShare() 
  {
	  long startTime,endTime,totalTime = 0;
	  startTime = System.currentTimeMillis();
    
	  String ascToText="";
	  
	  String name = originaltxt.getText(); // String to check it's value
	    int originaltxt = name.length(); // length of the string used for the loop
	    ArrayList<Integer> asc = new ArrayList<Integer>();
	    for(int i = 0; i < originaltxt ; i++){   // while counting characters if less than the length add one        
	        char character = name.charAt(i); // start on the first character
	        int ascii = (int) character; //convert the first character
	        asc.add(ascii);
	    }
	    //Creating Shares
	    for(int j=0; j<asc.size(); j++){//Creating first share
	    	int a0=asc.get(j);
	    	int a1=4, a2=5, p= 131, x=2;
	    	double share= (a0 + a1*x +a2*(Math.pow(x, 2)))% p;
	    	shares1.add((int) share);
	    }
	    for(int i = 0; i < shares1.size() ; i++){   
	    	int a= (shares1.get(i));
	    	 char str = ((char)a);
	        ascToText= ascToText+str;
	    }
	    share1.setText(ascToText.toString());
	    
	    for(int j=0; j<asc.size(); j++){//Creating second share
	    	int a0=asc.get(j);
	    	int a1=4, a2=5, p= 131, x=3;
	    	double share= (a0 + a1*x +a2*(Math.pow(x, 2)))% p;
	    	shares2.add((int) share);
	    }
	    for(int i = 0; i < shares2.size() ; i++){   
	    	int a= (shares2.get(i));
	    	 char str = ((char)a);
	        ascToText=ascToText+str;

	    }
	    share2.setText(ascToText);

	    for(int j=0; j<asc.size(); j++){//Creating third share
	    	int a0=asc.get(j);
	    	int a1=4, a2=5, p= 131, x=4;
	    	double shares= (a0 + a1*x +a2*(Math.pow(x, 2)))% p;
	    	shares3.add((int) shares);
	    }
	    for(int i = 0; i < shares3.size() ; i++){   
	    	int a= (shares3.get(i));
	    	 char str = ((char)a);
		     ascToText=ascToText+str;
	    }
	    share3.setText(ascToText);

	    for(int j=0; j<asc.size(); j++){//Creating fourth share
	    	int a0=asc.get(j);
	    	int a1=4, a2=5, p= 131, x=5;
	    	double shares= (a0 + a1*x +a2*(Math.pow(x, 2)))% p;
	    	shares4.add((int) shares);
	    }
	    for(int i = 0; i < shares4.size() ; i++){   
	    	int a= (shares4.get(i));
	    	 char str = ((char)a);
		        ascToText=ascToText+str;

	    }
	    share4.setText(ascToText.toString());

	    for(int j=0; j<asc.size(); j++){//Creating fourth share
	    	int a0=asc.get(j);
	    	int a1=4, a2=5, p= 131, x=6;
	    	double shares= (a0 + a1*x +a2*(Math.pow(x, 2)))% p;
	    	shares5.add((int) shares);
	    }
	    for(int i = 0; i < shares5.size() ; i++){   
	    	int a= (shares5.get(i));
	    	 char str = ((char)a);
//	            System.out.println(str);
	        ascToText=ascToText+str;
	    }
	    share5.setText(ascToText);
	    endTime = System.currentTimeMillis();
	      totalTime = endTime - startTime;
	      time.setText("Time required to create shares: "+Long.toString(totalTime)+"ms");
  }

  //this reconstructs the shares and dumps the result to the reconstructed text area
  public void txtRecon() 
  {	   long startTime,endTime,totalTime = 0;
  	   startTime = (int) System.currentTimeMillis();
    
	   ArrayList<Integer> resultList= new ArrayList<>();

	    int m[]= {2,3,4,5,6};
	    Map<Integer, Integer> map= new HashMap<>();
	    //Lagrange Interpolation
	    int y1,y2,y3,y4,y5 = 0;
	    for(int s=0; s<shares1.size(); s++){
//	    	int x= m[s];
	    	
	    	if(chk1.isSelected()){
	    		int x=2;
	    		 y1= shares1.get(s);
	    		 map.put(x, y1);
	    	}
	    	 if(chk2.isSelected()){
	    		 int x=3;
	    		  y2= shares2.get(s);
	    		  map.put(x, y2);
	    	}
	    	 if(chk3.isSelected()){
	    		 int x=4;
	    		  y3= shares3.get(s);
	    		  map.put(x, y3);
	    	}
	    	 if(chk4.isSelected()){
	    		 int x=5;
	    		  y4= shares4.get(s);
	    		  map.put(x, y4);
	    	}
	    	 if(chk5.isSelected()){
	    		 int x=6;
	    		  y5= shares5.get(s);
	    		  map.put(x, y5);
	    	}
	    	 ArrayList<Integer> keyList= new ArrayList<>();
	    	 ArrayList<Integer> valuesList= new ArrayList<>();

	    	 for (Entry<Integer, Integer> entry  : map.entrySet()) {
	    		    keyList.add(entry.getKey());
	    		    valuesList.add(entry.getValue());
	    	}
	    	 int x1, x2, x3, yy1, yy2, yy3=0, p=131; 
	    		 x1= keyList.get(0);
	    		 x2=keyList.get(1);
	    		 x3=keyList.get(2);
	    		 yy1=valuesList.get(0);
	    		 yy2=valuesList.get(1);
	    		 yy3=valuesList.get(2);
	    		 int xx=0;
	    	 int f= (yy1*(((xx-x2)*(xx-x3))/((x1-x2)*(x1-x3)))) + (yy2*(((xx-x1)*(xx-x3))/((x2-x1)*(x2-x3)))) + (yy3 * (((xx-x1)*(xx-x2))/((x3-x2)*(x3-x1))));
	    	 if(f<0){
	    		 while(f<0){
	    			 f=f+p;
	    		 }
	    	 }
	    	 int result = f%p;
	    	resultList.add(result);
	    	 
	    }
	    int a=0;
	    char str;
	    String ascToResultText="";
	    for(int i = 0; i < resultList.size() ; i++){   
	    	a = (resultList.get(i));
	    	 str = ((char)a);
	    	 ascToResultText=ascToResultText+str;
	    	 }
	    
	    retxt.setText(ascToResultText);
	    endTime = (int) System.currentTimeMillis();
	      totalTime = (endTime - startTime);
	      time.setText("Time required to reconstruct: "+Long.toString(totalTime)+"ms");
}

  //////////////////////////////////////////////////////
  //Basic Program Functions for Input/Output Ends Here// 
  //////////////////////////////////////////////////////
  

  //this determines what button has been pressed on the GUI
  public void actionPerformed(ActionEvent aE) {
    if (aE.getSource() == bttLoad)    {txtRead(SelectFile());}
    if (aE.getSource() == bttCreate)  {txtShare();}
    if (aE.getSource() == bttRecon)   {txtRecon();}
    if (aE.getSource() == bttDisplay) {JOptionPane.showMessageDialog(null,instructTxt);}
    if (aE.getSource() == bttAbout)   {JOptionPane.showMessageDialog(null,aboutTxt);}
    if (aE.getSource() == bttQuit)    {System.exit(0);}
  }
  
  //this is the program's main method, which creates a new application with title, then checks if closes
  public static void main(String args[]) {
     SwingUtilities.invokeLater(new Runnable() {public void run() {Share gui = new Share(); gui.setVisible(true);}});
  }
}