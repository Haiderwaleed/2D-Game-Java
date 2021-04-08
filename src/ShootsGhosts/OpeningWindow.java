package ShootsGhosts;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class OpeningWindow  extends JPanel{

	JFrame window = new JFrame();
	OpeningWindow()
	{
		window.add(this);
		
		try {
			File sounds = new File ("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\sounds\\openingwindow.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sounds);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}catch(Exception e) {System.out.println(e);}
		
		window.setLocation(300, 100);
		window.setUndecorated(true);
		window.setSize(620,480);
		window.setVisible(true);
		
		try {
			Thread.sleep(10000);
			window.dispose();
			Menu m = new Menu();
			
		} catch (Exception e) {System.out.println(e);}
		
	}
	
	public void paint (Graphics g)
	{
		ImageIcon background = new ImageIcon ("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\openingwindow.jpg");
		
		g.drawImage(background.getImage(),0,0,null);
		
	}
}