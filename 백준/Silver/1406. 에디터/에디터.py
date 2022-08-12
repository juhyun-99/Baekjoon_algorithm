#https://velog.io/@tkdduf727/%EB%B0%B1%EC%A4%80-%EA%B4%84%ED%98%B8-1406%EB%B2%88-%ED%8C%8C%EC%9D%B4%EC%8D%AC-Python-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0
import sys

stack_l = list(input())
stack_r = []
n = int(input())

for i in range(n):
    command = sys.stdin.readline().split()

    if command[0] == "L" and stack_l:
        stack_r.append(stack_l.pop())
    elif command[0] == "D" and stack_r:
        stack_l.append(stack_r.pop())
    elif command[0] == "B" and stack_l:
        stack_l.pop()
    elif command[0] == "P":
        stack_l.append(command[1])

print("".join(stack_l + list(reversed(stack_r))))
#마지막에 stack2를 뒤집어주는 과정에서 반드시 st2.reverse() 가 아닌 reversed(st2) 를 사용해줘야한다.
#만약 모든 명령이 끝난 후 st2에 값이 아무것도 존재하지 않는다면 st2.reverse() 는 TypeError를 띄우기 때문이다.
#반면에 reversed(st2) 는 st2에 값이 존재하지 않더라도 오류를 띄우지 않고 우리가 생각한대로 잘 작동한다.
