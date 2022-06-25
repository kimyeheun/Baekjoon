import sys
import heapq
arr = []
n = int(sys.stdin.readline())

for i in range(n):
    a = int(sys.stdin.readline())
    if a==0:
        if len(arr) != 0: 
            print(heapq.heappop(arr))
        else: 
            print(0)
    else: 
        heapq.heappush(arr, a)
    