package unl.soc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This is a collection of utility methods for manipulating images in a variety
 * of formats (jpg, bmp, gif, png, etc.).
 * 
 * For the purposes of these utilities, images are represented by a
 * 2-dimensional array of {@link RGB} elements (pixels).
 * 
 * The dimensions are assumed to be height x width (h x w). The first dimension
 * is considered to be the height (number of rows of pixels) and the second is
 * considered to be the width (number of columns of pixels). It is assumed that
 * all rows and all columns are uniform in their length.
 *
 */
public class ImageUtils {

	/**
	 * Loads an image from the file specified by the given <code>filePath</code>.
	 * 
	 * @param filePath
	 * @return
	 */
	public static RGB[][] loadImage(String filePath) {
		File file = new File(filePath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		RGB pixels[][] = new RGB[img.getHeight()][img.getWidth()];
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				int p = img.getRGB(x, y);
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;
				pixels[y][x] = new RGB(r, g, b);
			}
		}
		return pixels;
	}

	/**
	 * Saves the given image to the file specified by the given
	 * <code>filePath</code>
	 * 
	 * @param filePath
	 * @param image
	 */
	public static void saveImage(String filePath, RGB image[][]) {
		String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
		BufferedImage newImg = new BufferedImage(image[0].length, image.length, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < newImg.getHeight(); y++) {
			for (int x = 0; x < newImg.getWidth(); x++) {
				int p = (image[y][x].getRed() << 16) + (image[y][x].getGreen() << 8) + image[y][x].getBlue();
				newImg.setRGB(x, y, p);
			}
		}

		File f = new File(filePath);
		try {
			ImageIO.write(newImg, extension, f);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Creates a deep copy of the given image represented as a 2-D matrix of
	 * {@link RGB} values
	 * 
	 * @param image
	 * @return
	 */
	public static RGB[][] copyImage(RGB image[][]) {

		RGB[][] copy = new RGB[image.length][];
		for (int i = 0; i < image.length; i++) {
			copy[i] = new RGB[image[i].length];
			for (int j = 0; j < image[i].length; j++) {
				copy[i][j] = image[i][j];
			}
		}
		return copy;
	}

	/**
	 * Converts the given image to gray scale using the averaging method as
	 * implemented in {@link ColorUtils#toGrayScaleAverage()}
	 * 
	 * @param image
	 */
	public static void imageToGrayScaleAverage(RGB image[][]) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				image[i][j] = ColorUtils.toGrayScaleAverage(image[i][j]);
			}
		}
	}

	/**
	 * Converts the given image to gray scale using the averaging method as
	 * implemented in {@link ColorUtils#toGrayScaleLightness()}
	 * 
	 * @param image
	 */
	public static void imageToGrayScaleLightness(RGB image[][]) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				image[i][j] = ColorUtils.toGrayScaleLightness(image[i][j]);
			}
		}
	}

	/**
	 * Converts the given image to gray scale using the averaging method as
	 * implemented in {@link ColorUtils#toGrayScaleLuminosity()}
	 * 
	 * @param image
	 */
	public static void imageToGrayScaleLuminosity(RGB image[][]) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				image[i][j] = ColorUtils.toGrayScaleLuminosity(image[i][j]);
			}
		}
	}

	/**
	 * Converts the given image to a sepia-toned imaged as implemented in
	 * {@link ColorUtils#toSepia()}
	 * 
	 * @param image
	 */
	public static void imageToSepia(RGB image[][]) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				image[i][j] = ColorUtils.toSepia(image[i][j]);
			}
		}
	}

}
