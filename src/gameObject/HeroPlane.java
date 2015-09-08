package gameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import gameDto.GameDto;
import gameUtils.GameConstant;
import gameUtils.GameUtils;

public class HeroPlane extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isAlive = true;
	
	private boolean isLeft;
	private boolean isRight;
	private boolean isUp;
	private boolean isDown;
	
	private double imageW;
	private double imageH;
	
	private boolean isShoot = false;
	private int nowShoot;
	private int lastShoot;
	
	private boolean isShock = false;
	private int shockX;
	private int shockY;
	
	private int speed = GameConstant.HERO_SPEED;

	private int timer;
	
	private Boom boom = new Boom();
	private Image image;
	
	public HeroPlane()
	{
		this.setLayout(null);
		setBounds(0,0,GameConstant.FRAME_WIDTH,GameConstant.FRAME_HEIGHT);
		image = GameUtils.getImage("image/planes/plane.GIF");
		this.imageW = image.getWidth(null);
		this.imageH = image.getHeight(null);
		this.shockX = 4;
		this.shockY = 4;
		this.timer = 6;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(isAlive)
		{
			if(isShock)
			{
				shock(g);
				move();
			}
			else 
			{
				g.drawImage(image, GameDto.HERO_X, GameDto.HERO_Y, null);
				shoot();
				move();
				isBoom();
			}
		}
		else 
		{
			boom.draw(GameDto.HERO_X, GameDto.HERO_Y, g);
		}
		nowShoot++;
	}

	public void move()
	{
		if(isLeft)
		{
			if(GameDto.HERO_X - speed > 0)
			{
				GameDto.HERO_X -= speed;
			}
		}
		if(isRight)
		{
			if(GameDto.HERO_X + (int)imageW + speed < GameConstant.FRAME_WIDTH)
			{
				GameDto.HERO_X += speed;
			}
		}
		if(isUp)
		{
			if(GameDto.HERO_Y - speed >0)
			{
				GameDto.HERO_Y -= speed;
			}
		}
		if(isDown)
		{
			if(GameDto.HERO_Y + (int)imageH + speed + 20 < GameConstant.FRAME_HEIGHT)
			{
				GameDto.HERO_Y += speed;
			}
		}
	}
	
	public void addBullet()
	{
		Bullet bullet = new Bullet(GameDto.HERO_X + 19, GameDto.HERO_Y);
		GameDto.bullets.add(bullet);
		this.add(bullet);
	}
	
	public void shoot()
	{
		if(isShoot && nowShoot % 5 == 0)
		{
			addBullet();
			lastShoot = nowShoot;
		}
		else if (isShoot && (nowShoot - lastShoot) > 5)
		{
			addBullet();
			nowShoot = lastShoot;
		}
	}
	
	public boolean isBoom()
	{
		
		for(int i = 0; i < GameDto.Enemy_Plane_bullets.size(); i ++)
		{	
			if (GameDto.Enemy_Plane_bullets.get(i).isAlive && GameDto.Enemy_Plane_bullets.get(i).getRectangle().intersects(this.getRectangle()))
			{
				GameDto.HERO_LIVES --;
				GameDto.Enemy_Plane_bullets.get(i).isAlive = false;
				this.isShock = true;
				break;
			}
        }
		
		if(isAlive)
		{
			for(int i = 0; i < GameDto.enemy_Plane.size(); i ++)
			{
				if(GameDto.enemy_Plane.get(i).isAlive && GameDto.enemy_Plane.get(i).getRectangle().intersects(this.getRectangle()))
				{
					GameDto.HERO_LIVES --;
					GameDto.enemy_Plane.get(i).isAlive = false;
					this.isShock = true;
					break;
				}
			}

		}
		
		if(isAlive)
		{
			for(int i = 0; i < GameDto.enemy_PlaneB2s.size(); i ++)
			{
				if(GameDto.enemy_PlaneB2s.get(i).isAlive && GameDto.enemy_PlaneB2s.get(i).getRectangle().intersects(this.getRectangle()))
				{
					GameDto.HERO_LIVES --;
					GameDto.enemy_PlaneB2s.get(i).isAlive = false;
					this.isShock = true;
					break;
				}
			}
		}
		
		if(GameDto.HERO_LIVES < 0)
		{
			this.isAlive = false;
		}
	
		return isAlive;
	}

	public void shock(Graphics g)
	{
		g.drawImage(image, GameDto.HERO_X + shockX, GameDto.HERO_Y + shockY, null);
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
		return new Rectangle((int)GameDto.HERO_X,(int)GameDto.HERO_Y,(int)imageW,(int)imageH);
	}

	public final void addDirection(final KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_LEFT :
				isLeft = true;
				break;
			case KeyEvent.VK_RIGHT :
				isRight = true;
				break;
			case KeyEvent.VK_UP :
				isUp = true;
				break;
			case KeyEvent.VK_DOWN :
				isDown = true;
				break;
            default:
                break;
		}
	}
	
	public final void minusDirection(final KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_LEFT :
				isLeft = false;
				break;
			case KeyEvent.VK_RIGHT :
				isRight = false;
				break;
			case KeyEvent.VK_UP :
				isUp = false;
				break;
			case KeyEvent.VK_DOWN :
				isDown = false;
				break;
            default:
                break;
		}
	}
	
	public final void startShoot(final KeyEvent e)
	{
		switch (e.getKeyCode()) 
		{
			case KeyEvent.VK_Z:
				isShoot = true;
				break;
			default:
				break;
		}
	}
	
	public final void stopShoot(final KeyEvent e)
	{
		switch (e.getKeyCode()) 
		{
			case KeyEvent.VK_Z:
				isShoot = false;
				break;
			default:
				break;
		}
	}
}
