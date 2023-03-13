import sys
input = sys.stdin.readline

n = int(input())
arr = [0] * n
ans = 0
def check(num):
    for i in range(num):
        if arr[i] == arr[num] or abs(num - i) == abs(arr[num] - arr[i]):
            return False
    return True

def dfs(num):
    global ans

    if num == n:
        ans += 1
        return

    for i in range(n):
        arr[num] = i
        if check(num):
            dfs(num + 1)

dfs(0)
print(ans)