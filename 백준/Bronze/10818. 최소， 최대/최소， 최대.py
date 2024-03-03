N = int(input())

A = list(map(int,input().split()))

smallest = A[0]
largest = A[0]

for i in range(1, len(A)):
    if(smallest > A[i]):
        smallest = A[i]
    
    if(largest < A[i]):
        largest = A[i]

print(smallest,largest, sep = " ")
