import sys

input = sys.stdin.readline

dx = [-1,-1,-1,0,0,1,1,1]
dy = [-1,0,1,-1,1,-1,0,1]

arr = [list(input().rstrip()) for _ in range(10)]


def search(x, y):
    for i in range(8):
        ix, iy = x, y
        cnt = 1
        tmp = 0

        for _ in range(4):
            nx, ny = ix + dx[i], iy + dy[i]
            if 0 <= nx < 10 and 0 <= ny < 10:
                if arr[nx][ny] == 'X':
                    cnt += 1
                elif arr[nx][ny] == '.':
                    tmp += 1
                ix, iy = nx, ny
            else:
                break

        if cnt == 4 and tmp == 1:
            return True
    return False



for i in range(10):
    for j in range(10):
        if arr[i][j] == 'X':
            if search(i, j):
                print(1)
                exit()
print(0)