package gui.events;

import gui.control.ImagePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
/**
 * Class to browse the image files.
 * @author ASHWIN
 *
 */
public class BrowseHandler extends MouseAdapter {
	private JFileChooser chooser;
	private JTextField filePath;
	public ImagePanel ip1, ip2;
	private String path;

	public BrowseHandler(JTextField filepath, ImagePanel imagePanel1, ImagePanel imagePanel2) {
		filePath = filepath;
		this.ip1 = ip1;
		this.ip2 = ip2;
		chooser = new JFileChooser(new File(Messages
				.getString("BrowseHandler.0"))); //$NON-NLS-1$
		// chooser.changeToParentDirectory();
		// chooser.setCurrentDirectory(new File("data/Images"));
		chooser
				.addChoosableFileFilter(new FilterFile(
						Messages.getString("BrowseHandler.1"), Messages.getString("BrowseHandler.2"))); //$NON-NLS-1$ //$NON-NLS-2$
		chooser
				.addChoosableFileFilter(new FilterFile(
						Messages.getString("BrowseHandler.3"), Messages.getString("BrowseHandler.4"))); //$NON-NLS-1$ //$NON-NLS-2$
		chooser
				.addChoosableFileFilter(new FilterFile(
						Messages.getString("BrowseHandler.5"), Messages.getString("BrowseHandler.6"))); //$NON-NLS-1$ //$NON-NLS-2$
		chooser
				.addChoosableFileFilter(new FilterFile(
						Messages.getString("BrowseHandler.7"), Messages.getString("BrowseHandler.8"))); //$NON-NLS-1$ //$NON-NLS-2$
		chooser
				.addChoosableFileFilter(new FilterFile(
						Messages.getString("BrowseHandler.9"), Messages.getString("BrowseHandler.10"))); //$NON-NLS-1$ //$NON-NLS-2$
		chooser.setAcceptAllFileFilterUsed(true);

	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		int decision = chooser.showOpenDialog(null);
		if (decision == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
			filePath.setText(path);
			ip1.getPApplet().setImage(path);
			ip1.getPApplet().setDimForOriginal(ip1.getPApplet().getPImage());
			ip1.getPApplet().redraw();
		}
		if (decision == JFileChooser.ERROR_OPTION) {
			filePath.setText(Messages.getString("BrowseHandler.11")); //$NON-NLS-1$

		}
		if (decision == JFileChooser.CANCEL_OPTION) {
			filePath.setText(Messages.getString("BrowseHandler.12")); //$NON-NLS-1$
		}
	}

	public final String returnPath() {
		return filePath.getText();
	}

}
