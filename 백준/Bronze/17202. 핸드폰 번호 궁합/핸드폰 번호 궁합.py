import sys; input=sys.stdin.readline
dp = [0]*91
dp[1] = 1; dp[2]=1
num1 = input().rstrip()
num2 = input().rstrip()
s = ''
for i in range(len(num1)):
    s +=num1[i]; s +=num2[i]

while len(s) > 2:
    new = ''
    for i in range(len(s)-1):
        ss = str(int(s[i])+int(s[i+1]))
        if len(ss)==2:
            new +=ss[1]
        else:
            new +=ss[0]
    s = new
print(s)
