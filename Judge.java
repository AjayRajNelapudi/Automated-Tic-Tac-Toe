package ttt;
import javax.swing.*;
public class Judge
{
	char field[];
	int pattern[][]= {{0,1,2},{3,4,5},{6,7,8},
					  {0,3,6},{1,4,7},{2,5,8},
					  {0,4,8},{2,4,6}		};
	char winnerLetter;
	AlgorithmDeAjay ADA;
	JButton b[];
	
	Judge(FrontEnd target)
	{
		this.b=target.field;
	}
	
	public void checkWinner()
	{
		for(int i=0;i<9;i++)
		{
			String value=b[i].getActionCommand();
			this.field[i]=value.charAt(0);
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
		System.out.println("The winner is " + winnerLetter);
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
		System.out.println("Game Draw");
		System.exit(0);
	}
}
