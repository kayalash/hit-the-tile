// The "Timer" class.
import java.applet.*;
import java.awt.*;

public class Timer extends Applet
{
    int x = 60;

    public void init ()
    {

    } // init method


    public void paint (Graphics g)
    {
	g.drawString ("TIMER " + x, 100, 100);
	x--;
	delay (1000);
	if (x >= 0)
	{
	    repaint ();
	}
    } // paint method


    public void delay (int time)
    {
	try
	{
	    Thread.sleep (time);
	}
	catch (InterruptedException e)
	{

	}
    } // delay method
} // Timer class
