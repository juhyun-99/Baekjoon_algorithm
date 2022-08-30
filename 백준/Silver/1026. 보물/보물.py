N = int(input())
A = list(map(int,input().split()))
B = list(map(int,input().split()))
cnt = 0
for i in range(N):
    cnt+= max(B)*min(A)
    B.remove(max(B))
    A.remove(min(A))
print(cnt)