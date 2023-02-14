'''
봄   나무 -> 나이만큼 양분 먹고, 나이 1 증가 / 근데 나이가 어린 나무부터 양분 먹음 / 못먹으면 죽음
여름  봄에 죽은 나무 양분으로 변함 -> 죽은 나무 // 2 가 양분으로 추가
가을  나무가 번식 -> 5의배수인 나무가 번식-> 인접 8칸에 나이가 1인 나무가 생김 / 벗어나면 안생김
겨울  양분 추가
'''

from collections import deque
import sys

input = sys.stdin.readline


def spring_summer():
    global trees
    global food
    global ans

    for i in range(n):
        for j in range(n):
            if trees[i][j]:
                tree = trees[i][j]
                tmp = deque([])
                die = 0
                for _ in range(len(tree)):
                    x = tree.popleft()

                    if food[i][j] - x >= 0:  # 양분이 있으면 먹고 나이+1
                        food[i][j] -= x
                        tmp.append(x + 1)

                    else:  # 죽음
                        die += x // 2  # 여름
                        ans -= 1
                trees[i][j] = tmp
                food[i][j] += die


def fall_winter():
    global trees
    global ans
    for i in range(n):
        for j in range(n):
            for age in trees[i][j]:
                if age % 5 == 0:
                    for d in range(8):
                        nx = i + dx[d]
                        ny = j + dy[d]
                        if 0 <= nx < n and 0 <= ny < n:
                            trees[nx][ny].appendleft(1)
                            ans += 1
            food[i][j] += a[i][j]  # 겨울에 양분 추가


n, m, k = map(int, input().split()) #n: 땅 크기, m: 나무, k : 년도
food = [[5] * n for _ in range(n)]
a = [list(map(int, input().split())) for _ in range(n)]
trees = [[deque([]) for _ in range(n)] for _ in range(n)]

for _ in range(m):
    x, y, age = map(int, input().split())
    trees[x - 1][y - 1].append(age)
ans = m
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

for _ in range(k):
    spring_summer()
    fall_winter()
print(ans)
