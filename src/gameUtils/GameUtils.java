package gameUtils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameUtils {
	
	private GameUtils () { }
	
	public static Image getImage(String path) {
        BufferedImage bi = null;
        
        try
        {
            java.net.URL url = GameUtils.class.getClassLoader().getResource(path);
            bi = javax.imageio.ImageIO.read(url);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        return bi;
    }
	
	
}
