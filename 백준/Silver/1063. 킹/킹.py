import sys
input = sys.stdin.readline
move = ['R', 'L', 'B', 'T', 'RT', 'LT', 'RB', 'LB']
dx = [0, 0, 1, -1, -1, -1, 1, 1]
dy = [1, -1, 0, 0, 1, -1, 1, -1]
board = [[0] * 8 for _ in range(8)]
stone = [[0] * 8 for _ in range(8)]
alpha = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']

K, S, N = input().rstrip().split()
x, y = 0, 0
for i in range(8):
    if K[0] == alpha[i]:
        board[8 - int(K[1])][i] = 1
        x, y = 8 - int(K[1]), i
    if S[0] == alpha[i]:
        stone[8 - int(S[1])][i] = 1
k_x,k_y = 0,0
s_x,s_y = 0,0

for num in range(int(N)):
    s = input().rstrip()
    for i in range(8):
        if s == move[i]:
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= 8 or ny < 0 or ny >= 8:
                break
            else:
                if stone[nx][ny] == 1:
                    sx = nx + dx[i]
                    sy = ny + dy[i]
                    if sx < 0 or sx >= 8 or sy < 0 or sy >= 8:
                        break
                    else:
                        stone[nx][ny] = 0
                        stone[sx][sy] = 1
                board[x][y] = 0
                board[nx][ny] = 1
                x,y = nx, ny

for i in range(8):
    for j in range(8):
        if board[i][j] == 1:
            k_x, k_y = i, j
        if stone[i][j] == 1:
            s_x, s_y = i, j

for i in range(8):
    if k_y == i:
        k_y = alpha[i]
    if s_y == i:
        s_y = alpha[i]


# print(*board,sep = '\n')
# print()
# print(*stone,sep='\n')
print(k_y+str(8-k_x ))
print(s_y + str(8-s_x))