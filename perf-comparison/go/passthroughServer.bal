package main

import (
	"log"
	"net/http"
	"net/http/httputil"
	"net/url"
)

func handler(res http.ResponseWriter, req *http.Request) {
	url, _ := url.Parse("http://localhost:8688/backend")

	proxy := httputil.NewSingleHostReverseProxy(url)

	req.URL.Host = url.Host
	req.URL.Scheme = url.Scheme
	req.Header.Set("X-Forwarded-Host", req.Header.Get("Host"))
	req.Host = url.Host

	proxy.ServeHTTP(res, req)
}

func main() {
	http.HandleFunc("/passthrough", handler)
	log.Fatal(http.ListenAndServe(":9090", nil))
}
