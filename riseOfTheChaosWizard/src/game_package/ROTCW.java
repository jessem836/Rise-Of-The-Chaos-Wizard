package game_package;

// Imports for awt
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FontFormatException;

// Imports for io
import java.io.IOException;
import java.io.File;

// Imports for swing
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.Border;

// main class
public class ROTCW
{
	// Creating variables for the window screen
	JFrame window;
	Container con;
	ImageIcon image;
	
	// Booleans for in game events
	
	// A1 events
		// Questlord events
		boolean a1QuestlordHelp = false;
		boolean a1QuestlordMet = false;
		// Potion events
		boolean a1PotionKeep = false;
		boolean a1PotionDiscard = false;
		boolean a1PotionDrink = false;
		// Dwarf events
		boolean goblinKilled = false;
		boolean a1RallyDwarves = false;
		boolean a1DwarfKilled = false;
		// Misc events
		boolean noIhavent = false; 
		boolean noIdoNo = false;
	
	// Strings
	String position;
	
	String position2;
	
	String weapon;
	
	String enemy;
	
	String newItem = "";

	String descText = "<p>Game created by Jesse Mota in CSC110AB"
					+ "<br/> for an Honors Project.</p>"
					+ "<br/> This text-based adventure game is based off of"
					+ "<br/> Gloryhammer's first album,"
					+ "<br/>'<i>Tales from the Kingdom of Fife.</i>'";
	
	String prologue = "<p><b><u>Prologue - <i>Anstruther's Dark Prophecy:</u></b></i></p>"
					+ "<br/><i><p>\"The prophecy is written, Dundee will fall!\"</i></p>"
					+ "<br/> In the year 960, the oracle wizard, Malyroth of the city of"
					+ "<br/> Anstruther, peers into the future through a dream."
					+ "<br/> In this dream, he sees the mighty city of Dundee, the capital of"
					+ "<br/> the Kingdom of Fife, in ruins at the hands of the immortal"
					+ "<br/> chaos wizard, Zargothrax! Malyroth fears that if"
					+ "<br/> Dundee falls, then so will the rest of the Kingdom of Fife."
					+ "<br/> In an act of fear, Malyroth searches for the evil wizard"
					+ "<br/> Zargothrax, to join his evil forces...";
	
	String intro1 = "<p><b><u>Intro I - <i>The Unicorn Invasion of Dundee:</u></b></i></p>"
				  + "<br/><i><p>\"And an ominous shadow fell over the battlefield, as"
				  + "<br/> the evil wizard Zargothrax rode into the once mighty city of"
				  + "<br/> Dundee, atop an undead unicorn of war, to enthrone"
				  + "<br/> himself as it's new dark master!\"</i></p>"
				  + "<br/> 32 years later, in 992, the prophecy of Malyroth comes into"
				  + "<br/> fruition. At the first light of dawn, the armies of evil, led by"
				  + "<br/> Zargothrax, rode into the city of Dundee atop a horde of"
				  + "<br/> undead unicorns. The townspeople had little hope as they were"
				  + "<br/> not ready for war. Fireballs and lighting rain from the sky,"
				  + "<br/> chaos and bloodshed runs rampant. Zargothrax soon reaches"
				  + "<br/> the Citadel of Dundee, where he imprisons the princess, Iona"
				  + "<br/> McDougall. With Dundee conquered and the princess captured,"
				  + "<br/> the surivors yearn for a hero to regain Dundee's lost pride...";
	
	String intro2 = "<p><b><u>Intro II - <i>Angus McFife:</u></b></i></p>"
			  	  + "<br/><i><p>\"He is the prince of the land of Fife, noble and true with a"
			  	  + "<br/> heart of steel! Now that it is lost vengence shall be his,"
			  	  + "<br/> Angus McFife is his name!\"</i></p>"
			  	  + "<br/> Zargothrax's powers were too strong for the Prince of Fife"
			  	  + "<br/> to fight alone, and the hordes of evil were too many."
			  	  + "<br/> With no other choice, Angus retreats to safety and swears a"
			  	  + "<br/> mighty oath, \"I will make Zargothrax die!\" Angus mounts his"
			  	  + "<br/> noble steed and heads northbound. \"No turning back now,"
			  	  + "<br/> my journey lies ahead. I won't give up until the sorcerer is"
			  	  + "<br/> dead!\" Angus McFife begins his mighty quest, for the "
			  	  + "<br/> eternal glory of Dundee!";
	
	String act1 = "<p><b><u>Act I - <i>Quest for the Hammer of Glory:</u></b></i></p>"
		  	  	+ "<br/><i><p>\"In a cave on a mountain up high, there lies a mystical shrine."
		  	  	+ "<br/> If a warrior quests there, with a heart pure of steel, the"
		  	  	+ "<br/> Gods will grant unto him, a weapon that shall be revealed!</i></p>"
		  	  	+ "<br/> Angus begins his journey to the faraway mountain of"
		  	  	+ "<br/> Adjit, where he's heard tales of the Hammer of Glory,"
		  	  	+ "<br/> a weapon of ultimate steel created by the Star Lords "
		  	  	+ "<br/> many eons ago. With this all powerful weapon, Angus"
		  	  	+ "<br/> may stand a chance against the evil wizard Zargothrax"
		  	  	+ "<br/> and regain Dundee's lost pride...";
	
	// J variables
	JPanel titlePanel, startPanel, descPanel, proPanel, choicePanel, i1Panel, i2Panel, a1Panel, textPanel, hpPanel, playerPanel, enemyPanel, ehpPanel,
	xpPanel, miscPanel, picPanel;
	
	JLabel titleLabel, descLabel, prologueLabel, intro1Label, intro2Label, a1Label, hpLabel, vitLabel, vigorLabel, faithLabel, dmgLabel, evitLabel, evigorLabel, 
	efaithLabel, edmgLabel, ehpLabel, xpLabel, goldLabel, itemLabel, gainSLabel, gainLabel, picLabel;
	
