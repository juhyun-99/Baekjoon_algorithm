import sys
input = sys.stdin.readline

t = int(input())
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for _ in range(t):
    dir_num = 0
    max_x, min_x = 0, 0
    max_y, min_y = 0, 0
    x, y, = 0, 0
    s = input().rstrip()
    for i in s:
        if i =='F':
            x += dx[dir_num]
            y += dy[dir_num]
        elif i =='B':
            x -= dx[dir_num]
            y -= dy[dir_num]
        elif i == 'L':
            dir_num = (dir_num - 1) % 4
        else:
            dir_num = (dir_num + 1) % 4

        max_x, min_x = max(x, max_x), min(x, min_x)
        max_y, min_y = max(y, max_y), min(y, min_y)

        #print(max_x, min_x, max_y, min_y)
    print(abs(max_x- min_x) * abs(max_y - min_y))