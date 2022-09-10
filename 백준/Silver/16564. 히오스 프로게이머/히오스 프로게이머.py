import sys; input= sys.stdin.readline
N,K = map(int,input().split())
arr = [int(input()) for _ in range(N)]

start = min(arr)
end = max(arr)+ K

while start<=end:
    cnt = 0
    mid = (start + end)//2

    for i in range(N):
        if arr[i] < mid:
            cnt += mid-arr[i]
    
    if cnt <= K :
        start = mid+1
    else: 
        end = mid-1
print(end)
  
