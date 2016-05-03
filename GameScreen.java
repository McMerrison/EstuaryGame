import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import java.awt.event.*;
import javax.swing.*;

public class GameScreen extends JPanel{
	
	/**
	 * 
	 */
	
    private Collection<Handler> handlerCollection;
    private static final long serialVersionUID = 1L;
    /*
     * ImageBank contains a set of Sprite Set
     * SpriteSets contains a list of all Image Sets for a GameObject
     * Image Sets contains a list of Images for an animation of a GameObject
     *
     */
    
    public GameScreen()
    {
    	super();
    	this.setBackground(Color.GRAY);
    	this.setOpaque(true);
    	this.setFocusable(true);
		this.handlerCollection = new LinkedList<Handler>();
		
    }
	
	public void add(Handler handler)
	{
		handlerCollection.add(handler);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (Handler handler : handlerCollection )
		{
			handler.paint(g);
		}			
	}

	
	public Collection<Handler> getHandlerCollection() {
		return handlerCollection;
	}

	


}
