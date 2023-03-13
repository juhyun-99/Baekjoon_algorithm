import sys
input = sys.stdin.readline

t = int(input())
total = []
for _ in range(t):
    n = int(input())
    ans = []
    cnt = 0
    arr = list(map(int, input().split()))
    tmp = []
    for i in arr:
        tmp.append(i)
        for j in arr:
            if i < j:
                tmp.append(j - i)
    tmp = list(set(tmp))
    #print(*tmp)
    for a in tmp:
        for b in tmp:
            for c in tmp:
                if a <= b <= c:
                    count = [a, b, c, a + b, a + c, b + c, a + b + c]
                    tf = True
                    for i in arr:
                        if i not in count:
                            tf = False
                    if tf:
                        cnt += 1
    total.append(cnt)

print(*total, sep='\n')
