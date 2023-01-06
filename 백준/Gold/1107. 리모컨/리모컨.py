#완전탐색 생각
import sys
input = sys.stdin.readline

num = [i for i in range(10)]
ch = input().rstrip()
if ch=='100':
    print(0)
    sys.exit()

bnum = int(input())

if 0 < bnum < 10:
    brnum = list(map(int, input().split()))
    for i in brnum:
        num.remove(i)
    ch_check = True

    for i in ch:
        if int(i) not in num:
            ch_check = False

    m1,m2 = -1,-1
    for i in range(int(ch) - 1, -1, -1):
        tr = True
        for j in str(i):
            if int(j) not in num:
                tr = False
                break
        if tr:
            m1 = i
            break

    for i in range(int(ch) + 1,1000000):
        tr = True
        for j in str(i):
            if int(j) not in num:
                tr = False
                break
        if tr:
            m2 = i
            break
    # print(ch_check,m1,m2)
    
    if ch_check:
        print(min(len(ch), abs(int(ch) - 100)))
    else:
        if m1 != -1 and m2 != -1:
            a = min(abs(m1 - int(ch)) + len(str(m1)), abs(m2 - int(ch)) + len(str(m2)), abs(int(ch) - 100))
        elif m1 == -1:
            a = min(abs(m2 - int(ch)) + len(str(m2)), abs(int(ch) - 100))
        else:
            a = min(abs(m1 - int(ch)) + len(str(m1)), abs(int(ch) - 100))
        print(a)


elif bnum == 10: #모두 고장난 버튼
    print(abs(int(ch) - 100))
    sys.exit()

else: #고장난 버튼이 하나도 없을 때
    print(min(len(ch), abs(100 - int(ch))))
    sys.exit()