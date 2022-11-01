import math
T = int(input())

for tc in range(1, T + 1):
    N, M = map(int, input().split())
    cnt = 0
    for i in range(N, M+1):
        if str(i) == str(i)[::-1]:
            if math.sqrt(i).is_integer():
                if str(int(math.sqrt(i))) == str(int(math.sqrt(i)))[::-1]:
                    cnt+=1
    print(f'#{tc}',cnt)