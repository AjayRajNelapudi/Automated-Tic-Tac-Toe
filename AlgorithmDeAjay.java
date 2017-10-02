package ttt;

public class AlgorithmDeAjay
{
	char field[];
	short change;
	int pattern[][]= {{0,1,2},{3,4,5},{6,7,8},
					  {0,3,6},{1,4,7},{2,5,8},
					  {0,4,8},{2,4,6}		};
	
	AlgorithmDeAjay(char field[])
	{
		this.field=field;
	}

	public void makeMove()
	{
		if(attack())
		{
			return;
		}
		if(defend())
		{
			return;
		}
		advancedAttack();
	}
	
	public boolean defend()
	{
		//System.out.println("Defense");
		
		for(int i=7;i>=0;i--)
		{
			//System.out.println(pattern[i][0] + "," + pattern[i][1] + "," + pattern[i][2]);
			if(decideMove(pattern[i][0], pattern[i][1], pattern[i][2],'X'))
			{
				//System.out.println(pattern[i][0] + "," + pattern[i][1] + "," + pattern[i][2]);
				return true;
			}
		}
		
		
		if(advancedDefense())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean attack()
	{
		//System.out.println("Attack");
		
		for(int i=7;i>=0;i--)
		{
			if(decideMove(pattern[i][0], pattern[i][1], pattern[i][2],'O'))
			{
				//System.out.println(pattern[i][0] + "," + pattern[i][1] + "," + pattern[i][2]);
				return true;
			}
		}
		return false;
	}
	
	public boolean decideMove(int x, int y, int z, char var)
	{
		if(field[x]==var && field[y]==var && isDigit(field[z]))
		{
			field[z]='O';
			return true;
		}
		else if(field[x]==var && isDigit(field[y]) && field[z]==var)
		{
			field[y]='O';
			return true;
		}
		else if(isDigit(field[x]) && field[y]==var && field[z]==var)
		{
			field[x]='O';
			return true;
		}
		
		return false;
	}
	
	public boolean advancedDefense()
	{
		int edge[][]= {{1,2,5},{5,8,7},{7,6,3},{3,0,1}};
		for(int i=0;i<4;i++)
		{
			if(field[edge[i][0]]=='X' && field[edge[i][2]]=='X')
			{
				field[edge[i][1]]='O';
				return true;
			}
		}
		return false;
	}
	
	public void advancedAttack()
	{
		char myMove='O';
		
		if(isDigit(field[4]))
		{
			field[4]=myMove;
			return;
		}
		else
		{
			int cornerPoints[]= {0,2,8,6};
			for(int i: cornerPoints)
			{
				if(isDigit(field[i]))
				{
					field[i]=myMove;
					return;
				}
			}
			
			int midPoints[]= {1,3,5,7};
			for(int i: midPoints)
			{
				if(isDigit(field[i]))
				{
					field[i]=myMove;
					return;
				}
			}
		}
	}

	public boolean isDigit(char var)
	{
		char digits[]={'1','2','3','4','5','6','7','8','9'};

		for(char x: digits)
		{
			if(x==var)
			{
				return true;
			}
		}
		return false;
	}
}
