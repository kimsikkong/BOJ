package main

import "fmt"

func main() {
	var T int
	fmt.Scanf("%d", &T)
	arr := make([][2]int, T)
	for i := 0; i < T; i++ {
		var a, b int
		fmt.Scanf("%d %d", &a, &b)
		arr[i][0] = a
		arr[i][1] = b
	}

	for _, v := range arr {
		var a int
		if v[0] > v[1] {
			a = solution(v[0], v[1])
		} else {
			a = solution(v[1], v[0])
		}

		fmt.Println(v[0] * v[1] / a)
	}
}

func solution(a, b int) int {
	if a%b == 0 {
		return b
	} else {
		return solution(b, a%b)
	}
}
