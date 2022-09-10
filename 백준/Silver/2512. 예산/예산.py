import sys; input = sys.stdin.readline
N = int(input())

arr= list(map(int,input().split()))

M = int(input())
if sum(arr) <= M:
    print(max(arr))
    exit()

else:
    left, right = 1, max(arr)

    while left <= right:
        mid = (left + right) // 2
        total = 0

        for money in arr:
            if money >= mid:
                total += mid
            else:
                total += money

        if total <= M:
            left = mid + 1
        else:
            right = mid - 1

    print(right)