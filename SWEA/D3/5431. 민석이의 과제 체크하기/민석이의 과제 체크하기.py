
T = int(input())

for test_case in range(1, T + 1):
    arr = []
    N, K = map(int, input().split())
    for i in range(1,N+1):
        arr.append(i)
    student = list(map(int,input().split()))
    for i in student:
        arr.remove(i)
    print(f'#{test_case}',end = ' ')
    print(*arr, sep= ' ')