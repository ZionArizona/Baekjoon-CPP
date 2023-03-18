#include<iostream>
using namespace std;

void sorting(int arr[])
{

	int temp = 0;

	for (int i = 0; i < 2; i++)
	{
		for (int j = 1; j < 3; j++)
		{
			if (arr[i] >= arr[j])
			{
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
	}

	cout << arr[1];
}


int main()
{
   
	int sort[3] = { 0 };
	for (int i = 0; i < 3; i++)
	{
		cin >> sort[i];
	}

	sorting(sort);

}