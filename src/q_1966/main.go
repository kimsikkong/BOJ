package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Queue struct {
	arr [][2]int
}

func (q *Queue) Push(e, priority int) {
	q.arr = append(q.arr, [2]int{e, priority})
}

func (q *Queue) Pop() (int, int) {
	if q.Empty() != 1 {
		e := q.arr[0]
		q.arr = q.arr[1:]
		return e[0], e[1]
	} else {
		return -1, -1
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

	var t, n, m int
	fmt.Fscanf(reader, "%d\n", &t)
	for i := 0; i < t; i++ {
		fmt.Fscanf(reader, "%d %d\n", &n, &m)
		pq := Queue{arr: [][2]int{}}
		var s string
		l, _, _ := reader.ReadLine()
		s = string(l)
		k := strings.Split(s, " ")
		for j := 0; j < len(k); j++ {
			p, _ := strconv.Atoi(k[j])
			pq.Push(j, p)
		}

		var cnt int
		for len(pq.arr) != 0 {
			match := false
			idx, p := pq.Pop()
			for j := 0; j < len(pq.arr); j++ {
				if p < pq.arr[j][1] {
					match = true
					pq.Push(idx, p)
					break
				}
			}

			if !match {
				cnt++
				if idx == m {
					fmt.Fprintln(writer, cnt)
					break
				}
			}
		}
	}

	writer.Flush()
}
