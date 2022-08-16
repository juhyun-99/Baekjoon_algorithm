N = int(input())

arr = [1]
for k in range(1,N):
    if arr[k-1]*k <= N:
        arr.append(arr[k-1]*k)
    else:
        break


if N == 0 :
    print('NO')
    exit()


while N!=0:
    if sum(arr) < N:
        print('NO')
        break
    else:
        if N in arr:
            print('YES')
            break
        else:
            N-=arr[-1]
            del arr[-1]
            for i in range(len(arr)):
                if arr[i] > N:
                    del arr[i]
                else:
                    break
