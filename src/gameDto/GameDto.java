package gameDto;

import java.util.ArrayList;
import java.util.List;

import gameObject.Boss_Gun;
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
	public static int HERO_TOTAL_LIVES;
	public static int HERO_X;
	public static int HERO_Y;
	public static int Game_Point;
	public static int Boss_Lives;
	public static int Boss_Total_Lives;
	public static HeroPlane heroPlane ;
	
	public static List<Bullet> bullets;
	public static List<EBullet> Enemy_Plane_bullets;
	public static List<Enemy_Plane> enemy_Plane;
	public static List<Enemy_PlaneB2> enemy_PlaneB2s;
	public static List<Boss_Gun> boss_Guns;
	
	public static int timer;
	
	public static void resetAll()
	{
		timer = 0;
		Game_Point = 0;
		HERO_LIVES = 20;
		HERO_TOTAL_LIVES = 20;
		Boss_Lives = 10000;
		Boss_Total_Lives = 10000;
		HERO_X = GameConstant.FRAME_WIDTH/2 - 19;
		HERO_Y = GameConstant.FRAME_HEIGHT - GameUtils.getImage("image/planes/plane.GIF").getHeight(null) - 20;
		heroPlane = new HeroPlane();
		bullets = new ArrayList<>();
		enemy_Plane = new ArrayList<>();
		enemy_PlaneB2s = new ArrayList<>();
		Enemy_Plane_bullets = new ArrayList<>();
		bullets = new ArrayList<>();
		boss_Guns = new ArrayList<>();
	}
	
	
}
