package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ImageHandler;

public class ImageTransferEvent extends MouseAdapter {
	//private String path;
	private ImageHandler ih1,ih2;
	public ImageTransferEvent(ImageHandler ih1,ImageHandler ih2){
		//this.path = path;
		this.ih2 = ih2;
		this.ih1 = ih1;
		
	}
	
	public void mouseClicked(MouseEvent me){
		super.mouseClicked(me);
//		ReadImage ri = new  ReadImage(ih1.getFilePath());
//		this.path = ri.WriteImage();
//		ih2.setFilePath(path);
		ih2.getSubImage(ih1.getPImage());
		ih2.redraw();
		
	}
}
