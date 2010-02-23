package control;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {
	private String path;
	private String subImagePath = "data/test.jpg";
	public ReadImage(String path){
		this.path = path;

		
	}
	public BufferedImage ReadPImage(){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(path));
		} 
		catch (IOException e) {
		}
		
		System.out.println(img.getHeight());
		return img.getSubimage(0, 0, 100, 100);
		}
	
	public String WriteImage(){
		try {
			
			ImageIO.write(ReadPImage(), "JPEG",new File(subImagePath));
			System.out.println("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subImagePath;
	}

}
