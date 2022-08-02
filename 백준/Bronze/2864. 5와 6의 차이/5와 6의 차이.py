a,b = input().split()
a = list(a)
b = list(b)

def maxx(num):
    number = ''
    for i in num:
        if i=='5':
            i='6'
        number+=i  
    return int(number)

def minn(num):
    number = ''
    for i in num:
        if i=='6':
            i='5'
        number+=i
    return int(number)

a2 = maxx(a)
b2 = maxx(b)
aa = minn(a)
bb = minn(b)
print(aa+bb, a2+b2)

        
        
        
        