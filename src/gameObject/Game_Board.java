package gameObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

import gameDto.GameDto;
import gameUtils.GameConstant;

public class Game_Board extends JComponent{
	
	private final int HEIGHT;
	private final int LEN ;
	private final Font font;
	
	public Game_Board()
	{
		setLayout(null);
		setBounds(0, 0, GameConstant.FRAME_WIDTH, GameConstant.FRAME_HEIGHT);
		HEIGHT = 26;
		font = new Font("ºÚÌå", Font.BOLD, 20);
		LEN = 100;
	}
	
	public void paintComponent(Graphics g){
//			g.setColor(Color.BLACK);
//			g.fillRect(0, GamePanel.PANEL_H-HEIGHT, GamePanel.PANEL_W, HEIGHT);
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("point "+GameDto.Game_Point,5,GameConstant.FRAME_HEIGHT - HEIGHT - 30);
		g.drawString("lives ",5,GameConstant.FRAME_HEIGHT - HEIGHT - 3);
		g.drawString("BOSS ",5,GameConstant.FRAME_HEIGHT - HEIGHT - 60);
		double tempPercent = ((double)GameDto.HERO_LIVES/GameDto.HERO_TOTAL_LIVES);
		double tempPercentB = ((double)GameDto.Boss_Lives/GameDto.Boss_Total_Lives);
		
		g.fillRect(80, GameConstant.FRAME_HEIGHT-HEIGHT - 80, (int)(tempPercentB* 400), 20);
		g.fillRect(80, GameConstant.FRAME_HEIGHT-HEIGHT - 20, (int)(tempPercent* 400), 20);
		
		
		//g.drawImage(StaticImage.Rect.getSubimage(id, 0, 1, StaticImage.Rect.getHeight()),
			//	200, GamePanel.PANEL_H-(HEIGHT-10), (int)(tempPercent*LEN)+1, 10, null);
		
	//	g.drawImage(StaticImage.board, 4, GamePanel.PANEL_H-HEIGHT+4, GamePanel.PANEL_W, HEIGHT, null);
	}

}
