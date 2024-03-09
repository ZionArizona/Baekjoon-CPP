def solution(a, b, c, d):
    answer = 0
    
    ans = [0] * 10
    ans[a] += 1
    ans[b] += 1
    ans[c] += 1
    ans[d] += 1
    
    if 4 in ans:
        answer = 1111 * (ans.index(4))
    elif 3 in ans:
        answer = (10*ans.index(3)+ans.index(1))**2
    elif ans.count(2) == 2:
        if a == b:
            answer = (a+c)*abs(a-c)
        elif a == c:
            answer = (a+b)*abs(a-b)
        elif a == d:
            answer = (a + b)*abs(a-b)
    elif ans.count(1) == 4:
        answer = ans.index(1) 
    else:
        save_l = []
        for i in range(1,len(ans)):
            if ans[i] == 1:
                save_l.append(i)
        answer = save_l[0] * save_l[1]
        
        
    
    return answer