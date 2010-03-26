package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;

import control.CountColonies;
import control.ImageHandler;

public class ProcessImageEvent extends MouseAdapter {
	private ImageHandler ih;
	private int counter;
	private JTextField count;
	private CountColonies cc;

	public ProcessImageEvent(ImageHandler ih, JTextField count) {
		this.ih = ih;
		this.count = count;
	}

	@Override
	public void mousePressed(MouseEvent me) {
		File outFile=new File("F:/Ashwin/bioinfo/output_1.txt");
		FileWriter outs = null;
		try {
			outs = new FileWriter(outFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//outs.write(b + "\n");
		
		
		// working with images with black colonies against white background
		// eg.Ecoli.jpg
		super.mousePressed(me);
		cc = new CountColonies(ih, ih.getPImage());
		for (int i = 0; i < ih.getPImage().height; i++) {
			for (int j = 0; j < ih.getPImage().width; j++) {
				try {
					if(ih.getPImage().get(i, j)== -1){
					outs.write(0+"");
					}
					else if(ih.getPImage().get(i, j)== -16777216){
						outs.write(1+"");
						
					}
					else
					{
						outs.write(0+"");
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			try {
				outs.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			cc.count(ih.getPImage());
		counter = cc.getColonyCount();
//		System.out.println(Messages.getString("ProcessImageEvent.0") + counter); //$NON-NLS-1$
		count.setText(Messages.getString("ProcessImageEvent.1") + counter); //$NON-NLS-1$
	}

}
