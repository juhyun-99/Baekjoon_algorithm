arr = [int(input()) for _ in range(9)]
cnt = 0
tf = 1
for i in range(8):
    for j in range(i + 1, 9):
        if sum(arr) - (arr[i] + arr[j]) == 100:
            x, y = arr[i], arr[j]
            arr.remove(x)
            arr.remove(y)
            tf = 0
            break
    if tf == 0:
        break

print(*arr, sep= '\n')