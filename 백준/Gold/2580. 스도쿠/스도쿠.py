import sys
input = sys.stdin.readline


def col(v, n):
    for i in range(9):
        if n == arr[i][v]:
            return False
    return True

def row(v, n):
    for i in range(9):
        if n == arr[v][i]:
            return False
    return True

def nemo(x, y, n):
    nx = x // 3 * 3
    ny = y // 3 * 3

    for i in range(3):
        for j in range(3):
            if n == arr[nx + i][ny + j]:
                return False

    return True


def dfs(num):

    if num == len(zero):
        for i in range(9):
            print(*arr[i])
        exit(0)

    for i in range(1, 10):
        x = zero[num][0]
        y = zero[num][1]

        if row(x, i) and col(y, i) and nemo(x, y, i):
            arr[x][y] = i
            dfs(num + 1)
            arr[x][y] = 0


arr = []
zero = []
for i in range(9):
    arr.append(list(map(int, input().split())))
    for j in range(9):
        if arr[i][j] == 0:
            zero.append([i, j])

dfs(0)