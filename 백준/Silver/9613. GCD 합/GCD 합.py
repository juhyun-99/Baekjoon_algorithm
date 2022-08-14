import math
import sys
T = int(input())
for _ in range(T):
    arr = list(map(int,sys.stdin.readline().rstrip().split()))
    ans = 0
    for i in range(1,len(arr)):
        for k in range(i+1,len(arr)):
            ans += math.gcd(arr[i],arr[k])

    print(ans)
      