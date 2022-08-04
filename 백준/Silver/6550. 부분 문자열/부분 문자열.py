while True:
    try:
        s,t = input().split()
        m = ''
        for i in s:
            for k in range(len(t)):
                if i==t[k]:
                    m+=t[k]
                    t = t[k+1::]
                    break
        if s==m:
            print('Yes')
        else:
            print('No')
    
    except:
        break