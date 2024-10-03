#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());
    
    int right = people.size() - 1;
    int left = 0;
    
    while (right > left){
        if (people[right] + people[left] <= limit){
            answer += 1;
            left += 1;
            right -= 1;
        }
        else{
            answer += 1;
            right -= 1;
        }
    }
    if (right == left){
        answer += 1;
    }
    return answer;
}