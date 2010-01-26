package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ImagePanel1;
public class BrowseHandler extends MouseAdapter{
	private JFileChooser chooser;
	private JTextField filePath;
	public ImagePanel1 IP;
	public ImagePanel1 copyIP;
	private String path;
	public BrowseHandler(JTextField filepath,ImagePanel1 IP){
		filePath = filepath;
		this.IP=IP;
		chooser = new JFileChooser();
		chooser.addChoosableFileFilter(new FilterFile(".jpeg","JPEG ImageFile"));
		chooser.addChoosableFileFilter(new FilterFile(".jpg","JPG ImageFile"));
		chooser.addChoosableFileFilter(new FilterFile(".bmp","BMP ImageFile"));
		chooser.addChoosableFileFilter(new FilterFile(".png","PNG ImageFile"));
		chooser.addChoosableFileFilter(new FilterFile(".tiff","TIFF ImageFile"));
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		super.mouseClicked(me);
		int decision = chooser.showOpenDialog(null);
		if(decision == JFileChooser.APPROVE_OPTION){
			System.out.println("APPROVED"); 
			path = chooser.getSelectedFile().getAbsolutePath();
			 filePath.setText(path);
			copyIP = new ImagePanel1(path);
			IP=copyIP;
		}
		if(decision == JFileChooser.ERROR_OPTION){
			filePath.setText("Error occured");
		}
		if(decision == JFileChooser.CANCEL_OPTION){
			filePath.setText("Please Select file");
		}
	}
	
	public String returnPath(){
		return path;
	}

}
