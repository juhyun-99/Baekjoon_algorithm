#s = input()
#a =''
#for i in s:
    #if i=='U'or i=='C' or i=='P':
        #a+=i  

#if a == 'UCPC':
    #print('I love UCPC')
#else:
    #print('I hate UCPC')

import sys

s = sys.stdin.readline()
check_list = ['U', 'C', 'P', 'C']
isSuccess = True

for check in check_list:
    if check in s:
        s = s[s.find(check)+1:]
    else:
        isSuccess = False
        break

if isSuccess:
    print("I love UCPC")
else:
    print("I hate UCPC")