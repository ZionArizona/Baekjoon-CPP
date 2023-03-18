#include <iostream>

using namespace std;

int main()
{
    int arr[9][9] = {};
    int first_index = 1;
    int second_index = 1;

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> arr[i][j];
        }
    }
    int max = 0;
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            if (max < arr[i][j])
            {
                max = arr[i][j];
                first_index = i + 1;
                second_index = j + 1;
            }
        }
    }

    
    cout << max << endl;
    cout << first_index << " " << second_index;



    return 0;
}