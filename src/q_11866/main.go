package main

import (
	"bufio"
	"fmt"
	"os"
)

type Queue struct {
	arr []int
}

func (q *Queue) Push(e int) {
	q.arr = append(q.arr, e)
}

func (q *Queue) Pop() int {
	if q.Empty() != 1 {
		e := q.arr[0]
		q.arr = q.arr[1:]
		return e
	} else {
		return -1
	}
}

func (q *Queue) Size() int {
	return len(q.arr)
}

func (q *Queue) Empty() int {
	if q.Size() > 0 {
		return 0
	} else {
		return 1
	}
}

func main() {
	var (
		reader = bufio.NewReader(os.Stdin)
		writer = bufio.NewWriter(os.Stdout)
	)

	var n, k int
	fmt.Fscanf(reader, "%d %d\n", &n, &k)
	q := Queue{arr: []int{}}
	for i := 1; i <= n; i++ {
		q.arr = append(q.arr, i)
	}

	var cnt int
	answers := []int{}
	for len(q.arr) != 0 {
		e := q.Pop()
		cnt++
		if cnt == k {
			answers = append(answers, e)
			cnt = 0
		} else {
			q.Push(e)
		}
	}

	fmt.Fprintf(writer, "<")
	for i, v := range answers {
		if i != len(answers)-1 {
			fmt.Fprintf(writer, "%d, ", v)
		} else {
			fmt.Fprintf(writer, "%d", v)
		}
	}
	fmt.Fprintf(writer, ">\n")
	writer.Flush()
}
