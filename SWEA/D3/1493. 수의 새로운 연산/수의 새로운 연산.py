arr = [0, 1]

for i in range(2, 400):
    arr.append(arr[i - 1] + i)

t = int(input())

def retXY(num):
    dic = {}
    x = 1
    y = num
    for i in range(arr[num] - num + 1, arr[num] + 1):
        dic[(x,y)] = i
        x += 1
        y -= 1
    return dic



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

    dic_p = retXY(pp)
    dic_q = retXY(qq)
    
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
    
    number = x + (y - 1)
    ans_dic = retXY(number)

    print(f'#{tc} {ans_dic[(x,y)]}')