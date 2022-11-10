import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
for tc in range(t):
    N, K = map(int, input().split())
    time = [0] + list(map(int,input().split()))
    build = [[] for _ in range(N + 1)]
    nums = [0] * (N + 1)
    for _ in range(K):
        x, y = map(int, input().split())
        nums[y] += 1
        build[x].append(y)
    w = int(input())
    # print(build)
    # print(nums)
    dp = [0] * (N + 1)
    q = deque([])
    for i in range(1, N + 1):
        if nums[i] == 0:
            q.append(i)
            dp[i] = time[i]

    while q:
        v = q.popleft()
        for i in build[v]:
            nums[i] -= 1
            dp[i] = max(dp[i], dp[v] + time[i])
            if nums[i] == 0:
                q.append(i)
    print(dp[w])