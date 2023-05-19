t = int(input())
answer = []
for tc in range(1, t + 1):
    a,b,c,d = map(int,input().split())

    alice = a/b * 100000000
    bob = c/d * 100000000
    ans = ''
    alice = int(alice)
    bob = int(bob)
    if alice == bob:
        ans = 'DRAW'
    elif alice > bob:
        ans = 'ALICE'
    else:
        ans = 'BOB'
    answer.append(ans)

for i in range(len(answer)):
    print(f'#{i + 1} {answer[i]}')