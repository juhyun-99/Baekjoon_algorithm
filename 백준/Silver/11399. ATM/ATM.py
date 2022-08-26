N = int(input())
arr = list(map(int,input().split()))
arr.sort()
count = 0
num = N
for i in range(0,N):
    count+=arr[i]*num
    num-=1
print(count)