package gameObject;

import java.awt.Graphics;

import gameDto.GameDto;
import gameUtils.GameConstant;
import gameUtils.GameUtils;

public class Enemy_Plane extends Enemy 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Enemy_Plane()
	{
		super();
		this.isDrawing = true;
		this.lives = 2;
		this.speed = 2;
		
		this.image = GameUtils.getImage("image/planes/eplane2.gif");
		this.imageW = (int)imageW;
		this.imageH = (int)imageH;
		this.x = rX.nextInt(GameConstant.FRAME_WIDTH - (int)imageW);
		this.y = -30;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
		if (isAlive && isDrawing) 
		{
			isBoom();
			g.drawImage(image, x, y, null);
			this.move();
			if(timer % 125 == 0 && isAlive)
			{
				shoot();
			}
		}
		else if(!isAlive)
		{
			boom.draw(this.x - (int)imageW/2, this.y - (int)imageH/2, g);
		}
		
		if(!isAlive && !addPoint)
		{
			GameDto.Game_Point += 200;
			addPoint = true;
		}

		
		
		timer ++;
	}
	
	@Override
	public void isRightOrLeft()
	{
		
		if(this.x > GameDto.HERO_X && (this.x - GameDto.HERO_X) > 3 )
		{
			this.x -= 1;
		}
		else if(this.x < GameDto.HERO_X && (this.x - GameDto.HERO_X) < -3)
		{
			this.x += 1;
		}
	}
	
	@Override
	public void move()
	{
		super.move();
		this.y += speed;
	}
		
	@Override
	public void shoot()
	{
		EBullet bullet = new EBullet(this.x + (int)imageW/2, this.y + (int)imageH);
		GameDto.Enemy_Plane_bullets.add(bullet);
		this.add(bullet);
	}
}
