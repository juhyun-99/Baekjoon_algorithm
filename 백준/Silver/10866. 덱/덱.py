import sys
N = int(input())
deque=[]
for _ in range(N):
    command = sys.stdin.readline().rstrip().split()
    if command[0] =='push_front':
        deque.insert(0,command[1])
    elif command[0] =='push_back':
        deque.append(command[1])
    elif command[0] =='pop_front':
        if deque:
            print(deque[0])
            del deque[0]
        else : print(-1)
    elif command[0] =='pop_back':
        if deque:
            print(deque[-1])
            del deque[-1]
        else : print(-1)
    elif command[0] =='size':
        print(len(deque))
    elif command[0] =='empty':
        if not deque: print(1)
        else : print(0)
    elif command[0] =='front':
        if deque:
            print(deque[0])
        else : print(-1)
    else:
        if deque:
            print(deque[-1])
        else : print(-1)