import sys; input= sys.stdin.readline
N,K = map(int,input().split())
arr = [int(input()) for _ in range(N)]

start = min(arr)
end = max(arr)+ K

while start<=end:
    cnt = 0
    mid = (start + end)//2
    arr2 = arr[:]
  
    for i in range(N):
        if arr2[i] < mid:
            cnt += mid-arr2[i]
            arr2[i] = mid
    
    if cnt <= K :
        start = mid+1
    else: 
        end = mid-1
print(end)
  
