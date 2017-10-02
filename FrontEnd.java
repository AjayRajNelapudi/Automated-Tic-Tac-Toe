package ttt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FrontEnd implements ActionListener
{
	public Frame f;
	public JButton field[];
	AlgorithmDeAjay AI;
	Judge winner;
	public void userInterface()
	{
		f= new Frame("AUTOMATA - TIC TAC TOE");
		f.setLayout(new GridLayout(3,3,100,100));
		String buttonLabels[]= {"1","2","3","4","5","6","7","8","9"};
		JButton field[]=new JButton[9];
		this.field=field;
		f.setBackground(Color.BLUE);
		for(int i=0;i<9;i++)
		{
			field[i]=new JButton();
			field[i].setText(buttonLabels[i]);
			field[i].setSize(50, 50);
			field[i].setForeground(Color.BLACK);
			field[i].setBackground(Color.BLUE);
			field[i].addActionListener(this);
			f.add(field[i]);
		}
		AI=new AlgorithmDeAjay(field);
		winner=new Judge(this);
		f.setSize(500,500);
		f.setVisible(true);
	}
	
	/*FrontEnd()
	{
		AI=new AlgorithmDeAjay(field);
		winner=new Judge(field);
	}*/
	
	public void actionPerformed(ActionEvent e)
	{
		int number=Integer.parseInt(e.getActionCommand());
		field[number-1].setText("X");
		AI.makeMove();
		winner.checkWinner();
	}
	
	public static void main(String args[])
	{
		FrontEnd runner=new FrontEnd();
		runner.userInterface();
	}
}
