N,K = map(int,input().split())
ans = []
index = K-1
arr = list(range(1,N+1))
while True:
    ans.append(arr[index])
    del arr[index]
    if not arr:
        break
    index = (index + K - 1)%len(arr)
print('<'+', '.join(map(str,ans))+'>')
    
    
        
