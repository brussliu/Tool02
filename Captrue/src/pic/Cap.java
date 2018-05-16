package pic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Cap {

	ArrayList<String> fileList = new ArrayList<String>();
	String path = "D:\\pic\\";

	String cf = "com.png";


	public void output() {

		fileList.add("a.png");
		fileList.add("b.png");
		fileList.add("c.png");
		fileList.add("d.png");
		fileList.add("e.png");
		fileList.add("f.png");
		fileList.add("g.png");



		File f0 = new File(path + fileList.get(0));


		int[] pos = getPositon(f0);


	}



	private int[] getPositon(File f0) {

		try {

			File fc = new File(path + cf);

			BufferedImage bc = ImageIO.read(fc);

			int[][] cd = new int[bc.getWidth()][bc.getHeight()];
		    for(int w = 0;w < bc.getWidth();w ++){
		        for(int h = 0;h < bc.getHeight();h++){
		            cd[w][h] = bc.getRGB(w,h);
		        }
		    }


		    BufferedImage bi = ImageIO.read(f0);

			int[][] data = new int[bi.getWidth()][bi.getHeight()];
		    for(int w = 0;w < bi.getWidth();w ++){
		        for(int h = 0;h < bi.getHeight();h++){
		            data[w][h] = bi.getRGB(w,h);
		        }
		    }

		    int w_start = 0;
		    int w_end = data.length - cd.length;

		    int h_start = 0;
		    int h_end = data[0].length - cd[0].length;

		    for(int m = w_start;m < w_end;m ++){
		    	for(int n = h_start;n < h_end;n ++){

		    		if(compare(data,m,n,cd) == true){

		    			System.out.println(m);
		    			System.out.println(n);

		    			return new int[]{m,n};
		    			//break;
		    		}

		    	}

		    }


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return null;
	}



	private boolean compare(int[][] data, int m, int n, int[][] cd) {

		for(int w = 0;w < cd.length;w ++){
			for(int h = 0;h < cd[w].length;h ++){

				if(cd[w][h] != data[w + m][h + n]){

					return false;
				}

			}

		}


		return true;
	}

}
