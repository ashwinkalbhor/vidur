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
        chooser  = new JFileChooser(new File("data/Images"));

        chooser.addChoosableFileFilter(new FilterFile(".jpeg","JPEG ImageFile"));
        chooser.addChoosableFileFilter(
        new FilterFile(".jpg", "JPG ImageFile"));
        chooser.addChoosableFileFilter(new FilterFile("bmp", "BMP ImageFile"));
        chooser.addChoosableFileFilter(new FilterFile(".png","PNG ImageFile"));
        chooser.addChoosableFileFilter(new FilterFile(".tiff", "TIFF ImageFile"));
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
        filePath.setText("Error Ocuured in choosing the file");
        }

        if (decision == JFileChooser.CANCEL_OPTION) {
        filePath.setText("Please Select file");
        }
    }

    public final String returnPath() {
        return filePath.getText();
    }
}
