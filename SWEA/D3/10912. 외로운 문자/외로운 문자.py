from collections import Counter

T = int(input())

for tc in range(1, T + 1):
    s = list(input())
    dic = dict(Counter(s))
    ans = True
    for i in dic.values():
        if i%2!=0:
            ans = False
            break

    if ans == True:
        print(f'#{tc} Good')
    else:
        print(f'#{tc} ',end = '')
        dic = dict(sorted(dic.items()))
        for i in dic:
            if dic[i] % 2 != 0:
                print(i,end='')
        print()