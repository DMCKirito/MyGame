package gameUtils;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageIndexChange {
	
	private int index;
	private BufferedImage bufferedImage;
	private int count;
	private int width;
	private int height;
	
	public ImageIndexChange(int x,Image image)
	{
		this.index = x;
		this.bufferedImage = (BufferedImage)image;
		this.count = 0;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
	}
	
	public Image getImageOfIndex(int i)
	{
		return this.bufferedImage.getSubimage(0, (i-1) * height/index, width, height/index);
	}
	
	public Image NextImageIndex()
	{
		if (count +1 < index) {
			count++;
			return bufferedImage.getSubimage(0, (count -1) * height/index, width, height/index);
		}
		else
		{
			count = 0;
			return bufferedImage.getSubimage(0, (index - 1) * height/index, width, height/index);
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
