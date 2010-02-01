package control;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagePanel1 extends JPanel{
	//private String path;
	//private ImageHandler IH;
	public ImagePanel1(){
		setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		setLayout(null);
		//this.path = path;
		
		//path = new String("data/Images/1.jpg");
	}
	
	public void loadImagePanel(String path){
		
		ImageHandler IH = new ImageHandler(path);
		IH.setBounds(0, 0, 200, 200);
		IH.init();
		IH.start();
		//IH.run();
		IH.setup();
		IH.draw();
		
		
		//IH.stop();
		//IH.destroy();
		//IH.exit();
		//add(IH);
	}
	

}
