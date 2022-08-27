T = int(input())

for _ in range(T):
    N = int(input())
    tree = list(map(int, input().split()))
    tree.sort()
    M = 0
    for i in range(2, N):
        M = max(M, abs(tree[i]-tree[i-2]))
    print(M)
