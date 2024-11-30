package game_package;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameWindow
{
	// Creating variables for the window screen
	JFrame window;
	Container con;
	JPanel titlePanel, startButton;
	JLabel titleLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	
	public static void main(String[] args) 
	{
		// Creating a Game method
		new GameWindow();
	}
	
	// Game method
	public GameWindow() 
	{
		// Creating window for the game
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();
		
		// Creating the title
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 100, 600, 150);
		titlePanel.setBackground(Color.black);
		titleLabel = new JLabel("Rise of the Chaos Wizard");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);
		titlePanel.add(titleLabel);
		con.add(titlePanel);
		
		// Creating the start button
		startButton = new JPanel();
		startButton.setBounds(300, 400, 200, 100);
		startButton.setBackground(Color.blue);
		con.add(startButton);
		
		
		window.setVisible(true);
	}

}