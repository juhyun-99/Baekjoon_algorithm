import sys
input = sys.stdin.readline

l, c = map(int, input().split())
arr = sorted(input().split())
mo = ['a', 'e', 'i', 'o', 'u']

ans = []
mocnt = 0
jacnt = 0
def dfs(start):
    global mocnt
    global jacnt
    if len(ans) == l:
        if mocnt < 1 or jacnt < 2:
            return
        print(''.join(ans))
        return

    for i in range(start, c):
        ans.append(arr[i])
        if arr[i] in mo:
            mocnt += 1
        else:
            jacnt += 1
        dfs(i + 1)
        if arr[i] in mo:
            mocnt -= 1
        else:
            jacnt -= 1
        ans.pop()
dfs(0)