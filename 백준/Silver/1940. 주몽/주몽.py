import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

arr = sorted(list(map(int, input().split())))

start = 0
end = N - 1
cnt = 0

while start < end:
    if arr[start] + arr[end] == M:
        cnt += 1
        start += 1
        end -= 1
    elif arr[start] + arr[end] < M:
        start += 1
    else:
        end -= 1
print(cnt)
