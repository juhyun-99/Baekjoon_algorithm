import sys
input = sys.stdin.readline

n=int(input())
arr=list(map(int,input().split()))

dp=[1 for i in range(1001)]

for i in range(1,n):
	for j in range(0,i):
		if arr[j] < arr[i]:
			dp[i] = max(dp[i],dp[j]+1)
m = max(dp)
print(m)
arr2=[]
for i in range(n-1,-1,-1):
	if dp[i]==m:
		arr2.append(arr[i])
		m-=1
print(*reversed(arr2))