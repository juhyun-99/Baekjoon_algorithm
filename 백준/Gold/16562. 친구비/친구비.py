import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)

    if a != b:
        if friends[a] < friends[b]:
            parent[b] = a
        else:
            parent[a] = b

n, m, k = map(int, input().split())
friends = [0] + list(map(int, input().split()))
parent = [i for i in range(n + 1)]

for _ in range(m):
    v, w = map(int, input().split())
    union(v, w)

ans = 0
for i, v in enumerate(parent):
    if i and i == v:
        ans += friends[i]

if ans > k:
    print("Oh no")
else:
    print(ans)