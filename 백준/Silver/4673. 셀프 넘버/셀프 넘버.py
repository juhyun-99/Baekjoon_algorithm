arr = list(range(1,10001))

for i in range(1,10001):
    for elem in str(i):
        i += int(elem)
    if (i in arr) and i<10001:
        arr.remove(i)

for elem in arr:
    print(elem)