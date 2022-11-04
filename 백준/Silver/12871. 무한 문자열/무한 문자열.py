s = input().rstrip()
t = input()
l = len(s)

s *= len(t)
t *= l
if s == t:
    print(1)
else: print(0)