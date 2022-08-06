N,M = map(int,input().split())
alist=[
    list(map(int, input().split())) for _ in range(N)
]

M,K = map(int,input().split())
blist=[
    list(map(int, input().split())) for _ in range(M)
]

c = [[0 for _ in range(K)] for _ in range(N)]

for n in range(N):
    for k in range(K):
        for m in range(M):
            c[n][k]+=alist[n][m]*blist[m][k]

for i in c:
    for j in i:
        print(j,end=' ')
    print()