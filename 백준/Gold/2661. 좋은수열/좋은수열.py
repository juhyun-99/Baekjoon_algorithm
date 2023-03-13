import sys
input = sys.stdin.readline

n = int(input())
ans = []
def check(arr):
    for i in range(1, len(arr)//2 + 1):
        if arr[-2 * i : -i] == arr[-i:]:
            return False
    return True

def dfs():
    if not check(ans):
        return -1

    if len(ans) == n:
        print(*ans,sep='')
        exit()

    for i in range(1, 4):
        ans.append(i)
        dfs()
        ans.pop()

dfs()