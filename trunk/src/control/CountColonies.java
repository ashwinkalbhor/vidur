package control;

import processing.core.PImage;

//import processing.core.*;
public class CountColonies {
	private ImageHandler ih;
	private int totalColonies = 0;
	private int incr=0;
	private PImage img;

	public CountColonies(ImageHandler ih, PImage img) {
		//this.img = img;
		this.ih = ih;
		setPImage(img);
	}

	public PImage clean(PImage img,int x, int y) {
		int a = x;
		int b = y;
		//if (a > 2 && b > 2 && a < img.width - 2 && b < img.height - 2) {
			try{
				/*
				while( b>0){
					while(a>0 && img.get(a , b) == -16777216){
						img.set(a , b, -1);
						a--;
					}
					a=x+1;
					while(a < img.width - 1 && img.get(a , b) == -16777216){
						img.set(a , b, -1);
						a++;
					}
					b--;
				}
				b=y+1;
				a=x;
				while(b < img.height - 1){
					while(a>0 && img.get(a , b) == -16777216){
						img.set(a , b, -1);
						a--;
					}
					a=x+1;
					while(a < img.width - 1 && img.get(a , b) == -16777216){
						img.set(a , b, -1);
						a++;
					}
					b++;					
				}*/
				//return img;
				//setPImage(img);
				if (img.get(a + 1, b) == -16777216) {
					img.set(a + 1, b, -1);
					setPImage(img);
					clean(getPImage(),a + 1, b);
				}
				if (img.get(a, b + 1) == -16777216) {
					img.set(a, b + 1, -1);
					setPImage(img);
					clean(getPImage(),a, b+1);
				}
				if (img.get(a - 1, b) == -16777216) {
					img.set(a - 1, b, -1);
					setPImage(img);
					clean(getPImage(),a - 1, b);
				}
				if (img.get(a, b - 1) == -16777216) {
					img.set(a, b - 1, -1);
					setPImage(img);
					clean(getPImage(),a, b - 1);
				}
				
			}catch(Exception e){
				System.out.println("errot " + e);
			}
			// return true;
		
		// else {return false;}
		return img;
	}

	public void count(PImage img) {
		setPImage(img);
		for (int i = 2; i < getPImage().height - 2; i++) {
			for (int j = 2; j < getPImage().width - 2; j++) {
				//System.out.println(this.img.get(i, j));
				if (neighbours(getPImage(),i, j) == 25) {
					totalColonies++;
					setPImage(clean(getPImage(),i, j));
					//ih.setPImage(getPImage());
					//ih.redraw();
					
					//getPImage().set(i, j, -1);
					System.out.println(i+"\t"+j);
					
				}
				else
				{
					//
				}
				
			}

		}
		ih.setPImage(getPImage());
//		
//		//this.ih.setDimForOriginal(this.img);
		ih.redraw();
	}
	public int getColonyCount() {
		return totalColonies;
	}

	public int neighbours(PImage img,int a, int b) {
		int totalPixels = 0;
		for (int i = a - 2; i <= a + 2; i++) {
			for (int j = b - 2; j <= b + 2; j++) {
				if (getPImage().get(i, j) == -16777216) {
					totalPixels++;
				}
			}
		}
		return totalPixels;
	}
	
	public void setPImage(PImage pi){
		img = pi;
	}
	
	public PImage getPImage(){
		return img;
	}
}
