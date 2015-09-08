package gameDto;

import java.util.ArrayList;
import java.util.List;

import gameObject.Bullet;
import gameObject.EBullet;
import gameObject.Enemy_Plane;
import gameObject.Enemy_PlaneB2;
import gameObject.HeroPlane;
import gameUtils.GameConstant;
import gameUtils.GameUtils;

public class GameDto
{
	public static int HERO_LIVES;
	public static int HERO_X;
	public static int HERO_Y;
	
	public static HeroPlane heroPlane = new HeroPlane();
	
	
	static 
	{
		HERO_LIVES = 20;
		HERO_X = GameConstant.FRAME_WIDTH/2 - 19;
		HERO_Y = GameConstant.FRAME_HEIGHT - GameUtils.getImage("image/planes/plane.GIF").getHeight(null) - 20;
	}
	public static List<Bullet> bullets = new ArrayList<>();
	public static List<EBullet> Enemy_Plane_bullets = new ArrayList<>();
	public static List<Enemy_Plane> enemy_Plane = new ArrayList<>();
	public static List<Enemy_PlaneB2> enemy_PlaneB2s = new ArrayList<>();
	
	public static int timer = 0;
	
	
}
