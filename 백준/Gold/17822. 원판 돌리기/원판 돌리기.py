from collections import deque

n, m, t = map(int, input().split())
arr = [deque(list(map(int, input().split()))) for _ in range(n)]


def rotate(x, d, k):
    if d == 0:
        for i in range(x - 1, n, x):
            arr[i].rotate(k)
    else:
        for i in range(x - 1, n, x):
            arr[i].rotate(-k)


def search():
    global arr
    global avg
    global nz_cnt
    global cnt
    arr2 = []
    for i in range(n):
        tmp = deque([])
        for j in range(m):
            tmp.append(arr[i][j])
        arr2.append(tmp)

    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]

    change = False
    for x in range(n):
        for y in range(m):
            if arr[x][y] != 0:
                nz_cnt += 1
                cnt += arr[x][y]
                for i in range(4):
                    nx = x + dx[i]
                    ny = (y + dy[i] + m) % m

                    if 0 <= nx < n and 0 <= ny < m:
                        if arr[nx][ny] == arr[x][y]:
                            # print(x, y, nx, ny)
                            arr2[nx][ny] = 0
                            arr2[x][y] = 0
                            change = True
    if change:
        arr = arr2
    return change

def plus_minus():
    global avg
    global arr
    if cnt != 0 and nz_cnt != 0:
        avg = float(float(cnt) / float(nz_cnt))
    else:
        return

    for i in range(n):
        for j in range(m):
            if arr[i][j] == 0:
                continue
            if arr[i][j] < avg:
                arr[i][j] += 1
            elif arr[i][j] > avg:
                arr[i][j] -= 1


for _ in range(t):
    x, d, k = map(int, input().split())
    avg = 0
    nz_cnt = 0
    cnt = 0
    rotate(x, d, k)
    # print("돌리기")
    # print(*arr, sep='\n')
    chk = search()
    # print("search")
    # print(*arr, sep='\n')
    if not chk:
        plus_minus()
    # print("plus_minus")
    # # print(*arr, sep='\n')
    # print()

ans = 0
for i in range(n):
    for j in range(m):
        ans += arr[i][j]
print(ans)