import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JApplet;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Assignment4 extends JApplet{

	private static JFrame MainFrame;
	private static JPanel Result_panel;
	private static JComboBox ColorBox;
	private static JComboBox BGColorBox;
	private static JSlider AX_Slider;
	private static JSlider AY_Slider;
	private static JTextField MessageInput;
	private static JComboBox FTStyleBox;
	private static JSlider FTSize_Slider;
	private static JComboBox ShapeBox;
	private static JSlider SX_Slider;
	private static JSlider SY_Slider;
	private String message;
	private String shape;
	private int X;
	private int Y;
	private int XStart=0;
	private int YStart=0;
	private Font f;
	private int textX;
	private int textY;
	private int textStartX;
	private int textStartY;
	private static int SizeX;
	private static int SizeY;
	private FontMetrics metrics;
	private static Assignment4 draw;
	
	private Assignment4() {
		initialize();
	}
	
	public static void main(String[] args){
		draw = new Assignment4();
		draw.setSize(10, 10);
		Result_panel.add(draw);
	}

	private void initialize() {
		MainFrame = new JFrame();
		MainFrame.setFont(new Font("Noto Sans", Font.PLAIN, 12));
		MainFrame.setTitle("Assignment 4     by Chi-Heng Hung & Xinchen Yu");
		MainFrame.setMinimumSize(new Dimension(1000, 800));
		MainFrame.getContentPane().setBackground(new Color(211, 211, 211));
		MainFrame.getContentPane().setForeground(Color.WHITE);
		MainFrame.setBackground(new Color(153, 204, 255));
		MainFrame.setResizable(false);
		MainFrame.setBounds(100, 100, 798, 694);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);
//Header
		JPanel Title_panel = new JPanel();
		Title_panel.setBackground(new Color(51, 102, 153));
		Title_panel.setBounds(0, 0, 994, 55);
		MainFrame.getContentPane().add(Title_panel);
		Title_panel.setLayout(null);
		
		JLabel lblAssignment = new JLabel("Assignment 4");
		lblAssignment.setForeground(SystemColor.text);
		lblAssignment.setFont(new Font("Noto Sans", Font.BOLD, 30));
		lblAssignment.setBounds(20, 6, 265, 42);
		Title_panel.add(lblAssignment);
// Design Panel		
		JPanel Design_panel = new JPanel();
		Design_panel.setBorder(new LineBorder(new Color(227, 227, 227), 2, true));
		Design_panel.setBounds(14, 75, 473, 677);
		MainFrame.getContentPane().add(Design_panel);
		Design_panel.setLayout(null);
		
		JPanel Design_title = new JPanel();
		Design_title.setBackground(SystemColor.controlHighlight);
		Design_title.setBounds(0, 0, 473, 42);
		Design_panel.add(Design_title);
		Design_title.setLayout(null);
		
		JLabel label = new JLabel("Design");
		label.setFont(new Font("Noto Sans", Font.BOLD, 22));
		label.setBounds(14, 0, 112, 42);
		Design_title.add(label);
//Color		
		JLabel lblContentColor = new JLabel("Content Color : ");
		lblContentColor.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		lblContentColor.setBounds(27, 72, 132, 19);
		Design_panel.add(lblContentColor);
		
		ColorBox = new JComboBox();
		ColorBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
                repaint();
			}
		});
		ColorBox.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		ColorBox.setModel(new DefaultComboBoxModel(new String[] {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"}));
		ColorBox.setSelectedIndex(5);
		ColorBox.setBounds(194, 70, 200, 25);
		Design_panel.add(ColorBox);
		ColorBox.setVisible(true);
//Background color		
		JLabel lblBackgroundColor = new JLabel("Background Color : ");
		lblBackgroundColor.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		lblBackgroundColor.setBounds(27, 108, 157, 19);
		Design_panel.add(lblBackgroundColor);
		
		BGColorBox = new JComboBox();
		BGColorBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
                repaint();
			}
		});
		BGColorBox.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		BGColorBox.setModel(new DefaultComboBoxModel(new String[] {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"}));
		BGColorBox.setBounds(194, 106, 200, 25);
		Design_panel.add(BGColorBox);
		BGColorBox.setVisible(true);
//applet X
		JLabel lblAppletSize = new JLabel("Applet Width : ");
		lblAppletSize.setBounds(27, 151, 119, 19);
		Design_panel.add(lblAppletSize);
		lblAppletSize.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		AX_Slider = new JSlider(100,450,300);
		AX_Slider.setBounds(194, 144, 200, 26);
		Design_panel.add(AX_Slider);
		AX_Slider.setVisible(true);
		
		String AXvalue = String.valueOf(AX_Slider.getValue());
		JLabel AX_Value = new JLabel(AXvalue);
		AX_Value.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		AX_Value.setBounds(408, 148, 41, 19);
		Design_panel.add(AX_Value);
		AX_Value.setVisible(true);
		
		AX_Slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				String AXvalue = String.valueOf(AX_Slider.getValue());
                AX_Value.setText(AXvalue);
                draw.setSize(AX_Slider.getValue(),AY_Slider.getValue());
        		draw.setLocation(239-(AX_Slider.getValue()/2), 359-(AY_Slider.getValue()/2));
                repaint();
			}
		});
