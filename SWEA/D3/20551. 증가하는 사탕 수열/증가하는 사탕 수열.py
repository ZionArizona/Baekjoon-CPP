T = int(input())

for test in range(1,T+1):
    box = list(map(int, input().split()))
    ans = 0
    if (box[0] < box[1] < box[2]):
        print('#', test, ' 0', sep='')
    elif((box[2] <= 2) or (box[1] == 1)):
        print('#', test, ' -1', sep='')
    else:
        if box[2] > box[1]:
            ans = abs(box[0] - box[1]) + 1
            print('#', test, ' ', ans, sep='')
        elif box[1] >= box[2]:
            if abs(box[2] - box[0]) >= 2:
                ans = abs(box[2] - box[1]) + 1
                print('#', test, ' ', ans, sep='')
            elif abs(box[2] - box[0]) == 1:
                ans = abs(box[2] - box[1]) + 1 + 1
                print('#', test, ' ', ans, sep='')
            elif(abs(box[2] - box[0]) == 0):
                ans = abs(box[2] - box[1]) + 1 + 2
                print('#', test, ' ', ans, sep='')


