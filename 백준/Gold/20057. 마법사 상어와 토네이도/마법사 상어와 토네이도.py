import sys

input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
d = 0
ans = 0


def tornado():
    global arr

    cnt = 1
    x, y = n // 2, n // 2
    while cnt < n:
        # 0
        for i in range(cnt):
            nx = x + dx[0]
            ny = y + dy[0]
            move(x, y, nx, ny, 0)
            x, y = nx, ny

        # 1
        for i in range(cnt):
            nx = x + dx[1]
            ny = y + dy[1]
            move(x, y, nx, ny, 1)
            x, y = nx, ny

        # 2
        for i in range(cnt + 1):
            nx = x + dx[2]
            ny = y + dy[2]
            move(x, y, nx, ny, 2)
            x, y = nx, ny

        # 3
        for i in range(cnt + 1):
            nx = x + dx[3]
            ny = y + dy[3]
            move(x, y, nx, ny, 3)
            x, y = nx, ny

        cnt += 2
    for i in range(n - 1):
        nx = x + dx[0]
        ny = y + dy[0]
        move(x, y, nx, ny, 0)
        x, y = nx, ny


def move(x, y, nx, ny, d):
    global ans
    tmp = arr[nx][ny]
    cnt = 0
    # x,y에서 90도씩 꺾는 곳 위치
    for i in range(-1, 2, 2):
        d2 = (d + i + 4) % 4
        mx = x + dx[d2]
        my = y + dy[d2]
        if 0 <= mx < n and 0 <= my < n:
            arr[mx][my] += int(tmp * 0.01)
            cnt += int(tmp * 0.01)
        else:
            ans += int(tmp * 0.01)
            cnt += int(tmp * 0.01)

    # nx, ny에서 90도씩 꺽고 두 칸씩
    for i in range(-1, 2, 2):
        d2 = (d + i + 4) % 4
        for j in range(1, 3):
            mx = nx + dx[d2] * j
            my = ny + dy[d2] * j
            if 0 <= mx < n and 0 <= my < n:
                if j == 1:
                    arr[mx][my] += int(tmp * 0.07)
                    cnt += int(tmp * 0.07)
                if j == 2:
                    arr[mx][my] += int(tmp * 0.02)
                    cnt += int(tmp * 0.02)
            else:
                if j == 1:
                    ans += int(tmp * 0.07)
                    cnt += int(tmp * 0.07)
                else:
                    ans += int(tmp * 0.02)
                    cnt += int(tmp * 0.02)

    # 알파에서 90도씩 꺾는 곳 위치
    for i in range(-1, 2, 2):
        d2 = (d + i + 4) % 4
        mx = nx + dx[d] + dx[d2]
        my = ny + dy[d] + dy[d2]
        if 0 <= mx < n and 0 <= my < n:
            arr[mx][my] += int(tmp * 0.1)
            cnt += int(tmp * 0.1)
        else:
            ans += int(tmp * 0.1)
            cnt += int(tmp * 0.1)

    # 직진
    for i in range(2, 0, -1):
        mx = nx + dx[d] * i
        my = ny + dy[d] * i
        if 0 <= mx < n and 0 <= my < n:
            if i == 2:
                arr[mx][my] += int(tmp * 0.05)
                cnt += int(tmp * 0.05)
            else:
                arr[mx][my] += tmp - cnt
        else:
            if i == 2:
                ans += int(tmp * 0.05)
                cnt += int(tmp * 0.05)
            else:
                ans += tmp - cnt
    arr[nx][ny] = 0


tornado()
print(ans)
