import sys

input = sys.stdin.readline
c = int(input())
for _ in range(c):
    d, n = map(int, input().split())
    arr = [0] + list(map(int, input().split()))
    s = [0] * (n + 1)
    cnt = 0
    dic = {}

    for i in range(1, n + 1):
        tmp = arr[i] + s[i - 1]
        cnt += dic.get(tmp%d,0)
        s[i] = tmp
        dic[tmp%d] = dic.get(tmp%d,0) + 1  # 더해주기

        if s[i] % d == 0:
            cnt += 1
    # print(s)
    print(cnt)
