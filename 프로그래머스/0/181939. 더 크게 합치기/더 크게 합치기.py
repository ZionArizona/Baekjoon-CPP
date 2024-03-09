def solution(a, b):
    answer = 0
    
    a_b = str(a)+str(b)
    b_a = str(b)+str(a)
    
    if a_b >= b_a:
        answer = a_b
    else:
        answer = b_a
    
    answer = int(answer)
    return answer