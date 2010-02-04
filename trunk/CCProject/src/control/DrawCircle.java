package control;

import processing.core.PApplet;

public class DrawCircle extends PApplet {
	private float rad;
	public DrawCircle(float zoom){
		this.rad=zoom;
	}
	public void setup(){
		size(550,400);
		background(0,0,0,255);
	}
	public void draw(){
		rect(0,0,550,400);fill(0,0,0,255);
		
		ellipse(mouseX, mouseY, rad, rad);
	}
}
