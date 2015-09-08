package gameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JComponent;

import gameUtils.GameConstant;

public abstract class PlaneBullet extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int x;
	protected int y;
	protected Image image;
	
	protected boolean isAlive = true;
	
	public PlaneBullet() {}
	
	public PlaneBullet(int x, int y)
	{
		setLayout(null);
		setBounds(0, 0, GameConstant.FRAME_WIDTH, GameConstant.FRAME_HEIGHT);
		this.x = x;
		this.y = y;		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		judgeAlive();
	}
	
	public abstract void move();
	
	public void judgeAlive()
	{
		if(this.y > GameConstant.FRAME_HEIGHT)
		{
			this.isAlive = false;
		}
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle((int)this.x,(int)this.y,image.getWidth(null),image.getHeight(null));
	}
}
