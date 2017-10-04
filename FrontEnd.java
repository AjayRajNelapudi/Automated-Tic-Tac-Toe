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
	Font fontDescription;
	public void userInterface()
	{
		fontDescription=new Font("Arial",Font.BOLD, 33);
		String buttonLabels[]= {"1","2","3","4","5","6","7","8","9"};
		JButton field[]=new JButton[9];
		this.field=field;
		//Dimension size=new Dimension(30,30);
		f= new Frame("AUTOMATA - TIC TAC TOE");
		f.setLayout(new GridLayout(3,3,100,100));
		f.setBackground(Color.cyan);
		for(int i=0;i<9;i++)
		{
			field[i]=new JButton();
			//field[i].setSize(size);
			field[i].setText(buttonLabels[i]);
			//field[i].setForeground(Color.BLACK);
			field[i].setBackground(Color.white);
			field[i].addActionListener(this);
			f.add(field[i]);
		}
		AI=new AlgorithmDeAjay(field);
		winner=new Judge(field,AI);
		f.setSize(500,500);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int number=Integer.parseInt(e.getActionCommand());
		field[number-1].setFont(fontDescription);
		field[number-1].setText("X");
		winner.checkWinner(field);
		AI.makeMove();
		winner.checkWinner(field);
	}
	
	public static void main(String args[])
	{
		FrontEnd runner=new FrontEnd();
		runner.userInterface();
	}
}
