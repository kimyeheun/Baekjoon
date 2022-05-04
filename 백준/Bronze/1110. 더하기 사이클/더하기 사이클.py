n=0
a=int(input())
c=a
while True:
    b=a//10+a%10
    a=a%10*10+b%10
    n=n+1
    if c==a:
        print(n)
        exit()