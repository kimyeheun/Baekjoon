stair=int(input())
for i in range(stair):
    print(" "*(stair-i-1), end='')
    print("*"*(i+1))
    i=i+1