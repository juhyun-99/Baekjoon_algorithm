import sys
input = sys.stdin.readline
while True:
    s = input().rstrip()
    if s == '.':
        exit()
    stack = []
    ans = True
    for i in s:
        if i == '(':
            stack.append('(')
        elif i =='[':
            stack.append('[')
        elif i ==')':
            if not stack:
                ans = False
                break
            if stack.pop() != '(':
                ans = False
                break
        elif i ==']':
            if not stack:
                ans = False
                break
            if stack.pop() != '[':
                ans = False
                break
    if ans and not stack:
        print('yes')
    else:
        print('no')