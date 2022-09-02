n = 9
arr = [int(input()) for _ in range(n)]
one,two =0,0
for i in range(n):
    for j in range(i+1, n):
        if sum(arr) - (arr[i] + arr[j]) == 100:
            one = arr[i]
            two = arr[j]
            break
arr.remove(one)
arr.remove(two)

arr.sort()
print(*arr,sep='\n')