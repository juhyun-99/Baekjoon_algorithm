import sys;input = sys.stdin.readline
X,Y = map(int,input().split())
Z = (Y*100)//X

end = X
start = 1
ans = sys.maxsize
while start<=end:
    mid = (start+end)//2
    if ((Y+mid)*100//(X+mid)) <= Z:
        start = mid+1
    else:
        ans = min(ans,mid)
        end = mid -1

if ans == sys.maxsize:
    print(-1)
else: print(ans)

