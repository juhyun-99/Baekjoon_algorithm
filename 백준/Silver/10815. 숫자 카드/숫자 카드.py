N = int(input())
card = list(map(int,input().split()))
card.sort()

M = int(input())
card2 = list(map(int,input().split()))

ans = [0]*M

for i in range(len(card2)):
    start = 0
    end = N-1
    num = (end+start)//2
    while start<=end:
        if card2[i] == card[num]:
            ans[i] = 1
            break
        elif card2[i] < card[num]:
            end = num-1
        else:
            start = num+1
        num = (end+start)//2

print(*ans,sep = ' ')