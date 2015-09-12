package game;

import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JPanel;

import gameDto.GameDto;
import gameObject.Enemy_Boss;
import gameObject.Enemy_Plane;
import gameObject.Enemy_PlaneB2;
import gameObject.Game_Bg;
import gameObject.Game_Board;
import gameUtils.GameConstant;

public class GamePanel extends JPanel implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int count = 0;
	Game_Bg game_Bg = new Game_Bg();
	Game_Board game_Board = new Game_Board();
	
	public GamePanel() 
	{
		setLayout(null);
		setBounds(0, 0, GameConstant.FRAME_WIDTH, GameConstant.FRAME_HEIGHT);
		add(GameDto.heroPlane);
		add(game_Board);
		new Thread(this).start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		add(game_Bg);
		if(GameDto.timer % 30 == 0)
		{
			addEnemy_Plane();
		}
		if (GameDto.timer == 100) 
		{
			addEnemy_Plane2();
		}
		if(count == 0)
		{
			addEnemy_Boss();
			count++;
		}
	}
	
	public void addEnemy_Plane()
	{
		Enemy_Plane enemyPlane = new Enemy_Plane();
		GameDto.enemy_Plane.add(enemyPlane);
		this.add(enemyPlane);
	}
	
	public void addEnemy_Plane2()
	{
		Enemy_PlaneB2 enemy_Plane2 = new Enemy_PlaneB2();
		GameDto.enemy_PlaneB2s.add(enemy_Plane2);
		this.add(enemy_Plane2);
	}
	
	public void addEnemy_Boss()
	{
		Enemy_Boss enemy_Boss = new Enemy_Boss();
		this.add(enemy_Boss);
	}
	
	public void run()
	{
		try {
			while(true)
			{
				Thread.sleep(40);
				GameDto.timer++;
				repaint();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
