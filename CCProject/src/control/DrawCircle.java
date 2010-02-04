package control;

import processing.core.PApplet;

public class DrawCircle extends PApplet {
//	private float rad;
//	public DrawCircle(){
//		//this.rad=zoom;
//	}
	public void setup(){
		size(550,400);
		//background(0,0,0,255);
	}
	public void draw(float zoom){
		pushMatrix();
		//fill(0,0,0,255);
		//rect(0,0,550,400);
		stroke(255,0,0);
		strokeWeight(3);
		ellipse(height/2, width/2, zoom, zoom);
		popMatrix();
	}
}
