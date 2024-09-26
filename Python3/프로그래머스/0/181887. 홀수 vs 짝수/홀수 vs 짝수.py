def solution(num_list):
    sum1 = sum([num_list[i] for i in range(len(num_list)) if i % 2 == 0])
    sum2 = sum([num_list[i] for i in range(len(num_list)) if i % 2 == 1])
    
    return sum1 if sum1 > sum2 else sum2