t = int(input())


def get_gcd(a, b):
    while a % b != 0:
        a, b = b, a % b
    return b

for tc in range(t):
    s, t = input().split()
    minlen = min(len(s), len(t))
    a, b = max(len(s), len(t)), min(len(s), len(t))
    gcd = get_gcd(a, b)
    lcm = a//gcd*b

    s = s * (lcm//len(s))
    t = t * (lcm//len(t))


    ans = 'no'
    if s == t:
        ans = 'yes'

    print(f'#{tc + 1} {ans}')