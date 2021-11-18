package main

import "fmt"

func main() {
	var n, k int
	fmt.Scanf("%d %d", &n, &k)
	fmt.Println(factorial(n) / (factorial(n-k) * factorial(k)))
}

func factorial(n int) int {
	if n <= 1 {
		return 1
	} else {
		return n * factorial(n-1)
	}
}
