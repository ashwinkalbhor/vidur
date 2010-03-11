package control;

import processing.core.PImage;

//import processing.core.*;
public class CountColonies {
	private ImageHandler ih;
	private int totalColonies = 0;
	private int incr=0;
	private PImage img;

	public CountColonies(ImageHandler ih, PImage img) {
		this.img = img;
		this.ih = ih;
//		for (int i = 0; i < this.img.height; i++) {
//			for (int j = 0; j < this.img.width; j++) {
//				System.out.print(this.img.get(i, j)+"\t");
//				
//			}
//			System.out.println();
//			
//		}
		//System.out.println(img.width+"\t"+img.height);
	}

	public void clean(int x, int y) {
		int a = x;
		int b = y;
		if (a > 2 && b > 2 && a < this.img.width - 2 && b < this.img.height - 2) {
			try{
				while( b>0 && this.img.get(a , b) == -16777216){
					while(a>0 && this.img.get(a , b) == -16777216){
						this.img.set(a , b, -1);
						a--;
					}
					a=x+1;
					while(a < this.img.width - 1 && this.img.get(a , b) == -16777216){
						this.img.set(a , b, -1);
						a++;
					}
					b--;
				}
				b=y+1;
				while(b < this.img.height - 1 && this.img.get(a , b) == -16777216){
					while(a>0 && this.img.get(a , b) == -16777216){
						this.img.set(a , b, -1);
						a--;
					}
					a=x;
					while(a < this.img.width - 1 && this.img.get(a , b) == -16777216){
						this.img.set(a , b, -1);
						a++;
					}
					b++;					
				}
				/*if (this.img.get(a + 1, b) == -16777216) {
					this.img.set(a + 1, b, 255);
					clean(a + 1, b);
				}
				if (this.img.get(a, b + 1) == -16777216) {
					this.img.set(a, b + 1, 255);
					clean(a, b+1);
				}
				if (this.img.get(a - 1, b) == -16777216) {
					this.img.set(a - 1, b, 255);
					clean(a - 1, b);
				}
				if (this.img.get(a, b - 1) == -16777216) {
					this.img.set(a, b - 1, 255);
					//clean(a, b - 1);
				}*/
				
			}catch(Exception e){
				System.out.println("errot " + e);
			}
			// return true;
		}
		// else {return false;}
	}

	public void count() {
		for (int i = 2; i < this.img.height - 2; i++) {
			for (int j = 2; j < this.img.width - 2; j++) {
				//System.out.println(this.img.get(i, j));
				if (this.neighbours(i, j) == 25) {
					this.img.set(i, j, -1);
					this.clean(i, j);
					this.totalColonies++;
					//System.out.println("HELLO");
				//System.out.println("colonies"+totalColonies);	
				}
				
			}

		}
		this.ih.setPImage(this.img);
		
		//this.ih.setDimForOriginal(this.img);
		this.ih.redraw();
	}

	public int getColonyCount() {
		return this.totalColonies;
	}

	public int neighbours(int a, int b) {
		int totalPixels = 0;
		for (int i = a - 2; i <= a + 2; i++) {
			for (int j = b - 2; j <= b + 2; j++) {
				if (this.img.get(i, j) == -16777216) {
					totalPixels++;
				}
			}
		}
		return totalPixels;
	}
}
