import sys
input = sys.stdin.readline
N, S = map(int, input().split())
cow = sorted([int(input()) for _ in range(N)])

cnt = 0
start = 0
end = N - 1

while start < end:
    if cow[start] + cow[end] <=S:
        cnt += (end - start)
        start += 1
    else:
        end -= 1

print(cnt)