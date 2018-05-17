package pic;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import common.Constent;

public class Cap {


	public static void makePic(ArrayList<String[]> dl) {

		for(int i = 0;i < dl.size();i ++){

			int[][] noPic = getNoPic(i+1);

			String level = dl.get(i)[0];
			int[][] levelPic = getLevelPic(i);

			String count = dl.get(i)[1];
			int[][] countPic = getCountPic(count);

			String name = dl.get(i)[2];
			int[][] namePic = getNamePic(name);

		}

		// TODO Auto-generated method stub

	}

	private static int[][] getNamePic(String name) {

		// L‚³
		int width = 100;
		// ‚‚³
		int height = 50;
		// font
		Font font = new Font("‚l‚r ‚oƒSƒVƒbƒN", Font.BOLD, 10);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.setClip(0, 0, width, height);
		// ”wŒiF
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		//@•¶ŽšF
		g.setColor(Color.red);
		g.setFont(font);

		Rectangle clip = g.getClipBounds();
		FontMetrics fm = g.getFontMetrics(font);
		int ascent = fm.getAscent();
		int descent = fm.getDescent();
		//ã‰º‚Ì^‚ñ’†
		int y = (clip.height - (ascent + descent)) / 2 + ascent;

		//@•¶Žš‹LÚ
		g.drawString(name, 10, y);

		g.dispose();


		int[][] data = new int[image.getWidth()][image.getHeight()];
		for(int w = 0;w < image.getWidth();w ++){
		    for(int h = 0;h < image.getHeight();h++){
		        data[w][h] = image.getRGB(w,h);
		    }
		}

		return data;

	}

	private static int[][] getCountPic(String count) {

		int[][] data = new int[0][0];

		try {

			for(int i = 0;i < count.length();i ++){

				String c = count.substring(i, i + 1);

				File f = new File(Constent.PIC_PATH + "count" + c + ".png");

				int[][] countData = readPicToData(f);

				data = mergeData(data,countData,1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static int[][] mergeData(int[][] data, int[][] addData, int flg) {

		// ‰¡
		if(flg == 1){

			int w1 = data.length;
			int w2 = addData.length;
			int h = data.length;
			int[][] newdata = new int[w1 + w2][h];

			for(int i = 0;i < newdata.length;i ++){
				for(int j = 0;j < newdata[i].length;j ++){
					if(i <= w1){
						newdata[i][j] = data[i][j];

					}else{
						newdata[i][j] = addData[i-w1][j];
					}
				}
			}

			return newdata;
		// c
		}else if(flg == 2){

			int w = data.length;
			int h1 = data[0].length;
			int h2 = addData[0].length;

			int[][] newdata = new int[w][h1 + h2];

			for(int i = 0;i < newdata.length;i ++){
				for(int j = 0;j < newdata[i].length;j ++){
					if(j <= h1){
						newdata[i][j] = data[i][j];

					}else{
						newdata[i][j] = addData[i][j - h1];
					}
				}
			}


		}

		// TODO Auto-generated method stub
		return null;
	}

	private static int[][] getLevelPic(int i) {

		File f = new File(Constent.PIC_PATH + "level" + String.format("%02d", i) + ".png");

		int[][] data = readPicToData(f);

		return data;
	}

	private static int[][] getNoPic(int i) {

		File f = new File(Constent.PIC_PATH + "no" + String.format("%02d", i) + ".png");


		int[][] data = readPicToData(f);

		return data;
	}


	private static int[][] readPicToData(File f) {

	    try {

			BufferedImage bi = ImageIO.read(f);

			int[][] data = new int[bi.getWidth()][bi.getHeight()];
			for(int w = 0;w < bi.getWidth();w ++){
			    for(int h = 0;h < bi.getHeight();h++){
			        data[w][h] = bi.getRGB(w,h);
			    }
			}

			return data;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;



	}

}
