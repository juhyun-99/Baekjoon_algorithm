g = int(input())
arr = [0]
for i in range(1, g):
    tmp = i*i
    if tmp - arr[-1] <= g:
        arr.append(tmp)
    else:
        break

s , e = 1, 2
ans = False
while True:
    if e >= len(arr):
        break
    tmp = arr[e] - arr[s]
    if tmp < g:
        e += 1

    elif tmp > g:
        s += 1
    else:
        ans = True
        print(e)
        e += 1
        s += 1

if not ans:
    print(-1)