n = int(input())
arr = list(map(int,input().split()))
arr.remove(max(arr))

print(sum(arr))
