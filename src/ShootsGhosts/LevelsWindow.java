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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LevelsWindow extends JPanel implements ActionListener, KeyListener {
	
	JFrame window = new JFrame();
	String[] s = {"Ghost-level","Evil-Levels","Dragon_Levels"};
	JComboBox nameOfLevels = new JComboBox(s);
	JButton enterButton = new JButton();
	JButton backButton = new JButton();
	
	
	Font customFont = new Font("Bold",Font.BOLD,30);
	Font ComboFont = new Font("Italic",Font.ITALIC,25);
	
	
	
	LevelsWindow()
	{
		this.setBackground(Color.BLACK);
		window.add(this);
		
		nameOfLevels.setFont(ComboFont);
		nameOfLevels.setForeground(Color.DARK_GRAY);
		nameOfLevels.setBackground(Color.BLACK);
		window.add(nameOfLevels,BorderLayout.PAGE_START);
		
		
		backButton.setFont(ComboFont);
		backButton.setText("Back");
		backButton.setBackground(Color.black);
		backButton.setForeground(Color.white);
		backButton.addActionListener(this);
		backButton.addKeyListener(this);
		window.add(backButton,BorderLayout.PAGE_END);
		
		
		
		enterButton.setIcon(new ImageIcon("C:\\Users\\haide\\eclipse-workspace\\YoutubeGame\\image\\Level1.jpg"));
		enterButton.addActionListener(this);
		enterButton.addKeyListener(this);
		window.add(enterButton,BorderLayout.CENTER);
		
		
		window.setUndecorated(true);
		window.setSize(750, 550);
		window.setLocation(50, 50);
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
			GhostLevel gl = new GhostLevel();
		}

	
		
	}

	@Override
	public void keyReleased(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
		window.dispose();	
		Menu m = new Menu();
		
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==0)
		{
			GhostLevel gl = new GhostLevel();
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==1)
		{
			JOptionPane.showMessageDialog(null, "Evil Level is not ready"); 	
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==2)
		{
			JOptionPane.showMessageDialog(null, "Dragon Level is not ready"); 	
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==backButton)
		{
			window.dispose();
			Menu m = new Menu();
		}
			
	
	
	else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==0)
	 {
		GhostLevel gl = new GhostLevel();
		
	 }
	else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==1)
	 {
		JOptionPane.showMessageDialog(null, "Evil Level is still maintenance"); 
		
	 }
	else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==2)
	 {
		JOptionPane.showMessageDialog(null, "Dragon Level is still maintenance"); 
	 }
		
		
		
		
	}
}


