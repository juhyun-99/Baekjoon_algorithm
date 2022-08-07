import sys
n = int(input())
arr=[sys.stdin.readline().strip() for _ in range(n)]
a = list(set(arr))
a.sort(key = lambda x:(len(x),x))

print(*a , sep='\n')