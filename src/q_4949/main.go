package main

import (
	"bufio"
	"fmt"
	"os"
)

type stack struct {
	arr []string
	top int
	cap int
}

func NewStack(n int) *stack {
	stack := stack{arr: make([]string, n)}
	return &stack
}

func (st *stack) Push(e string) {
	st.arr[st.top] = e
	st.top++
	st.cap++
}

func (st *stack) Pop() string {
	e := st.arr[st.top-1]
	st.top--
	st.cap--
	return e
}

func (st *stack) Empty() int {
	if st.cap == 0 {
		return 1
	} else {
		return 0
	}
}

func main() {
	var (
		reader = bufio.NewReader(os.Stdin)
		writer = bufio.NewWriter(os.Stdout)
	)

	for {
		var line string
		line, _ = reader.ReadString('\n')
		if line == ".\n" {
			break
		}

		fmt.Fprintf(writer, "%s\n", Calc(line))
	}

	writer.Flush()
}

func Calc(line string) string {
	stack := NewStack(len(line))
	for i := 0; i < len(line); i++ {
		if line[i] == '(' {
			stack.Push("(")
		} else if line[i] == '[' {
			stack.Push("[")
		} else if line[i] == ')' {
			if stack.Empty() == 1 || stack.Pop() != "(" {
				return "no"
			}
		} else if line[i] == ']' {
			if stack.Empty() == 1 || stack.Pop() != "[" {
				return "no"
			}
		}
	}

	if stack.cap == 0 {
		return "yes"
	} else {
		return "no"
	}
}
