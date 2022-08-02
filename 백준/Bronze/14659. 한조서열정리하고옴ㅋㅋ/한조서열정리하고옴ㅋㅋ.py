n = int(input())
arr= list(map(int,input().split()))

cnt = 0
cnt_arr = []
m = arr[0]
for i in range(n-1):
    if m > arr[i+1]:
        cnt+=1
    else:
        m = arr[i+1]
        cnt_arr.append(cnt)
        cnt = 0
cnt_arr.append(cnt)
print(max(cnt_arr))