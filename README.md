
# Beep – Sistema de Monitoramento de Estoque Hospitalar

## Como rodar
```bash
mvn spring-boot:run
```

## Endpoints (API RESTful)
| Recurso        | URI Base                 | Verbo  | Descrição                                 | Status codes           |
|----------------|--------------------------|--------|-------------------------------------------|------------------------|
| Usuario        | /api/usuarios            | GET    | Lista usuários                             | 200                    |
|                | /api/usuarios/{id}       | GET    | Detalha usuário                            | 200, 404               |
|                | /api/usuarios            | POST   | Cria usuário                               | 201, 400               |
|                | /api/usuarios/{id}       | PUT    | Atualiza usuário                           | 200, 400, 404          |
|                | /api/usuarios/{id}       | DELETE | Remove usuário                             | 204, 404               |
| Regra          | /api/regras              | GET    | Lista regras                               | 200                    |
|                | /api/regras/{id}         | GET    | Detalha regra                              | 200, 404               |
|                | /api/regras              | POST   | Cria regra                                 | 201, 400               |
|                | /api/regras/{id}         | PUT    | Atualiza regra                             | 200, 400, 404          |
|                | /api/regras/{id}         | DELETE | Remove regra                               | 204, 404               |
| UsuarioRegra   | /api/usuarios-regras     | GET    | Lista vínculos                             | 200                    |
|                | /api/usuarios-regras/{id}| GET    | Detalha vínculo                            | 200, 404               |
|                | /api/usuarios-regras     | POST   | Cria vínculo usuário↔regra                 | 201, 400               |
|                | /api/usuarios-regras/{id}| DELETE | Remove vínculo                             | 204, 404               |
| Produto        | /api/produtos            | GET    | Lista produtos                             | 200                    |
|                | /api/produtos/{id}       | GET    | Detalha produto                            | 200, 404               |
|                | /api/produtos            | POST   | Cria produto                               | 201, 400               |
|                | /api/produtos/{id}       | PUT    | Atualiza produto                           | 200, 400, 404          |
|                | /api/produtos/{id}       | DELETE | Remove produto                             | 204, 404               |
| Beep           | /api/beeps               | GET    | Lista beeps                                | 200                    |
|                | /api/beeps/{id}          | GET    | Detalha beep                               | 200, 404               |
|                | /api/beeps               | POST   | Cria beep (livre)                          | 201, 400               |
| Ação           | /api/beeps/registrar     | POST   | Registra um "bepar" (—1 no estoque)        | 201, 400               |

### Swagger
`http://localhost:8080/swagger-ui.html`
