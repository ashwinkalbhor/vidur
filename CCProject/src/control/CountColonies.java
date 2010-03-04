package control;

import processing.core.PImage;

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
		
		if(total>6){
			CountColonies cc = new CountColonies(img);
			if(cc.count(x-1,y)){}
			if(cc.count(x,y-1)){}
	    	//if(cc.count(x+1,y)){img.set(x, y, 0);}
			//if(cc.count(x,y+1)){img.set(x, y, 0);}
//			//System.out.println("hi");
			
			return true;
		}
		}
		return false;
	}
}
