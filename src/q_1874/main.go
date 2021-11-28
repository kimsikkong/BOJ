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
	fmt.Fscanln(reader, &n)
	stack := []int{}
	answers := []string{}
	start := 0
	for i := 0; i < n; i++ {
		var v int
		fmt.Fscanf(reader, "%d\n", &v)
		if v > start {
			for j := start + 1; j <= v; j++ {
				stack = append(stack, j)
				answers = append(answers, "+")
			}

			start = v
		} else {
			if stack[len(stack)-1] != v {
				answers = answers[:0]
				answers = append(answers, "NO")
				break
			}
		}

		stack = stack[:len(stack)-1]
		answers = append(answers, "-")
	}

	for _, v := range answers {
		fmt.Fprintf(writer, "%s\n", v)
	}

	writer.Flush()
}
