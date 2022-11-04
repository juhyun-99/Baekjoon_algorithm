n = int(input())
arr = [[0]*n for _ in range(n)]
num = int(input())

arr[0][0] = n*n
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
dir_num = 0
x,y = 0,0
a_x,a_y = 0,0
for i in range(n*n-1, 0, -1):
    x += dx[dir_num]
    y += dy[dir_num]
    if (x < 0 or x >= n or y < 0 or y >= n)  or arr[x][y] != 0:
        x -= dx[dir_num]
        y -= dy[dir_num]
        dir_num = (dir_num + 1) % 4
        x += dx[dir_num]
        y += dy[dir_num]
        arr[x][y] = i
    else:
        arr[x][y] = i
    if i == num:
        a_x,a_y = x, y
for i in range(n):
    for j in range(n):
        print(arr[i][j],end=' ')
    print()
print(a_x+1,a_y+1)

