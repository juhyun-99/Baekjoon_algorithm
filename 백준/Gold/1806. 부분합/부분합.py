import sys
input = sys.stdin.readline

n, s = map(int,input().split())
arr = list(map(int,input().split()))

start,e = 0,0
tmp = arr[e]
ans = 100000
while True:
    #print(tmp)
    if tmp >= s:
        ans = min(ans, e - start + 1)
        tmp -= arr[start]
        start += 1
    elif tmp < s:
        e += 1
        if e < n:
            tmp += arr[e]
        else:
            break

if ans == 100000:
    print(0)
else:
    print(ans)
