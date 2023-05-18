arr = [0, 1]

for i in range(2, 400):
    arr.append(arr[i - 1] + i)

t = int(input())
for tc in range(1, t + 1):
    p, q = map(int,input().split())
    pp = 0
    qq = 0
    for i in range(len(arr)):
        if arr[i] >= p:
            pp = i
            break

    for i in range(len(arr)):
        if arr[i] >= q:
            qq = i
            break

    dic_p = {}
    x = 1
    y = pp
    for i in range(arr[pp] - pp + 1, arr[pp] + 1):
        dic_p[(x,y)] = i
        x += 1
        y -= 1
    x = 1
    y = qq
    dic_q ={}

    for i in range(arr[qq] - qq + 1, arr[qq] + 1):
        dic_q[(x,y)] = i
        x += 1
        y -= 1
    x1, y1 = 0,0
    x2, y2 = 0,0

    for i in dic_p:
        if dic_p[i] == p:
            x1, y1 = i
            break

    for i in dic_q:
        if dic_q[i] == q:
            x2, y2 = i
            break

    x = x1 + x2
    y = y1 + y2

    ans_y = 1
    ans_x = x + (y - 1)

    ans_dic = {}
    for i in range(arr[ans_x] - ans_x + 1, arr[ans_x] + 1):
        ans_dic[(ans_y, ans_x)] = i
        ans_y += 1
        ans_x -= 1

    print(f'#{tc} {ans_dic[(x,y)]}')