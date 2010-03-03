package control;

import processing.core.PImage;

public class CountColonies {
	private ImageHandler ih;
	private int total;
	private PImage img;
	public CountColonies(ImageHandler ih){
		this.ih = ih;
		img = ih.getPImage();
		
	}
	
	public boolean count(int x,int y){
		total = 0;
		final int a = x;
		final int b = y;
		for (int i = a-1; i < a+2; i++) {
			for (int j = b-1; j < b+2; j++) {
				if(img.get(i, j)== -1){
					total+=1;
				}
			}
		}
		
		if(total>=6){
			img.set(a, b, 0);
//			if(this.count(a-1,b)){}
//			if(this.count(a,b-1)){}
//			if(this.count(a+1,b)){}
//			if(this.count(a,b+1)){}
//			
			return true;
		}
		
		return false;
	}
}
