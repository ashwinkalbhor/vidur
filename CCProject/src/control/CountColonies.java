package control;

import processing.core.PImage;
import processing.core.*;
public class CountColonies {
	//private ImageHandler ih;
	private int total;
	private PImage img;
	public CountColonies(PImage img){
		this.img=img;
		
	}
	
	public boolean count(int x,int y){
		//img = ih.gettempImage();
		
		total = 0;
		//int a = x;
		//int b = y;
		if(x>2 && y>2 && x<img.width-2 && y<img.height-2){
		for (int i = x-1; i < x+2; i++) {
			for (int j = y-1; j < y+2; j++) {
				if(img.get(i, j)== -16777216){
					total+=1;
				}
			}
		}
		
		if(total==9){
			//CountColonies cc = new CountColonies(img);
			if(count((int)(x+1),y)){}
			if(count(x,(int)(y+1))){}
//			if(count((int)(x-1),y)){}
//			if(count(x,(int)(y-1))){}
//	    	
//			//System.out.println("hi");
			this.img.set(x, y,255);
			
			return true;
		}
		}
		return false;
	}
}
