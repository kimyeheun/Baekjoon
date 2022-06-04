import sys

n = int(sys.stdin.readline())
number = list(map(int, sys.stdin.readline().split()))
mark = list(map(int, sys.stdin.readline().split()))
answer_list = []


def calculation(a, answer, plus, mi, mul, div):
    if a == n:
        answer_list.append(answer)
        return answer_list
    if plus:
        calculation(a+1, answer+number[a], plus-1, mi, mul, div)
    if mi:
        calculation(a+1, answer-number[a], plus, mi-1, mul, div)
    if mul:
        calculation(a+1, answer*number[a], plus, mi, mul-1, div)
    if div:
        if answer < 0:
            calculation(a+1, -(abs(answer)//number[a]), plus, mi, mul, div-1)
        else:
            calculation(a+1, (answer//number[a]), plus, mi, mul, div-1)
calculation(1, number[0], mark[0], mark[1], mark[2], mark[3])
answer_list.sort()
print(answer_list[-1])
print(answer_list[0])
