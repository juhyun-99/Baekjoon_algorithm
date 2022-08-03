n = int(input())
arr = list(map(int,input().split()))
arr.sort(reverse=True)
day = 1+n
n_max = 0

for i in range(n):
    n_max=max(arr[i]-(n-i-1),n_max)

print(day+n_max)
  