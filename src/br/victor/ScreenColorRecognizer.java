package br.victor;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

import br.victor.utils.ColorUtils;

public class ScreenColorRecognizer {

	private static Robot robo;
	private static ColorUtils cu;
	public ScreenColorRecognizer() throws AWTException {
		Robot robo = new Robot();
		ScreenColorRecognizer.robo = robo;
	}

	public static void main(String[] args) {
		try {
			new ScreenColorRecognizer();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		getColorFromPixel(100, 100);
	}

	private static void getColorFromPixel(int x, int y) {
		Color c = robo.getPixelColor(x, y);
		String colorname = cu.getColorNameFromColor(c);
		System.out.println(colorname);
	}

	public static Point getPoint() {
		return MouseInfo.getPointerInfo().getLocation();
	}
	
	public static void Y_MOVE(int pixels) throws AWTException {
		robo.mouseMove(X_GET(), (Y_GET() + pixels));
	}

	public static void X_MOVE(int pixels) throws AWTException {
		robo.mouseMove((X_GET() + pixels), Y_GET());
	}

	public static int X_GET() {
		return getPoint().x;
	}

	public static int Y_GET() {
		return getPoint().y;
	}

	public static int getPixelCord(char p) {
		return (p == 'x') ? getPoint().x : getPoint().y;
	}

}