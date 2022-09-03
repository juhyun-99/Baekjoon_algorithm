import sys

input = sys.stdin.readline

cnt = int(input())
arr = list(map(int,input().split()))

print(min(arr)*max(arr))
  
