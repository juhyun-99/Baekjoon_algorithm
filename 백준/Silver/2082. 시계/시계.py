import sys
input = sys.stdin.readline
arr = [['###','#.#','#.#','#.#','###'],['..#','..#','..#','..#','..#'],['###','..#','###','#..','###'],
       ['###','..#','###','..#','###'],['#.#','#.#','###','..#','..#'],['###','#..','###','..#','###'],
       ['###','#..','###','#.#','###'],['###','..#','..#','..#','..#'],['###','#.#','###','#.#','###'],
       ['###','#.#','###','..#','###']]

ans = [[True]*10 for _ in range(4)]

for i in range(5):
    s = list(input().rstrip().split())
    for j in range(4):
        for k in range(10):
            if not ans[j][k]:
                continue
            for m in range(3):
                #print(s[j][m], arr[k][i][m])
                if s[j][m] == '#' and arr[k][i][m] == '.':
                    ans[j][k] = False
                    continue

for i in range(4):
    for j in range(10):
        if ans[i][j] :
            print(j, end='')
            break
    if i == 1:
        print(':',end='')


