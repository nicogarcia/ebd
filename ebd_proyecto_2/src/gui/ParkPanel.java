package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ParkPanel extends JPanel implements MouseMotionListener,
		MouseListener {

	Image img;
	Ellipse2D ellipse;
	Image mouse;
	Rectangle2D imgBounds;
	Point mousePos = new Point(0, 0);
	ParkingScreen parent;

	public ParkPanel(ParkingScreen pk) {
		super();
		parent = pk;
		ellipse = new Ellipse2D.Double(255, 435, 50, 50);
		imgBounds = new Rectangle2D.Double();

		try {
			mouse = ImageIO.read(getClass().getClassLoader().getResource(
					"img/cospel.png"));
			img = ImageIO.read(getClass().getClassLoader().getResource(
					"img/parq.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB),
				new Point(0, 0), "name"));
		imgBounds.setFrame(new Point(350 - img.getWidth(null)/2, 0), new Dimension(img.getWidth(null),
				img.getHeight(null)));
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D e = (Graphics2D) g;

		e.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		e.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		e.drawImage(img, (int) imgBounds.getX(), (int) imgBounds.getY(),
				img.getWidth(null), img.getHeight(null), null);

		e.setColor(Color.yellow);
		e.setStroke(new BasicStroke(5));
		//e.draw(ellipse);
		
		e.setColor(Color.yellow);
		e.setFont(new Font("arial", Font.BOLD, 20));
		//e.drawString("Introduzca el cospel", 200, 520);

		g.drawImage(mouse, mousePos.x - 32, mousePos.y - 32, 48, 108, null);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mousePos = arg0.getPoint();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (ellipse.contains(arg0.getPoint())) {
			setCursor(Cursor.getDefaultCursor());
			parent.conectar();
			setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
					new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB),
					new Point(0, 0), "name"));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
