import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
ans = [0] * n
for i in range(1, n + 1):
    tmp = arr[i - 1]
    cnt = 0
    for j in range(n):
        if cnt == tmp and ans[j] == 0:
            ans[j] = i
            break
        elif ans[j] == 0:
            cnt += 1
print(*ans)

