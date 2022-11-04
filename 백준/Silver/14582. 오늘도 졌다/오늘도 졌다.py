team1 = list(map(int,input().split()))
team2 = list(map(int,input().split()))

cnt1 = 0
cnt2 = 0
win = False
for i in range(9):
    cnt1 += team1[i]
    if cnt1 > cnt2:
        win = True
    cnt2 += team2[i]

if win:
    print('Yes')
else:
    print('No')
