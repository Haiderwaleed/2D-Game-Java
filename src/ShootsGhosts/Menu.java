package ShootsGhosts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener, KeyListener {
	JFrame window = new JFrame();
	JButton PlayButton = new JButton();
	JButton exitButton = new JButton();
	JLabel infoLabel = new JLabel();
	JLabel centerImageLabel = new JLabel();
	JButton BackgroundButton = new JButton();
	

	Font customFont = new Font ("Italic",Font.ITALIC,22); 
	
	Menu()
	{
		
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.DARK_GRAY);

		window.add(this);
		
		
		PlayButton.setBackground(Color.DARK_GRAY); 
		PlayButton.setIcon(new ImageIcon("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\playbutton.png"));
		PlayButton.addActionListener(this);
		PlayButton.addKeyListener(this);
		window.add(PlayButton,BorderLayout.PAGE_START);

		
		exitButton.setBackground(Color.DARK_GRAY);
		exitButton.setIcon(new ImageIcon("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\exitgame.png"));
		exitButton.addActionListener(this);
		exitButton.addKeyListener(this);
		window.add(exitButton,BorderLayout.PAGE_END);
		
		
		BackgroundButton.setBackground(Color.darkGray);
		BackgroundButton.setIcon(new ImageIcon("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\h123123.jpg"));
		BackgroundButton.addActionListener(this);
		BackgroundButton.addKeyListener(this);
		window.add(BackgroundButton,BorderLayout.WEST);
		
		infoLabel.setText("        Shoot Ugur       ");
		infoLabel.setFont(customFont);
		infoLabel.setOpaque(true);
		infoLabel.setBackground(Color.DARK_GRAY);
		infoLabel.setForeground(Color.GREEN);
		window.add(infoLabel,BorderLayout.EAST);
		
		centerImageLabel.setBackground(Color.DARK_GRAY);
		centerImageLabel.setIcon(new ImageIcon("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\center.jpg"));
		window.add(centerImageLabel,BorderLayout.CENTER);
		
		
		
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(900, 550);
		window.setVisible(true);
		
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
		window.dispose();
		}
		
		else  if(kp.getKeyCode()==KeyEvent.VK_ENTER)
		{
			window.dispose();
			LevelsWindow lw = new LevelsWindow();
			
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
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exitButton)
		{
		window.dispose();
	}
		
		else if(ae.getSource()==PlayButton)
		{
		window.dispose();
		LevelsWindow lw = new LevelsWindow();

	}
		
		
		
	}

}
