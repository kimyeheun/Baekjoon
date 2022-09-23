import sys

n = int(sys.stdin.readline())
stair = [0 for _ in range(301)]
for i in range(n):
    stair[i] = int(sys.stdin.readline())
dp = [0 for _ in range(301)]
dp[0] = (stair[0])
dp[1] = (stair[0]+stair[1])
dp[2] = (max(stair[1]+stair[2], stair[0] + stair[2]))
for y in range(3, n):
    dp[y] = (max(stair[y]+stair[y-1]+dp[y-3], stair[y]+dp[y-2]))
print(dp[n-1])