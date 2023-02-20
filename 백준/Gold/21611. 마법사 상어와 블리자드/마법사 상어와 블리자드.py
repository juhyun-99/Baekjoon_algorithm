'''
1. 구슬 파괴 destroy(d,s)
2. 구슬 이동 move()
3. 구슬 폭발 explosion() -> 이동 -> 더 이상 폭발하는 구슬이 없을 때 까지 반복 check()
'''
import sys

input = sys.stdin.readline


def arr_arr1():  # 2차원 to 1차원 변경
    global arr1
    visit = [[False] * n for _ in range(n)]
    dx1 = [0, 1, 0, -1]
    dy1 = [1, 0, -1, 0]
    x, y = 0, 0
    d = 0
    cnt = 0
    while cnt < n * n:
        arr1[cnt] = arr[x][y]
        visit[x][y] = True
        cnt += 1
        nx = x + dx1[d]
        ny = y + dy1[d]
        if (nx < 0 or nx >= n or ny < 0 or ny >= n) or visit[nx][ny]:
            d = (d + 1) % 4
            nx = x + dx1[d]
            ny = y + dy1[d]
        x, y = nx, ny

    arr1.reverse()


def arr1_arr():
    global arr
    visit = [[False] * n for _ in range(n)]
    dx1 = [0, 1, 0, -1]
    dy1 = [1, 0, -1, 0]
    x, y = 0, 0
    d = 0
    cnt = 0
    while cnt < n * n:
        arr[x][y] = arr1[-cnt - 1]
        visit[x][y] = True
        cnt += 1
        nx = x + dx1[d]
        ny = y + dy1[d]
        if (nx < 0 or nx >= n or ny < 0 or ny >= n) or visit[nx][ny]:
            d = (d + 1) % 4
            nx = x + dx1[d]
            ny = y + dy1[d]
        x, y = nx, ny

def destroy(d, s):  # 파괴
    x, y = n // 2, n // 2
    for i in range(1, s + 1):
        nx = x + dx[d] * i
        ny = y + dy[d] * i
        arr[nx][ny] = 0
    arr_arr1()


def move():  # 이동
    for i in range(len(arr1) - 1, 0, -1):
        if arr1[i] == 0:
            del arr1[i]
            arr1.append(0)


def check():
    global ans
    tmp = 0
    cnt = 1
    idx = 1
    change = False
    for i in range(1, len(arr1)):
        if tmp != arr1[i]:
            if cnt >= 4:
                ans += cnt * tmp
                arr1[idx: i] = [0] * cnt
                change = True
            tmp = arr1[i]
            idx = i
            cnt = 1
        else:
            cnt += 1
    move()
    return change


def change():  # 구슬 변화
    global arr1
    tmp = [0]
    cnt = 1
    num = arr1[1]
    for i in range(2, len(arr1)):
        if num != arr1[i]:
            tmp.append(cnt)
            tmp.append(num)
            if len(tmp) == n * n:
                break
            num = arr1[i]
            cnt = 1
        else:
            cnt += 1

    while len(tmp) < n * n:
        tmp.append(0)

    arr1 = tmp


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
arr1 = [0] * (n * n)
arr_arr1()
dx = [0, -1, 1, 0, 0]
dy = [0, 0, 0, -1, 1]
ans = 0
for _ in range(m):
    d, s = map(int, input().split())
    destroy(d, s)
    # print(arr1)
    move()
    # print(arr1)
    while True:
        if not check():
            break
    # print(arr1)
    change()
    # print(arr1)
    arr1_arr()
    # print(arr1)
    # print(*arr)

print(ans)
