import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
s = 0
e = n - 1
ans = 0
while s < e:
    ans = max((e - s - 1) * min(arr[e], arr[s]),ans)

    if arr[s] < arr[e]:
        s += 1

    else:
        e -= 1

print(ans)


