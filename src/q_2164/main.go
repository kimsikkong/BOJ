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

	q := Queue{arr: []int{}}
	var n int
	fmt.Fscanf(reader, "%d\n", &n)
	for i := 1; i <= n; i++ {
		q.arr = append(q.arr, i)
	}

	for {
		if len(q.arr) == 1 {
			fmt.Fprintf(writer, "%d", q.arr[0])
			break
		}

		q.Pop()
		q.Push(q.Pop())
	}

	writer.Flush()
}
