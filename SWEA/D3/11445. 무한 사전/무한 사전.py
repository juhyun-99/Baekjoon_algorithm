T = int(input())

for tc in range(1, T + 1):
    p = input().rstrip()
    q = input().rstrip()
    result = 'Y'
    if p+'a' == q:
        result = 'N'
    print(f'#{tc} {result}')


