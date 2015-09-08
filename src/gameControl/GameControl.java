package gameControl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gameDto.GameDto;

public class GameControl extends KeyAdapter
{
	@Override
	public void keyPressed(KeyEvent e) 
	{
		GameDto.heroPlane.addDirection(e);
		GameDto.heroPlane.startShoot(e);
		// ╪стьсно╥
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		GameDto.heroPlane.minusDirection(e);
		GameDto.heroPlane.stopShoot(e);
	}

}
