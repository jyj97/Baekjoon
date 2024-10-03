#include <string>
#include <iostream>
#include <vector>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    vector<char> v;
    
    for(char c : s){
        if (c == '('){
            v.push_back('(');
        }
        else{
            if (v.size() == 0){
                answer = false;
                break;
            }
            else{
                v.pop_back();
            }
        }
    }
    
    if (answer && v.size() != 0){
        answer = false;
    }
    

    return answer;
}