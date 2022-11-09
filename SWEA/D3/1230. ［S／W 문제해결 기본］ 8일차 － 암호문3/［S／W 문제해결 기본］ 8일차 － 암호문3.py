for tc in range(1, 11):
    N = int(input())
    code = list(map(int, input().split()))
    c_cnt = int(input())
    command = list(input().split())

    for i in range(len(command)):
        if command[i] == 'I':
            idx = int(command[i + 1])
            cnt = int(command[i + 2])
            for j in range(cnt):
                code.insert(idx + j, int(command[i + j + 3]))

        elif command[i] == 'D':
            idx = int(command[i + 1])
            cnt = int(command[i + 2])
            for j in range(cnt):
                del code[idx]

        elif command[i] == 'A':
            cnt = int(command[i + 1])
            for j in range(cnt):
                code.append(int(command[i + 2 + j]))

    print(f'#{tc} ',end = '')
    for i in range(10):
        print(code[i],end=' ')
    print()