//applet Y		
		JLabel lblAppletHeight = new JLabel("Applet Height : ");
		lblAppletHeight.setBounds(27, 194, 119, 19);
		Design_panel.add(lblAppletHeight);
		lblAppletHeight.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		
		AY_Slider = new JSlider(100,600,150);
		AY_Slider.setBounds(194, 187, 200, 26);
		Design_panel.add(AY_Slider);
		AY_Slider.setVisible(true);
		
		String AYvalue = String.valueOf(AY_Slider.getValue());
		JLabel AY_Value = new JLabel(AYvalue);
		AY_Value.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		AY_Value.setBounds(408, 190, 41, 19);
		Design_panel.add(AY_Value);
		AY_Value.setVisible(true);
		
		AY_Slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				String AYvalue = String.valueOf(AY_Slider.getValue());
                AY_Value.setText(AYvalue);
                draw.setSize(AX_Slider.getValue(),AY_Slider.getValue());
        		draw.setLocation(239-(AX_Slider.getValue()/2), 359-(AY_Slider.getValue()/2));
                repaint();
			}
		});
//message design		
		JPanel MessageDesign_panel = new JPanel();
		MessageDesign_panel.setBorder(new LineBorder(new Color(227, 227, 227), 3, true));
		MessageDesign_panel.setBounds(16, 249, 443, 188);
		Design_panel.add(MessageDesign_panel);
		MessageDesign_panel.setLayout(null);
		
		JPanel MessageDesignTitle_panel = new JPanel();
		MessageDesignTitle_panel.setLayout(null);
		MessageDesignTitle_panel.setBackground(SystemColor.controlHighlight);
		MessageDesignTitle_panel.setBounds(0, 0, 443, 42);
		MessageDesign_panel.add(MessageDesignTitle_panel);
		
		JLabel lblMessageDesign = new JLabel("Message Design");
		lblMessageDesign.setFont(new Font("Noto Sans", Font.PLAIN, 20));
		lblMessageDesign.setBounds(14, 0, 231, 42);
		MessageDesignTitle_panel.add(lblMessageDesign);
//message		
		JLabel lblMessage = new JLabel("Message : ");
		lblMessage.setBounds(14, 64, 157, 19);
		MessageDesign_panel.add(lblMessage);
		lblMessage.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		
		MessageInput = new JTextField();
		MessageInput.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (MessageInput.getText().length() >= 10 ) { // limit to 3 characters
	                e.consume();
	            }
	            repaint();
	        }
	    });
		MessageInput.setBounds(175, 61, 200, 25);
		MessageInput.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		MessageInput.setText("Message");
		MessageInput.setColumns(10);
		MessageDesign_panel.add(MessageInput);
		MessageInput.setVisible(true);
//font style		
		JLabel lblFontStyle = new JLabel("Font Style : ");
		lblFontStyle.setBounds(14, 104, 157, 19);
		MessageDesign_panel.add(lblFontStyle);
		lblFontStyle.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		
		FTStyleBox = new JComboBox();
		FTStyleBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
                repaint();
			}
		});
		FTStyleBox.setBounds(175, 101, 200, 25);
		FTStyleBox.setModel(new DefaultComboBoxModel(new String[] {"Regular", "Bold", "Italic", "Bold Italic"}));
		FTStyleBox.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		MessageDesign_panel.add(FTStyleBox);
		FTStyleBox.setVisible(true);
