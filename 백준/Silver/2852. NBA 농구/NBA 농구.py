import sys
input = sys.stdin.readline
n = int(input())
t = []
g = []
for _ in range(n):
    team, time = input().rstrip().split()
    m = time[0:2]
    s = time[3:]
    t.append(int(team))
    g.append(int(m)*60 + int(s))
t.append(0)
g.append(48 * 60)
g1, g1_t = 0, 0
g2, g2_t = 0, 0

for i in range(n):
    if t[i] == 1:
        g1 += 1
    elif t[i] == 2:
        g2 += 1

    if g1 > g2:
        g1_t += g[i + 1] - g[i]
    elif g2 > g1:
        g2_t += g[i + 1] - g[i]

g1_m = ''
if len(str(g1_t // 60)) == 1:
    g1_m = '0'+str(g1_t // 60) + ':'
else:
    g1_m = str(g1_t // 60) + ':'
if len(str(g1_t % 60)) == 1:
    g1_m += '0' + str(g1_t % 60)
else:
    g1_m += str(g1_t % 60)

g2_m = ''
if len(str(g2_t // 60)) == 1:
    g2_m = '0'+str(g2_t // 60) + ':'
else:
    g2_m = str(g2_t // 60) + ':'
if len(str(g2_t % 60)) == 1:
    g2_m += '0' + str(g2_t % 60)
else:
    g2_m += str(g2_t % 60)

print(g1_m)
print(g2_m)