t = int(input())

for tc in range(1, t + 1):
    a, b = input().rstrip().split()
    if len(a) == 2 or len(b) == 2:
        ans = -1
    else:
        ans = int(a) * int(b)
    print(f'#{tc} {ans}')