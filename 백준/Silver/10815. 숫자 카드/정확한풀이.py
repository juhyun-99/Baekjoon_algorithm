#10815 .숫자카드 
import sys
input = sys.stdin.readline
from bisect import bisect_left, bisect_right

N = int(input().rstrip())
nums = list(map(int,input().rstrip().split()))
nums.sort()

M= int(input().rstrip())
targets= list(map(int,input().rstrip().split()))
for target in targets:
    if bisect_right(nums, target) - bisect_left(nums,target) > 0: print(1, end = " ")
    else: print(0, end = " ")
