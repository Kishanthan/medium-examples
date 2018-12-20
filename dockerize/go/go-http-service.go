package main

import (
    "fmt"
    "log"
    "net/http"
)

func handler(w http.ResponseWriter, r *http.Request) {
    fmt.Fprintf(w, "Hello World from GO !!!")
}

func main() {
    http.HandleFunc("/hello", handler)
    log.Fatal(http.ListenAndServe(":8080", nil))
}

