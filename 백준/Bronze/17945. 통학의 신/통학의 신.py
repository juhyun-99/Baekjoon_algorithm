import math

A, B = map(int, input().split())

num1 = -A + math.sqrt(A*A - B)
num2 = -A - math.sqrt(A*A - B)

if num1 > num2 :
    print(int(num2), int(num1))
elif num1 == num2:
    print(int(num1))
else:
    print(int(num1), int(num2))