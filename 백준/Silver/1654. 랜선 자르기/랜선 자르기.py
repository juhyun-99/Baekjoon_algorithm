import sys; input = sys.stdin.readline
K, N = map(int, input().rstrip().split())

lans = [int(input()) for _ in range(K)]


left, right = 1, max(lans)

while left <= right:
    mid = (left + right) // 2
    total = 0

    for lan in lans:
        if lan >= mid:
            total += lan // mid

    if total >= N:
        left = mid + 1
    else:
        right = mid - 1

print(right)