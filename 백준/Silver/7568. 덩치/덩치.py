import sys
N = int(input())
arr=[]
ans = []
for _ in range(N):
    arr.append(list(map(int,sys.stdin.readline().split())))

for i in range(N):
    count=0
    for k in range(N):
        if arr[i][1]<arr[k][1] and arr[i][0] < arr[k][0]:
            count+=1
    ans.append(count+1)

for i in ans:
    print(i,end=' ')