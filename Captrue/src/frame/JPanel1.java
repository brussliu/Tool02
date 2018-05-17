package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import pic.Cap;

public class JPanel1 extends JPanel{

	private static final long serialVersionUID = 1L;

	public JButton jb1;

	public JComboBox<String> jcb1;

    public static ArrayList<File> fileList = new ArrayList<File>();

    public JPanel1(MainFrame mf){

    	this.setBorder(BorderFactory.createTitledBorder("Captrue"));

        this.jb1 = new JButton("Captrue");

        this.jcb1.addItem("XXXXX");


        this.setBounds(5, 5, 100, 85);
        this.jcb1.setBounds(10, 20, 80, 25);
        this.jb1.setBounds(10, 50, 80, 25);


        this.jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


//            	jb2.setEnabled(true);
//
//            	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//            	Rectangle screenRectangle = new Rectangle(screenSize);
//
//            	try {
//
//					Robot robot = new Robot();
//					BufferedImage image = robot.createScreenCapture(screenRectangle);
//
//					String fileName = new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date());
//
//					File picFolder = new File(Constent.PIC_PATH);
//					if(picFolder.exists() == false){
//
//						picFolder.mkdirs();
//					}
//
//					File screenFile = new File(Constent.PIC_PATH + fileName + ".png");
//
//					ImageIO.write(image, "png", screenFile);
//
//					fileList.add(screenFile);
//
//				} catch (AWTException | IOException e1) {
//					e1.printStackTrace();
//				}

            	ArrayList<String[]> dl = new ArrayList<String[]>();

            	dl.add(new String[]{"01","300,000","AAA"});
            	dl.add(new String[]{"02","200,000","BBB"});
            	dl.add(new String[]{"03","100,000","CCC"});

            	Cap.makePic(dl);
            }
        });

    	this.add(this.jcb1);
    	this.add(this.jb1);


    	this.setLayout(null);

    }

}
