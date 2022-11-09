
for tc in range(1, 11):
    l, s = input().rstrip().split()
    stack = [s[0]]
    for i in range(1, int(l)):
        if stack and stack[-1] != s[i]:
            stack.append(s[i])
        elif stack and stack[-1] == s[i]:
            stack.pop()
        elif not stack:
            stack.append(s[i])
    ans = ''.join(stack)
    print(f'#{tc} {ans}')
