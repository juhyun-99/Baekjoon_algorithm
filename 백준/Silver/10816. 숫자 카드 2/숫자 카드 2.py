import sys
from bisect import bisect_left, bisect_right

N = int(input())
arr = list(map(int,sys.stdin.readline().split()))
arr.sort()
M = int(input())
targets = list(map(int,sys.stdin.readline().split()))

for target in targets:
    num = bisect_right(arr,target) - bisect_left(arr,target)
    if num > 0:
        print(num,end=' ')
    else:
        print(0,end = ' ')