
package tic_tac_toe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tic_tac_toe implements ActionListener{
	private JFrame frame;
	private JPanel panel;
	private JButton[] buttons = new JButton[9];
	private boolean xTurn = true;
	
	public Tic_tac_toe()
	{
		frame = new JFrame("Tic-Tac-Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		for(int i = 0; i < 9; i++)
		{
			buttons[i] = new JButton();
			buttons[i].setFont(new Font("Algerian",Font.PLAIN,70));
			buttons[i].addActionListener(this);
                        buttons[i].setBackground(Color.black);
			panel.add(buttons[i]);
		}
		frame.add(panel,BorderLayout.CENTER);
		frame.setSize(400,400);
		frame.setVisible(true);
                frame.setResizable(false);
                frame.setBounds(600,200,400,400);
//		frame.setBackground(Color.BLACK);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton button = (JButton) e.getSource();
		if(xTurn)
		{
			button.setText("X");
		}
		else
		{
			button.setText("O");
		}
		button.setEnabled(false);
		xTurn = !xTurn;
		
		checkForWinner();
	}
	public void checkForWinner()
	{
		//check rows
		for(int i = 0 ; i < 9 ; i+=3)
		{
			if(buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled())
			{
				JOptionPane.showMessageDialog(frame, buttons[i].getText() + " Wins!");
				resetGame();
				return;
			}
		}
		//check columns
		for(int i = 0 ; i < 3 ; i++)
		{
			if(buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled())
			{
				JOptionPane.showMessageDialog(frame, buttons[i].getText() + " Wins!");
				resetGame();
				return;
			}
		}
		//check diagonals
		if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled())
				{
					JOptionPane.showMessageDialog(frame, buttons[0].getText() + " Wins!");
					resetGame();
					return;
				}
		if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled())
				{
					JOptionPane.showMessageDialog(frame, buttons[2].getText() + " Wins!");
					resetGame();
					return;
				}
		//check for tie
		boolean tie = true;
		for(int i = 0; i<9;i++)
		{
			if(buttons[i].isEnabled())
			{
				tie = false;
				break;
			}
		}
		if(tie)
		{
			JOptionPane.showMessageDialog(frame,"Tie Game!");
			resetGame();
		}
	}
	public void resetGame()
	{
		for(int i = 0 ;i<9;i++)
		{
			buttons[i].setText("");
			buttons[i].setEnabled(true);
		}
		xTurn = true;
	}
	public static void main(String[] args)
	{
		new Tic_tac_toe();
	}
}
