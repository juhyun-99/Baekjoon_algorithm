T = int(input())

for tc in range(1, T + 1):
    D, L, N = map(int,input().split())
    cnt = 0
    for i in range(N):
        cnt+= D * (1 + i * (L * 0.01))
    print(f'#{tc}',int(cnt))