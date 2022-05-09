import sys
count = int(sys.stdin.readline())

dp = [0 for i in range(count+1)]

for y in range(2, count+1):
    dp[y] = dp[y-1] + 1  

    if (y % 2 == 0) and (dp[y] > dp[y//2] + 1) :
        dp[y] = dp[y // 2]+1
        
    if (y % 3 == 0) and (dp[y] > dp[y//3] + 1) :
        dp[y] = dp[y // 3] + 1
        
print(dp[count])