from collections import Counter
T = int(input())

for tc in range(1, T + 1):
    n = int(input())
    student = list(map(int, input().split()))
    dic = dict(Counter(student))
    dic = sorted(dic.items(), key = lambda x : (x[1],x[0]), reverse = True)
    print(f'#{n} {dic[0][0]}')