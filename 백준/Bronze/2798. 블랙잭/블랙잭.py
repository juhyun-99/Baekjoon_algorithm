import sys
N,M = map(int,input().split())
arr = list(map(int,sys.stdin.readline().split()))

ma = 0
tr = True
for i in range(N-2):
    if tr == False:
        break
    for k in range(i+1,N-1):
        for j in range(k+1,N):
            if arr[i]+arr[k]+arr[j]<=M:
                ma = max(arr[i]+arr[k]+arr[j],ma)
            if ma == M:
                tr = False
                break

print(ma)