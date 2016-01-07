#include<stdio.h>
#include<ctype.h>

char string[105];
int calc(), i = -1;

int main()
{
	int sum = 0;
	scanf("%s",string);

	sum = calc();

	printf("\n%d",sum);
	return 0;
}

/*
 * Recurrsive function to calcuate the molecular mass
 */
int calc()
{
	i++;
	int sum = 0, sum1 = 0,value;

	while(string[i]!='\0')
	{
		value = 0 ;
		sum1 = 0;
		if(string[i] == '(')
		{
			sum1 = 0;

			sum1= calc();


			if(isdigit(string[i+1]))
			{
				sum1 *= (string[++i] - 48);
			}//end of else
		}
		sum += sum1;

		if(isalpha(string[i]))
		{
			switch(string[i])
			{
				case 'C':
							value = 12;
							break;
				case 'H':
							value = 1;
							break;
				case 'O':
							value = 16;
							break;
			}//end of switch
		}

		if(isdigit(string[i+1]))
		{
			 value *= (string[++i] - 48);
		}//end of else

		sum += value;

		i++;

		if(string[i] == ')')
			return sum;
	}
	return sum;
}
