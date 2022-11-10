import math

def sosu(n):
    if n <= 1:
        return False
    else:
        for i in range(2, int(math.sqrt(n)) + 1):
            if n % i == 0:
                return False
                break
        return True

for i in range(1, 1000000):
    if sosu(i):
        print(i, end = ' ')