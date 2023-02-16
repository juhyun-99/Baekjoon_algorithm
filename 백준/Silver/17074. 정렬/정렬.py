import sys

input = sys.stdin.readline

n = int(input())  # 100000
arr = list(map(int,input().split()))

cnt = 0
tmp = 0

for i in range(n - 1):
    if arr[i] > arr[i + 1]:
        tmp = i + 1
        cnt+=1

#print(tmp)

if cnt >= 2:
    print(0)
    exit()
elif cnt == 0:
    print(n)
else:
    ans = 0
    if tmp == 1 or arr[tmp] >= arr[tmp - 2]:
        ans += 1
    if tmp == n - 1 or arr[tmp + 1] >= arr[tmp - 1]:
        ans += 1
    print(ans)



