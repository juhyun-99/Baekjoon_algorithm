import math
T = int(input())
for _ in range(T):
    H,W,N = map(int,input().split())
    ans=''
    if N<=H:
        ans = str(N)+'01'
    else:
        res = N%H
        if res == 0:
            res = H
        m = str(math.ceil(N/H))
        if len(m)!=1:
            ans=str(res)+m
        else:
            ans=str(res)+'0'+m
      
    print(ans)