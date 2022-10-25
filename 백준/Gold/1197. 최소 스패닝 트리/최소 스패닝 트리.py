import sys
input = sys.stdin.readline
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

V, E = map(int, input().split())
parent = [i for i in range(V + 1)]
edges = []

for i in range(E):
    A, B, C = map(int, input().split())
    edges.append((C, A, B))
edges.sort()

ans = 0
for edge in edges:
    C, A, B = edge
    if find_parent(parent, A) != find_parent(parent, B):
        union_parent(parent, A, B)
        ans += C
print(ans)