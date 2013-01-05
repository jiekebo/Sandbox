package com.jiekebo.OldSchool.tunnel;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class TunnelCanvas extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 256;
	private static final int HEIGHT = 256;
	private static final int SCALE = 1;
	private static final int FPS = 10;

	private long timer;
	private BufferedImage img;
	private int[] pixels;
	private int[][] texture;
	private int[][] distanceTable;
	private int[][] angleTable;
	
	private Thread tunnel;
	
	int i = 200;

	public TunnelCanvas() {
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setSize(size);

		// Generate standard XOR-texture

		texture = new int[WIDTH][HEIGHT];
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				int c = x ^ y;
				int blue = c;
				// int green = c << 8;
				// int red = c << 16;

				texture[x][y] = blue;
			}
		}
		
		int w = getWidth();
		int h = getHeight();

		img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

		distanceTable = new int[w][h];
		angleTable = new int[w][h];

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int angle;
				int distance;
				float ratio = 32.0f;
				distance = (int) (ratio * WIDTH / Math.sqrt((x - w / 2.0) * (x - w / 2.0) + (y - h / 2.0) * (y - h / 2.0))) % WIDTH;
				angle = (int) (0.5 * WIDTH * Math.atan2(y - h / 2.0, x - w / 2.0) / 3.1416);
				distanceTable[x][y] = distance;
				angleTable[x][y] = angle;
			}
		}

		tunnel = new Thread(this);
		tunnel.start();
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();

		img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

		distanceTable = new int[w][h];
		angleTable = new int[w][h];

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int angle;
				int distance;
				float ratio = 32.0f;
				distance = (int) (ratio * WIDTH / Math.sqrt((x - w / 2.0) * (x - w / 2.0) + (y - h / 2.0) * (y - h / 2.0))) % WIDTH;
				angle = (int) (0.5 * WIDTH * Math.atan2(y - h / 2.0, x - w / 2.0) / 3.1416);
				distanceTable[x][y] = distance;
				angleTable[x][y] = angle;
			}
		}

		g.fillRect(0, 0, getWidth(), getHeight());

		double animation = i;

		// calculate the shift values out of the animation value
		int shiftX = (int) (WIDTH * 1.0 * animation);
		int shiftY = (int) (HEIGHT * 0.25 * animation);

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				// get the texel from the texture by using the tables, shifted
				// with the animation values
				int a = (distanceTable[x][y] + shiftX) % WIDTH;
				int b = (angleTable[x][y] + shiftY) % HEIGHT;

				pixels[x + y * w] = texture[a][b];
			}
		}
		g.drawImage(img, 0, 0, getWidth() * SCALE, getHeight() * SCALE, null);
		i++;
	}

	@Override
	public void run() {
		while (true) {
			updateImage();
		}
	}

	public synchronized void updateImage() {
		repaint();
		long t = System.currentTimeMillis();
		if ((timer -= t - (1000L / FPS)) > 0)
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {

			}
		timer = System.currentTimeMillis();
	}
}