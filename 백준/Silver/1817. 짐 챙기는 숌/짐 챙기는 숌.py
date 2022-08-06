n,m = map(int,input().split())
if n==0:
    print(0)
    exit() 

arr = list(map(int,input().split()))
cnt = 1
weight = m
for i in range(len(arr)):
    if arr[i] <= weight:
        weight -=arr[i]
    else:
        cnt+=1
        weight = m
        weight -=arr[i]

print(cnt)