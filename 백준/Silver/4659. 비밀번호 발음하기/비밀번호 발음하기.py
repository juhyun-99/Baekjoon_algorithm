import sys
input = sys.stdin.readline

while True:
    s = input().rstrip()
    c_aeiou = 0
    c_other = 0
    if s == 'end':
        break

    ans = True
    previous = '.'
    if ('a' not in s) and ('e' not in s) and ('i' not in s) and ('o' not in s) and ('e' not in s):
        print(f'<{s}> is not acceptable.')
        continue

    for i in s:
        if i=='a' or i == 'e' or i=='i' or i=='o' or i=='u':
            c_aeiou += 1
            c_other = 0
            if previous == i and (i !='e' and i !='o'):
                ans = False
                break
        else:
            if previous == i:
                ans = False
                break
            c_other += 1
            c_aeiou = 0
        previous = i

        if c_other == 3 or c_aeiou == 3:
            ans = False
            break

    if ans:
        print(f'<{s}> is acceptable.')
    else:
        print(f'<{s}> is not acceptable.')