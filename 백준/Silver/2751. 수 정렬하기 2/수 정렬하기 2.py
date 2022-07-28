import sys
n = int(sys.stdin.readline())
num = []
for i in range(n):
    b = int(sys.stdin.readline())
    num.append(b)
num.sort()
for m in range(n):
    print(num[m])
    