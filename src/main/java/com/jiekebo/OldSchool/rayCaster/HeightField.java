package com.jiekebo.OldSchool.rayCaster;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HeightField extends Applet implements KeyListener, Runnable {
	private static final long serialVersionUID = 1L;
	int WIDTH = 640;
	int HEIGHT = 480;
	int DEPTH = 400;
	byte[] height;
	byte[] colorindex;
	double xp, yp;
	int hp, vp;
	double angle = Math.PI / 2;
	int[] paletter;
	int[] paletteg;
	int[] paletteb;
	BufferedImage bimage;
	WritableRaster raster;
	byte[] image;
	private Thread thread;
	private static final int FPS = 25;
	private long timer;
	int lace = 0;

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		// System.out.println(c);
		if (c == KeyEvent.VK_LEFT) {
			angle += 0.1;
		}
		if (c == KeyEvent.VK_RIGHT) {
			angle -= 0.1;
		}
		if (c == KeyEvent.VK_UP) {
			// yp--;
			xp -= 2. * Math.sin(angle);
			yp -= 2. * Math.cos(angle);
		}
		if (c == KeyEvent.VK_DOWN) {
			xp += 2. * Math.sin(angle);
			yp += 2. * Math.cos(angle);

			// yp++;
		}
		if (c == KeyEvent.VK_A) {
			hp += 2;
		}
		if (c == KeyEvent.VK_Z) {
			hp -= 2;
		}

		if (c == KeyEvent.VK_X) {
			vp += 40;
		}
		if (c == KeyEvent.VK_S) {
			vp -= 40;
		}

		repaint();

	}

	public void keyTyped(KeyEvent e) {
	}

	public void init() {
		bimage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		raster = bimage.getRaster();

		height = new byte[0x100000];
		colorindex = new byte[0x100000];
		xp = 512;
		yp = 512;
		hp = 50;
		vp = -HEIGHT / 2;

		image = new byte[WIDTH * HEIGHT];

		byte[] palette = new byte[256 * 3];
		paletter = new int[256];
		paletteg = new int[256];
		paletteb = new int[256];
		for (int k = 0; k < 256; k++) {
			paletter[k] = k;
			paletteg[k] = k;
			paletteb[k] = k;
		}

		try {
			InputStream file_input = this.getClass().getResourceAsStream("rgb.dat");
			BufferedInputStream bfile_input = new BufferedInputStream(file_input);

			bfile_input.read(palette);

			for (int k = 0; k < 256; k++) {
				paletter[k] = (palette[k * 3 + 0] & 0xFF) * 4;
				paletteg[k] = (palette[k * 3 + 1] & 0xFF) * 4;
				paletteb[k] = (palette[k * 3 + 2] & 0xFF) * 4;
			}

		} catch (IOException e) {
			return;
		}

		try {
			InputStream file_input = this.getClass().getResourceAsStream("heightmap.dat");
			BufferedInputStream bfile_input = new BufferedInputStream(file_input);

			bfile_input.read(height);

		} catch (IOException e) {
			return;
		}

		try {
			InputStream file_input = this.getClass().getResourceAsStream("colormap.dat");
			BufferedInputStream bfile_input = new BufferedInputStream(file_input);

			bfile_input.read(colorindex);

		} catch (IOException e) {
			return;
		}

		addKeyListener(this);
		thread = new Thread(this);
		thread.start();
	}

	public void start() {

	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			image[i] = 0;
		}

		for (int i = 0; i < WIDTH; i++) {
			double y3d = -DEPTH;
			double x3d = (i - WIDTH / 2) * 0.7;

			double rotx = Math.cos(angle) * x3d + Math.sin(angle) * y3d;
			double roty = -Math.sin(angle) * x3d + Math.cos(angle) * y3d;

			raycast(i, xp, yp, rotx + xp, roty + yp, y3d / Math.sqrt(/*x3d **/ x3d + y3d * y3d));
		}

		int[] rasterline = new int[WIDTH * 3];

		for (int k = 0; k < HEIGHT; k++) {
			for (int i = 0; i < WIDTH; i++) {
				int ci = image[i + k * WIDTH] & 0xFF;
				rasterline[i * 3 + 0] = paletter[ci];
				rasterline[i * 3 + 1] = paletteg[ci];
				rasterline[i * 3 + 2] = paletteb[ci];
			}
			raster.setPixels(0, k, WIDTH, 1, rasterline);
		}
		g.drawImage(bimage, 0, 0, this);
	}

	/**
	 * Casts rays in vertical strips along the horizontal axis
	 * 
	 * @param line
	 *            Vertical strip position in the image (0 <= line < WIDTH)
	 * @param x1
	 *            X-Position
	 * @param y1
	 *            Y-Position
	 * @param x2
	 *            X-Direction
	 * @param y2
	 *            Y-Direction
	 * @param d
	 *            Distance vector
	 */
	public void raycast(int line, double x1, double y1, double x2, double y2, double d) {
		double dx = x2 - x1;
		double dy = y2 - y1;

		double r = Math.sqrt(dx * dx + dy * dy);
		dx = dx / r;
		dy = dy / r;

		int ymin = HEIGHT;

		for (int i = 0; i < r - 20; i++) {
			x1 += dx;
			y1 += dy;

			byte ci = colorindex[((int) y1 & 1023) * 1024 + ((int) x1 & 1023)];

			int h = height[((int) y1 & 1023) * 1024 + ((int) x1 & 1023)];
			h = 256 - h;
			h = h - 128 + hp;

			// y-fov seems like...
			double y3 = (double) i * Math.abs(1);

			// top points of each voxel
			double z3 = h / y3 * 100 - vp;

			if (z3 < 0) {
				z3 = 0;
			}

			if (z3 < HEIGHT) {
				int offset = (int) z3 * WIDTH + line;
				for (int k = (int) z3; k < ymin; k++) {
					image[offset] = ci;
					offset += WIDTH;
				}
			}

			if (ymin > z3) {
				ymin = (int) z3;
			}
		}
	}

	@Override
	public void run() {
		while (true) {
//			xp -= 2. * Math.sin(angle);
//			yp -= 2. * Math.cos(angle);
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
}
