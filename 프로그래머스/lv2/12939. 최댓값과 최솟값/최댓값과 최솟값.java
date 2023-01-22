#include <string>
#include <vector>
#include <algorithm>

using namespace std;

//자바는 왜 취급 안해줘,,
string Solution(string s) {
    string answer = "";
    
    vector<int> result;
    string tmp;
    for(int i=0;i<s.length();i++){
        if(s[i]!=' '){
            tmp += s[i];
        }else{
            result.push_back(stoi(tmp));
            tmp.clear();
        }
    }
    result.push_back(stoi(tmp));
    
    sort(result.begin(), result.end());
    
    answer += to_string(result.front())+ " " + to_string(result.back());
    
    return answer;
}