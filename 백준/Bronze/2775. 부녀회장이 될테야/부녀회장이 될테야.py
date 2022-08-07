T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())
    arr = [i for i in range(1,n+1)]

    if n==1:
        print(1)
    else:
        for i in range(k):
            for j in range(1,n):
                arr[j]+=arr[j-1]

        print(arr[n-1])
      