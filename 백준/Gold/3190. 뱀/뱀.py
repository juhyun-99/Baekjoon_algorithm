import sys
from collections import deque
input = sys.stdin.readline

#보드
N = int(input())
board = [[0]*N for _ in range(N)]

#방향
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


#사과
K = int(input())
for _ in range(K):
    a, b = map(int,input().split())
    board[a - 1][b - 1] = 2

# 방향 전환 정보
L = int(input())
turn = dict()
for _ in range(L):
    X, C = input().strip().split()
    if C == 'D':
        turn[int(X)] = 1
    else:
        turn[int(X)] = -1

t = 0 # 시간
dir_num = 0 # 뱀 초기 방향
x, y = 0, 0 # 뱀 초기 위치
snake = deque([(0, 0)])
board[0][0] = 1

while True:
    t += 1
    x, y = x + dx[dir_num], y + dy[dir_num]

    # 벽에 닿거나 몸에 닿으면 끝
    if x < 0 or x >= N or y < 0 or y >= N or board[x][y] == 1:
        break

    # 아무 것도 없을 때
    if board[x][y] == 0:
        snake.append((x, y))
        board[x][y] = 1
        #꼬리 움직여주기
        a, b = snake.popleft()
        board[a][b] = 0

    # 사과일 때
    elif board[x][y] == 2:
        snake.append((x, y))
        board[x][y] = 1

    # 방향 전환
    if t in turn:
        dir_num = (dir_num + turn[t]) % 4

print(t)
