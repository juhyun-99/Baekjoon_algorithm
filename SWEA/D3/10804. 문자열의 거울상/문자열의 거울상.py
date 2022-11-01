T = int(input())

for tc in range(1, T + 1):
    s = input().rstrip()
    ss = list(s[::-1])
    for i in range(len(ss)):
        if ss[i] == 'b':
            ss[i] = 'd'
        elif ss[i] == 'd':
            ss[i] = 'b'
        elif ss[i] == 'p':
            ss[i] = 'q'
        else:
            ss[i] = 'p'
    ans = ''.join(ss)
    print(f'#{tc} {ans}')