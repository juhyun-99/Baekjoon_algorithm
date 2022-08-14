T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    arr = [[0] * N for _ in range(N)]
    x,y = 0,0
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]
    dist = 0
    for i in range(1, N*N+1):
        arr[x][y] = i
        x+=dx[dist]
        y+=dy[dist]
        if x < 0 or y < 0 or x >= N or y >= N or arr[x][y] != 0:
            x-=dx[dist]
            y-=dy[dist]
            dist = (dist+1)%4
            x+=dx[dist]
            y+=dy[dist]
            
        
            
    print(f'#{test_case}')
    for i in arr:
        for k in i:
            print(k, end=' ')
        print()