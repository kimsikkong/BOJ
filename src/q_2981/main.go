package main

import (
	"bufio"
	"os"
	"sort"
	"strconv"
)

func main() {
	var N int
	sc := bufio.NewReader(os.Stdin)
	sw := bufio.NewWriter(os.Stdout)
	temp, _, _ := sc.ReadLine()
	N, _ = strconv.Atoi(string(temp))
	arr := make([]int, N)
	for i := 0; i < N; i++ {
		temp, _, _ := sc.ReadLine()
		arr[i], _ = strconv.Atoi(string(temp))
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i] < arr[j]
	})

	gcd := arr[1] - arr[0]
	for i := 2; i < N; i++ {
		gcd = Gcd(gcd, arr[i]-arr[i-1])
	}

	answer := []int{}
	for i := 1; i*i <= gcd; i++ {
		if gcd%i == 0 {
			answer = append(answer, i)
			if i != gcd/i {
				answer = append(answer, gcd/i)
			}
		}
	}

	sort.Slice(answer, func(i, j int) bool {
		return answer[i] < answer[j]
	})

	for i := 1; i < len(answer); i++ {
		sw.WriteString(strconv.Itoa(answer[i]) + " ")
	}

	sw.Flush()
}

func Gcd(a, b int) int {
	if a%b == 0 {
		return b
	} else {
		return Gcd(b, a%b)
	}
}
