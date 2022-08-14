T = int(input())

for t in range(1, T + 1):
    N,M = map(int,input().split())
    arr=[
        list(map(int,input().split())) for _ in range(N)
    ]
    ans=[]
    for i in range(N-M+1):
        for k in range(N-M+1):
            s = 0
            for m in range(M):
                for j in range(M):
                    s+=arr[i+m][k+j]
            ans.append(s)
    print(f'#{t} {max(ans)}')
            
        
                
        