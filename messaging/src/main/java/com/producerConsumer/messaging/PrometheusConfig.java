package com.producerConsumer.messaging;

import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PrometheusConfig {
    @PostConstruct
    public void startPrometheusServer() throws Exception {
        DefaultExports.initialize();
        new HTTPServer(1234); // Exposes Prometheus metrics on localhost:1234/metrics
    }
}
