package main

import "fmt"

func main() {
	var n, k int
	fmt.Scanf("%d %d", &n, &k)
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, n+1)
	}

	for i := 0; i <= n; i++ {
		for j := 0; j <= i; j++ {
			if i == 0 || j == 0 {
				dp[i][j] = 1
			} else {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007
			}
		}
	}

	fmt.Println(dp[n][k])
}
