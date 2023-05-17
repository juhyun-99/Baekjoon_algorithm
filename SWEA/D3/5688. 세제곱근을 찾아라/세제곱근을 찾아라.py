t = int(input())
for tc in range(1, 1 + t):
    n = int(input())
    result = -1
    for i in range(1, n + 1):
        if i * i * i > n:  
            break

        if i * i * i == n: 
            result = i
            break

    print(f'#{tc} {result}')