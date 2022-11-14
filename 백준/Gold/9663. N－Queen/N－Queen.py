def possible(x):
    for i in range(x):
        if queen[i] == queen[x] or abs(x - i) == abs(queen[x] - queen[i]):
            return False
    return True

def q(x):
    global ans
    if x == n:
        ans += 1
        return
    for i in range(n):
        queen[x] = i
        if possible(x):
            q(x + 1)

n = int(input())
queen = [0] * n
ans = 0
q(0)
print(ans)