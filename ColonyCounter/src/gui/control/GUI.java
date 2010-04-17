package gui.control;


import javax.swing.JFrame;
/**
 * This class handles and displays the ImagePanel's and control panels object.
 * @author ASHWIN
 *
 */
public class GUI extends JFrame {
	private static final long serialVersionUID = -591008432209644219L;
	private String s = Messages.getString("GUI.0"); //$NON-NLS-1$
	private static final int panelHeight = 400;
	private static final int panelWidth = 550;
	private static final int controlPanelWidth=1150;
	private static final int controlPanelHeight=1150;

	public GUI(String frameName, int width, int height) {
		super(frameName);

		ImagePanel ip1 = new ImagePanel(s);
		ip1.setBounds(20, 20, panelWidth, panelHeight);
		this.add(ip1);

		ImagePanel ip2 = new ImagePanel(s);
		ip2.setBounds(600, 20, panelWidth, panelHeight);
		this.add(ip2);

		ControlPanel controlPanel = new ControlPanel(ip1, ip2);
		controlPanel.setBounds(20, 450, controlPanelWidth, controlPanelHeight);
		add(controlPanel);
	}

}