//font size		
		JLabel lblFontSize = new JLabel("Font Size : ");
		lblFontSize.setBounds(14, 144, 119, 19);
		MessageDesign_panel.add(lblFontSize);
		lblFontSize.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		
		FTSize_Slider = new JSlider(1,50,20);
		FTSize_Slider.setBounds(175, 138, 200, 26);
		MessageDesign_panel.add(FTSize_Slider);
		FTSize_Slider.setVisible(true);
		
		String FTSvalue = String.valueOf(FTSize_Slider.getValue());
		JLabel FTSize_Value = new JLabel(FTSvalue);
		FTSize_Value.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		FTSize_Value.setBounds(389, 141, 41, 19);
		MessageDesign_panel.add(FTSize_Value);
		FTSize_Value.setVisible(true);
		
		FTSize_Slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
                String FTSvalue = String.valueOf(FTSize_Slider.getValue());
                FTSize_Value.setText(FTSvalue);
                repaint();
			}
		});
//shape design		
		JPanel ShapeDesign_panel = new JPanel();
		ShapeDesign_panel.setBorder(new LineBorder(new Color(227, 227, 227), 2, true));
		ShapeDesign_panel.setBounds(16, 457, 443, 196);
		Design_panel.add(ShapeDesign_panel);
		ShapeDesign_panel.setLayout(null);
		
		JPanel ShapeDesignTitle_panel = new JPanel();
		ShapeDesignTitle_panel.setLayout(null);
		ShapeDesignTitle_panel.setBackground(SystemColor.controlHighlight);
		ShapeDesignTitle_panel.setBounds(0, 0, 443, 42);
		ShapeDesign_panel.add(ShapeDesignTitle_panel);
		
		JLabel lblShapeDesign = new JLabel("Shape Design");
		lblShapeDesign.setFont(new Font("Noto Sans", Font.PLAIN, 20));
		lblShapeDesign.setBounds(14, 0, 184, 42);
		ShapeDesignTitle_panel.add(lblShapeDesign);
//shape		
		JLabel lblShape = new JLabel("Shape : ");
		lblShape.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		lblShape.setBounds(14, 65, 157, 19);
		ShapeDesign_panel.add(lblShape);
		
		ShapeBox = new JComboBox();
		ShapeBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
                repaint();
			}
		});
		ShapeBox.setModel(new DefaultComboBoxModel(new String[] {"Rectangle", "Oval", "Rounded Rectangle"}));
		ShapeBox.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		ShapeBox.setBounds(175, 62, 200, 25);
		ShapeDesign_panel.add(ShapeBox);
		ShapeBox.setVisible(true);
//shape X 		
		JLabel lblShapeWidth = new JLabel("Shape Width : ");
		lblShapeWidth.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		lblShapeWidth.setBounds(14, 105, 119, 19);
		ShapeDesign_panel.add(lblShapeWidth);
		
		SX_Slider = new JSlider(100,999,200);
		SX_Slider.setMaximum(AX_Slider.getValue()-10);
		SX_Slider.setBounds(175, 101, 200, 26);
		ShapeDesign_panel.add(SX_Slider);
		SX_Slider.setVisible(true);
		
		String SXvalue = String.valueOf(SX_Slider.getValue());
		JLabel SX_Value = new JLabel(SXvalue);
		SX_Value.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		SX_Value.setBounds(389, 103, 41, 19);
		ShapeDesign_panel.add(SX_Value);
		SX_Value.setVisible(true);
		
		SX_Slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
        		String SXvalue = String.valueOf(SX_Slider.getValue());
                SX_Value.setText(SXvalue);
                repaint();
			}
		});
//shape Y		
		JLabel lblShapeHeight = new JLabel("Shape Height : ");
		lblShapeHeight.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		lblShapeHeight.setBounds(14, 144, 119, 19);
		ShapeDesign_panel.add(lblShapeHeight);
		
		SY_Slider = new JSlider();
		SY_Slider.setMinimum(100);
		SY_Slider.setMaximum(AY_Slider.getValue()-10);
		SY_Slider.setValue(140);
		SY_Slider.setBounds(175, 140, 200, 26);
		ShapeDesign_panel.add(SY_Slider);
		SY_Slider.setVisible(true);
		
		String SYvalue = String.valueOf(SY_Slider.getValue());
		JLabel SY_Value = new JLabel(SYvalue);
		SY_Value.setFont(new Font("Noto Sans", Font.PLAIN, 15));
		SY_Value.setBounds(389, 142, 41, 19);
		ShapeDesign_panel.add(SY_Value);
		SY_Value.setVisible(true);
		
		SY_Slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
        		String SYvalue = String.valueOf(SY_Slider.getValue());
                SY_Value.setText(SYvalue);
                repaint();
			}
		});
