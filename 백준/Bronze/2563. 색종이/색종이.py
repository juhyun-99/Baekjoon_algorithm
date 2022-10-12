import sys
input = sys.stdin.readline
paper = [[0] * 101 for _ in range(101)]

N = int(input())
for _ in range(N):
    x, y = map(int,input().split())
    for i in range(x, x + 10):
        paper[i][y : y + 10] = [1] * 10

print(sum(sum(paper,[])))