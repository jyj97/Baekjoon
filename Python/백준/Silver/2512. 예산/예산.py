n = int(input())
li = list(map(int, input().split()))
m = int(input())


# 1. 일단 요쳥 배정될 수 있는 경우 그 금액 그대로 배정한다.
answer = max(li) if sum(li) <= m else 0

# 2. 불가능하면 정수 상한액 계산해서, 그 이상인 요청에는 모두 상한액 배정
# 상한액 이하 금액은 또 그대로 배정
if answer == 0:
    start = 0
    end = m

    while start <= end:
        mid = (start + end) // 2

        tmp = [i if i <= mid else mid for i in li]
        tmpsum = sum(tmp)

        if tmpsum > m:
            end = mid - 1
        else:
            start = mid + 1
            answer = max(tmp)

print(answer)
