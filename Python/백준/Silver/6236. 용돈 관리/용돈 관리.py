n, m = map(int, input().split())
li = [int(input()) for _ in range(n)]

start = max(li)
end = sum(li)
answer = end

while start <= end:
    mid = (start + end) // 2

    count = 1  # 첫 번째 인출은 무조건 해야 하므로 1부터 시작
    money = mid

    for i in li:
        if money >= i:
            money -= i
        else:
            count += 1
            money = mid - i
    
    if count > m:
        start = mid + 1
    else:
        answer = mid
        end = mid - 1

print(answer)