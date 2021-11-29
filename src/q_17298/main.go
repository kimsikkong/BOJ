package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var (
		reader = bufio.NewReader(os.Stdin)
		writer = bufio.NewWriter(os.Stdout)
	)

	var n int
	fmt.Fscanf(reader, "%d\n", &n)
	arr := make([]int, n)
	stack := []int{}
	for i := 0; i < n; i++ {
		fmt.Fscanf(reader, "%d", &arr[i])
	}

	for i := 0; i < n; i++ {
		for {
			// 현재 배열 원소 스택의 top index 원소보다 큰 경우 교환
			if len(stack) != 0 && arr[i] > arr[stack[len(stack)-1]] {
				arr[stack[len(stack)-1]] = arr[i]
				stack = stack[:len(stack)-1]
			} else {
				break
			}
		}

		stack = append(stack, i)
	}

	for _, v := range stack {
		arr[v] = -1
	}

	for _, v := range arr {
		fmt.Fprintf(writer, "%d ", v)
	}

	writer.Flush()
}
