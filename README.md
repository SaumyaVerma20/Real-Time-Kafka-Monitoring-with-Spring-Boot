
## Real-Time Kafka Monitoring with Spring Boot, React, Prometheus & Grafana

This project demonstrates a real-time event flow system using a **React client** to send events to a **Spring Boot Kafka producer**, which publishes messages to a Kafka topic. A **Kafka consumer** receives and processes the events, tracking them with **Prometheus metrics**. These metrics are visualized in **Grafana dashboards**, allowing for real-time monitoring of Kafka event flow.

---

## 🧩 Technologies Used
- **React** – Sends events to Spring Boot backend
- **Spring Boot** – Acts as Kafka producer & consumer
- **Kafka & Zookeeper** – Message queue system
- **Prometheus** – Monitors custom metrics from Spring Boot
- **Grafana** – Visualizes Kafka metrics

---

## 🛠 Project Setup Guide

### **1. Set up the Spring Boot Project**
1. Create a Spring Boot project with dependencies:
   - Spring Web
   - Spring Kafka
   - Micrometer Prometheus

2. Add dependencies to `pom.xml`:
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   <dependency>
       <groupId>org.springframework.kafka</groupId>
       <artifactId>spring-kafka</artifactId>
   </dependency>
   <dependency>
       <groupId>io.micrometer</groupId>
       <artifactId>micrometer-registry-prometheus</artifactId>
   </dependency>
   ```

3. Set up Kafka producer & consumer logic, and expose metrics at `localhost:1234/metrics`.

---

### **2. Set up Kafka and Zookeeper**
1. Download [Apache Kafka](https://kafka.apache.org/downloads).
2. Start Zookeeper:
   ```bash
   zookeeper-server-start.sh config/zookeeper.properties
   ```
3. Start Kafka:
   ```bash
   kafka-server-start.sh config/server.properties
   ```
4. Create a Kafka topic:
   ```bash
   kafka-topics.sh --create --topic testy --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
   ```

---

### **3. Configure Prometheus**
1. Download [Prometheus](https://prometheus.io/download/).
2. Modify `prometheus.yml`:
   ```yaml
   scrape_configs:
     - job_name: 'spring-boot-app'
       static_configs:
         - targets: ['localhost:1234']
   ```
3. Run Prometheus:
   ```bash
   prometheus --config.file=prometheus.yml
   ```

---

### **4. Set up Grafana**
1. Download and install [Grafana](https://grafana.com/grafana/download).
2. Start Grafana:
   ```bash
   grafana-server web
   ```
3. Log in (default: `admin` / `admin`).
4. Add Prometheus as a data source (`http://localhost:9090`).
5. Create a dashboard using the metric:
   ```
   kafka_events_received_total
   ```

---

### **5. Set up the React Client**
1. Create a new React app:
   ```bash
   npx create-react-app kafka-client
   cd kafka-client
   ```
2. Start the client:
   ```bash
   npm start
   ```

---

## 🚀 Running the System
1. Start Zookeeper  
2. Start Kafka  
3. Start Spring Boot backend  
4. Start Prometheus  
5. Start Grafana  
6. Start the React client

Click the button on the React app to send events to Kafka and see real-time metrics in Grafana.

