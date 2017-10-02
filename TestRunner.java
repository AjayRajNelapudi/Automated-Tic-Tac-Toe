package ttt;
import java.util.Scanner;

public class TestRunner
{
	public static void main(String args[])
	{
		Scanner read=new Scanner(System.in);
		boolean flag=true;
		int n;
		char field[]={'1','2','3','4','5','6','7','8','9'};

		System.out.println(field[0] + " " + field[1] + " " + field[2]);
		System.out.println(field[3] + " " + field[4] + " " + field[5]);
		System.out.println(field[6] + " " + field[7] + " " + field[8]);
		AlgorithmDeAjay AI=new AlgorithmDeAjay(field);
		Judge winner=new Judge(field,AI);
		while(flag)
		{
			n=read.nextInt();
			
			if(n<10)
			{
				field[n-1]='X';
				AI.makeMove();
				System.out.println(field[0] + " " + field[1] + " " + field[2]);
				System.out.println(field[3] + " " + field[4] + " " + field[5]);
				System.out.println(field[6] + " " + field[7] + " " + field[8]);
				winner.checkWinner();
			}
			else
			{
				flag=false;
			}
		}
		read.close();
	}
}
