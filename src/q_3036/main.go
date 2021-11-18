package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	sc := bufio.NewReader(os.Stdin)
	sw := bufio.NewWriter(os.Stdout)
	temp, _, _ := sc.ReadLine()
	N, _ := strconv.Atoi(string(temp))
	temp, _, _ = sc.ReadLine()
	sarr := strings.Split(string(temp), " ")
	arr := make([]int, len(sarr))
	for i, v := range sarr {
		arr[i], _ = strconv.Atoi(v)
	}

	r := arr[0]
	for i := 1; i < N; i++ {
		var g int
		if r > arr[i] {
			g = Gcd(r, arr[i])
		} else {
			g = Gcd(arr[i], r)
		}

		a := fmt.Sprintf("%d/%d", r/g, arr[i]/g)
		sw.WriteString(a + "\n")
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
