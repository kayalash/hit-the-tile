// The "HitTheTile" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class HitTheTile extends Applet implements KeyListener
{
    AudioClip noyourefinished;
    AudioClip bubblepop;
    Image trump;
    boolean left = false;
    boolean middle = false;
    boolean right = false;
    boolean start = false;
    boolean lose = false;
    boolean box[] = new boolean [18];
    int points = 0;
    int highscore = 0;
    Font font = new Font ("SansSerif", Font.BOLD, 25);
    Font font1 = new Font ("SansSerif", Font.ITALIC, 13);
    Font font2 = new Font ("SansSerif", Font.BOLD, 13);
    Font font3 = new Font ("Serif", Font.PLAIN, 13);


    public void init ()
    {
	addKeyListener (this); // adds KeyListener
	trump = getImage (getCodeBase (), "trump.jpg"); // initializes image
	noyourefinished = getAudioClip (getCodeBase (), "noyourefinished.wav"); // initalizes audioclip
	bubblepop = getAudioClip (getCodeBase (), "bubblepop.wav"); // initializes audioclip
    } // init method


    public void paint (Graphics g)
    {
	game (g); // game method; checks if lost = true
	if (start == false) // intro screen
	{
	    if (points > highscore)
	    {
		highscore = points; // changes highscore value if beaten
	    }
	    for (int i = 0 ; i < 18 ; i++)
	    {
		box [i] = false; // resets all boxes to false; white
	    }
	    lose = false;
	    points = 0; // resets points value to 0
	    g.drawRect (10, 10, 300, 300); // draws gameboard
	    g.setFont (font); // changes font
	    g.setColor (Color.black);
	    g.drawString ("HIT THE TILES!", 75, 50); // title
	    g.setFont (font1);
	    g.drawString ("Open the window to maximum to get the best", 25, 75);
	    g.drawString ("gaming experience", 25, 90);
	    g.setFont (font2);
	    g.drawString ("Instructions: ", 25, 120);
	    g.setFont (font3);
	    g.drawString ("The object of the game is to hit the most tiles in", 25, 140); // instructions
	    g.drawString ("the fastest time possible. The board is made up of", 25, 155);
	    g.drawString ("3 columns. The first column is 'f', the second", 25, 170);
	    g.drawString ("column is 'g', and the third column is 'h'. Hit the", 25, 185);
	    g.drawString ("corresponding letter to the tiles that are black in", 25, 200);
	    g.drawString ("the red box of the board. If the red box is all white,", 25, 215);
	    g.drawString ("hit 't'. You lose when you click a wrong letter. ", 25, 230);
	    g.drawString ("*Turn up volume*", 105, 255);
	    g.setFont (font2);
	    g.drawString ("Hit 'q' to start", 110, 285); // instruction to start game
	    g.drawRect (100, 265, 105, 30);
	    g.drawString ("Highscore: " + highscore, 125, 335); // shows high score
	}
	if ((start == true) && (lose == false)) // start of game
	{
	    g.setFont (font);
	    g.drawString ("Score: " + points, 115, 370); // displays score
	    g.setFont (font2);
	    g.drawString ("Highscore: " + highscore, 125, 335); // displays highscore
	    g.drawString ("The object of the game it to hit the most tiles in", 330, 140); // displays instructions
	    g.drawString ("the fastest time possible. The board us made up of", 330, 155); // beside gameboard
	    g.drawString ("3 columns. The first column is 'f', the second", 330, 170);
	    g.drawString ("column is 'g', and the third column is 'h'. Hit the", 330, 185);
	    g.drawString ("corresponding letter to the tiles that are black in", 330, 200);
	    g.drawString ("the red box of the board. If the red box is all white,", 330, 215);
	    g.drawString ("hit 't'. You lose when you click a wrong letter. ", 330, 230);
	    g.drawRect (10, 10, 300, 300); // draws the gameboard
	    g.drawLine (110, 10, 110, 310); // draws individual boxes
	    g.drawLine (210, 10, 210, 310);
	    g.drawLine (10, 60, 310, 60);
	    g.drawLine (10, 110, 310, 110);
	    g.drawLine (10, 160, 310, 160);
	    g.drawLine (10, 210, 310, 210);
	    g.drawLine (10, 260, 310, 260);
	    shift (); // shifts rows of boxes with KeyTyped
	    topRow (); // puts random box in top row
	    fillBox (g); // fills black boxes
	}
    } // paint method


    public void topRow ()
    {
	int b = (int) (Math.random () * 3); // choses random box on top row
	int a = (int) (Math.random () * 5); // choses random number
	if (b == 0) // if b == 0, 1sr box is filled
	{
	    box [0] = true;
	    box [1] = false;
	    box [2] = false;
	}
	else if (b == 1) // if b == 1, 2nd box is filled
	{
	    box [0] = false;
	    box [1] = true;
	    box [2] = false;
	}
	else if (b == 2) // if b == 1, 3rd box is filled
	{
	    box [0] = false;
	    box [1] = false;
	    box [2] = true;
	}
	if (a == 2) // if a == 2, no boxes are filled
	{
	    box [0] = false;
	    box [1] = false;
	    box [2] = false;
	}
    } // topRow method


    public void shift () // shifts rows top down one row
    {
	box [17] = box [14];
	box [16] = box [13];
	box [15] = box [12];
	box [14] = box [11];
	box [13] = box [10];
	box [12] = box [9];
	box [11] = box [8];
	box [10] = box [7];
	box [9] = box [6];
	box [8] = box [5];
	box [7] = box [4];
	box [6] = box [3];
	box [5] = box [2];
	box [4] = box [1];
	box [3] = box [0];
    } // shift method


    public void fillBox (Graphics g) // fills in rectangles that are true
    {
	if (box [0] == true)
	{
	    g.fillRect (12, 12, 96, 46);
	}
	if (box [1] == true)
	{
	    g.fillRect (112, 12, 96, 46);
	}
	if (box [2] == true)
	{
	    g.fillRect (212, 12, 96, 46);
	}
	if (box [3] == true)
	{
	    g.fillRect (12, 62, 96, 46);
	}
	if (box [4] == true)
	{
	    g.fillRect (112, 62, 96, 46);
	}
	if (box [5] == true)
	{
	    g.fillRect (212, 62, 96, 46);
	}
	if (box [6] == true)
	{
	    g.fillRect (12, 112, 96, 46);
	}
	if (box [7] == true)
	{
	    g.fillRect (112, 112, 96, 46);
	}
	if (box [8] == true)
	{
	    g.fillRect (212, 112, 96, 46);
	}
	if (box [9] == true)
	{
	    g.fillRect (12, 162, 96, 46);
	}
	if (box [10] == true)
	{
	    g.fillRect (112, 162, 96, 46);
	}
	if (box [11] == true)
	{
	    g.fillRect (212, 162, 96, 46);
	}
	if (box [12] == true)
	{
	    g.fillRect (12, 212, 96, 46);
	}
	if (box [13] == true)
	{
	    g.fillRect (112, 212, 96, 46);
	}
	if (box [14] == true)
	{
	    g.fillRect (212, 212, 96, 46);
	}
	if (box [15] == true)
	{
	    g.fillRect (12, 262, 96, 46);
	}
	if (box [16] == true)
	{
	    g.fillRect (112, 262, 96, 46);
	}
	if (box [17] == true)
	{
	    g.fillRect (212, 262, 96, 46);
	}
	g.setColor (Color.red);
	g.drawRect (10, 260, 300, 50);
    } // fillBox method


    public void delay (int time) // delay methdod
    {
	try
	{
	    Thread.sleep (time);
	}
	catch (InterruptedException e)
	{

	}
    } // delay method


    public void keyTyped (KeyEvent e) // checks if a key is typed
    {
	char c = e.getKeyChar (); // checks which key is typed
	if (c == 'f')
	{
	    bubblepop.play (); // play bubble sound
	    left = true;
	    repaint ();
	    points += 1; // adds a point
	    if (box [15] == false) // checks if key typed is wrong
	    {
		lose = true;
		start = false;
	    }
	}
	if (c == 'g') 
	{
	    bubblepop.play (); // plays bubble sound
	    middle = true;
	    repaint ();
	    points += 1; // adds a point
	    if (box [16] == false) // check if key typed is wrong
	    {
		lose = true;
		start = false;
	    }
	}
	if (c == 'h') 
	{
	    bubblepop.play (); // plays bubble sound
	    right = true;
	    repaint ();
	    points += 1; // adds a point 
	    if (box [17] == false) // checks if key typed is wrong
	    {
		lose = true;
		start = false;
	    }
	}
	if (c == 'q') // if key is typed, start game
	{
	    start = true;
	    repaint ();
	}
	if (c == 't') 
	{
	    bubblepop.play (); // plays bubble sound
	    start = true;
	    repaint ();
	    points += 1; // adds a point
	    if ((box [15] == true) || (box [16] == true) || (box [17] == true)) // checks if key typed is wrong
	    {
		lose = true;
		start = false;
	    }
	}
    } // keyTyped method


    public void game (Graphics g)
    {
	if (lose == true)
	{
	    g.drawImage (trump, 10, 10, null); // draws image
	    delay (500);
	    noyourefinished.play (); // plays soundbite
	    delay (500);
	    lose = false;
	    repaint ();
	}
    }


    public void keyReleased (KeyEvent e)
    {

    } // keyReleased method


    public void keyPressed (KeyEvent e)
    {

    } // keyPressed method
} // HitTheTile class
