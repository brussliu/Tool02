package frame;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public JPanel1 jp1;


    public MainFrame(){

    	this.jp1 = new JPanel1(this);

    	this.add(this.jp1);

    	this.setAlwaysOnTop(true);

    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	this.setLayout(null);
        this.setSize(110, 120);
        this.setLocation(1000, 0);
        this.setVisible(true);
        this.setResizable(false);


    }


}
