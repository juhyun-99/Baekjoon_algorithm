paper = [[0]*100 for _ in range(100)]

n = int(input())
for _ in range(n):
    a,b = map(int,input().split())
    for x in range(a, a + 10):
        for y in range(b, b + 10):
            paper[x][y] = 1

print(sum(sum(paper,[])))