n, m = map(int, input().split())

li = list(range(1, n + 1))

per_li = [0] * m


def permu(cnt):
    if cnt == m:
        print(" ".join(map(str, per_li)))
        return
    
    for idx in range(n):    
        per_li[cnt] = li[idx]
        permu(cnt + 1)



permu(0)