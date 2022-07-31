T = int(input())

for _ in range(T):
    n,s = input().split()
    n = int(n)
    ss = ''
    for k in range(len(s)):
        for i in range(n):
            ss += s[k]
    print(ss)