T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    arr = list(map(int,input().split()))
    m = sum(arr)//N
    cnt = 0
    for i in arr:
        if i <= m:
           cnt+=1
    print(f'#{tc} {cnt}')