	JButton startButton, choice1, choice2, choice3, choice4;
	JProgressBar healthBar, ehealthBar, xpBar;
	JTextArea mainTextArea;
	
	// Fonts
	Font Glory;
	Font Pixel;
	Font TextFont;
	
	// Borders
	Border tPanel = BorderFactory.createLineBorder(Color.darkGray, 4);
	Border hPanel = BorderFactory.createLineBorder(Color.red, 3);
	Border sPanel = BorderFactory.createLineBorder(new Color(25,50,200), 3);
	Border xPanel = BorderFactory.createLineBorder(new Color(25,125,150), 3);
	
	// Round int
	int round = 0;
	
	// XP and Gold
	int xp = 0;
	int xpUp = 100;
	int level = 1;
	int Gold = 50;
	
	// Player stats
	int maxHp = 200;
		int hp = 200;
	int ad = 50;
	int ap = 0;
	int totalDmg = ad + ap;
	int vitality = 25;
		double pReduc = 1.00 - (100.00 / (100.00 + vitality));
	int faith = 20;
		double mReduc = 1.00 - (100.00 / (100.00 + faith));
		int critStrike = totalDmg * 2;
		double critChance = 1.00 - (100.00 / (100.00 + (faith - 15)));
	int vigor = 20;
			double dodgeChance = 1.00 - (100.00 / (100.00 + (vigor - 10)));
			
	// Goblin stats
	int GobHP = 150;
	int GobMHP = 150;
	int GobFth = 5;
		double GmReduc = 1.00 - (100.00 / (100.00 + GobFth));
		int GcritStrike = totalDmg * 2;
		double GcritChance = 1.00 - (100.00 / (100.00 + (GobFth - 15)));
	int GobVig = 25;
	double GdodgeChance = 1.00 - (100.00 / (100.00 + (GobVig - 10)));
	int GobVit = 10;
		double GpReduc = 1.00 - (100.00 / (100.00 + GobVit));

	// Damage Calc
		// Goblin damage
		int GobTD = 30;
		double GobRDmg = Math.round(GobTD - (GobTD * pReduc));
		int GobDmg = (int) GobRDmg;
	
	// Event handlers
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	IntroScreenHandler isHandler = new IntroScreenHandler();
	ChoiceHandler csHandler = new ChoiceHandler();
	
	// Main
	public static void main(String[] args) 
	{
		// Creating a Game method
		new ROTCW();
	}
	
	// title method
	public ROTCW() 
	{
		// Creating Glory custom font
		try 
		{
			Glory = Font.createFont(Font.TRUETYPE_FONT, new File("dc_s.ttf")).deriveFont(52f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("dc_s.ttf")));
		}
			catch (IOException | FontFormatException e)
			{
				
			}
		
