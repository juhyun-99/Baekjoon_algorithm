import sys;input = sys.stdin.readline
X,Y = map(int,input().split())
Z = Y*100//X

if Z>=99: #승률이 99가 넘어가면 절대 승률을100를 달성할 수 없기 때문(한판이라도 졌음 or 다 이김)
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

