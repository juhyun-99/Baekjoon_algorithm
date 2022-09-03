import sys
from itertools import combinations 

input = sys.stdin.readline
N,S = map(int,input().split())
count = 0
arr = list(map(int,input().split()))
result = []

for i in range(1,N+1):
    result += list(combinations(arr,i)) 

for i in range(len(result)):
    if sum(result[i]) == S:
        count+=1
print(count)