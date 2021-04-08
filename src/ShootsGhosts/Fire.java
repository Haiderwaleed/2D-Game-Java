package ShootsGhosts;

import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Fire extends Thread {
	
 Bullet bullet;
 GhostLevel gl;
 Ghost [] [] ghosts;
 public static int scoure =0;
 
 Fire(Bullet bullet,GhostLevel gl,Ghost [] [] ghost)
 {
	 
	 this.bullet = bullet;
	 this.gl = gl;
	 this.ghosts = ghost;
	 
	 
 }
	
	
	
	@Override
	public void run	()
  {
	  
	  while (bullet.getyAxis()>-500)
	  {
		  bullet.setyAxis(bullet.getyAxis()-50);
		  checkCollision();
		  
		  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  gl.repaint();

	  }
	  
	
  }
	
	
	
	public void checkCollision()
	{
		Rectangle bulletRect = new Rectangle(bullet.getxAxis(),bullet.getyAxis(),9,41);
		
		for(int i = 0;i<ghosts.length;i++)
		{
			for(int j = 0;j<ghosts[i].length;j++)
			{
				Rectangle	ghostRect = new Rectangle(ghosts[i][j].getxAxis(),ghosts[i][j].getyAxis(),45,45);
				if(bulletRect.intersects(ghostRect))
				{
					ghosts[i][j].setxAxis(500000);
					bullet.setyAxis(-50000);
					scoure++;
					
					
					
					try {File sounds = new File ("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\sounds\\deadsound.wav");
					AudioInputStream ais = AudioSystem.getAudioInputStream(sounds);
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();}
					catch(Exception e) {System.out.println(e);}
				}
				
			}	
				
		}
	
	}
}
	

