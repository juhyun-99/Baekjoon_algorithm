import sys
input = sys.stdin.readline
from bisect import bisect_left, bisect_right

N = int(input())
arr1 = list(map(int,input().rstrip().split()))
arr1.sort()

M= int(input().rstrip())

targets= list(map(int,input().rstrip().split()))
for target in targets:
    if bisect_right(arr1, target) - bisect_left(arr1,target) > 0: print(1)
    else: print(0)