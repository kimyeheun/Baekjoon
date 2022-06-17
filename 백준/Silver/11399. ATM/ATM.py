import sys
people = int(sys.stdin.readline())
time = list(map(int, sys.stdin.readline().split()))
tot = []
time.sort()
sum_ = 0
for i in range(len(time)):
    sum_ += time[i]
    tot.append(sum_)

print(sum(tot))