package gameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

import gameDto.GameDto;
import gameUtils.GameConstant;

public abstract class Enemy extends JComponent
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int x;
	protected int y;
	
	protected int speed;
	protected int mSpeed;
	protected Random rX;
	
	protected double imageW;
	protected double imageH;
	
	protected boolean isAlive;
	protected boolean isDrawing;
	protected int lives;
	protected Boom boom = new Boom();
	protected Image image;
	
	protected boolean addPoint;
	protected int timer;
	
	public Enemy()
	{
		setLayout(null);
		setBounds(0, 0, GameConstant.FRAME_WIDTH, GameConstant.FRAME_HEIGHT);
		
		this.isAlive = true;
		this.isDrawing = true;
		addPoint = false;
		rX = new Random();
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
	
	public Rectangle getRectangle()
	{
		return new Rectangle((int)this.x,(int)this.y,image.getWidth(null),image.getHeight(null));
	}

	public void move()
	{
		isRightOrLeft();
		if(this.y > GameConstant.FRAME_HEIGHT)
		{
			this.isDrawing = false;
		}
	}
	
	
	public boolean isBoom()
	{
		for(int i = 0; i < GameDto.bullets.size(); i ++)
		{	
			if (GameDto.bullets.get(i).isAlive && GameDto.bullets.get(i).getRectangle().intersects(this.getRectangle()))
			{
				this.lives -= 1;
				GameDto.bullets.get(i).isAlive = false;
				break;
			}
			if(lives == 0)
			{
				isAlive = false;
			}
        }
		
		return isAlive;

	}
	
	public abstract void isRightOrLeft();
	
	public abstract void shoot();
}
