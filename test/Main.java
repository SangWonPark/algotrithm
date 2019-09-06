package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		init();
		setAddmoney();
		long gcd = GCD();
		if (gcd == 1)
		{
			gcd = -1;
		}
		System.out.println(gcd);
	}

	static Scanner sc = new Scanner(System.in);
	static long[][] wallet = null;
	static ArrayList<Long> addmoney = new ArrayList<Long>();

	static void init()
	{
		int iter = sc.nextInt();
		wallet = new long[iter][2];
		for (int i = 0; i < iter; i++)
		{
			wallet[i][0] = sc.nextLong();
			wallet[i][1] = sc.nextLong();
		}
	}

	static void setAddmoney()
	{
		for (int i = 0; i < wallet.length; i++)
		{
			if (wallet[i][0] < 0)
			{
				long money = wallet[i][1] - wallet[i][0];
				if (i > 0)
				{
					money -= wallet[i - 1][1];
				}
				if (i == 0)
				{
					addmoney.add(money);
				}
				else if (-1 * wallet[i][0] > wallet[i - 1][1])
				{
					addmoney.add(money);
				}
			}
		}
	}

	static long GCD()
	{
		long ans = 0;
		long min = addmoney.get(0);
		int idx = 0;

		long gcd = 1;

		for (int i = 1; i < addmoney.size(); i++)
		{
			if (min > addmoney.get(i))
			{
				min = addmoney.get(i);
				idx = i;
			}
		}

		for (int i = 0; i < addmoney.size(); i++)
		{
			long a = addmoney.get(i);
			long b = min;
			if (gcd == 1)
			{
				gcd = getGCD(a, b);
			}
			else if (a % gcd != 0)
			{
				gcd = getGCD(a, b);
			}
		}

		return gcd;
	}

	static long getGCD(long a, long b)
	{
		while (b != 0)
		{
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
