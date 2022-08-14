
T = int(input())

for test_case in range(1, T + 1):
    N,M = map(int,input().split())
    arr = list(map(int,input().split()))
    arr2 = list(map(int,input().split()))
    
    if N > M:
        s = 0
        for k in range(N - M +1):
            ss = 0
            for i in range(M):
                ss+= arr[k+i]*arr2[i]
            s = max(s, ss)
    else:
        s = 0
        for k in range(M-N+1):
            ss = 0
            for i in range(N):
                ss+= arr2[k+i]*arr[i]
            s = max(s,ss)
    print(f'#{test_case} {s}')
