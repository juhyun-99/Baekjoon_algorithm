from itertools import combinations
t = int(input())

for tc in range(1, t+1):
    nums = list(map(int, input().split()))
    l =list(set([sum(i) for i in combinations(nums,3)]))
    l.sort(reverse = True)
    print(f'#{tc} {l[4]}')