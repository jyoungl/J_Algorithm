#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int N,M;
const int MAX = 10001;
vector<int> map[MAX];
bool visited[MAX];
//<컴퓨터 번호, 해킹 가능한 컴퓨터 수> = 유사 class 선언
vector<pair<int, int>> v;
int hacked = 1;
queue<int> que;

void bfs(int x){
    visited[x] = true;
    que.push(x);

    while(!que.empty()){
        x = que.front();
        que.pop();

        for(int i=0;i<map[x].size();i++){
            int now = map[x][i];

            if(visited[now] == 0){
                visited[now] = true;
                que.push(now);
                hacked++;
            }
        }
    }
}
int main(){
    cin>>N>>M;
    for(int i=0;i<M;i++){
        int x, y;
        cin>>x>>y;
        map[y].push_back(x);
    }

    for(int i=1;i<=N;i++){
        bfs(i);

        for(int i=0;i<=N;i++)
            visited[i] = 0;
        
        v.push_back(make_pair(i, hacked));
        hacked = 1;
    }

    int max = 0;
    for(int i=0;i<v.size();i++){
        if(v[i].second > max)
            max = v[i].second;
    }

    for(int i=0;i<v.size();i++){
        if(v[i].second == max)
            cout <<v[i].first << " ";   
    }

    return 0;
}