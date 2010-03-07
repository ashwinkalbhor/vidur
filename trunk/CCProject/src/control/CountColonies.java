package control;

import processing.core.PImage;
//import processing.core.*;
public class CountColonies {
	private ImageHandler ih;
	private int totalColonies=0;
	
	private PImage img;
	public CountColonies(ImageHandler ih,PImage img){
		this.img=img;
		this.ih = ih;
	}
	
	public void count(){
		for (int i = 2; i < this.img.width-2; i++) {
			for (int j = 2; j < this.img.height-2; j++) {

				if(this.neighbours(i,j) == 25){
					this.img.set(i, j, 255);
					this.clean(i, j);
					this.totalColonies++;
				}
				
			}
			
		}
		this.ih.setPImage(this.img);
		this.ih.redraw();
	}
	
	public void clean(int x,int y){
		int a = x;
		int b = y;
		if(a>1 && b>1 && a<this.img.width-1 && b<this.img.height-1){
		if(this.img.get(a-1, b)== -16777216){
			this.img.set(a-1, b, 255);
			clean(a-1, b);
		}
		if(this.img.get(a, b-1)== -16777216){
			this.img.set(a, b-1, 255);
			clean(a, b-1);
		}
		if(this.img.get(a+1, b)== -16777216){
			this.img.set(a+1, b, 255);
			clean(a+1, b);
		}
		if(this.img.get(a, b+1)== -16777216){
			this.img.set(a, b+1, 255);
			//clean(a, b+1);
		}
		//return true;
		}
		//else {return false;}
	}
	
	public int neighbours(int a,int b){
		int totalPixels = 0;
		for (int i = a-2; i <= a+2; i++) {
			for (int j = b-2; j <= b+2; j++) {
				if(this.img.get(i, j)== -16777216){
					totalPixels++;
				}
			}
		}
		return totalPixels;
	}
	
	public int getColonyCount(){
		return this.totalColonies;
	}
}
