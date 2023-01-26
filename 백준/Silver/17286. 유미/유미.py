yumi = list(map(int,input().split()))
people = [list(map(int,input().split())) for _ in range(3)]

tmp = []
for i in range(3):
    x = (yumi[0] - people[i][0])
    y = (yumi[1] - people[i][1])
    tmp.append((x*x + y*y)**0.5)
idx1 = tmp.index(min(tmp))

p2 = []
for i in range(3):
    visit = [0] * 3
    visit[i] = 1
    ans = 0
    tmp2 = []
    for j in range(3):
        if i == j:
            tmp2.append(1e9)
        else:
            x = people[i][0] - people[j][0]
            y = people[i][1] - people[j][1]
            tmp2.append((x*x + y*y)**0.5)
    idx = tmp2.index(min(tmp2))
    ans += tmp2[idx]
    visit[idx] = 1

    for k in range(3):
        if visit[k] == 0:
            x = people[idx][0] - people[k][0]
            y = people[idx][1] - people[k][1]
            ans += (x*x + y*y)**0.5
    p2.append(ans)
ans = 1e9
for i in range(3):
    ans = min(ans, p2[i] + tmp[i])
print(int(ans))