from itertools import combinations

T = int(input())

for tc in range(1, T + 1):
    n = int(input())
    i = 0
    s=''
    while True:
        s += ''.join(list(input().split()))
        if len(s) == n:
            break

    while True:
        if str(i) not in s:
            break
        i+=1
    print(f'#{tc} {i}')