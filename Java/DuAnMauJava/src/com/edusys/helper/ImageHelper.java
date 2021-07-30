package com.edusys.helper;

import java.awt.Image;

public class ImageHelper {
	public static Image resize(Image image, int width, int height) {
		Image reImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return reImage;
	}
}
