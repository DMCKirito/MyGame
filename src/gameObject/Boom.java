package gameObject;

import java.awt.Graphics;
import java.awt.Image;

import gameUtils.GameUtils;

public class Boom 
{
	private int x = 10;
	private int y = 10;
	private static Image[] images = new Image[34];
	static
	{
		for (int i = 0; i < 34; i++)
		{
			images[i] = GameUtils.getImage("image/boom/" + (i + 1) + ".png");
			images[i].getWidth(null);
		}

	}
	
	public Boom() {}
	
	public Boom(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	
	private int count = 0;
	public void draw(int x, int y, Graphics g)
	{
		this.x = x;
		this.y = y;
		
		if(count < 34)
		{
			g.drawImage(images[count], this.x, this.y, null);
		}
		count++;
	}
}
