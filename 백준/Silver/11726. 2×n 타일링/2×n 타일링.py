import sys
n = int(sys.stdin.readline())
cnt_list = [1, 2] + [0]*(n-2)

for i in range(2, n):
    cnt_list[i] = cnt_list[i-1] + cnt_list[i-2]
    
print(cnt_list[n-1] % 10007)