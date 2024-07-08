#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int n;

int main()
{
    cin >> n;
	int arr[n + 1];
	arr[0] = 0;
	for (int i = 1; i < n + 1; i++)
	{
		cin >> arr[i];
	}
    sort(arr, arr + n + 1);
    cout << arr[(n + 1)/2];

	return 0;
}