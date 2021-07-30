package help;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
public class ImageEdit {
	public static Image resize(Image image, int width, int height) {
		Image reImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return reImage;
	}
	
	public static byte[] getByteImage(Image img, String type) throws IOException  {
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = bi.createGraphics();
		graphics2d.drawImage(img, 0, 0, null);
		graphics2d.dispose();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bi,type,baos);
		byte[] imageInByte = baos.toByteArray();
		return imageInByte;
	}
	
	public static Image getImage(byte[] data, String type) throws IOException {
		if(data == null) {
			return null;
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		BufferedImage bimage = ImageIO.read(bais);
		Image img = bimage.getScaledInstance(bimage.getWidth(), bimage.getHeight(), Image.SCALE_SMOOTH);
		return img;
	}
	
}
