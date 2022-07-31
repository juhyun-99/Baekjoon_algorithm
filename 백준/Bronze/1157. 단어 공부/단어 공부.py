w = input()
w = w.upper()
w_list = list(set(w))

cnt = []
for i in w_list:
    count = w.count(i)
    cnt.append(count)

if cnt.count(max(cnt)) >=2:
    print('?')
else :
    print(w_list[cnt.index(max(cnt))])