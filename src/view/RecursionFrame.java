package view;

import controller.RecursionController;
import javax.swing.JFrame;

public class RecursionFrame extends JFrame
{
	private RecursionPanel basePanel;
	private RecursionController baseController;
	
	public RecursionFrame(RecursionController baseController)
	{
		basePanel = new RecursionPanel(baseController);
		this.baseController = baseController;
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("let's recurse");
		this.setSize(500, 500);
		this.setVisible(true);
		
	}
	
}
