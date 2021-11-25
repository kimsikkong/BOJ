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
	fmt.Fscanln(reader, &t)
	answers := make([]int, t)
	for i := 0; i < t; i++ {
		var t2, j int
		fmt.Fscanln(reader, &t2)
		c := make(map[string]int)
		for j = 0; j < t2; j++ {
			var n, k string
			fmt.Fscanln(reader, &n, &k)
			cnt, exists := c[k]
			if exists {
				c[k] = cnt + 1
			} else {
				c[k] = 1
			}
		}

		answer := 1
		for _, val := range c {
			answer *= (val + 1)
		}

		answer = answer - 1
		answers[i] = answer
	}

	for i := 0; i < t; i++ {
		fmt.Fprintf(writer, "%d\n", answers[i])
	}

	writer.Flush()
}
