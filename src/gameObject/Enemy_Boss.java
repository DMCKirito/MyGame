package gameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

import gameDto.GameDto;
import gameUtils.GameConstant;
import gameUtils.GameUtils;
import gameUtils.ImageIndexChange;

public class Enemy_Boss extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int lives;
	private int x;
	private int y;
	private int shockX = 4;
	private int shockY = 4;
	private int timer;
	
	private double imageW;
	private double imageH;
	
	private Image image;
	private Image image2;
	
	private int mSpeed;
	private boolean isAlive;
	private boolean isShock;
	private Random random;
	
	private int shootCount;
	
	private Boom boom = new Boom();
	
	public Enemy_Boss()
	{
		setLayout(null);
		setBounds(0, 0, GameConstant.FRAME_WIDTH, GameConstant.FRAME_HEIGHT);

		ImageIndexChange imageIndexChange = new ImageIndexChange(2, GameUtils.getImage("image/planes/4.png"));
		
		this.image = imageIndexChange.getImageOfIndex(2);
		this.image2 = imageIndexChange.getImageOfIndex(1);
		
		this.isAlive = true;
		this.lives = 50;
		
		this.mSpeed = 3;
		
		this.timer = 6;
		
		this.imageH = this.image.getHeight(null)*1.5;
		this.imageW = this.image.getWidth(null)*1.5;
		
		random = new Random();
		this.x = random.nextInt(GameConstant.FRAME_WIDTH - image.getWidth(null) );
		this.y = 0 - image.getHeight(null)/2;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(isAlive)
		{
			isBoom();
			if(isShock)
			{
				shock(g);
				if(this.mSpeed == 0)
				{
					shoot();
				}
			}
			else 
			{
				g.drawImage(image, x, y, (int)imageW, (int)imageH, null);
				if(this.mSpeed == 0)
				{
					shoot();
				}
				move();
			}
			
		}
		else
		{
			boom.draw(this.x, this.y, g);
		}
	}
	
	public void shoot()
	{
		if(shootCount == 0)
		{
			Boss_Gun boss_Gun = new Boss_Gun(this.x + (int)imageW/6, this.y + (int)imageH);
			this.add(boss_Gun);
			shootCount++;
		}
	}
	
	public void isRightOrLeft() 
	{			
		judgeMove();
		if(this.x > GameDto.HERO_X && (this.x - GameDto.HERO_X) > 3)
		{
			this.x -= mSpeed;
		}
		else if(this.x < GameDto.HERO_X && (this.x - GameDto.HERO_X) < -3)
		{
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
			this.mSpeed = 3;
			this.shootCount = 0;
		}
	}

	public void move() 
	{
		if(this.y < 0)
		{
			y += 1;
		}
		isRightOrLeft();
	}
	
	public boolean isBoom() 
	{
		for(int i = 0; i < GameDto.bullets.size(); i ++)
		{	
			if (GameDto.bullets.get(i).isAlive && GameDto.bullets.get(i).getRectangle().intersects(this.getRectangle()))
			{
				this.lives -= 1;
				GameDto.bullets.get(i).isAlive = false;
				this.isShock = true;
				break;
			}
			if(lives == 0)
			{
				isAlive = false;
			}
        }
		
		return isAlive;
	}
	
	public void shock(Graphics g)
	{
		g.drawImage(image2, this.x + shockX, this.y + shockY, (int)imageW, (int)imageH, null);
		this.timer--;
		this.shockY = -this.shockY;
		if(this.timer<=0)
		{
			this.isShock = false;
			this.timer = 6;
		}

	}
	public Rectangle getRectangle()
	{
		return new Rectangle((int)this.x,(int)this.y,(int)imageW,(int)imageH);
	}

}
