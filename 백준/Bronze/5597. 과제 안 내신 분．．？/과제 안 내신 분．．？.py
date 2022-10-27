student = [i for i in range(1, 31)]

for _ in range(28):
    num = int(input())
    if num in student:
        student.remove(num)
print(student[0])
print(student[1])