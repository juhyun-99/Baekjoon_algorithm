import sys
input = sys.stdin.readline

def search(left, right, tmp):
    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == tmp:
            return 1

        elif arr[mid] > tmp:
            right = mid - 1

        else:
            left = mid + 1
    return 0

t = int(input())
for _ in range(t):
    n = int(input())
    arr = sorted(list(map(int,input().split())))
    left, right = 0, n -1
    ans = 0
    for i in range(n - 1):
        for j in range(i + 1, n):
            tmp = abs(arr[i] - arr[j]) + arr[j]
            ans += search(left, right, tmp)

    print(ans)