n = int(input())
arr = list(map(int,input().split()))
cnt = 0
start = 0
for i in range(len(arr)):
    if arr[i] == start:
        cnt+=1
        start+=1
    if start==3:
        start = 0

print(cnt)