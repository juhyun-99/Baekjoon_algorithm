import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
a = [1] * n
b = [1] * n

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            a[i] = max(a[i],a[j]+1)

arr2 = arr[::-1]
for i in range(n):
    for j in range(i):
        if arr2[i] > arr2[j]:
            b[i] = max(b[i], b[j] + 1)
           
b = b[::-1]
ans = 0
for i in range(n):
    ans = max(ans, a[i]+b[i]-1)
print(ans)