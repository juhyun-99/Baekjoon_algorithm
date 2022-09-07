import sys
input = sys.stdin.readline
N,M = map(int,input().split())
arr1 = list(map(int,input().split()))
arr2 = list(map(int,input().split()))
arr3 = arr1+arr2
arr3.sort()
print(*arr3,sep=' ')