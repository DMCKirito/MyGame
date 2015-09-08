package gameObject;


import java.awt.Graphics;

import gameUtils.GameUtils;

public class EBullet extends PlaneBullet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EBullet(int x, int y)
	{
		super(x, y);
		image = GameUtils.getImage("image/bullet/0.png");
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(isAlive)
		{
			g.drawImage(image, x, y, null);
			move();
		}
	}
	
	public void move()
	{
		this.y += 5;
	}
}
