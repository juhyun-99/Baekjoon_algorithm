from collections import deque

for tc in range(1, int(input()) + 1 ):
    n, k = map(int,input().split())
    arr = list(map(int,input().split()))
    arr.sort()
    q = deque(arr)
    ans = 0
    for i in range(k):
        ans += q.pop()
    print(f'#{tc} {ans}')