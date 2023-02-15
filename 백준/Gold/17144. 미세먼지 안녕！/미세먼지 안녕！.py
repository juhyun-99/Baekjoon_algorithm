'''
미세먼지 확산 / 모든 칸 동시에 / 인접한 4방향 / r,c/5만큼 소수점 버림 /남은 것 rc - rc/5* 확산 방향 수
공기청정기 작동/ 바람 나옴 / 위쪽 : 반시계 / 아래쪽 시계 방향/ 미세먼지가 바람 방향대로 한칸 이동/ 공기청정기로 들어가면 정화됨
'''
import sys

input = sys.stdin.readline


def dust():
    arr2 = [[0] * c for _ in range(r)]

    for i in range(r):
        for j in range(c):
            if arr[i][j] >= 5:
                tmp = arr[i][j] // 5
                for d in range(4):
                    nx = i + dx1[d]
                    ny = j + dy1[d]
                    if 0 <= nx < r and 0 <= ny < c and not exist[nx][ny]:  # 공기 청정기 칸은 확산일어나지 않음
                        arr2[nx][ny] += tmp  # arr2에 늘어나는 미세먼지양을 저장함
                        arr2[i][j] -= tmp  # arr2에 감소하는 양을 빼줌

    for i in range(r):
        for j in range(c):  # arr에 arr2값 더해주기
            arr[i][j] += arr2[i][j]


def clear_dust():
    # 위
    d = 0
    x, y = clear[0][0], 1
    tmp = 0
    while True:
        nx = x + dx1[d]
        ny = y + dy1[d]

        if x == clear[0][0] and y == 0:
            break
        if (nx < 0 or nx >= r) or (ny < 0 or ny >= c):
            d += 1
            continue

        arr[x][y], tmp = tmp, arr[x][y]
        x, y = nx, ny
    # 아래
    d = 0
    x, y = clear[1][0], 1
    tmp = 0
    while True:
        nx = x + dx2[d]
        ny = y + dy2[d]

        if x == clear[1][0] and y == 0:
            break
        if (nx < 0 or nx >= r) or (ny < 0 or ny >= c):
            d += 1
            continue

        arr[x][y], tmp = tmp, arr[x][y]
        x, y = nx, ny


r, c, t = map(int, input().split())
exist = [[False] * c for _ in range(r)]
clear = []
arr = []

for i in range(r):
    tmp = list(map(int, input().split()))
    for j in range(c):
        if tmp[j] == -1:
            tmp[j] = 0
            exist[i][j] = True
            clear.append([i, j])
    arr.append(tmp)

#
dx1 = [0, -1, 0, 1]
dy1 = [1, 0, -1, 0]

dx2 = [0, 1, 0, -1]
dy2 = [1, 0, -1, 0]
for _ in range(t):
    dust()
    # print()
    # print(*arr, sep='\n')
    clear_dust()
    # print()
    # print(*arr, sep='\n')

print(sum(sum(arr, [])))
