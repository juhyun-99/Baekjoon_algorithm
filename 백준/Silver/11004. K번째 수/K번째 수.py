import sys
N,K = map(int,input().split())
arr= list(map(int,sys.stdin.readline().strip().split()))

arr.sort()
print(arr[K-1])