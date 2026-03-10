async function cargarUsuarios() {
  // llama api publica
  const response = await fetch("https://jsonplaceholder.typicode.com/users");

  // se convierte la respuesta a json
  const usuarios = await response.json();

  // se busca el elemento por id x en el html
  const lista = document.getElementById("listaUsuarios");

  // se limpia la lista
  lista.innerHTML = "";

  // se recorre el array recibido de la api
  // se crea un elemento en el html
  // y se agrega como texto lo recibido de la api
  usuarios.forEach((usuario) => {
    const item = document.createElement("li");
    item.textContent = usuario.name;
    lista.appendChild(item);
  });
}
