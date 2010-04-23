package gui.events;

//~--- non-JDK imports --------------------------------------------------------

import gui.control.ImagePanel;

//~--- JDK imports ------------------------------------------------------------

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
/**
 * Class provides access to JFileChooser to access the image file.
 * @author ASHWIN
 */
public class BrowseHandler extends MouseAdapter {
    private JFileChooser chooser;
    private JTextField   filePath;
    public ImagePanel    imagePanel1, imagePanel2;
    private String       path;
/**
 * Constructor for BrowseHandler class.
 * @param filepath : Filepath for the image.
 * @param ip1 : Object ImagePanel class.
 * @param ip2 : Object ImagePanel class.
 */
    public BrowseHandler(JTextField filepath, ImagePanel ip1, ImagePanel ip2) {
        filePath = filepath;
        imagePanel1 = ip1;
        imagePanel2 = ip2;
        chooser  = new JFileChooser(
        new File(Messages.getString("BrowseHandler.0")));    // $NON-NLS-1$

        chooser.addChoosableFileFilter(new FilterFile(Messages
        .getString("BrowseHandler.1"), Messages
        .getString("BrowseHandler.2")));
        chooser.addChoosableFileFilter(
        new FilterFile(Messages
        .getString("BrowseHandler.3"),
        Messages.getString("BrowseHandler.4")));
        chooser.addChoosableFileFilter(new FilterFile(Messages
        .getString("BrowseHandler.5"), Messages.getString("BrowseHandler.6")));
        chooser.addChoosableFileFilter(new FilterFile(Messages
        .getString("BrowseHandler.7"), Messages.getString("BrowseHandler.8")));
        chooser.addChoosableFileFilter(new FilterFile(Messages
        .getString("BrowseHandler.9"), Messages.getString("BrowseHandler.10")));
        chooser.setAcceptAllFileFilterUsed(true);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        super.mousePressed(me);

        int decision = chooser.showOpenDialog(null);

        if (decision == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            filePath.setText(path);
            imagePanel1.getPApplet().setPImage(path);
            imagePanel1.getPApplet()
            .setDimForOriginal(imagePanel1.getPApplet().getPImage());
            imagePanel1.getPApplet().redraw();
        }

        if (decision == JFileChooser.ERROR_OPTION) {
        filePath.setText(Messages
        .getString("BrowseHandler.11"));
        }

        if (decision == JFileChooser.CANCEL_OPTION) {
        filePath.setText(Messages.getString("BrowseHandler.12"));
        }
    }

    public final String returnPath() {
        return filePath.getText();
    }
}
