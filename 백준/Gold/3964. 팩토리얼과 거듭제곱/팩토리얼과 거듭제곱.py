# m은 소인수분해가 필요하고
# n은 m의 소인수분해 한 것의 값들이 몇개가 있는지 찾아야함
import sys

input = sys.stdin.readline
t = int(input())


def f(num, di):
    for i in range(2, int(num ** 0.5) + 1):
        while num % i == 0:
            di[i] = di.get(i, 0) + 1
            num //= i
    if num != 1:
        di[num] = di.get(num, 0) + 1


for _ in range(t):
    dic_n = {}
    dic_k = {}
    n, k = map(int, input().split())
    f(k, dic_k)
    ans = 999999999999999999
    #print(dic_k)

    for i in dic_k:
        tmp = i
        while n >= tmp:
            dic_n[i] = dic_n.get(i, 0) + (n // tmp)
            tmp *= i

        if dic_n.get(i, 0) < dic_k[i]:
            ans = 0
            break
        else:
            ans = min(ans, dic_n[i] // dic_k[i])
    print(ans)
