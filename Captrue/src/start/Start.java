package start;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import frame.MainFrame;

public class Start {


	public static void main(String[] args) {

		MainFrame mf = new MainFrame();


//		String a = "ï∂éö";
//
//		createImage("ï∂éö", new Font("ÇlÇr ÇoÉSÉVÉbÉN", Font.BOLD, 10), new File("D:\\a.png"), 60, 30);

//		Opt opt = new Opt();
//
//		ArrayList<int[][]> dl = opt.changePicToData();
//
//		int[][] bigData = opt.mergeBigData(dl);
//
//		String fileName = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
//
//		opt.makePic(bigData,fileName);


//		//ÇPÅAÉLÉÉÉbÉvÉVÉÉÅ[éÊìæ
//		Cap cap = new Cap();
//
//		cap.output();


	}

	private static void createImage(String str, Font font, File outFile, int width, int height) {


        try {

			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
			Graphics g = image.getGraphics();
			g.setClip(0, 0, width, height);
			g.setColor(Color.black);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.red);
			g.setFont(font);

			Rectangle clip = g.getClipBounds();
			FontMetrics fm = g.getFontMetrics(font);
			int ascent = fm.getAscent();
			int descent = fm.getDescent();
			int y = (clip.height - (ascent + descent)) / 2 + ascent;

			g.drawString(str, 10, y);

			g.dispose();
			ImageIO.write(image, "png", outFile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
