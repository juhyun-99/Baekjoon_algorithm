a,b = input().split()

def change(value):
    ss=''
    for i in value[::-1]:
      ss+=i
    return ss

print(max(int(change(a)),int(change(b))))