//result		
		Result_panel = new JPanel();
		Result_panel.setBounds(501, 75, 479, 677);
		MainFrame.getContentPane().add(Result_panel);
		Result_panel.setLayout(null);
		
		JPanel ResultTitle_panel = new JPanel();
		ResultTitle_panel.setLayout(null);
		ResultTitle_panel.setBackground(SystemColor.controlHighlight);
		ResultTitle_panel.setBounds(0, 0, 479, 42);
		Result_panel.add(ResultTitle_panel);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Noto Sans", Font.BOLD, 22));
		lblResult.setBounds(14, 0, 112, 42);
		ResultTitle_panel.add(lblResult);		
//pack
		
		MainFrame.pack();
		MainFrame.setVisible(true);
}

	public void setColor(Graphics g, String c) {
		switch(c) {
		case "Black":
			g.setColor(Color.BLACK);
			break;
		case "Blue":
			g.setColor(Color.BLUE);
			break;
		case "Cyan":
			g.setColor(Color.CYAN);
			break;
		case "Dark Gray":
			g.setColor(Color.DARK_GRAY);
			break;
		case "Gray":
			g.setColor(Color.GRAY);
			break;
		case "Green":
			g.setColor(Color.GREEN);
			break;
		case "Light Gray":
			g.setColor(Color.LIGHT_GRAY);
			break;
		case "Magenta":
			g.setColor(Color.MAGENTA);
			break;
		case "Orange":
			g.setColor(Color.ORANGE);
			break;
		case "Pink":
			g.setColor(Color.PINK);
			break;
		case "Red":
			g.setColor(Color.RED);
			break;
		case "White":
			g.setColor(Color.WHITE);
			break;
		case "Yellow":
			g.setColor(Color.YELLOW);
			break;
		default :
			g.setColor(Color.WHITE);
			break;
		}
	}
	
	public Font setFont(String fontname, int s) {
		switch(fontname) {
			case "Regular" :
				f = new Font("TimesRoman", Font.PLAIN,s);	
				break;
			case "Bold Italic" :
				f = new Font("TimesRoman", Font.BOLD | Font.ITALIC,s);
				break;
			case "Bold" :
				f = new Font("TimesRoman", Font.BOLD,s);	
				break;
			case "Italic" :
				f = new Font("TimesRoman", Font.ITALIC,s);	
				break;
			default :
				f = new Font("TimesRoman", Font.PLAIN,s);
				break;
		}
		return f;
	}
	
	public void check() {
		X = SX_Slider.getValue();
		Y = SY_Slider.getValue();
		SizeX=AX_Slider.getValue();
		SizeY=AY_Slider.getValue();
		XStart = (AX_Slider.getValue()-X)/2;
		YStart = (AY_Slider.getValue()-Y)/2;
		message = MessageInput.getText();
		f = setFont(FTStyleBox.getSelectedItem().toString(),FTSize_Slider.getValue());
		metrics = getFontMetrics(f);
		textX = metrics.stringWidth(message);
		textY = metrics.getHeight();
		SX_Slider.setMaximum(AX_Slider.getValue()-10);
		SY_Slider.setMaximum(AY_Slider.getValue()-10);
		SX_Slider.setMinimum(textX+10);
		SY_Slider.setMinimum(textY+10);
		AX_Slider.setMinimum(textX+20);
		AY_Slider.setMinimum(textY+20);
		textStartX = (SizeX - this.textX)/2;
		textStartY = (SizeY/2 + this.textY/4);
	}
	
	@Override
	public void paint (Graphics g)
	{	
		check();
		setColor(g,BGColorBox.getSelectedItem().toString());
		g.fillRect(0, 0, AX_Slider.getValue(), AY_Slider.getValue());
		setColor(g,ColorBox.getSelectedItem().toString());
		shape = ShapeBox.getSelectedItem().toString();
		if(shape.equals("Oval")) {
			g.drawOval(XStart, YStart, X, Y);
		}else if(shape.equals("Rectangle")) {
			g.drawRect(XStart, YStart, X, Y);
		}else if(shape.equals("Rounded Rectangle")) {
			g.drawRoundRect(XStart, YStart, X, Y, 30, 30);
		}
		setFont(FTStyleBox.getSelectedItem().toString(),FTSize_Slider.getValue());
		g.setFont(f);
		g.drawString(message, this.textStartX ,this.textStartY);
	}
}