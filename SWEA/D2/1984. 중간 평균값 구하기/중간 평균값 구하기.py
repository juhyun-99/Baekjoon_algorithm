
T = int(input())

for t in range(1, T + 1):
    arr= list(map(int,input().split()))
    arr.sort()
    del arr[0]
    del arr[-1]
    print(f'#{t} {round(sum(arr)/8)}')
