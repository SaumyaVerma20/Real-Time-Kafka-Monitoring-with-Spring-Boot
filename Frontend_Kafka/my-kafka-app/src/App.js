function App() {
  const sendEvent = async () => {
    await fetch("http://localhost:8080/producer/event", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify("User clicked!")
    });
  };

  return (
    <div>
      <h2>Send Event to Kafka</h2>
      <button onClick={sendEvent}>Send Event</button>
    </div>
  );
}

export default App;
