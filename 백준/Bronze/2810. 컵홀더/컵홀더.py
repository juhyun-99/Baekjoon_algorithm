n = int(input())
s = input()
a = (s.count('L')//2)
print(min(n,n-a+1))