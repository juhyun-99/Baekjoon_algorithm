import sys;input = sys.stdin.readline
X,Y = map(int,input().split())
Z = Y*100//X

if Z>=99:
    print(-1)
    exit()

end = 1000000000
start = 1
ans = 0
while start<=end:
    mid = (start+end)//2
    if ((Y+mid)*100)//(X+mid) <= Z:
        start = mid+1
    else:
        ans = mid
        end = mid -1

print(ans)

