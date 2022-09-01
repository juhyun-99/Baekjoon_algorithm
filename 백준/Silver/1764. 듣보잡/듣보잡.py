import sys
N, M = map(int, input().split())
name = set([sys.stdin.readline().strip() for _ in range(N)])
mame = set([sys.stdin.readline().strip() for _ in range(M)])

ans = sorted(list(name & mame))
print(len(ans))
print(*ans,sep='\n')