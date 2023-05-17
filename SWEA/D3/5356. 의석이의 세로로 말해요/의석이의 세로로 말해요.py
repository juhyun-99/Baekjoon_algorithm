t = int(input())

for tc in range(1, t + 1):
    arr = [input() for _ in range(5)]
    max_len = 0
    ans = ''

    for i in range(1, 16):
        for j in range(5):
            if len(arr[j]) < i:
                continue
            else:
                ans += arr[j][i - 1]

    print(f'#{tc} {ans}')