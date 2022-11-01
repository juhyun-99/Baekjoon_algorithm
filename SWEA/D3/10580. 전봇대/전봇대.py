T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    arr = []
    cnt = 0
    for _ in range(N):
        a, b = map(int, input().split())
        arr.append((a,b))
    for i in range(N -1):
        for j in range(i + 1, N):
            if  (arr[i][0] < arr[j][0] and arr[i][1] > arr[j][1]) or (arr[i][0] > arr[j][0] and arr[i][1] < arr[j][1]):
                cnt+=1

    print(f'#{tc}',cnt)
