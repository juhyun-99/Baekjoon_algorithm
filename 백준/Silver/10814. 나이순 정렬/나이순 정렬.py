import sys
n = int(input())
arr=[sys.stdin.readline().strip().split() for _ in range(n)]

arr.sort(key = lambda x:(int(x[0])))

for i in arr:
    for k in i:
        print(k,end=' ')
    print()