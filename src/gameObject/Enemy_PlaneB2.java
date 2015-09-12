package gameObject;

import java.awt.Graphics;

import gameDto.GameDto;
import gameUtils.GameConstant;
import gameUtils.GameUtils;

public class Enemy_PlaneB2 extends Enemy {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Enemy_PlaneB2() 
	{
		super();
		this.lives = 15;
		
		this.speed = 1;
		this.mSpeed = 1;
		
		image = GameUtils.getImage("image/planes/eplaneB2.gif");
		this.imageW = image.getWidth(null);
		this.imageH = image.getHeight(null);
		
		this.x = rX.nextInt(GameConstant.FRAME_WIDTH - (int)imageW);
		this.y = 0 - (int)imageH;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
		if (isAlive && isDrawing) 
		{
			isBoom();
			g.drawImage(image, x, y, null);
			this.move();
			if(this.mSpeed == 0)
			{
				shoot();
			}
		}
		else if(!isAlive)
		{
			boom.draw(this.x - (int)imageW/2, this.y - (int)imageH/2, g);
		}
		
		timer ++;
	}

	
	@Override
	public void isRightOrLeft() 
	{			
		if(this.x > GameDto.HERO_X && (this.x - GameDto.HERO_X) > 3)
		{
			judgeMove();
			this.x -= mSpeed;
		}
		else if(this.x < GameDto.HERO_X && (this.x - GameDto.HERO_X) < -3)
		{
			judgeMove();
			this.x += mSpeed;
		}
	}

	
	public void judgeMove()
	{
		if(GameDto.timer % 120 > 0 && GameDto.timer % 120 < 25) 
		{
			this.mSpeed = 0;
		}
		else
		{
			this.mSpeed = 1;
		}
	}

	@Override
	public void move() 
	{
		super.move();
		y += 1;
	}

	@Override
	public void shoot() 
	{
		if (timer % 5 == 0) {
			
			EBullet eBullet = new EBullet(this.x + (int)imageW/4 - 5, this.y + (int)imageH);
			EBullet eBullet2 = new EBullet(this.x + (int)imageW*3/4 - 15, this.y + (int)imageH);
			GameDto.Enemy_Plane_bullets.add(eBullet);
			GameDto.Enemy_Plane_bullets.add(eBullet2);
			this.add(eBullet);
			this.add(eBullet2);
		}
	}

}
