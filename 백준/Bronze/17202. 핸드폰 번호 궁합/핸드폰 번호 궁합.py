import sys; input=sys.stdin.readline

num1 = input().rstrip()
num2 = input().rstrip()
s = ''
for i in range(len(num1)):
    s +=num1[i]; s +=num2[i]

while len(s) > 2:
    new = ''
    for i in range(len(s)-1):
        ss = int(s[i])+int(s[i+1])
        new += str(ss%10)
    s = new
print(s)
