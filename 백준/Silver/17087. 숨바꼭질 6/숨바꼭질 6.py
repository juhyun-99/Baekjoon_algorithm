import math
import sys
n,s = map(int,input().split())
arr = list(map(int,sys.stdin.readline().split()))

if n == 1:
    print(abs(s-arr[0]))
elif n == 2:
    g = math.gcd(abs(arr[0]-s), abs(arr[1]-s))
    print(g)
else :
    g = math.gcd(abs(arr[0]-s), abs(arr[1]-s))
    for i in range(2, n):
        g = math.gcd(g, abs(arr[i]-s))

    print(g)