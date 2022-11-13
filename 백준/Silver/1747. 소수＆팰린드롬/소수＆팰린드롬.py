s = []
def sosu(n):
    if n < 2:
        return False
    else:
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
    return True

n = int(input())
while True:
    if sosu(n):
        ss = str(n)
        if ss == ss[::-1]:
            print(n)
            break
        else:
            n += 1
    else:
        n+=1

