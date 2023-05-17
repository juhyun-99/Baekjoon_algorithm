t = int(input())
for tc in range(1, t + 1):
    s = input()
    num = int(s[0])
    person = 0
    for i in range(1, len(s)):
        if num < i:
            tmp = i - num
            num += tmp
            person += tmp

        if s[i] != '0':
            num += int(s[i])

    print(f'#{tc} {person}')
