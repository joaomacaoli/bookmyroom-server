# BookMyRoom Server

## Descrição

BookMyRoom é uma API para gerenciamento de reservas de salas. O projeto utiliza Spring Boot e um banco de dados MySQL rodando em um container Docker.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Web**
- **MySQL**
- **Docker**
- **Maven**

## Configuração do Ambiente

1. Clone o repositório:

   ```sh
   git clone https://github.com/joaomacaoli/bookmyroom-server.git
   cd bookmyroom-server
   ```

2. Inicie o container do banco de dados:

   ```sh
   sudo docker-compose up -d
   ```

3. Execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```

A API estará disponível em `http://localhost:8080`

## Endpoints

### **Rooms**

#### Criar uma sala

**POST** `/v1/rooms`

##### **Body**

```json
{
  "description": "Teste",
  "floor": "2º Andar",
  "capacity": 15,
  "status": "ACTIVE"
}
```

##### **Resposta (201 Created)**

```json
{
  "roomId": "5fab2614-cbb0-4ea7-88db-9a0a771e2009",
  "description": "Teste",
  "floor": "2º Andar",
  "capacity": 15,
  "status": "ACTIVE"
}
```

#### Listar todas as salas

**GET** `/v1/rooms`

##### **Resposta (200 OK)**

```json
[
  {
    "roomId": "5fab2614-cbb0-4ea7-88db-9a0a771e2009",
    "description": "Teste",
    "floor": "2º Andar",
    "capacity": 15,
    "status": "ACTIVE"
  }
]
```

### **Appointments**

#### Criar um agendamento

**POST** `/v1/appointments/{roomId}`

##### **Body**

```json
{
  "date": "2025-03-20",
  "shift": "MORNING",
  "timeSlot": "A",
  "description": "Reunião de planejamento"
}
```

##### **Resposta (201 Created)**

```json
{
  "appointmentId": "d2ae5bea-7a69-4f1d-8d54-d1eb37040ea9",
  "room": {
    "roomId": "5fab2614-cbb0-4ea7-88db-9a0a771e2009",
    "description": "Teste",
    "floor": "2º Andar",
    "capacity": 15,
    "status": "ACTIVE"
  },
  "date": "2025-03-20",
  "shift": "MORNING",
  "timeSlot": "A",
  "description": "Reunião de planejamento"
}
```

#### Listar todos os agendamentos

**GET** `/v1/appointments`

##### **Resposta (200 OK)**

```json
[
  {
    "appointmentId": "d2ae5bea-7a69-4f1d-8d54-d1eb37040ea9",
    "room": {
      "roomId": "5fab2614-cbb0-4ea7-88db-9a0a771e2009",
      "description": "Teste",
      "floor": "2º Andar",
      "capacity": 15,
      "status": "ACTIVE"
    },
    "date": "2025-03-20",
    "shift": "MORNING",
    "timeSlot": "A",
    "description": "Reunião de planejamento"
  }
]
```

#### Buscar um agendamento por ID

**GET** `/v1/appointments/{appointmentId}`

##### **Resposta (200 OK)**

```json
{
  "appointmentId": "d2ae5bea-7a69-4f1d-8d54-d1eb37040ea9",
  "room": {
    "roomId": "5fab2614-cbb0-4ea7-88db-9a0a771e2009",
    "description": "Teste",
    "floor": "2º Andar",
    "capacity": 15,
    "status": "ACTIVE"
  },
  "date": "2025-03-20",
  "shift": "MORNING",
  "timeSlot": "A",
  "description": "Reunião de planejamento"
}
```

#### Atualizar um agendamento

**PUT** `/v1/appointments/{appointmentId}`

##### **Body**

```json
{
  "date": "2025-03-21",
  "shift": "AFTERNOON",
  "timeSlot": "B",
  "description": "Reunião de retrospectiva"
}
```

##### **Resposta (200 OK)**

```json
{
  "appointmentId": "d2ae5bea-7a69-4f1d-8d54-d1eb37040ea9",
  "room": {
    "roomId": "5fab2614-cbb0-4ea7-88db-9a0a771e2009",
    "description": "Teste",
    "floor": "2º Andar",
    "capacity": 15,
    "status": "ACTIVE"
  },
  "date": "2025-03-21",
  "shift": "AFTERNOON",
  "timeSlot": "B",
  "description": "Reunião de retrospectiva"
}
```

#### Excluir um agendamento

**DELETE** `/v1/appointments/{appointmentId}`

##### **Resposta (204 No Content)**

## Melhorias Futuras

- Implementação de autenticação e autorização.
- Logs e monitoramento da API.
- Testes unitários.
- Integração com um frontend desenvolvido em Next.js.

---

💡 **Desenvolvido por [João Macaoli](https://github.com/joaomacaoli)** 🚀
