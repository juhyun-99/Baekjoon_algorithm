T = int(input())

for tc in range(1, T + 1):
    arr = [0] * 10
    N = int(input())
    num = N
    while True:
        s = str(num)
        for i in s:
            arr[int(i)] = 1
        if sum(arr) == 10:
            break
        else:
            num += N
    print(f'#{tc} {num}')
