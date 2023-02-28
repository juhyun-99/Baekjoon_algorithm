import sys

input = sys.stdin.readline

n = int(input())
arr1 = sorted(list(map(int, input().split())))
m = int(input())
arr2 = list(map(int, input().split()))

for num in arr2:
    tf = False
    start = 0
    end = n - 1
    right = 1e19
    while start <= end:
        mid = (start + end) // 2

        if arr1[mid] == num:
            right = mid
            start = mid + 1
            tf = True

        elif arr1[mid] > num:
            end = mid - 1

        else:
            start = mid + 1

    start = 0
    end = n - 1
    left = 0
    while start <= end:
        mid = (start + end) // 2

        if arr1[mid] == num:
            left = mid
            end = mid - 1
            tf = True

        elif arr1[mid] > num:
            end = mid - 1

        else:
            start = mid + 1
    if tf:
        print(right - left + 1, end=" ")
    else:
        print(0, end=" ")
