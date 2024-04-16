def solution(arr):
    answer = []
    
    answer = arr
    
    ar1 = [0]
    
    if len(arr) == 1:
        return arr
    
    
    for i in range(1,11):
        ar1.append(2**i)
    
    key = 0
    
    for i in range(11):
        if ar1[i]  >= len(answer):
            key = i
            break
    
    for i in range(2**(key)-len(arr)):
        answer.append(0)
    
    
    return answer