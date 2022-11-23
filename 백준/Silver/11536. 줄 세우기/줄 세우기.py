import sys
input = sys.stdin.readline
n = int(input())
arr = [input().rstrip() for _ in range(n)]
arr2 = sorted(arr, reverse = True)
arr3 = sorted(arr)

if arr3 == arr:
    print('INCREASING')
elif arr2 == arr:
    print('DECREASING')
else:
    print('NEITHER')