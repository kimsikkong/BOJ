package main

import (
	"bufio"
	"fmt"
	"os"
)

type stack struct {
	arr []int
	top int
	cap int
}

func NewStack(n int) *stack {
	stack := stack{arr: make([]int, n)}
	return &stack
}

func (st *stack) Push(e int) {
	st.arr[st.top] = e
	st.top++
	st.cap++
}

func (st *stack) Pop() int {
	if st.top-1 < 0 {
		return -1
	} else {
		e := st.arr[st.top-1]
		st.top--
		st.cap--
		return e
	}
}

func (st *stack) Size() int {
	return st.cap
}

func (st *stack) Empty() int {
	if st.cap == 0 {
		return 1
	} else {
		return 0
	}
}

func (st *stack) Top() int {
	if st.Empty() == 1 {
		return -1
	} else {
		return st.arr[st.top-1]
	}
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)

	var n int
	fmt.Fscanln(reader, &n)
	stack := NewStack(n)
	for i := 0; i < n; i++ {
		var command string
		var element int
		fmt.Fscanf(reader, "%s %d\n", &command, &element)
		if command == "push" {
			stack.Push(element)
		} else if command == "pop" {
			fmt.Fprintln(writer, stack.Pop())
		} else if command == "size" {
			fmt.Fprintln(writer, stack.Size())
		} else if command == "empty" {
			fmt.Fprintln(writer, stack.Empty())
		} else if command == "top" {
			fmt.Fprintln(writer, stack.Top())
		}
	}

	writer.Flush()
}
