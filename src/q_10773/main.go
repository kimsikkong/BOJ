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

	var k int
	fmt.Fscanln(reader, &k)
	arr := make([]int, k)
	for i := 0; i < k; i++ {
		fmt.Fscanln(reader, &arr[i])
	}

	sum := 0
	cnt := 0
	for i := k - 1; i >= 0; i-- {
		if arr[i] == 0 {
			cnt++
		} else {
			if cnt > 0 {
				cnt--
			} else {
				sum += arr[i]
			}
		}
	}

	fmt.Fprintf(writer, "%d\n", sum)
	writer.Flush()
}
