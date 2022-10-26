from itertools import permutations

N, M = map(int,input().split())
matrix = [i for i in range(1, N + 1)]
arr = permutations(matrix, M)

for i in arr:
    for j in i:
        print(j, end = ' ')
    print()