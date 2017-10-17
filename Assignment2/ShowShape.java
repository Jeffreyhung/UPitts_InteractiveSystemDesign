//Chi-Heng Hung CHH162@pitt.edu
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import java.awt.*;
import java.util.Arrays;

public class ShowShape extends JApplet{
	private String message;
	private String shape;
	private String color;
	private String BGcolor;
	private int X;
	private int Y;
	private String FTStyle;
	private int FTSize;
	
	private String XString;
	private String YString;
	private String FTSizeString;
	private String error;
	private int XStart=0;
	private int YStart=0;
	private Font f;
	private int textX;
	private int textY;
	private int textStartX;
	private int textStartY;
	private int SizeX;
	private int SizeY;
	private FontMetrics metrics;
	private String[] shapeArray={"OVAL","RECT","ROUNDRECT"};
	private String[] colorArray={"black","blue","cyan","darkGray","gray","green","lightGray","magenta","orange","pink","red","white","yellow"};
	private String[] FTStyleArray={"REGULAR","BOLD","ITALIC","BOLD ITALIC"};
	
	public void check(){
		this.error = "";
		//Check message
		try { 
			this.message=this.getParameter("Message");
			if(this.message == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.message="Sample";
			this.error += "No message received, use default. ";
		}
		// check shape
		try {
			this.shape=this.getParameter("Shape");
			if(this.shape == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.shape="RECT";
			this.error += "No shape received, use default. ";
		}
		// check if shape is legal
		try {
			if(Arrays.asList(shapeArray).contains(this.shape)) {
				;
			}else {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.shape="RECT";
			this.error += "Shape unrecognized, use default. ";
		}
		// check color
		try {
			this.color=this.getParameter("Color");
			if(this.color == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.color="black";
			this.error += "No color Received, use default. ";
		}
		// check if color is legal
		try {
			if(Arrays.asList(colorArray).contains(this.color)) {
				;
			}else {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException) {
			this.color="black";
			this.error += "Color unrecognized, use default. ";
		}
		// check BGcolor
		try {
			this.BGcolor=this.getParameter("BGColor");
			if(this.BGcolor == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.BGcolor="white";
			this.error += "No BGcolor Received, use default. ";
		}
		// check if BGcolor is legal
		try {
			if(Arrays.asList(colorArray).contains(this.BGcolor)) {
				;
			}else {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException) {
			this.BGcolor="white";
			this.error += "BGcolor unrecognized, use default. ";
		}
		// check X
		try {
			this.XString=this.getParameter("X");
			if(this.XString == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.XString="100";
			this.error += "No X received, use default. ";
		}
		// check if X is legal
		try {
			this.X = Integer.parseInt("0" + this.XString);
		}catch (NumberFormatException localNumberFormatException1){
			this.XString="100";
			this.X=100;
			this.error += "Illegal X, use default. ";
		}
		try{
			if(this.X>SizeX || this.X < 1 ) {
				 throw new NullPointerException();	
				}
		}catch(NullPointerException localNullPointerException){
			this.X=100;
			this.error += "Illegal X, use default. ";
		}
		// check Y
		try {
			this.YString=this.getParameter("Y");
			if(this.YString == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.YString="70";
			this.error += "No Y received, use default. ";
		}catch (NumberFormatException localNumberFormatException1){
			this.YString="70";
			this.error += "Illegal Y, use default. ";
		}
		// check if Y is legal
		try {
			this.Y = Integer.parseInt("0" + this.YString);
		}catch (NumberFormatException localNumberFormatException1){
			this.YString="70";
			this.Y=70;
			this.error += "Illegal Y, use default. ";
		}
		try{
			if(this.Y>this.SizeY || this.Y < 1 ) {
				 throw new NullPointerException();	
				}
		}catch(NullPointerException localNullPointerException){
			this.Y=70;
			this.error += "Illegal Y, use default. ";
		}
		// check FTStyle
		try {
			this.FTStyle=this.getParameter("FTStyle");
			if(this.FTStyle == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.FTStyle="REFULAR";
			this.error += "No FTStyle Received, use default. ";
		}
		// check if FTStyle is legal
		try {
			if(Arrays.asList(FTStyleArray).contains(this.FTStyle)) {
				;
			}else {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException) {
			this.FTStyle="REGULAR";
			this.error += "FTStyle unrecognized, use default. ";
		}
		// check FTSize
		try {
			this.FTSizeString=this.getParameter("FTSize");
			
			if(this.FTSizeString == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException){
			this.FTSizeString="20";
			this.error += "No FTSize Received, use default. ";
		}
		// check if FTSize is legal
		try {
			this.FTSize = Integer.parseInt("0"+this.FTSizeString);
		}catch (NumberFormatException localNumberFormatException1){
			this.FTSize=20;
			this.error += "FTSize illeagel, use default. ";
		}
		try {
			if(this.FTSize <1) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException) {
			this.FTSize=20;
			this.error += "FTSize illeagel, use default. ";
		}
	}

	public void setColor(Graphics g, String c) {
		switch(c) {
		case "black":
			g.setColor(Color.BLACK);
			break;
		case "blue":
			g.setColor(Color.BLUE);
			break;
		case "cyan":
			g.setColor(Color.CYAN);
			break;
		case "darkGray":
			g.setColor(Color.DARK_GRAY);
			break;
		case "gray":
			g.setColor(Color.GRAY);
			break;
		case "green":
			g.setColor(Color.GREEN);
			break;
		case "lightGray":
			g.setColor(Color.LIGHT_GRAY);
			break;
		case "magenta":
			g.setColor(Color.MAGENTA);
			break;
		case "orange":
			g.setColor(Color.ORANGE);
			break;
		case "pink":
			g.setColor(Color.PINK);
			break;
		case "red":
			g.setColor(Color.RED);
			break;
		case "white":
			g.setColor(Color.WHITE);
			break;
		case "yellow":
			g.setColor(Color.YELLOW);
			break;
		default :
			g.setColor(Color.BLACK);
			break;
		}
	}
	
	public void setBG(Graphics g, String c) {
		switch(c) {
		case "black":
			setBackground(Color.BLACK);
			break;
		case "blue":
			setBackground(Color.BLUE);
			break;
		case "cyan":
			setBackground(Color.CYAN);
			break;
		case "darkGray":
			setBackground(Color.DARK_GRAY);
			break;
		case "gray":
			setBackground(Color.GRAY);
			break;
		case "green":
			setBackground(Color.GREEN);
			break;
		case "lightGray":
			setBackground(Color.LIGHT_GRAY);
			break;
		case "magenta":
			setBackground(Color.MAGENTA);
			break;
		case "orange":
			setBackground(Color.ORANGE);
			break;
		case "pink":
			setBackground(Color.PINK);
			break;
		case "red":
			setBackground(Color.RED);
			break;
		case "white":
			setBackground(Color.WHITE);
			break;
		case "yellow":
			setBackground(Color.YELLOW);
			break;
		default :
			setBackground(Color.BLACK);
			break;
		}
	}
	
	public Font setFont(String fontname, int s) {
		switch(fontname) {
			case "REGULAR" :
				this.f = new Font("TimesRoman", Font.PLAIN,s);	
				break;
			case "BOLD" :
				this.f = new Font("TimesRoman", Font.BOLD,s);	
				break;
			case "ITALIC" :
				this.f = new Font("TimesRoman", Font.ITALIC,s);	
				break;
			case "BOLD ITALIC" :
				this.f = new Font("TimesRoman", Font.BOLD+Font.ITALIC,s);	
				break;
			default :
				this.f = new Font("TimesRoman", Font.PLAIN,s);
				break;
		}
		return this.f;
	}
	
	public void compare() {
		this.f = setFont(this.FTStyle,this.FTSize);
		metrics = getFontMetrics(this.f);
		textX = metrics.stringWidth(this.message);
		textY = metrics.getHeight();
		try {
			if(textX > X) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException) {
			this.error += "Message width bigger than the shape.";
		}
		try {
			if(textY > Y) {
				throw new NullPointerException();
			}
		}catch(NullPointerException localNullPointerException) {
			this.error += "Message height bigger than the shape";
		}
		this.textStartX = (this.SizeX - this.textX)/2;
		this.textStartY = (this.SizeY/2 + this.textY/4);
	}
	
	public void init() {
		Dimension localDimension = getSize();
	    this.SizeY = localDimension.height;
	    this.SizeX = localDimension.width;
		check();
		compare();
		if (this.error != "") {
			JOptionPane.showMessageDialog(this, "ERROR¡G" + this.error);
	    }
	}
	public void paint ( Graphics g)
	{	
		setColor(g,this.BGcolor);
		g.fillRect(0, 0, SizeX, SizeY);
		setColor(g,this.BGcolor);
		g.fillRect(0, 0, SizeX, SizeY);
		setColor(g,this.color);		
		XStart = (this.SizeX - this.X)/2;
		YStart = (this.SizeY - this.Y)/2;
		if(this.shape.equals("OVAL")) {
			g.drawOval(XStart, YStart, X, Y);
		}else if(this.shape.equals("RECT")) {
			g.drawRect(XStart, YStart, X, Y);
		}else if(this.shape.equals("ROUNDRECT")) {
			g.drawRoundRect(XStart, YStart, X, Y, 25, 25);
		}
		g.setFont(this.f);
		g.drawString(this.message, this.textStartX ,this.textStartY);
		showStatus(this.error);	
	}
	
}
