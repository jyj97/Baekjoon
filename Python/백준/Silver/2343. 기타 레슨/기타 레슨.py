n, m = map(int, input().split())
li = list(map(int, input().split()))

start = max(li)
end = sum(li)

while start <= end:
    mid = (start + end) // 2

    total = 0
    count = 1

    for i in li:
        if total + i > mid:
            count += 1
            total = 0
        
        total += i

    if count <= m:
        answer = mid
        end = mid - 1
    
    else:
        start = mid + 1

print(answer)