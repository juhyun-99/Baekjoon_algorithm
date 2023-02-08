n = int(input())
arr = list(map(int,input().split()))
x = int(input())
arr.sort()
s,e = 0,n - 1

cnt = 0
while s < e:

    ss = arr[s] + arr[e]
    if ss > x:
        ss -= arr[e]
        e -= 1
    elif ss < x:
        ss -= arr[s]
        s += 1

    else:
        cnt += 1
        s += 1
        e -= 1
print(cnt)