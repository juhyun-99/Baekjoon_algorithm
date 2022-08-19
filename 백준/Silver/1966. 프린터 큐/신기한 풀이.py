from collections import deque
#디큐 처음 써봄 rotate이용하려고 함
T=int(input())

for test_case in range(T):
    N, M = map(int,input().split())
    List=deque([(i, k) for i,k in enumerate(map(int,input().split()))])
    print(List)  
    #점과 가중치를 묶어서 dq로
    cnt=0
    rst=-1
    while rst!=M:
        #제일 큰 가중치가 앞에 올 때까지 돌려서
        #팝하고 카운터+1
        #최대치 기준을 가중치로 둠
        List.rotate(-List.index(max(List,key=lambda x:x[1])))
        print(List)
        rst=List.popleft()[0]
        print('rst',rst)
        cnt+=1
    print(cnt)
