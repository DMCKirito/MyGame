package gameObject;

import java.awt.Graphics;
import java.awt.Image;
import java.security.Timestamp;

import javax.swing.JComponent;
import javax.swing.plaf.synth.SynthTabbedPaneUI;

import org.w3c.dom.html.HTMLIsIndexElement;

import gameUtils.GameConstant;
import gameUtils.GameUtils;

public class Game_Bg extends JComponent{
	
	private int x;
	private int y;
	private int y2;
	private int speed;
	private Image image;
	
	public Game_Bg()
	{
		setLayout(null);
		setBounds(0, 0, GameConstant.FRAME_WIDTH, GameConstant.FRAME_HEIGHT);

		this.x = 0;
		this.image = GameUtils.getImage("image/bg/roll3.png");
		this.y = 0 - this.image.getHeight(null) + GameConstant.FRAME_HEIGHT;
		this.y2 = y -1;
		this.speed = 3;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawBg(g);
	}
	
	public void drawBg(Graphics g)
	{
		if(this.y > this.y2)
		{
			if(this.y < GameConstant.FRAME_HEIGHT)
			{
				y2 = this.y - this.image.getHeight(null);
				g.drawImage(image, this.x, this.y, GameConstant.FRAME_WIDTH, this.image.getHeight(null), null);
				if(this.y > 0)
				{
					g.drawImage(image, this.x, y2, GameConstant.FRAME_WIDTH, this.image.getHeight(null), null);
				}
				this.y += speed;
			}
			else if (y2 < GameConstant.FRAME_HEIGHT) 
			{
				g.drawImage(image, this.x, y2, GameConstant.FRAME_WIDTH, this.image.getHeight(null), null);
				if(this.y2 > 0)
				{
					g.drawImage(image, this.x, y2 - this.image.getHeight(null), GameConstant.FRAME_WIDTH, this.image.getHeight(null), null);
				}
				y2 += speed;
			}
			else {
				this.y = 0 - this.image.getHeight(null) + GameConstant.FRAME_HEIGHT;
				this.y2 = y - 1;
			}
		}
		
	}
}
