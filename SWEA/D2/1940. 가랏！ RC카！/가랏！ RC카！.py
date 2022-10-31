T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    move = 0
    before_speed = 0
    for _ in range(N):
        command = list(map(int, input().split()))
        if command[0] == 1:
            before_speed += command[1]
        elif command[0] == 2:
            if before_speed < command[1]:
                before_speed = 0
            else:
                before_speed -= command[1]
        move += before_speed
    print(f'#{tc} {move}')