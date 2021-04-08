package ShootsGhosts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GhostLevel extends JPanel implements ActionListener, KeyListener {
	
	JFrame window = new JFrame("Ghost Level");
	Shooter shooter = new Shooter(380,400,"C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\shooter1.jpg");
	Ghost[] [] ghosts = new Ghost[2] [15];
	int xAxis = 0;
	int yAxis = 0;
	Bullet[] bullet = new Bullet[1000];
	int count = 0;
	Dropper dropper = new Dropper(this,ghosts);
	private boolean fail = false;
	
	

	GhostLevel()
	{
		
		this.setFocusable(true);
		this.addKeyListener(this);
		
		try {File sounds = new File ("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\sounds\\levelstart.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(sounds);
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		clip.start();}
		catch(Exception e) {System.out.println(e);}
		
		
		window.add(this);
		
		
		for(int i = 0;i<ghosts.length;i++)
		{
			for(int j = 0;j<ghosts[i].length;j++)
			{
				ghosts[i][j] = new Ghost(xAxis,yAxis,"C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\h1.jpg");
				xAxis+= 50;
				
			}
			yAxis+=50;
			xAxis =0;
		}
		
		dropper.start();

		
		
		for(int i = 0;i<bullet.length;i++)
		{
				bullet [i] = new Bullet(410,650,"C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\bullet.jpg");
				
			}
		
		window.setSize(768, 576);
		window.setLocation(40, 20);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		

	}
	
	
	
	public void paint (Graphics g)
	{
		ImageIcon background = new ImageIcon("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\Dragon.jpg");
		g.drawImage(background.getImage(), 0, 0, null);
		
		shooter.drawShooter(g);
		
		for(int i = 0;i<ghosts.length;i++)
		{
			for(int j = 0;j<ghosts[i].length;j++)
			{
				ghosts[i][j].drawGhost(g);
			}
		}
		
		
		for(int i = 0;i<bullet.length;i++)
		{
		
				bullet[i].drawBullet(g);
			}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("",Font.BOLD,22));
		g.drawString("Score = "+Fire.scoure, 600, 500);
		levelFailed();
		levelCompete();
		
		
		
		}
	public void levelCompete()
	{
		if(Fire.scoure>=10)
		{
			window.dispose();
			dropper.stop();
			JOptionPane.showMessageDialog(null," Level Completed ");
		}
			
	}
	
	
	public void levelFailed()
	{
		for(int i = 0;i<ghosts.length;i++)
		{
			for(int j = 0;j<ghosts[i].length;j++)
			{
				if (ghosts[i][j].getyAxis()>350) {
					
					fail = true;
					dropper.stop();

					break;
					
					
				}
			}

		}
		if (fail==true)
		{
			window.dispose();
			JOptionPane.showMessageDialog(null, "Game Over");


			
		}
				
				

	}
		
	
	
	

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if (shooter.getxAxis()<805)
				shooter.setxAxis(shooter.getxAxis()+5);
			this.repaint();

		}
		else if(kp.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if (shooter.getxAxis()>-2)
			{
				shooter.setxAxis(shooter.getxAxis()-5);

			}
			this.repaint();

		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_SPACE)
		{
			try {File sounds = new File ("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\sounds\\bulletsound.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sounds);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();}
			catch(Exception e) {System.out.println(e);}
			
			bullet[count].setxAxis(shooter.getxAxis());
			Fire f = new Fire(bullet[count],this,ghosts);
			
			bullet[count].setxAxis(shooter.getxAxis()+30);
			bullet[count].setyAxis(shooter.getyAxis()+10);

		
			f.start();
			count++;
		}
			


	
	}
	
	
		
		
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
