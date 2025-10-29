INSERT INTO USUARIO(id, nome, data_nascimento) VALUES (1,'Amanda','2005-10-11');
INSERT INTO REGRA(id, nome_regra, date_created) VALUES (1,'OPERADOR', CURRENT_TIMESTAMP());
INSERT INTO USUARIO_REGRA(id, usuario_id, regra_id, date_created) VALUES (1,1,1, CURRENT_TIMESTAMP());
INSERT INTO PRODUTO(id, nome, quantidade_estoque, preco) VALUES (1,'Máscara',100, 19.99);
INSERT INTO PRODUTO(id, nome, quantidade_estoque, preco) VALUES (2,'Luvas',50, 12.50);
