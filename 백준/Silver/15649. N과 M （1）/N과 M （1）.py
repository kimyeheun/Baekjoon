n, m = map(int, input().split())
l_ist = []
def backTracking():
    if len(l_ist) == m:
        print(' '.join(map(str,l_ist)))
        return
    for i in range(1, n+1):
        if i not in l_ist:
            l_ist.append(i)
            backTracking()
            l_ist.pop()
backTracking()