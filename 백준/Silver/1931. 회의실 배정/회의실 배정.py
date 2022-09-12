import sys; input = sys.stdin.readline
N = int(input())
arr = []
for _ in range(N):
    a,b = map(int,input().split())
    arr.append([a,b])


arr.sort(key = lambda x : x[0])
arr.sort(key = lambda x : x[1])
start = arr[0][0]
end = arr[0][1]
cnt=1

for i in range(1,len(arr)):
    if arr[i][0] >= end:
        cnt+=1
        end = arr[i][1]
        start = arr[i][0]
print(cnt)