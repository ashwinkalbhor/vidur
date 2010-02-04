package event;

import gui.ImagePanel1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BrowseHandler extends MouseAdapter{
	private JFileChooser chooser;
	private JTextField filePath;
	public ImagePanel1 ip;
	//public ImagePanel1 copyIP;
	private String path;
	public BrowseHandler(JTextField filepath,ImagePanel1 ip){
		filePath = filepath;
		this.ip=ip;
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
			ip=new ImagePanel1("data/Images/o157.jpg");
			//ip.setBounds(0, 0, 200, 200);
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
