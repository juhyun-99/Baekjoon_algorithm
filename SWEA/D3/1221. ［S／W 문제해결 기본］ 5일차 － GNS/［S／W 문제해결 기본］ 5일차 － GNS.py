from collections import Counter

t = int(input())
nums = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
for tc in range(1, t + 1):
    print(f'#{tc}')
    s,l = input().split()
    arr = list(input().split())
    dic = dict(Counter(arr))
    for i in nums:
        for k in range(dic[i]):
            print(i,end= ' ')
