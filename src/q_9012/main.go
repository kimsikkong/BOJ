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

	var T int
	fmt.Fscanln(reader, &T)
	arr := make([]string, T)
	for i := 0; i < T; i++ {
		fmt.Fscanln(reader, &arr[i])
	}

	for i := 0; i < T; i++ {
		var r int
		ps := arr[i]
		answer := "YES"
		for j := len(ps) - 1; j >= 0; j-- {
			// (
			if ps[j] == 40 {
				if r == 0 {
					answer = "NO"
					break
				}

				r--
			}

			// )
			if ps[j] == 41 {
				r++
			}
		}

		if r != 0 {
			answer = "NO"
		}

		fmt.Fprintf(writer, "%s\n", answer)
	}

	writer.Flush()
}
