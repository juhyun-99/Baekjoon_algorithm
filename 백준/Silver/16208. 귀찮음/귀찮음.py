n = int(input())
arr= list(map(int,input().split()))
cnt = 0
arr.sort()
s = sum(arr)
for i in range(n-1):
    s -= arr[i]
    cnt+= arr[i]*s
    
print(cnt)