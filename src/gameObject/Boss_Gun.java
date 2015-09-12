package gameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import gameDto.GameDto;
import gameUtils.GameConstant;
import gameUtils.GameUtils;
import gameUtils.ImageIndexChange;

public class Boss_Gun extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x;
	private int y;
	private boolean isAlive;
	private int count;
	ImageIndexChange change  = new ImageIndexChange(4, GameUtils.getImage("image/bullet/5.png"));
	
	public Boss_Gun () {}
	
	public Boss_Gun(int x, int y) 
	{
		setLayout(null);
		setBounds(0, 0, GameConstant.FRAME_WIDTH, GameConstant.FRAME_HEIGHT);
		this.x = x;
		this.y = y;
		count = 0;
		isAlive = true;
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (isAlive) {
			isBoom();
			g.drawImage(change.NextImageIndex(),x - ((int)(change.NextImageIndex().getWidth(null)/2 * Math.pow(1.003,count) - change.NextImageIndex().getWidth(null)/2)), y, 
					(int)(change.NextImageIndex().getWidth(null) * Math.pow(1.003,count)),
					(int)(change.NextImageIndex().getHeight(null) * Math.pow(1.003, count)), null);
			move();
			count ++;
		}
	}
	
	public void isBoom() 
	{
		for(int i = 0; i < GameDto.bullets.size(); i ++)
		{	
			if (GameDto.bullets.get(i).isAlive && GameDto.bullets.get(i).getRectangle().intersects(this.getRectangle()))
			{
				GameDto.bullets.get(i).isAlive = false;
				break;
	        }
		}

	}
	public void move()
	{
		if(this.y > GameConstant.FRAME_HEIGHT)
		{
			this.isAlive = false;
		}
		this.y += 2;
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle((int)this.x - ((int)(change.NextImageIndex().getWidth(null)/2 * Math.pow(1.003,count) - change.NextImageIndex().getWidth(null)/2)),(int)this.y,
				(int)(change.NextImageIndex().getWidth(null) * Math.pow(1.003,count) - 5*Math.pow(1.003, count)),
				(int)(change.NextImageIndex().getHeight(null) * Math.pow(1.003, count) - 5*Math.pow(1.003, count)));
	}

}
