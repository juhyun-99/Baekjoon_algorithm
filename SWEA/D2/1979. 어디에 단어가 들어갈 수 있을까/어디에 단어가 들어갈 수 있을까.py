
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for t in range(1, T + 1):
    N,K = map(int,input().split())
    arr = [
        list(map(int,input().split())) for _ in range(N)
    ]
    ans = 0
    for i in range(N):
        cnt = 0
        for j in range(N):
            if arr[i][j] == 1: cnt+=1
            else: 
                if cnt == K: ans+=1
                cnt = 0
        if cnt == K: ans+=1
    
    for i in range(N):
        cnt = 0
        for j in range(N):
            if arr[j][i] == 1: cnt+=1
            else: 
                if cnt == K: ans+=1
                cnt = 0
        if cnt == K: ans+=1
            
    print(f'#{t} {ans}')