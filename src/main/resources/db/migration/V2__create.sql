insert into cliente (nome, id) values ('Igor', nextval ('cliente_seq'));

insert into produto (nome, valor, id) values ('Arroz', 1.1, nextval ('produto_seq'));
insert into produto (nome, valor, id) values ('Feijão', 1.2, nextval ('produto_seq'));
insert into produto (nome, valor, id) values ('Macarrão', 1.3, nextval ('produto_seq'));
insert into produto (nome, valor, id) values ('Farinha', 1.4, nextval ('produto_seq'));

insert into estoque (id) values (nextval ('estoque_seq'));

insert into item_estoque (estoque_id, produto_id, quantidade, id) values (1, 1, 10, nextval ('item_estoque_seq'));
insert into item_estoque (estoque_id, produto_id, quantidade, id) values (1, 2, 10, nextval ('item_estoque_seq'));
insert into item_estoque (estoque_id, produto_id, quantidade, id) values (1, 3, 10, nextval ('item_estoque_seq'));
insert into item_estoque (estoque_id, produto_id, quantidade, id) values (1, 4, 10, nextval ('item_estoque_seq'));
