package gui.control;

import gui.events.BrowseHandler;
import gui.events.ClearCircleEvent;
import gui.events.DrawCircleEvent;

import image.control.CalculateControl;
import image.control.ColorControl;
import image.control.ImageColorController;
import image.control.ImageControl;
import image.events.ImageTransferEvent;
import image.events.InvertImage;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.control.ProcessImage;


public class ControlPanel extends JPanel {
	private static final long serialVersionUID = -6581079276015103030L;
	private JTextField filePath;
	private JButton browse;
	private JButton transfer;
	private JButton invert, drawcircle, clearcircle;

	public ControlPanel(ImagePanel ip1, ImagePanel ip2) {
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		setLayout(null);
		filePath = new JTextField(Messages.getString("ControlPanel.0"), 10); //$NON-NLS-1$
		filePath.setLocation(10, 30);
		filePath.setSize(300, 30);
		add(filePath);

		BrowseHandler BH = new BrowseHandler(filePath, ip1, ip2);

		ColorControl colorControl = new ColorControl(ip2.getPApplet());
		colorControl.setBounds(10, 70, 300, 180);
		add(colorControl);

		ImageControl imageControl = new ImageControl(ip1.getPApplet(), ip2
				.getPApplet());
		imageControl.setBounds(800, 20, 300, 100);
		add(imageControl);

		CalculateControl calculate = new CalculateControl(ip2.getPApplet());
		calculate.setBounds(800, 140, 300, 100);
		add(calculate);

		ProcessImage pi = new ProcessImage(ip2.getPApplet());
		pi.setBounds(460, 10, 320, 200);
		add(pi);

		browse = new JButton(Messages.getString("ControlPanel.1")); //$NON-NLS-1$
		browse.setLocation(335, 30);
		browse.setSize(100, 30);
		browse.addMouseListener(BH);
		add(browse);

		invert = new JButton(Messages.getString("ControlPanel.2")); //$NON-NLS-1$
		invert.setLocation(335, 70);
		invert.setSize(100, 30);
		invert.addMouseListener(new InvertImage(ip2.getPApplet()));
		//invert.setEnabled(false);
		add(invert);

		transfer = new JButton(Messages.getString("ControlPanel.3")); //$NON-NLS-1$
		transfer.setLocation(335, 110);
		transfer.setSize(100, 30);
		ImageTransferEvent ite = new ImageTransferEvent(ip1.getPApplet(), ip2
				.getPApplet());
		transfer.addMouseListener(ite);
		add(transfer);

		drawcircle = new JButton(Messages.getString("ControlPanel.4")); //$NON-NLS-1$
		drawcircle.setLocation(335, 150);
		drawcircle.setSize(100, 30);
		DrawCircleEvent dce = new DrawCircleEvent(ip1.getPApplet(),
				new ImageColorController(ip2.getPApplet().getPImage()));
		drawcircle.addMouseListener(dce);
		add(drawcircle);

		clearcircle = new JButton(Messages.getString("ControlPanel.5")); //$NON-NLS-1$
		clearcircle.setLocation(335, 190);
		clearcircle.setSize(100, 30);
		ClearCircleEvent cce = new ClearCircleEvent(ip1.getPApplet());
		clearcircle.addMouseListener(cce);
		add(clearcircle);

	}

}
