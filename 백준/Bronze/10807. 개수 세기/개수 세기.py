from collections import Counter

N = int(input())
arr = list(map(int,input().split()))
dic = Counter(arr)
print(dic[int(input())])