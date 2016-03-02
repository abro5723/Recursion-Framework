package Model;

public class RecursionTool
{
	public int getFibNumber(int position)
	{
		if(position < 0)
		{
			return Integer.MIN_VALUE;
		}
		if(position == 0 || position == 1)
		{
			return 1;
		}
		else
		{
			return getFibNumber(Math.abs(position - 1) )+ getFibNumber(Math.abs(position - 2));
		}
	}
	
	public double getFactorialNumber(double position)
	{
		if(position < 0)
		{
			return Integer.MIN_VALUE;
		}
		if(position == 0)
		{
			return 1;
		}
		else
		{
			return position * getFactorialNumber(position-1);
		}
	}

}
