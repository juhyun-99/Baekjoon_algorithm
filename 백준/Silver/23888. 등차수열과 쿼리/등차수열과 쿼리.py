import sys

input = sys.stdin.readline

a, d = map(int, input().split())
q = int(input())


def get_gcd(n1, n2):
    n1, n2 = max(n1, n2), min(n1, n2)
    while n1 % n2 != 0:
        n1, n2 = n2, n1 % n2
    return n2


for _ in range(q):
    n, l, r = map(int, input().split())
    if n == 1:  # l ~ r번째까지 합= s(r) - s(l - 1)
        sl = ((l - 1) * (a + a + (l - 2) * d)) // 2
        sr = (r * (a + a + (r - 1) * d)) // 2
        print(sr - sl)

    elif n == 2:  # l번째와 r번째 최대공약수 구하기 어차피 l이 가장 작고 r이 가장 크기 때문
        if l == r:
            print(a + (l - 1) * d)
        else:
            if d == 0:
                print(a)
            else:
                print(get_gcd(a, d))

