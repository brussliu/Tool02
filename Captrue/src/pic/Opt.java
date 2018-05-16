package pic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;

public class Opt {

	String path = "D:\\pic";

	int startR = 130;

	int startC = 35;
	int endC = 1250;

	int compareR = 10;
	int compareC_start = 51;
	int compareC_end = 1000;

	public ArrayList<int[][]> changePicToData() {

		ArrayList<int[][]> dl = new ArrayList<int[][]>();

    	try {

			File folder = new File(path);

			File[] fl0 = folder.listFiles();

	        List<File> fileList = Arrays.asList(fl0);

	        Collections.sort(fileList, new Comparator<File>() {
	            @Override
	            public int compare(File o1, File o2) {
	                if (o1.isDirectory() && o2.isFile())
	                    return -1;
	                if (o1.isFile() && o2.isDirectory())
	                    return 1;
	                return o1.getName().compareTo(o2.getName());
	            }
	        });

	        int no = 0;
			for(int i = 0;i < fileList.size(); i ++){

				File pf = fileList.get(i);

				if(pf.isFile() == false || pf.getName().endsWith(".png") == false){
					continue;
				}
				no = no + 1;

				BufferedImage bi = ImageIO.read(pf);

//			    int width = bi.getWidth();
			    int height = bi.getHeight();
			    int start = 0;

			    if(no > 1){
			    	start = startR;
			    	height = height - startR;
			    }

			    int [][] data = new int[endC-startC][height];

			    for(int w = startC;w < endC;w ++){
			        for(int h = start;h < bi.getHeight();h++){
			            data[w-startC][h-start] = bi.getRGB(w,h);
			        }
			    }

			    dl.add(data);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dl;

	}

	public int[][] mergeBigData(ArrayList<int[][]> dl) {

		int[][] bigData = null;

		for(int i = 0;i < dl.size();i ++){

			int[][] d = dl.get(i);

//			makePic(d,Integer.toString(i));

			if(i == 0){

				bigData = d;

			}else if(i > 0){

				int c_w = compareC_end - compareC_start;
				int c_h = compareR;

				int [][] cd = new int[c_w][c_h];

				for(int m = 0;m < c_w;m ++){
					for(int n = 0;n < c_h;n ++){
						cd[m][n] = d[m + compareC_start][n];
					}
				}

//				int[][] lastData = dl.get(i-1);
				int line = getLastPicEnd(bigData,cd);

				System.out.println(line);

				bigData = makeBigData(bigData,line,d);

			}

		}

		makePic(bigData,"zzz");

		return bigData;

	}


	private int[][] makeBigData(int[][] bigData, int line, int[][] d) {

		int w = bigData.length;
		int h = line + d[0].length;

		int[][] newBigData = new int[w][h];

		for(int m = 0;m < w;m ++){
			for(int n = 0;n < h;n ++){

				if(n <= line){

					newBigData[m][n] = bigData[m][n];

				}else{
					newBigData[m][n] = d[m][n-line];

				}


			}
		}

		return newBigData;
	}

	private int getLastPicEnd(int[][] d, int[][] cd) {

		int picEnd = d[0].length - cd[0].length;
//		makePic(d,"big");
//		makePic(cd,"cd");
		for(int Y = picEnd;Y >= 0;Y --){

			int[][] cd0 = getPartData(d,compareC_start,Y,cd.length,cd[0].length);

//			makePic(cd0,"cd0");
//			makePic(cd,"cd");

			if(compartData(cd0,cd) == true){
				return Y;
			}

		}

		return 0;
	}

	private void makePic(int[][] data, String name) {

		try {

			int width = data.length;
			int height = data[0].length;

			int d[] = changeArray(data);

			BufferedImage newImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

			newImg.setRGB(0,0,width,height,d,0,width);

			File outFile = new File(path + "\\" + name + ".png");
			ImageIO.write(newImg,   "png",   outFile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private int[] changeArray(int[][] data) {

		int w = data.length;
		int h = data[0].length;

		int[] d = new int[w * h];


		for(int y = 0;y < data[0].length;y ++){

			for(int x = 0;x < data.length;x ++){

				int index = y * w + x;
				d[index] = data[x][y];

			}
		}


		return d;
	}



	private boolean compartData(int[][] cd0, int[][] cd) {

		if(cd0.length != cd.length){
			return false;
		}

		for(int i = 0;i < cd0.length;i ++){

			if(cd0[i].length != cd[i].length){
				return false;
			}

			for(int j = 0;j < cd0[i].length;j ++){

				if(cd0[i][j] != cd[i][j]){

					return false;
				}

			}

		}

		return true;
	}

	private int[][] getPartData(int[][] d, int startX,int startY,int w,int h) {


		int[][] nd = new int[w][h];

		for(int m = 0;m < w;m++){
			for(int n = 0;n < h;n ++){

				nd[m][n] = d[startX + m][startY + n];

			}

		}


		return nd;
	}




}
