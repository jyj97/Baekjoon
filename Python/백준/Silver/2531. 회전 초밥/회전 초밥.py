n, d, k, c = map(int, input().split())

li = [int(input()) for _ in range(n)]

start = -1 * n  # 포인터 -부터로 시작  -n ~ n-1까지로 표기가 편해보임
end = start + k
sub = li[start:end]
answer = -1  # 최대 초밥개수

while start <= -1:
    tmp = set(sub)
    le = len(tmp)

    if c in tmp:
        answer = le if (answer < le) else answer
    elif c not in tmp:
        answer = (le + 1) if (answer < le + 1) else answer

    sub.remove(li[start])
    start += 1
    sub.append(li[end])
    end += 1
    

print(answer)
