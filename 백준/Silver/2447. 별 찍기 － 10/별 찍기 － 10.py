n = int(input())
def make(block, n):
    star_floor = [i*3 for i in block]
    space_floor = [i+" "*n+i for i in block]
    return star_floor + space_floor + star_floor
def pattern(n):
    if n == 3:
        base = [ "***","* *","***" ]
        return base
    else:
        n = n//3
        star = pattern(n)
        base = make(star, n)
        return base
for y in pattern(n):
    print(y)
    