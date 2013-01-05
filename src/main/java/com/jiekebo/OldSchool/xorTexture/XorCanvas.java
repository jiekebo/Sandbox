package com.jiekebo.OldSchool.xorTexture;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class XorCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 1024;
	private static final int SCALE = 1;

	private BufferedImage img;
	private int[] pixels;

	public XorCanvas() {
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setSize(size);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		g.fillRect(0, 0, getWidth(), getHeight());
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				int c = x ^ y;
				int blue = c;
				int green = c << 8;
				int red = c << 16;
				// red = 255 - red;
				// blue = blue % 128;

				pixels[x + y * WIDTH] = red;
			}
		}
		g.drawImage(img, 0, 0, getWidth() * SCALE, getHeight() * SCALE, null);
	}
}