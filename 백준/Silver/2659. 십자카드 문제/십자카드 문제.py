
ll = []
#print(arr)
l = list(map(int, input().split()))
for i in range(4):
    tmp = ''
    for j in range(4):
        tmp += str(l[(i + j) % 4])
    if tmp[0] != '0':
        ll.append(int(tmp))
ll.sort()
#print(ll)

arr = []
for i in range(1111, ll[0]):
    s = list(str(i))
    if '0' in s:
        continue
    ss = []
    for i in range(4):
        tmp = ''
        for j in range(4):
            tmp += s[(i + j) % 4]
        ss.append(tmp)
    ss.sort()
    idx = int(ss[0])
    if idx not in arr:
        arr.append(idx)
print(len(arr) + 1)