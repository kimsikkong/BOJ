package main

import "fmt"

func main() {
	var a, b int
	fmt.Scanf("%d %d", &a, &b)
	var gcd int
	if a > b {
		gcd = solution(a, b)
	} else {
		gcd = solution(b, a)
	}
	lcm := a * b / gcd
	fmt.Println(gcd)
	fmt.Println(lcm)
}

func solution(a, b int) int {
	if a%b == 0 {
		return b
	} else {
		return solution(b, a%b)
	}
}
