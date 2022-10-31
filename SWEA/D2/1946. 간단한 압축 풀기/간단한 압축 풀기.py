T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    s = ''
    print(f'#{tc}')
    for _ in range(N):
        command = list(map(str, input().split()))
        for i in range(int(command[1])):
            s += command[0]
            if len(s) == 10:
                print(s)
                s = ''
    print(s)
