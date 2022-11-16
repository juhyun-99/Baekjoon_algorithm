#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AW9j74FacD0DFAUY&categoryId=AW9j74FacD0DFAUY&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=8
from collections import deque
T = int(input())

for tc in range(1, T + 1):
    n, m = map(int, input().split())#n 주차공간, 차량 수
    #i번째 주차공간의 단위 무게당 요금
    price = [int(input()) for _ in range(n)]

    #차량 i의 무게
    car = {i + 1 : int(input()) for i in range(m)}

    ans = 0
    park = [0] * n
    stay = deque()
    for _ in range(2 * m):
        num = input()
        if int(num) > 0:
            if 0 not in park:
                stay.append(int(num))
                continue
            for i in range(n):
                if park[i] == 0:
                    park[i] = int(num)
                    break
        else:
            idx = park.index(abs(int(num)))
            park[idx] = 0
            ans += car[abs(int(num))] * price[idx]
            while True:
                if stay and 0 in park:
                    c = stay.popleft()
                    for i in range(n):
                        if park[i] == 0:
                            park[i] = c
                            break
                else: break
    print(f'#{tc} {ans}')