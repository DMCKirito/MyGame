package game;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gameControl.GameControl;
import gameDto.GameDto;
import gameUtils.GameConstant;

public class GameFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GamePanel gamePanel;
	public GameFrame() {
        GameDto.resetAll();
		gamePanel = new GamePanel();
	}
	
	public void lanuch()
	{
//		try {
//            /**
//             * 窗体风格
//             */
//			JDialog.setDefaultLookAndFeelDecorated(true);
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
//        } catch (ClassNotFoundException e1) {
//            e1.printStackTrace(); 
//        } catch (InstantiationException e1) {
//            e1.printStackTrace();
//        } catch (IllegalAccessException e1) {
//            e1.printStackTrace();
//        } catch (UnsupportedLookAndFeelException e1) {
//            e1.printStackTrace();
//        }
        setSize(GameConstant.FRAME_WIDTH,GameConstant.FRAME_HEIGHT);
        setLocation(GameConstant.SCREEN_WIDTH / 2 - GameConstant.FRAME_WIDTH / 2,
                    GameConstant.SCREEN_HEIGHT / 2 - GameConstant.FRAME_HEIGHT / 2);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                exit();
            }
        });
        addKeyListener(new GameControl());
        add(gamePanel);
        setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	
	public void exit(){
        /**
         * 退出窗口询问方法
         */
        Object[] options = {"好的！","没问题！"};
        int n = JOptionPane.showOptionDialog(this,
                "既然退出游戏了，那么约吗？！", "_(:з」∠)_",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                options, options[0]);
        if(n == -1 || n == 1)
        {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else if (n == 0)
        {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
       
    }
	
}
