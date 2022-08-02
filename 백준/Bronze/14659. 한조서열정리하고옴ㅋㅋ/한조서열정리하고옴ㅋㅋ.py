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
        
#[10,9,8]의 경우 cnt+=1만 해주고 cnt_arr에 넣어주지 않기 때문에 넣어주어야한다.
cnt_arr.append(cnt)
print(max(cnt_arr))