		// Creating pixel custom font
		try 
		{
			Pixel = Font.createFont(Font.TRUETYPE_FONT, new File("eight-bit-dragon.otf")).deriveFont(19f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("eight-bit-dragon.otf")));
		}
			catch (IOException | FontFormatException e)
			{
				
			}
		try 
		{
			TextFont = Font.createFont(Font.TRUETYPE_FONT, new File("eight-bit-dragon.otf")).deriveFont(17f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("eight-bit-dragon.otf")));
		}
			catch (IOException | FontFormatException e)
			{
				
			}
		
		// Creating window for the game
		window = new JFrame();
		window.setSize(800, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new JLabel (new ImageIcon (".//res//space1992.jpg")));
		window.setLayout(null);
		con = window.getContentPane();
		
		// Creating the title
		titlePanel = new JPanel();
		titlePanel.setBounds(5, 75, 770, 150);
		titlePanel.setBackground(new Color(0,0,0,0));
		
		titleLabel = new JLabel("<html><b>Rise of the Chaos Wizard</b><html>");
		titleLabel.setForeground(new Color (0,255,127));
		titleLabel.setFont(Glory);
		
		titlePanel.add(titleLabel);
		con.add(titlePanel);
		
		// Creating the description
		descPanel = new JPanel();
		descPanel.setBounds(75, 240, 650, 150);
		descPanel.setBackground(new Color(0,0,0,150));
		
		descLabel = new JLabel("<html><div style='text-align: center;'>" + descText + "</div></html>");
		descLabel.setForeground(Color.white);
		descLabel.setFont(Pixel);
		
		descPanel.add(descLabel);
		con.add(descPanel);
		
		// Creating the start button
		startPanel = new JPanel();
		startPanel.setBounds(300, 500, 200, 50);
		startPanel.setBackground(new Color(0,0,0,0));
		
		startButton = new JButton("<html><div style='text-align: center;'> START <br/> GAME </div></html>");
		startButton.setBackground(new Color(0,0,0,0));
		startButton.setForeground(Color.black);
		startButton.setFont(Pixel);
		startButton.addActionListener(tsHandler);
		
		startPanel.add(startButton);
		con.add(startPanel);
		
		// Sets entire window visible
		window.setVisible(true);
		
	} // end of game method

	// Intro screen method
		public void PrologueScreen()
		{
			position = "prologue";
			// Disabling title screen
			titlePanel.setVisible(false);
			descPanel.setVisible(false);
			startButton.setVisible(false);
			
			// Creating the main text for the game
			proPanel = new JPanel();
			proPanel.setBounds(65,75,670,250);
			proPanel.setBackground(new Color(0,0,0,150));
			con.add(proPanel);
			
			prologueLabel = new JLabel("<html><div style='text-align: center;'>" + prologue + "</div></html>");
			prologueLabel.setForeground(Color.white);
			prologueLabel.setFont(TextFont);
			
			proPanel.add(prologueLabel);
			
			// Creating choice buttons
			choicePanel = new JPanel();
			choicePanel.setBounds(250, 435, 300, 140);
			choicePanel.setBackground(new Color(0,0,0,115));
			choicePanel.setLayout(new GridLayout (4,1));
			con.add(choicePanel);
			
			choice1 = new JButton("Continue to Intro I");
			choice1.setBackground(Color.black);
			choice1.setForeground(Color.white);
			choice1.setFont(TextFont);
			choice1.addActionListener(csHandler);
			choicePanel.add(choice1);
			
			choice2 = new JButton();
			choice2.setBackground(Color.black);
			choice2.setForeground(Color.white);
			choice2.setFont(TextFont);
			choicePanel.add(choice2);
			
			choice3 = new JButton();
			choice3.setBackground(Color.black);
			choice3.setForeground(Color.white);
			choice3.setFont(TextFont);
			choicePanel.add(choice3);
			
			
			choice4 = new JButton();
			choice4.setBackground(Color.black);
			choice4.setForeground(Color.white);
			choice4.setFont(TextFont);
			choicePanel.add(choice4);
	
		} // end of game screen method
	
		public void Intro1Screen()
		{
			position = "intro1";
			prologueLabel.setVisible(false);
			proPanel.setVisible(false);
			
			i1Panel = new JPanel();
			i1Panel.setBounds(65,75,670,310);
			i1Panel.setBackground(new Color(0,0,0,150));
			con.add(i1Panel);
			
			intro1Label = new JLabel("<html><div style='text-align: center;'>" + intro1 + "</div></html>");
			intro1Label.setForeground(Color.white);
			intro1Label.setFont(TextFont);
			
			i1Panel.add(intro1Label);
			choice1.setText("Continue to Intro II");
			choice1.addActionListener(csHandler);
		}
		
		public void Intro2Screen()
	{
		position = "intro2";
		i1Panel.setVisible(false);
		intro1Label.setVisible(false);
		
		i2Panel = new JPanel();
		i2Panel.setBounds(65,75,670,275);
		i2Panel.setBackground(new Color(0,0,0,150));
		con.add(i2Panel);
		
		intro2Label = new JLabel("<html><div style='text-align: center;'>" + intro2 + "</div></html>");
		intro2Label.setForeground(Color.white);
		intro2Label.setFont(TextFont);
		
		i2Panel.add(intro2Label);
		choice1.setText("Continue to Act I");
		choice1.addActionListener(csHandler);
	}
	
	// Act Intro Screens
		public void Act1Screen()
	{
		position = "act1S";
		i2Panel.setVisible(false);
		intro2Label.setVisible(false);
		
		a1Panel = new JPanel();
		a1Panel.setBounds(65,75,670,250);
		a1Panel.setBackground(new Color(0,0,0,110));
		con.add(a1Panel);
		
		a1Label = new JLabel("<html><div style='text-align: center;'>" + act1 + "</div></html>");
		a1Label.setForeground(Color.white);
		a1Label.setFont(TextFont);
		
		picPanel = new JPanel();
		picPanel.setBounds(-80, -150, 1000, 1000);
		picPanel.setBackground(Color.blue);
		con.add(picPanel);
		
		picLabel = new JLabel();
		image = new ImageIcon(".//res//TFTKOF.jpg");
		picLabel.setIcon(image);
		picPanel.add(picLabel);
		
		a1Panel.add(a1Label);
		choice1.setText("BEGIN QUEST!");
		choice1.addActionListener(isHandler);
	}
		
		public void Act2Screen()
		{
			
		}
	
		public void Act3Screen()
		{
			
		}
		
		public void Act4Screen()
		{
			
		}
		
		// Game screen
		public void GameScreen()
		{
		position = "none";
		a1Panel.setVisible(false);
		a1Label.setVisible(false);
		
		// Text 
		textPanel = new JPanel();
		textPanel.setBackground(Color.black);
		textPanel.setBounds(65,100,670, 260);
		con.add(textPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(70,100,600,260);
		mainTextArea.setBackground(new Color(0, 0, 0, 0));
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(TextFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		textPanel.setBorder(tPanel);
		textPanel.add(mainTextArea);
		
		// Health bar
		hpPanel = new JPanel();
		hpPanel.setBounds(65, 45, 250, 45);
		hpPanel.setBackground(Color.black);
		hpPanel.setForeground(new Color(0, 0, 0, 0));
		hpPanel.setBorder(sPanel);
		con.add(hpPanel);
		
		hpLabel = new JLabel("HP: " + hp + "/" + maxHp);
		hpLabel.setForeground(Color.white);
		hpLabel.setFont(TextFont);
		hpPanel.add(hpLabel);
		
		healthBar = new JProgressBar(0, maxHp);
		healthBar.setPreferredSize(new Dimension (250, 35));
		healthBar.setValue(hp);
		healthBar.setBackground(new Color(0,0,0, 175));
		healthBar.setForeground(new Color(0, 250, 0, 175));
		hpPanel.add(healthBar);
		
		// Stats panel
		playerPanel = new JPanel();
		playerPanel.setBounds(340, 45, 395, 45);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(2,4));
		playerPanel.setBorder(sPanel);
		con.add(playerPanel);
		
		vigorLabel = new JLabel(" Vigor: " + vigor);
		vigorLabel.setFont(TextFont);
		vigorLabel.setForeground(new Color(240, 230, 140));
		playerPanel.add(vigorLabel);
		
		dmgLabel = new JLabel("Damage: " + totalDmg);
		dmgLabel.setFont(TextFont);
		dmgLabel.setForeground(Color.cyan);
		playerPanel.add(dmgLabel);
		
		vitLabel = new JLabel(" Vitality: " + vitality);
		vitLabel.setFont(TextFont);
		vitLabel.setForeground(new Color(178, 34, 34));
		playerPanel.add(vitLabel);

		faithLabel = new JLabel("Faith: " + faith);
		faithLabel.setFont(TextFont);
		faithLabel.setForeground(new Color(148, 0, 211));
		playerPanel.add(faithLabel);
		
		// Enemy stats
		enemyPanel = new JPanel();
		enemyPanel.setBounds(340, 370, 395, 45);
		enemyPanel.setBackground(Color.black);
		enemyPanel.setLayout(new GridLayout(2,4));
		con.add(enemyPanel);
		enemyPanel.setBorder(hPanel);
		
		evigorLabel = new JLabel();
		evigorLabel.setFont(TextFont);
		evigorLabel.setForeground(new Color(240, 230, 140));
		enemyPanel.add(evigorLabel);
		
		edmgLabel = new JLabel();
		edmgLabel.setFont(TextFont);
		edmgLabel.setForeground(Color.cyan);
		enemyPanel.add(edmgLabel);
		
		evitLabel = new JLabel();
		evitLabel.setFont(TextFont);
		evitLabel.setForeground(new Color(178, 34, 34));
		enemyPanel.add(evitLabel);

		efaithLabel = new JLabel();
		efaithLabel.setFont(TextFont);
		efaithLabel.setForeground(new Color(148, 0, 211));
		enemyPanel.add(efaithLabel);
		
		// Enemy hp
		ehpPanel = new JPanel();
		ehpPanel.setBounds(65, 370, 250, 45);
		ehpPanel.setBackground(Color.black);
		ehpPanel.setForeground(new Color(0, 0, 0, 0));
		con.add(ehpPanel);
		ehpPanel.setBorder(hPanel);
		
		ehpLabel = new JLabel();
		ehpLabel.setForeground(Color.white);
		ehpLabel.setFont(TextFont);
		ehpPanel.add(ehpLabel);
		
		ehealthBar = new JProgressBar();
		ehealthBar.setPreferredSize(new Dimension (250, 35));
		ehealthBar.setValue(0);
		ehealthBar.setBackground(new Color(0,0,0, 175));
		ehealthBar.setForeground(new Color(250, 0, 0, 175));
		ehpPanel.add(ehealthBar);
		
		Act1Pathway();
		
	}
	
		public void StatsInfo()
		{
			position = "stats";
			
			mainTextArea.setText( "Stats Legend:"
								+ "\nIncrease these stats by leveling up OR obtaining new gear."
								+ "\n\nVitality: Reduces PHYSICAL damage taken, also slightly increases MAX HP."
								+ "\nFaith: Reduces MAGICAL damage taken, also increases Critcal Strike Chance."
								+ "\nVigor: Dictates who strikes first in battle, also increases Dodge Chance."
								+ "\n\nCritcal Strike: Your attack has a chance to deal double damage."
								+ "\nDodge: You have a chance to dodge an enemy attack.");
		
			ClearButtons();
			choice1.setText("Back");
			choice1.addActionListener(csHandler);
		}
		
		public void ClearButtons()
		{
			// Rest buttons
			choice1.setText("");
			choice1.addActionListener(csHandler);
			choice2.setText("");
			choice2.addActionListener(csHandler);
			choice3.setText("");
			choice3.addActionListener(csHandler);
			choice4.setText("");
			choice4.addActionListener(csHandler);
		}

		public void UpdateStats()
		{	
			totalDmg = ad + ap;
			
			vigorLabel.setText(" Vigor: " + vigor);
			dmgLabel.setText("Damage: " + totalDmg);
			vitLabel.setText(" Vitality: " + vitality);
			faithLabel.setText("Faith: " + faith);	
		}
	
		public void ClearEstats()
		{
			edmgLabel.setText("");
			evitLabel.setText("");
			efaithLabel.setText("");
		}
	
		// ACT I
	// Act 1
	public void Act1Pathway()
		{
			// Position
			position = "act1PW";
			
			picPanel.setVisible(false);
			picLabel.setVisible(false);
			
			XPGained();
			GoldGained();
			
			// Weapon
			weapon = "Royal Short Sword";
			
			// Text and buttons
			mainTextArea.setText("Riding north into the forests of Glenrothes, the young prince stumbles upon a broken wagon. \n\n"
					+ "Angus examines the wagon and notices a trail of footprints leading deeper into the forest. \"Goblins\", he thinks to himself. \n\n"
					+ "What will you do?\n\n\n\n\n\n\n");
			
			// Deeper into forest ; Goblin fight
			choice1.setText("Into the forest!");
			choice1.addActionListener(csHandler);
			
			// Near the path ; run into mysterious potion
			choice2.setText("The path is safer...");
			choice2.addActionListener(csHandler);
			
			// Stat legend
			choice3.setText("Stats info");
			choice3.addActionListener(csHandler);
		}
		
		public void A1Forest()
		{
			// Positions
			position = "a1Forest";
			position2 = "a1Forest";
			
			// Text 
			mainTextArea.setText("Following the footprints into the forest, you see what looks to be an Aberdeen helmet on the ground."
					+ "\nAs you approach the helmet a goblin leaps out from the bush and attacks!"
					+ "\n\nPrepare for epic battle!\n\n\n");
			
			// Goblin fight
			enemy = "Goblin";
			ClearButtons();
			choice1.setText("Fight!");
			choice1.addActionListener(csHandler);
		}
		
				public void A1DeepForest()
				{
					position = "a1DeepF";
					ClearButtons();
					xp = 32;
					Gold = Gold + 12;
					hp = hp + 20;
					maxHp = maxHp + 20;
					vitality = vitality + 5;
					faith = faith + 3;
					
					newItem = "Aberdeen Helm";
					XPGained();
					GoldGained();
					edmgLabel.setText("+12g +32XP");
					evitLabel.setText(" " + newItem + ": ");
					efaithLabel.setText("+20HP +5Vit +3Fth");
					UpdateHP();
					UpdateStats();
					
					goblinKilled = true;
					mainTextArea.setText("The Goblin has been defeated!"
							+ "\n32 XP gained! 12 Gold found!"
							+ "\n\nYou pick up the helmet on the floor next to the Goblin corpse and examine it. It's an Aberdeen helmet, "
							+ "a helmet belonging to a dwarven miner..."
							+ "\n\n" + newItem + " eqiupped!"
							+ "\n\nAs you travel farther into the forest, you see a strange figure wearing a black cloak near a granite pillar.\n\n");
					
					choice1.setText("Speak to the man");
					choice1.addActionListener(csHandler);
					
					choice2.setText("Keep walking");
					choice2.addActionListener(csHandler);
					
				}
	
					public void A1Questlord()
					{
						position = "a1Questlord";
						
						a1QuestlordMet = true;
						
						ClearEstats();
						ClearButtons();
						
						mainTextArea.setText("Upon closer inspection, the mans cloak bears the symbol of the Questlords of Inverness."
								+ "\nA Questlord, of the ancient town of Inverness, is a mighty warrior, loyal to the Kingdom of Fife, whom complete quests given to them by"
								+ " the Lord of Questing."
								+ "\n\nBut this is no ordinary Questlord, his armor is peculiar. White steel covered in buttons filled with small colorfull fires."
								+ " His helmet and chestpiece are covered in strange contraptions."
								+ "\n\n\"Who goes there? State your name or I will defend myself!\"  ");
						
						choice1.setText("I am Angus McFife!");
						choice1.addActionListener(csHandler);
		
					}
					
					public void A1QuestlordA()
					{
						position = "a1QuestlordA";
						ClearButtons();
						mainTextArea.setText("\"Angus McFife? Angus McFife the I? \n\nIt seems I overcharged my EDC and teleported into the far past!"
								+ " My EDC, Enchanted Dimensional Crystal, is no longer charged... I am stuck here. \n\nI need to return to 1992 and warn "
								+ "Angus McFife XIII that a demon horde will invade Mars and alongside it, the great Martian towns!\" \n\n");
						choice1.setText("???");
						choice1.addActionListener(csHandler);
					}
					
					public void A1QuestlordB()
					{
						position = "a1QuestlordB";
						
						ClearButtons();
						
						mainTextArea.setText("\"Do not worry about the events of the far distant future, Angus. There is nothing you can do now"
								+ " that will alter the future, fate has already been decided.\n\nBut there is something that can help me return to my"
								+ " time. The Hammer of Glory. \nThe Gloryhammer was forged in a time before time, powered by lasers entwined in a star; "
								+ "enchanted by crystals suffused with astral fire. My EDC can be powered by the Gloryhammer, which will give me enough energy"
								+ " to return to the Galactic Fortress in 1992. \n\nWill you help me?\"  ");
						choice1.setText("Yes");
						choice1.addActionListener(csHandler);
						
						choice2.setText("No");
						choice2.addActionListener(csHandler);
					}
					
					public void A1QuestlordC()
					{
						position = "a1QuestlordC";
						
						ClearButtons();
						hp = hp + 30;
						a1QuestlordHelp = true;
						newItem = "Small Health Pot";
						evitLabel.setText(" " + newItem + ": ");
						efaithLabel.setText("+30 HP");
						UpdateHP();
						
						mainTextArea.setText("\"Go on Angus, complete your mighty quest to obtain the Hammer of Glory. "
								+ "\nYour legendary journey to liberate the great city of Dundee and save the princess from the clutches of evil will always"
								+ " be remembered! I will see you again once "
								+ "you've obtained the Hammer. \n\nTake this, it will help you on your quest.\""
								+ "\n\n" + newItem + " obtained!"
								+ "\n\n\"For the eternal glory of Dundee!\"        ");
						
						choice1.setText("Onwards!");
						choice1.addActionListener(csHandler);
					}
		
					public void A1QuestlordD()
					{
						position = "a1QuestlordD";
						
						ClearButtons();
						
						ad = ad + 5;
						vigor = vigor + 5;
						faith = faith + 5;
						
						UpdateStats();
						
						newItem = "Charm of Hoots";
						
						evitLabel.setText(" " + newItem + ": ");
						efaithLabel.setText("+5Fth +5Vig +5Dmg");
						
						mainTextArea.setText("\"I understand, retaking the crystaline throne of Dundee is far more important"
								+ " than wasting precious time to assist me. Go forth Angus, aquire the Hammer of Glory and"
								+ " save the Kingdom of Fife, so that your future generations can fight for justice and glory."
								+ "\n\nHere take this, it is a charm the Hollywood Hootsman gave me in 1987.\""
								+ "\n\nCharm of Hoots equipped!"
								+ "\n\n\"For the eternal glory of Dundee!\"              ");
						
						choice1.setText("Forwards!");
						choice1.addActionListener(csHandler);
					}
			
			public void A1StayPath()
			{
				position = "a1StayPath";
				ClearButtons();
				
				mainTextArea.setText("After traveling for what seemed like hours, the mighty mountain, Adjit, can be seen in the distance."
						+ "\n\nBut as you traversed further into path, you stumble upon a strange potion on a gravel patch.\n"
						+ "The potion is a deep purple with strange white stripes. The designs and decorations of the potion container "
						+ "resembles that of the Aberdeen dwarves."
						+ "\n\nWill you drink the potion?\n");
				
				choice1.setText("Drink the potion");
				choice1.addActionListener(csHandler);
				choice2.setText("Discard it");
				choice3.setText("Keep it");
			}
			
			public void A1DrinkPot()
			{
				position = "a1DrinkPot";
				
				ClearButtons();
				
				vigor = 20 + 8;
				vitality = 25 + 7;
				ad = 50 + 6;
				hp = 180;
				maxHp = 180;
				
				a1PotionDrink = true;
				
				UpdateStats();
				UpdateHP();
				
				newItem = "Strange Potion";
				
				evitLabel.setText(" " + newItem + ":");
				efaithLabel.setText("+8Vig +7Vit +6Dmg");
				
				mainTextArea.setText("Drinking the potion turns your stomach and causes you to feel naseous."
						+ "\nThe purple color flows through your veins as you wretch in pain. \n\nA few minutes later and the pain subsides."
						+ "\nYou are filled with energy, power flowing through your veins. \nBut the potion has caused your skin to become"
						+ " extremely bruised.\n\n"
						+ "You lose HP, but gain a large boost to your stats!      ");
				
				choice1.setText("Nice?");
				choice1.addActionListener(csHandler);
			}

			public void A1Pot()
			{
				position = "a1Pot";
				
				ClearButtons();
				
				if (a1PotionKeep)
				{
					newItem = "Strange Potion";
					
					evitLabel.setText(" " + newItem + ": ");
					efaithLabel.setText("???");
					
					mainTextArea.setText("Mysterious Potion obtained!"
							+ "\n\n\"This potion may come in handy later. It may be safer to keep than to drink it\""
							+ "\n\nThe path finally leads to the edge of the forest, following it you see small footprints on the dirt."
							+ "\nToo large to be a goblin print...    ");
				}
				else if (goblinKilled)
				{
					mainTextArea.setText("Leaving the mysterious figure behind, you venutre forth to complete your quest."
							+ "\n\nThe path finally leads to the edge of the forest.\nFollowing the trail you see small footprints on the dirt."
							+ "\nToo large to be a goblin print...   ");
				}
				else
				{
					mainTextArea.setText("You leave the potion alone, perhaps its owner will come looking for it or maybe"
							+ " it would be safer to not drink it."
							+ "\n\nThe path finally leads to the edge of the forest, following it you see small footprints on the dirt."
							+ "\nToo large to be a goblin print...  ");
				}
				
				choice1.setText("Investigate");
				choice1.addActionListener(csHandler);
			}
			
			public void A1Glen()
			{
				position = "a1Glen";
				
				ClearButtons();
				
				if (a1QuestlordHelp == true)
				{
					hp = hp - 30;
					UpdateHP();
				}
				if (a1PotionDrink)
				{
					maxHp = 180;
					hp = 180;
					UpdateHP();
				}
				
				mainTextArea.setText("The forests of Glenrothes soon come to an end as the thicket of trees dwindles."
						+ " The mountain of Adjit can now be seen in full view. As you take in the vista, a dwarf begins shouting."
						+ "\n\n\"Prince! Prince McFife!"
						+ "\nMy wagon, a goblin ambushed me and stole all my gold and goods!"
						+ "\nHave you seen the goblin? Please tell me that the mighty Angus defeated that miniscule goblin with its "
						+ "impractical sword?\"     ");
				
				if (goblinKilled == true)
				{
					choice1.setText("Of course");
					choice1.addActionListener(csHandler);
				}
				else
				{
					choice1.setText("No, I haven't");
					choice1.addActionListener(csHandler);
				}
				
				if (a1PotionKeep == true)
				{
					choice2.setText("Give potion");
					choice2.addActionListener(csHandler);
				}
				
			}
	
			public void A1Dwarf()
			{
				position = "a1Dwarf";
				
				ClearButtons();
				
				// If goblin was killed
				if (goblinKilled)
				{
					Gold = Gold + 15;
					xp = 42;
					
					edmgLabel.setText("+15g +10XP");
					GoldGained();
					XPGained();
					
					mainTextArea.setText("\"Oh thank you valiant prince! I must award thy royal prowess with the little gold I have."
							+ "\n\nPrince Angus, after I fled Dundee, I was attempting to travel to Aberdeen and convince the Dwarven King"
							+ " to rally the dwarves of Aberdeen to fight alongside the Barbarians of Unst to retake Dundee. \nBut that "
							+ "goblin stopped me in my tracks. \n\nDo you know of a way to help me get to Aberdeen?\"    ");
					
					choice1.setText("No, I do not.");
					choice1.addActionListener(csHandler);
					
					// If helped questlord
					if (a1QuestlordHelp || a1QuestlordMet)
					{
						choice2.setText("The Questlord...");
						choice2.addActionListener(csHandler);
					}
				}
				
				// If kept potion
				else if (a1PotionKeep && noIhavent == false)
				{
					Gold = Gold + 15;
					xp = xp + 20;
					ad = 55;
					ap = 10;
					
					edmgLabel.setText("+15g +20XP");
					newItem = "Magic Battleaxe";
					weapon = "Magic Battleaxe";
					evitLabel.setText(" " + newItem + ": ");
					efaithLabel.setText("+15 (5P 10M) Dmg");
					a1RallyDwarves = true;
					
					GoldGained();
					XPGained();
					
					mainTextArea.setText("\"Where did you find this?"
							+ "\n\nI must've dropped it fleeing from the goblin. Thank you."
							+ "\nHere I must award you with the few gold I have! Oh, take my father's enchanted axe, mighty prince!\""
							+ "\n\n" + newItem + " equipped!"
							+ "\n\n\"With this potion, I will have enough energy and strength to travel to Aberdeen alone. I will rally"
							+ " the Aberdeen dwarves to your side!"
							+ "\n\nFor the eternal glory of Dundee!\"   ");
					
					choice1.setText("To the mountain!");
					choice1.addActionListener(csHandler);
				}
				
				// if discarded potion or drank it
				else 
				{
					mainTextArea.setText("\"You did not see such a vile imp? I see."
							+ "\n\nI was traveling to Aberdeen to convince the Dwarven King"
							+ " to rally the dwarves of Aberdeen to fight alongside the Barbarians of Unst to retake Dundee."
							+ "\n\nBut with my wagon broken, goods lost, and that goblin lurking in the forest, I must stay near the"
							+ " Dwarven Caverns and hide until Zargothrax's armies of evil are defeated once and for all!\"   ");
					
					choice1.setText("Unfortunate");
					choice1.addActionListener(csHandler);
				}
			}
	
			public void A1DwarfB()
			{
				position = "a1DwarfB";
	
				ClearButtons();
				
				if (a1QuestlordHelp == true && noIdoNo == false || a1QuestlordMet == true && noIdoNo == false)
				{
					a1RallyDwarves = true;
					
					mainTextArea.setText("\"A Questlord? A Questlord of Inverness? \nBy the heavens, they're almost "
							+ "as mighty as the Knights of Crail!"
							+ "\n\nThank you, young prince! I shall search for that Questlord, so that I may travel safely to "
							+ "Aberdeen. I will rally the Aberdeen dwarves to your side!"
							+ "\n\nFor the eternal glory of Dundee!\"");
				}
				
				else if (noIdoNo == true)
				{

					a1DwarfKilled = true;
					
					mainTextArea.setText("\"I see, then I must travel by foot! Traveling through Glenrothes should be safer"
							+ " with that Golin killed... but, traversing through Dunfermline will be treacherous."
							+ "\n\nA trader from Dunkeld told me that Zargothrax's armies were expanding towards Dunfermline."
							+ " But, rallying the dwarves is far more important! May the light be with you Angus!"
							+ "\nFor the eternal glory of Dundee!\"");
					
				}
				
				choice1.setText("To mount Adjit!");
				choice1.addActionListener(csHandler);
			}
			
			
			public void A1Adjit()
			{
				position = "Adjit";
				
				ClearButtons();
				
				newItem = "Frozen";
				
				evitLabel.setText(" Frozen:");
				efaithLabel.setText("-5Vig -4Vit -3Dmg");
				
				UpdateStats();
				
				mainTextArea.setText("You finally reach the mountain. At the very peak, you can see a cave with a grand and mystic entrance."
						+ "\nA crude bridge that crosses a large chasm, seems to be the only path to the base of the mountain."
						+ "\n\nThe sun sets and the freezing mountain winds set in. Your armor and weapons soon become covered in ice."
						+ "\nYou decide to set camp here.");
				
				choice1.setText("Rest");
				choice1.addActionListener(csHandler);
			}
			
	// Battle methods
	public void fightGUI(int eHP, int eMHP, int eVig, int eVit, int eFth, int eDmg)
			{
				position ="fight";
				
				// Enemy stats
				evigorLabel.setText(" Vigor: " + eVig);
				edmgLabel.setText("Damage: " + eDmg);
				evitLabel.setText(" Vitality: " + eVit);
				efaithLabel.setText("Faith: " + eFth);
				
				// Enemy hp
				ehpLabel.setText(enemy + " HP: " + eHP + "/" + eMHP);
				
				ehealthBar.setMinimum(0);
				ehealthBar.setMaximum(eMHP);
				ehealthBar.setValue(eHP);
				ehealthBar.setForeground(new Color(250, 0, 0, 175));
			}

			public void A1Amulet()
			{
				position = "a1Amulet";
				
				ClearButtons();
				
				vigor = vigor - 5;
				vitality = vitality - 4;
				ad = ad - 3;
				UpdateStats();
				
				mainTextArea.setText("As you rest by the campfire you begin to dream."
						+ "\n\nIn this dream you see yourself wielding the Hammer of Glory atop a dragon made of steel."
						+ "\nYou soon land in a mysterious river where you uncover a strange amulet. The amulet begins to glow a bright red,"
						+ " so bright that it begins to radiate immense heat. You hear a woman's faint voice crying for help. The voice sounds"
						+ " familiar to the prince..."
						+ "\n\nYou wake up in a sweat. The sun has begun to rise, you pick up your weapons and head towards the bridge...");
				
				choice1.setText("WIP :(");
			}
	public void PlayerAttack(int enemyDamage, int playerDamage, int eHP)
	{
		position = "playerAttack";
		
		// Checking if player or enemy still have hp
		if (eHP < 1)
		{
			NextScene();
		}
		else if (hp < 1)
		{
			GameOver();
		}
		
		// Fight if hp is >1
		else
		{

		fightGUI(GobHP, GobMHP, GobVig, GobVit, GobFth, GobTD);
		mainTextArea.setText("You attack the goblin with a mighty slash!"
				+ "\nYou deal " + playerDamage +" damage to the " + enemy +"!"
				+ "\n\nThe " + enemy + " prepares its next attack...\n\n\n");
		
		hp = hp - enemyDamage;
		UpdateHP();
		
		// If 
		if (round == 2)
		{
			GobHP = GobHP - playerDamage;
		}
		
		ClearButtons();
		choice1.setText("Attack");
		choice1.addActionListener(csHandler);
		
		if (hp < 1)
		{
			GameOver();
		}
		
		}
		
	}
	
	public void EnemyAttack(int enemyDamage, int playerDamage, int eHP)
	{
		position = "enemyAttack";
		round = 1;

		if (eHP < 1)
		{
			NextScene();
		}
		else if (hp < 1)
		{
			GameOver();
		}
		else
		{
		fightGUI(GobHP, GobMHP, GobVig, GobVit, GobFth, GobTD);
		mainTextArea.setText("The " + enemy + " is quicker than you and strikes!"
				+ "\nYou take " + enemyDamage + " damage!"
				+ "\n\nYou ready your senses and raise your " + weapon + "...\n\n\n");
		
		 UpdateHP();
	

		if (round >= 2)
		{
			GobHP = GobHP - playerDamage;
			fightGUI(GobHP, GobMHP, GobVig, GobVit, GobFth, GobTD);
		}
		round++;
		ClearButtons();
		choice1.setText(">");
		choice1.addActionListener(csHandler);
		
		if (hp < 1)
		{
			GameOver();
		}
		
		}
	}
	
	public void NextScene()
	{	
		ehealthBar.setValue(0);
		ehpLabel.setText("Enemy Defeated!");
		
		ClearEstats();
		
		
		mainTextArea.setText("");
		switch (position2)
		{
		case "a1Forest": A1DeepForest(); break;
		}
	}

	public void GameOver()
	{
		position = "GameOver";
		hp = 0;
		healthBar.setValue(hp);
		hpLabel.setText("HP: " + hp + "/" + maxHp);
		ClearButtons();
		mainTextArea.setText("You have been slain by " + enemy + "..."
				+ "\n\nThe young prince falls to the ground accepting his terrible fate."
				+ "\nAngus McFife has been vanquished. \n\nWith no hero to liberate Dundee from the clutches of Zargothrax, the evil"
				+ " wizard begins his reign of terror over the lands of Dundee..."
				+ "\n\nThe Kingdom of Fife has been lost to the forces of evil. Dundee's fallen pride will never be "
				+ "restored again -- Game over.\n\n");
	}
	
	public void XPGained()
	{
		ehpLabel.setText("Lv." + level + "   XP: " + xp + "/" + xpUp);
		
		ehealthBar.setMinimum(0);
		ehealthBar.setMaximum(xpUp);
		ehealthBar.setValue(xp);
		ehealthBar.setForeground(Color.white);
	}
	
	public void GoldGained()
	{
		evigorLabel.setText(" Gold: " + Gold);
	}

	public void UpdateHP()
	{
		hpLabel.setText("HP: " + hp + "/" + maxHp);
		healthBar.setMaximum(maxHp);
		healthBar.setValue(hp);
	}
	
	// Event handlers
	public class TitleScreenHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			PrologueScreen();
		}
	}
	
	public class IntroScreenHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			GameScreen();	
		}
	}

	public class ChoiceHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{	
			// Button input
			String yourChoice = event.getActionCommand();
			// Button output
			// Intro screens
			switch (position)
			{
				case "prologue":
					switch(yourChoice)
					{
						case "Continue to Intro I": Intro1Screen(); break;
					}
				case "intro1":
					switch(yourChoice)
					{
					case "Continue to Intro II": Intro2Screen(); break;
					}
				case "intro2":
					switch(yourChoice)
					{
					case "Continue to Act I": Act1Screen(); break;
					}
				case "act1S":
					switch(yourChoice)
					{
					case "BEGIN QUEST!": Act1Pathway(); break;
					}
				// ACT I
				case "stats":
					switch(yourChoice)
					{
					case "Back": Act1Pathway(); break;
					}
					
					case "act1PW":
						switch(yourChoice)
						{
						case "Into the forest!": A1Forest(); break;
						case "The path is safer...": A1StayPath();  break;
						case "Stats info": StatsInfo(); break;
						}
						case "a1Forest":
							switch(yourChoice)
							{
							case "Fight!": 
								fightGUI(GobHP, GobMHP, GobVig, GobVit, GobFth, GobTD);
								EnemyAttack(GobDmg, totalDmg, GobHP); break;
							}
							case "playerAttack":
								switch (yourChoice)
								{
								case "Attack": EnemyAttack(GobDmg, totalDmg, GobHP); break;
								}
							case "enemyAttack":
								switch (yourChoice)
								{
								case ">": PlayerAttack(GobDmg, totalDmg, GobHP);
								}
							case "a1DeepF":
								switch (yourChoice)
								{
								case "Speak to the man": A1Questlord(); break;
								case "Keep walking": A1Pot();
								}
							case "a1Questlord":
							{
								switch (yourChoice)
								{
									case "I am Angus McFife!": A1QuestlordA(); break;
								}
							}
							
							case "a1QuestlordA":
							{
								switch (yourChoice)
								{
									case "???": A1QuestlordB(); break;
								}
							}
							
							case "a1QuestlordB":
							{
								switch (yourChoice)
								{
									case "Yes": A1QuestlordC(); break;
									case "No": A1QuestlordD(); break;
								}
							}
							case "a1StayPath":
							{
								switch (yourChoice)
								{
									case"Drink the potion": A1DrinkPot(); break;
									case"Discard it": A1Pot(); break;
									case"Keep it": a1PotionKeep = true; A1Pot(); break;
								}
							}
							case "a1DrinkPot":
							{
								switch (yourChoice)
								{
								case "Nice?": A1Glen(); break;
								}
							}
							
							case "a1QuestlordC":
							{
								switch (yourChoice)
								{
								case "Onwards!": A1Glen(); break;
								}
							}
							
							case "a1QuestlordD":
							{
								switch (yourChoice)
								{
								case "Forwards!": A1Glen(); break;
								}
							}
							
							case "a1Pot":
							{
								switch (yourChoice)
								{
								case "Investigate": A1Glen(); break;
								}
							}
							
							case "a1Glen":
								switch (yourChoice)
								{
								case "Of course": A1Dwarf(); break;
								case "No, I haven't": noIhavent = true; A1Dwarf(); break;
								case "Give potion": A1Dwarf(); break;
								}
							case "a1Dwarf":
								switch (yourChoice)
								{
									case "No, I do not.": noIdoNo = true; A1DwarfB(); break;
									case "The Questlord...": A1DwarfB(); break;
									case "To the mountain!": A1Adjit(); break;
									case "Unfortunate": A1Adjit(); break;
								}
							case "a1DwarfB":
								switch (yourChoice)
								{
								case "To mount Adjit!": A1Adjit(); break;
								}
							case "Adjit":
								switch (yourChoice)
								{
								case "Rest": A1Amulet(); break;
								}
					
					
					
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
} // end of main class