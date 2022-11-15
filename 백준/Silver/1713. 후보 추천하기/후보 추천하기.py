from collections import deque
n = int(input())
m = int(input())

arr = list(map(int,input().split()))
s = {i : 0 for i in range(1, 101)}
a = []

for i in arr:
    if len(a) != n: #액자에 자리가 있으면
        if i in a: # 넣으려는 값이 자리에 있으면
            s[i] = s.get(i, 0) + 1 # 추천받은 횟수만 증가
        else:
            a.append(i) # 넣으려는 값이 자리에 없으면 넣어주고
            s[i] = s.get(i, 0) + 1 # 추천받은 횟수 증가

    else: # 액자에 자리가 없을때
        if i in a: #이미 있는 값이 추천받으면
            s[i] = s.get(i, 0) + 1 # 추천 받은 횟수 증가
        else:
            ss = [s[a[j]] for j in range(len(a))] #가장 작은 값 찾기
            idx = ss.index(min(ss))
            s[a[idx]] = 0
            del a[idx]
            a.append(i)
            s[i] = s.get(i, 0) + 1
a.sort()
print(*a)
