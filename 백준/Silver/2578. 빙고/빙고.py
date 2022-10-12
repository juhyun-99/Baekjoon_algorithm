#다시 풀어보자
import sys
input = sys.stdin.readline

bingo = dict()

for i in range(5):
    temp = list(map(int,input().split()))
    for j in range(5):
        bingo[temp[j]] = (i, j)

cnt = 0
visit = [[0]*5 for _ in range(5)]

for _ in range(5):
    nums = list(map(int, input().split()))
    for i in range(5):
        cnt += 1

        if nums[i] in bingo:
            visit[bingo[nums[i]][0]][bingo[nums[i]][1]] = 1

            b = 0
            for j in range(5):
                if sum(visit[j]) == 5:
                    b += 1
                if sum([k[j] for k in visit]) == 5:
                    b += 1
            #대각선
            if visit[0][4] + visit[1][3] + visit[2][2] + visit[3][1] + visit[4][0] == 5:
                b += 1
            if visit[0][0] + visit[1][1] + visit[2][2] + visit[3][3] + visit[4][4] == 5:
                b += 1

            if b >= 3:
                print(cnt)
                sys.exit()