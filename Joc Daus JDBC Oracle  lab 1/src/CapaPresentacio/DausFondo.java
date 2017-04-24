package CapaPresentacio;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DausFondo extends JPanel {

	private Image backgroundImage;

	public DausFondo() {
		String filename = "dausVermells.jpg";
		try {
			backgroundImage = ImageIO.read(new File("imatges/" + filename));

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	
		g.drawImage(backgroundImage, 0, 0, this);
	}


}
