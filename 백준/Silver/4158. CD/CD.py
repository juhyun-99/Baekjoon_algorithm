import sys
input = sys.stdin.readline

while True:
    #상근, 선영
    N, M = map(int,input().split())
    if N == M == 0:
        sys.exit()

    #상근
    sg_cd = [int(input()) for _ in range(N)]
    #선영
    sy_cd = [int(input()) for _ in range(M)]


    cnt = 0

    for cd in sg_cd:
        start, end = 0, M - 1
        while start <= end:
            mid = (start + end)//2

            if sy_cd[mid] == cd:
                cnt += 1
                break

            elif sy_cd[mid] > cd:
                end = mid - 1

            else:
                start = mid + 1

    print(cnt)