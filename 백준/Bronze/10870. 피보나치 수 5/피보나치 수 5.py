a=int(input())

def pi(a):
    if a<2:
        return a
    else : 
        return pi(a-1)+pi(a-2)

print(pi(a))
