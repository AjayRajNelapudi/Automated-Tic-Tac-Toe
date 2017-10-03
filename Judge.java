package ttt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Judge implements ActionListener
{
	char field[];
	int pattern[][]= {{0,1,2},{3,4,5},{6,7,8},
					  {0,3,6},{1,4,7},{2,5,8},
					  {0,4,8},{2,4,6}		};
	char winnerLetter;
	AlgorithmDeAjay ADA;
	JButton b[];
	
	Judge(JButton b[], AlgorithmDeAjay AI)
	{
		this.b=b;
		this.ADA=AI;
		field=new char[9];
	}
	
	public void checkWinner(JButton b[])
	{	
		for(int i=0;i<9;i++)
		{
			this.field[i]=b[i].getActionCommand().charAt(0);
		}
		
		for(int i=0;i<8;i++)
		{
			if(patternCheck(pattern[i][0], pattern[i][1], pattern[i][2]))
			{
				declareWinner();
			}
			else if(drawCheck())
			{
				gameDraw();
			}
		}
	}
	
	public boolean patternCheck(int x, int y, int z)
	{
		if(field[x]=='X' && field[y]=='X' && field[z]=='X')
		{
			winnerLetter='X';
			return true;
		}
		else if(field[x]=='O' && field[y]=='O' && field[z]=='O')
		{
			winnerLetter='O';
			return true;
		}
		
		return false;
	}
	
	public void declareWinner()
	{
		Frame f=new Frame("Game Over");
		f.setSize(200,200);
		f.setLayout(new FlowLayout());
		Label status=new Label();
		f.setVisible(true);
		f.setBackground(Color.RED);
		status.setText("The winner is letter '" + winnerLetter + "' player");
		Label wishes=new Label();
		if(winnerLetter=='X')
		{
			wishes.setText("Congratulations!");
		}
		else if(winnerLetter=='O')
		{
			wishes.setText("You Lose!");
		}
		f.add(status);
		f.add(wishes);
		Button okButton=new Button("OK");
		f.add(okButton);
		okButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	
	public boolean drawCheck()
	{
		for(int i=0;i<9;i++)
		{
			if(ADA.isDigit(field[i]))
			{
				return false;
			}
		}
		return true;
	}
	
	public void gameDraw()
	{
		Frame f=new Frame("Game Over");
		f.setSize(200,200);
		f.setLayout(new FlowLayout());
		Label status=new Label();
		f.setVisible(true);
		f.setBackground(Color.RED);
		status.setText("Game Draw");
		f.add(status);
		Button okButton=new Button("OK");
		f.add(okButton);
		okButton.addActionListener(this);
	}
}
