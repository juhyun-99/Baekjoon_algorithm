import sys
input = sys.stdin.readline
t = int(input())

for _ in range(t):
    input()
    cnt = 0
    r, c = map(int, input().split())
    arr = [list(input().rstrip()) for _ in range(r)]
    for i in range(r):
        for j in range(c - 2):
            if arr[i][j] =='>' and arr[i][j + 1] =='o' and arr[i][j + 2] == '<':
                cnt += 1

    for i in range(r - 2):
        for j in range(c):
            if arr[i][j] =='v' and arr[i + 1][j] =='o' and arr[i + 2][j] == '^':
                cnt += 1
    print(cnt)