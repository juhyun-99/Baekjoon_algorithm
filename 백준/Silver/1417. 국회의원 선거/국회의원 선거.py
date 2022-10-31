N = int(input())
dasom = int(input())
if N == 1:
    print(0)
    exit()
arr = [int(input()) for _ in range(N-1)]
cnt = 0
while True:
    if dasom > max(arr):
        break

    arr[arr.index(max(arr))] -= 1
    dasom += 1
    cnt+=1
print(cnt)


