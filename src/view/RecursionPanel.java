package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.RecursionController;

public class RecursionPanel extends JPanel
{
	private RecursionController baseController;
	private JButton fibonacciButton;
	private JButton factorialButton;
	private JTextField inputField;
	private JTextArea resultsArea;
	private SpringLayout baseLayout;
	

	
	public RecursionPanel(RecursionController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		fibonacciButton = new JButton("Get the Fibonacci sequence for this number");
		factorialButton = new JButton("Get n");
		inputField = new JTextField(20);
		resultsArea = new JTextArea(10, 20);
	
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(fibonacciButton);
		this.add(factorialButton);
		this.add(inputField);
		this.add(resultsArea);
		this.setBackground(Color.CYAN);
		resultsArea.setWrapStyleWord(true);
		resultsArea.setLineWrap(true);
		resultsArea.setEditable(false);
		resultsArea.setText(baseController.getCalculatedValue());
	}
	
	public void setupLayout()
	{	
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -6, SpringLayout.NORTH, fibonacciButton);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -80, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, fibonacciButton, -6, SpringLayout.NORTH, resultsArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, resultsArea, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, resultsArea, -96, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, factorialButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, factorialButton, -175, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, fibonacciButton, -58, SpringLayout.EAST, this);
	}
	
	public void setupListeners()
	{
		fibonacciButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userInput = inputField.getText();
				if(checkInput(userInput))
				{
					resultsArea.setText(baseController.doFibonacci(userInput));
				}
			}
		});
		
		factorialButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userInput = inputField.getText();
				if(checkInput(userInput))
				{
					resultsArea.setText(baseController.doFactorial(userInput));
				}
			}
		});
	}
	
	private boolean checkInput(String input)
	{
		boolean isNumber = false;
		
		try
		{
			Integer.parseInt(input);
			isNumber = true;
		}
		catch(Exception numberException)
		{
			resultsArea.setText("Type in a Number you fool!");
		}
		
		return isNumber;
	}
}
