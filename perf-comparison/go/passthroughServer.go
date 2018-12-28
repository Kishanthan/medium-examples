package main

import (
	"io/ioutil"
	"log"
	"net/http"
)

var client = &http.Client{}

func handler(w http.ResponseWriter, req *http.Request) {
	backendReq, _ := http.NewRequest(req.Method, "http://localhost:8688/backend", req.Body)
	resp, _ := client.Do(backendReq)
	body, _ := ioutil.ReadAll(resp.Body)
	w.Write(body)
}

func main() {
	httpTransport := &http.Transport{
		MaxIdleConns:        250,
		MaxIdleConnsPerHost: 250,
		MaxConnsPerHost:     250,
	}

	client.Transport = httpTransport

	http.HandleFunc("/passthrough", handler)
	log.Fatal(http.ListenAndServe(":9090", nil))
}

