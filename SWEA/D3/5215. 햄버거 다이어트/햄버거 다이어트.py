from itertools import combinations

t = int(input())

for tc in range(1, t + 1) :
    n, l = map(int, input().split())
    data = [list(map(int, input().split())) for _ in range(n)]

    max_score = 0
    for i in range(1, n + 1) :
        for value in combinations(data, i) :
            kcal = 0
            score = 0
            for v in range(len(value)) :
                kcal += value[v][1]
                score += value[v][0]
            if kcal > l :
                continue
            max_score = max(max_score, score)

    print(f'#{tc} {max_score}')