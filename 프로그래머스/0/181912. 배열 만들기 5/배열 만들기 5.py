def solution(intStrs, k, s, l):
    answer = []
    for i in range(len(intStrs)):
        a = intStrs[i]
        ans = a[s:s+l]
        
        if int(ans) > k:
            answer.append(int(ans))
        
    return answer