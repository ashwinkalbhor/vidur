package event;

import gui.ImagePanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class BrowseHandler extends MouseAdapter{
	private JFileChooser chooser;
	private JTextField filePath;
	public ImagePanel ip1,ip2;
	private String path;
	public BrowseHandler(JTextField filepath,ImagePanel ip1,ImagePanel ip2){
		filePath = filepath;
		this.ip1=ip1;
		this.ip2=ip2;
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("data/Images"));
		chooser.addChoosableFileFilter(new FilterFile(".jpeg","JPEG ImageFile"));
		chooser.addChoosableFileFilter(new FilterFile(".jpg","JPG ImageFile"));
		chooser.addChoosableFileFilter(new FilterFile(".bmp","BMP ImageFile"));
		chooser.addChoosableFileFilter(new FilterFile(".png","PNG ImageFile"));
		chooser.addChoosableFileFilter(new FilterFile(".tiff","TIFF ImageFile"));
		chooser.setAcceptAllFileFilterUsed(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		super.mouseClicked(me);
		int decision = chooser.showOpenDialog(null);
		if(decision == JFileChooser.APPROVE_OPTION){
			path = chooser.getSelectedFile().getAbsolutePath();
			filePath.setText(path);
			ip1.getPApplet().setImage(path);
			ip1.getPApplet().setDimForOriginal(ip1.getPApplet().getPImage());
			ip1.getPApplet().redraw();
			}
		if(decision == JFileChooser.ERROR_OPTION){
			filePath.setText("Error occured");
			
		}
		if(decision == JFileChooser.CANCEL_OPTION){
			filePath.setText("Please Select file");
		}
	}
	
	public String returnPath(){
		return filePath.getText();
	}
	

}
