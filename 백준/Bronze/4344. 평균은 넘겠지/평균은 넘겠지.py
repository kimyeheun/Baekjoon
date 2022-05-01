case=int(input())
sc=[]
for i in range(case):
    score=list(map(int, input().split()))
    s_avg=(sum(score)-score[0])/score[0]
    high=0
    for y in range(1, score[0]+1):
        if score[y]>s_avg:
            high+=1
    sc.append(high/score[0]*100)
for u in range(case):
    print('%.3f' %sc[u], end="%\n")