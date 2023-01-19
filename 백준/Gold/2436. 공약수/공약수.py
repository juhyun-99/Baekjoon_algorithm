import sys
input = sys.stdin.readline
GCD, LCM = map(int, input().split())  # 최대공약수, 최소공배수
s = GCD * LCM
ans = 1e9

def get_gcd(a, b):
    while a % b != 0:
        a, b = b, a % b
    return b

s1,s2 = 0,0
for i in range(GCD, int(s ** 0.5) + 1, GCD):
    n2 = s // i
    num = get_gcd(n2, i)
    if num == GCD and n2 // num * i == LCM:
        s1, s2 = i, n2
        ans = min(ans, i + n2)

print(s1,s2)