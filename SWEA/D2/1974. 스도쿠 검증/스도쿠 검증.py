
T = int(input())

for t in range(1, T + 1):
    arr=[
        list(map(int,input().split())) for _ in range(9)
    ]
    tf = 1
    for i in range(9):
        if len(set(arr[i])) != 9:
            tf = 0
            break
        if len(set([row[i] for row in arr])) !=9:
            tf = 0
            break
        if i%3==0:
            for k in range(0,9,3):
                arr2 = []
                for j in range(3):
                    for jj in range(3):
                        arr2.append(arr[i+j][k+jj])
            if len(set(arr2)) !=9:
                tf = 0
                break
    print(f'#{t} {tf}')