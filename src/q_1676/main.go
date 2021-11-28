package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	var n, cnt int
	fmt.Fscanln(reader, &n)
	for i := 5; i <= n; i = i * 5 {
		cnt += n / i
	}

	fmt.Fprintf(writer, "%d", cnt)
	writer.Flush()
}
