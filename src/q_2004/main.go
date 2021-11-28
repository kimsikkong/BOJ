package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	var n, m int
	fmt.Fscanln(reader, &n, &m)
	var a, b, c, d, e, f int
	a, b = calc(n)
	c, d = calc(n - m)
	e, f = calc(m)
	// 2^(a - c - e), 5^(b - d - f)
	fmt.Fprintf(writer, "%d\n", min(a-c-e, b-d-f))
	writer.Flush()
}

func calc(n int) (int, int) {
	var a, b int
	for i := 2; i <= n; i = i * 2 {
		a += n / i
	}

	for i := 5; i <= n; i = i * 5 {
		b += n / i
	}

	return a, b
}

func min(a, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}
