#include<iostream>
#include<utility>
#include<algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	
	int N = 0; 
	cin >> N;

	pair<int, int> pa[100001];  //pa.first는 끝, pa.second는 시작
	

	int start = 0;
	int end = 0;

	for (int i = 0; i < N; i++) {
		cin >> pa[i].second >> pa[i].first;
	}
	sort(pa, pa + N);

	int ans = 0;

	for (int i = 0; i < N; i++) {
		if (end > pa[i].second) continue;
		ans++;
		end = pa[i].first;
		
	}

	cout << ans;
}