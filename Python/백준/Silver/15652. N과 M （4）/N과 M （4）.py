n, m = map(int, input().split())

li = list(range(1, n + 1))

com_li = [0] * m

def combi(cnt, idx):
    if cnt == m:
        print(" ".join(map(str, com_li)))
        return
    
    for i in range(idx, n):
        com_li[cnt] = li[i]
        combi(cnt + 1, i)
        


combi(0,0)
