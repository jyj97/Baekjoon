t = int(input())

s = ""

for _ in range(t):
    a,b, n = map(int, input().split())

    answer = 0
    while True:
        x = min(a,b)
        y = max(a,b)
        x += y
        a = x
        b = y
        answer += 1

        if x > n:
            break

    s += "{}\n".format(answer)

print(s)