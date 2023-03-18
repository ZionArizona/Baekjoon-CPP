#include<iostream>
using namespace std;
int fib_count = 0;
int fibonacci_count = 0;

int fib(int n)
{
	if (n == 1 || n == 2)
	{
		fib_count++;
		return 1;
	}
	else
	{
		return fib(n - 1) + fib(n - 2);
	}
	
}

int fibonacci(int n)
{
	int Fib_Arr[41] = { 0 };
	Fib_Arr[1] = Fib_Arr[2] = 1;

	for (int i = 3; i <= n; i++)
	{
		fibonacci_count++;
		Fib_Arr[i] = Fib_Arr[i - 1] + Fib_Arr[i - 2];
	}
	return Fib_Arr[n];

}



int main()
{
	int n = 0;
	cin >> n;

	fib(n);
	fibonacci(n);
	

	cout << fib_count << " " << fibonacci_count++;

}