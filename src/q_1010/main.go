package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	var t int
	r := 0
	fmt.Fscanln(reader, &t)
	arr := make([][2]int, t)
	for i := 0; i < t; i++ {
		fmt.Fscanln(reader, &arr[i][0], &arr[i][1])
		if arr[i][1] > r {
			r = arr[i][1]
		}
	}

	dp := make([][]int, 31)
	for i := 0; i < 31; i++ {
		dp[i] = make([]int, 31)
	}

	for i := 0; i <= r; i++ {
		for j := 0; j <= i; j++ {
			if i == 0 || j == 0 {
				dp[i][j] = 1
			} else {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
			}
		}
	}

	for i := 0; i < t; i++ {
		fmt.Fprintf(writer, "%d\n", dp[arr[i][1]][arr[i][0]])
	}

	writer.Flush()
}
