Sistema Controle Delivery de um Restaurante.

Requisitos Técnicos:
- Código versionado em repositório Git
- Java 8
- Spring Boot 2 (Validation, Security, Data)
- Banco de Dados MySql
- JWT com security para autenticação via token
- API RESTful
- Maven
- OpenAPI 3.0 (Swagger) para os endpoints
- Arquivo README informando os passos necessários para execução da sua aplicação.
----------------------------------------------------------------------------------------
Login

JSON para realizar login
{
"email":"admin.teste@gmail.com",
"senha":"123456"
}
JSON resposta
{
"email": "admin.teste@gmail.com",
"autenticado": true,
"criado": "2022-09-06T21:23:28.265+00:00",
"expiracao": "2022-09-06T22:23:28.265+00:00",
"accessToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbi50ZXN0ZUBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX0FETUlOIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImV4cCI6MTY2MjUwMzAwOCwiaWF0IjoxNjYyNDk5NDA4fQ.ju-xggR9CTfl5fiIQkdUEZMqdqRM-C-8udMhrEzGORI",
"refreshToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbi50ZXN0ZUBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX0FETUlOIl0sImV4cCI6MTY2MjUxMDIwOCwiaWF0IjoxNjYyNDk5NDA4fQ.vhX3UJLmMMCVSkeLQS6EBl0KLXhZLwqEiP4QO5D7g-A"
}
----------------------------------------------------------------------------------------
Swagger

localhost:8080/swagger-ui/index.html

/v3/api-docs
----------------------------------------------------------------------------------------
Usuário

JSON para criar usuário
{
"email":"spl.07.spl@gmail.com",
"senha":"123456",
"perfilAcesso":{
"descricao":"Administrador"
}
}
JSON resposta
{
"id": 3,
"email":"spl.07.spl@gmail.com",
"senha": "123456",
"perfilAcesso": {
"descricao": "Administrador"
},
"_links": {
"self": {
"href": "http://localhost:8080/restaurante-delivery/usuario/3"
}
}
}

Usuário Criar, buscar, atualizar e deletar usuários
GET-> /restaurante-delivery/usuario/{id}
PUT-> /restaurante-delivery/usuario/{id}
DELETE-> /restaurante-delivery/usuario/{id}
GET-> /restaurante-delivery/usuario
POST-> /restaurante-delivery/usuario
----------------------------------------------------------------------------------------
Pedido

JSON para criar pedido
{
"itensPedido":[
{
"comidaBebida": "Picadinho",
"quantidade": 3,
"valorTotal": 50.00
},
{
"comidaBebida": "Refrigerante",
"quantidade": 1,
"valorTotal": 5.00
},
{
"comidaBebida": "Suco",
"quantidade": 1,
"valorTotal": 4.00
}
],
"idCliente": 1,
"desconto":0.02
}
JSON resposta
{
"id": 1,
"cliente": {
"id": 1,
"nome": "Samuel Lima",
"telefone": "(11)96156-8904",
"endereco": {
"logradouro": "Rua XXXX",
"bairro": "XXXXXXX",
"localidade": "Guarulhos",
"uf": "SP",
"cep": "XXXXX-XXX"
},
"formaPagamento": "Débito"
},
"itensPedido": [
{
"id": 1,
"comidaBebida": "Picadinho",
"quantidade": 3,
"valorTotal": 75
},
{
"id": 2,
"comidaBebida": "Refrigerante",
"quantidade": 1,
"valorTotal": 5
},
{
"id": 3,
"comidaBebida": "Suco",
"quantidade": 1,
"valorTotal": 4
}
],
"data": "2022-09-06T17:53:36.6971438",
"valorTotal": 83.98,
"desconto": 0.02,
"_links": {
"self": {
"href": "http://localhost:8080/restaurante-delivery/pedido/1"
}
}
}
----------------------------------------------------------------------------------------
Cliente

JSON para criar cliente
{
"nome": "Samuel Lima",
"telefone": "(11)96156-8904",
"formaPagamento":"Débito",
"endereco":{
"logradouro":"Rua XXXX",
"bairro":"XXXXXXX",
"localidade":"Guarulhos",
"uf":"SP",
"cep":"XXXXX-XXX"
}
}
JSON resposta
{
"id": 2,
"nome": "Samuel Lima",
"telefone": "(11)96156-8904",
"endereco": {
"logradouro": "Rua XXXX",
"bairro": "XXXXXXX",
"localidade": "Guarulhos",
"uf": "SP",
"cep": "XXXXX-XXX"
},
"formaPagamento": "Débito",
"_links": {
"self": {
"href": "http://localhost:8080/restaurante-delivery/cliente/2"
}
}
}
----------------------------------------------------------------------------------------
Entrega

JSON para criar entrega
{
"motoboy":"Leandro",
"valor":10.0,
"idPedidos":[
1
]
}
JSON resposta
{
"id": 1,
"data": "2022-09-06T18:19:00.1792196",
"motoboy": "Leandro",
"valor": 10.0,
"pedidos": [
{
"id": 1,
"cliente": {
"id": 1,
"nome": "Samuel Lima",
"telefone": "(11)96156-8904",
"endereco": {
"logradouro": "Rua XXXX",
"bairro": "XXXXXXX",
"localidade": "Guarulhos",
"uf": "SP",
"cep": "XXXXX-XXX"
},
"formaPagamento": "Débito"
},
"itensPedido": [
{
"id": 4,
"comidaBebida": "Picadinho",
"quantidade": 3,
"valorTotal": 75.00
},
{
"id": 5,
"comidaBebida": "Refrigerante",
"quantidade": 1,
"valorTotal": 5.00
},
{
"id": 6,
"comidaBebida": "Suco",
"quantidade": 1,
"valorTotal": 4.00
}
],
"data": "2023-06-09T19:10:02.396686",
"valorTotal": 83.50,
"desconto": 0.50
}
],
"_links": {
"self": {
"href": "http://localhost:8080/restaurante-delivery/entrega/1"
}
}
}

