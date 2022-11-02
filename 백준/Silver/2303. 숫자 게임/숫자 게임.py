from itertools import combinations

N = int(input())
num = [0]
for _ in range(N):
    num1 = list(map(int, input().split()))
    num1_1 = list(combinations(num1,3))
    ans = []
    for i in num1_1:
        ans.append(str(sum(i))[-1:])
    ans.sort(reverse = True)
    num.append(int(ans[0]))

m = 0
an_num = 0
for i in range(1, len(num)):
    if num[i] >= m:
        an_num = i
        m = num[i]
print(an_num)
