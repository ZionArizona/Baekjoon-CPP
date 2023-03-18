#include<stdio.h>



int get_answer(int n)
{
    
    if(n > 1)
    {
        return n * get_answer(n - 1);
    }
   
    return 1;
    
}



int main()
{
    int n = 0;
    scanf("%d", &n);
    
    printf("%d",get_answer(n));
    
}