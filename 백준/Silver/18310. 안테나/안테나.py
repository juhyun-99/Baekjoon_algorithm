import sys

input = sys.stdin.readline
n = int(input())

arr = [0] + list(map(int, input().split()))

arr.sort()
print(arr[(n + 1) // 2])