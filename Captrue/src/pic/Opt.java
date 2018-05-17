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

	static int startR = 130;

	static int startC = 35;
	static int endC = 1250;

	static int compareR = 10;
	static int compareC_start = 51;
	static int compareC_end = 1000;


//	public static ArrayList<int[][]> changePicToData(ArrayList<File> fileList) {
//
//		ArrayList<int[][]> dl = new ArrayList<int[][]>();
//
//    	try {
//
//	        Collections.sort(fileList, new Comparator<File>() {
//
//	            @Override
//	            public int compare(File o1, File o2) {
//
//	                if (o1.isDirectory() && o2.isFile())
//	                    return -1;
//	                if (o1.isFile() && o2.isDirectory())
//	                    return 1;
//	                return o1.getName().compareTo(o2.getName());
//
//	            }
//
//	        });
//
//			for(int i = 0;i < fileList.size(); i ++){
//
//				File pf = fileList.get(i);
//
//				BufferedImage bi = ImageIO.read(pf);
//
//				int [][] data = new int[bi.getWidth()][bi.getHeight()];
//
//			    for(int w = 0;w < bi.getWidth();w ++){
//			        for(int h = 0;h < bi.getHeight();h++){
//			            data[w][h] = bi.getRGB(w,h);
//			        }
//			    }
//
//			    dl.add(data);
//
////			    int width = bi.getWidth();
////			    int height = bi.getHeight();
////			    int start = 0;
//
////			    if(i > 1){
////			    	start = startR;
////			    	height = height - startR;
////			    }
////
////			    int [][] data = new int[endC-startC][height];
////
////			    for(int w = startC;w < endC;w ++){
////			        for(int h = start;h < bi.getHeight();h++){
////			            data[w-startC][h-start] = bi.getRGB(w,h);
////			        }
////			    }
//
//
//			}
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//		return dl;
//
//	}
//
//
//	public static ArrayList<int[][]> collectPicData(ArrayList<int[][]> dataList) {
//
//		ArrayList<int[][]> newDataList = new ArrayList<int[][]>();
//
//
//		int [][] headData = dataList.get(0);
//
//		int [] headPosition = getHeadPosion(headData);
//
//		headData = getDataByPosition(headData,headPosition);
//		newDataList.add(headData);
//
//
//		for(int i = 1;i < dataList.size();i ++){
//
//			int [][] data = dataList.get(i);
//
//			int[] position = getPosition(data);
//
//			data = getDataByPosition(data,position);
//
//			newDataList.add(data);
//		}
//
//		return newDataList;
//	}
//
//
//	private static int[] getPosition(int[][] data) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	private static int[][] getDataByPosition(int[][] headData, int[] headPosition) {
//
//		int x1 = headPosition[0];
//		int x2 = headPosition[1];
//		int y1 = headPosition[2];
//		int y2 = headPosition[3];
//
//		int[][] data = new int[x2-x1][y2-y1];
//
//		for(int i = 0;i < data.length;i ++){
//
//			for(int j = 0;j < data[0].length;j ++){
//
//				data[i][j] = headData[x1 + i][y1 + j];
//
//			}
//
//		}
//
//		return data;
//	}
//
//
//	private static int[] getHeadPosion(int[][] headData) {
//
//		int [] top_left;
//
//		int [] top_right;
//
//		int [] buttom_left;
//
//		int [] buttom_right;
//
//		File fc1 = new File("");
//		int[] p1 = getPositon(headData,fc1);
//		top_left = p1;
//
//		File fc2 = new File("");
//		int[] p2 = getPositon(headData,fc2);
//		top_right = p2;
//
//		File fc3 = new File("");
//		int[] p3 = getPositon(headData,fc3);
//		buttom_left = p3;
//
//		File fc4 = new File("");
//		int[] p4 = getPositon(headData,fc4);
//		buttom_right = p4;
//
//		int x1 = top_left[0];
//		int x2 = buttom_right[0];
//		int y1 = top_left[1];
//		int y2 = buttom_right[1];
//
//		return new int[]{x1,x2,y1,y2};
//	}
//
//
//	private static int[] getPositon(int[][] data,File fc) {
//
//		try {
//
//			BufferedImage bc = ImageIO.read(fc);
//
//			int[][] cd = new int[bc.getWidth()][bc.getHeight()];
//		    for(int w = 0;w < bc.getWidth();w ++){
//		        for(int h = 0;h < bc.getHeight();h++){
//		            cd[w][h] = bc.getRGB(w,h);
//		        }
//		    }
//
//		    int w_start = 0;
//		    int w_end = data.length - cd.length;
//
//		    int h_start = 0;
//		    int h_end = data[0].length - cd[0].length;
//
//		    for(int m = w_start;m < w_end;m ++){
//		    	for(int n = h_start;n < h_end;n ++){
//		    		if(compare(data,m,n,cd) == true){
//		    			return new int[]{m,n};
//		    		}
//		    	}
//		    }
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	private boolean compare(int[][] data, int m, int n, int[][] cd) {
//
//		for(int w = 0;w < cd.length;w ++){
//			for(int h = 0;h < cd[w].length;h ++){
//				if(cd[w][h] != data[w + m][h + n]){
//					return false;
//				}
//			}
//
//		}
//
//		return true;
//	}
//
//	public int[][] mergeBigData(ArrayList<int[][]> dl) {
//
//		int[][] bigData = null;
//
//		for(int i = 0;i < dl.size();i ++){
//
//			int[][] d = dl.get(i);
//
////			makePic(d,Integer.toString(i));
//
//			if(i == 0){
//
//				bigData = d;
//
//			}else if(i > 0){
//
//				int c_w = compareC_end - compareC_start;
//				int c_h = compareR;
//
//				int [][] cd = new int[c_w][c_h];
//
//				for(int m = 0;m < c_w;m ++){
//					for(int n = 0;n < c_h;n ++){
//						cd[m][n] = d[m + compareC_start][n];
//					}
//				}
//
////				int[][] lastData = dl.get(i-1);
//				int line = getLastPicEnd(bigData,cd);
//
//				System.out.println(line);
//
//				bigData = makeBigData(bigData,line,d);
//
//			}
//
//		}
//
//		makePic(bigData,"zzz");
//
//		return bigData;
//
//	}
//
//
//	private int[][] makeBigData(int[][] bigData, int line, int[][] d) {
//
//		int w = bigData.length;
//		int h = line + d[0].length;
//
//		int[][] newBigData = new int[w][h];
//
//		for(int m = 0;m < w;m ++){
//			for(int n = 0;n < h;n ++){
//
//				if(n <= line){
//
//					newBigData[m][n] = bigData[m][n];
//
//				}else{
//					newBigData[m][n] = d[m][n-line];
//
//				}
//
//
//			}
//		}
//
//		return newBigData;
//	}
//
//	private int getLastPicEnd(int[][] d, int[][] cd) {
//
//		int picEnd = d[0].length - cd[0].length;
////		makePic(d,"big");
////		makePic(cd,"cd");
//		for(int Y = picEnd;Y >= 0;Y --){
//
//			int[][] cd0 = getPartData(d,compareC_start,Y,cd.length,cd[0].length);
//
////			makePic(cd0,"cd0");
////			makePic(cd,"cd");
//
//			if(compartData(cd0,cd) == true){
//				return Y;
//			}
//
//		}
//
//		return 0;
//	}
//
//	public void makePic(int[][] data, String name) {
//
//		try {
//
//			int width = data.length;
//			int height = data[0].length;
//
//			int d[] = changeArray(data);
//
//			BufferedImage newImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
//
//			newImg.setRGB(0,0,width,height,d,0,width);
//
//			File outFile = new File(path + "\\" + name + ".png");
//			ImageIO.write(newImg,   "png",   outFile);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//
//	private int[] changeArray(int[][] data) {
//
//		int w = data.length;
//		int h = data[0].length;
//
//		int[] d = new int[w * h];
//
//
//		for(int y = 0;y < data[0].length;y ++){
//
//			for(int x = 0;x < data.length;x ++){
//
//				int index = y * w + x;
//				d[index] = data[x][y];
//
//			}
//		}
//
//
//		return d;
//	}
//
//
//
//	private boolean compartData(int[][] cd0, int[][] cd) {
//
//		if(cd0.length != cd.length){
//			return false;
//		}
//
//		for(int i = 0;i < cd0.length;i ++){
//
//			if(cd0[i].length != cd[i].length){
//				return false;
//			}
//
//			for(int j = 0;j < cd0[i].length;j ++){
//
//				if(cd0[i][j] != cd[i][j]){
//
//					return false;
//				}
//
//			}
//
//		}
//
//		return true;
//	}
//
//	private int[][] getPartData(int[][] d, int startX,int startY,int w,int h) {
//
//
//		int[][] nd = new int[w][h];
//
//		for(int m = 0;m < w;m++){
//			for(int n = 0;n < h;n ++){
//
//				nd[m][n] = d[startX + m][startY + n];
//
//			}
//
//		}
//
//
//		return nd;
//	}





}
