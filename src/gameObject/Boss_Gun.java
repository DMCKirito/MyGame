package gameObject;

import java.awt.Graphics;
import javax.swing.JComponent;

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
	ImageIndexChange change  = new ImageIndexChange(4, GameUtils.getImage("image/bullet/5.png"));
	
	public Boss_Gun () {}
	
	public Boss_Gun(int x, int y) 
	{
		setLayout(null);
		setBounds(0, 0, GameConstant.FRAME_WIDTH, GameConstant.FRAME_HEIGHT);
		this.x = x;
		this.y = y;
		isAlive = true;
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (isAlive) {
			g.drawImage(change.NextImageIndex(), x, y, null);
			move();
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
}
