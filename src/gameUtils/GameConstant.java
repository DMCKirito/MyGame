package gameUtils;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

public class GameConstant 
{
	public GameConstant() { }
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static Image IMAGE_BG;
	public static Image IMAGE_HERO;
	public static Image[] IMAGES_ENEMY;
	public static Image IMAGE_BUTTLET;
	
	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 850;
	public static final int HERO_SPEED = 5;
	
	public static final int SCREEN_WIDTH = (int)screenSize.getWidth();
    public static final int SCREEN_HEIGHT = (int)screenSize.getHeight();
}
