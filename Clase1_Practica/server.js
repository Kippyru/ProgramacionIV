const http = require("http"); // modulo de node
// datos ejemplo
const productos = [
  { id: 1, nombre: "Teclado", precio: 15000 },
  { id: 2, nombre: "Mouse", precio: 8500 },
  { id: 3, nombre: "Monitor", precio: 120000 },
];
// crear el sv
const server = http.createServer((req, res) => {
  // Configuración básica de headers
  res.setHeader("Content-Type", "application/json"); // respuesta json
  res.setHeader("Access-Control-Allow-Origin", "*"); // habilita CORS

  if (req.method === "GET" && req.url === "/api/productos") {
    res.writeHead(200); // 200 ok
    res.end(JSON.stringify(productos));
  } else {
    res.writeHead(404); // 404 not found
    res.end(JSON.stringify({ mensaje: "Recurso no encontrado" }));
  }
});
// inicia sv en puerto x
server.listen(8080, () => {
  console.log("Servidor ejecutándose en http://localhost:8080");
});
