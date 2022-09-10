import sys

n, m = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))
answer = None
while True:
    std = (sum(trees) - m) // len(trees)
    new_trees = [x for x in trees if x >= std]
    if len(new_trees) == len(trees):
        answer = std
        break
    else:
        trees = new_trees

print(answer)
