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

func (q *Queue) Front() int {
	if q.Empty() == 1 {
		return -1
	} else {
		return q.arr[0]
	}
}

func (q *Queue) Back() int {
	if q.Empty() == 1 {
		return -1
	} else {
		return q.arr[len(q.arr)-1]
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

	for i := 0; i < n; i++ {
		var command string
		var e int
		fmt.Fscanf(reader, "%s %d\n", &command, &e)
		switch command {
		case "push":
			q.Push(e)
		case "pop":
			fmt.Fprintln(writer, q.Pop())
		case "size":
			fmt.Fprintln(writer, q.Size())
		case "empty":
			fmt.Fprintln(writer, q.Empty())
		case "front":
			fmt.Fprintln(writer, q.Front())
		case "back":
			fmt.Fprintln(writer, q.Back())
		}
	}

	writer.Flush()
}
