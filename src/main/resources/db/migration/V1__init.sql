create sequence cliente_seq start 1 increment 1;
create sequence estoque_seq start 1 increment 1;
create sequence item_estoque_seq start 1 increment 1;
create sequence item_seq start 1 increment 1;
create sequence pedido_seq start 1 increment 1;
create sequence produto_seq start 1 increment 1;
create sequence reposical_seq start 1 increment 1;
create sequence item_reposicao_seq start 1 increment 1;

create table cliente (id int8 not null, nome varchar(255), primary key (id));
create table estoque (id int8 not null, ativo boolean, primary key (id));
create table item (id int8 not null, quantidade int8, pedido_id int8 not null, produto_id int8 not null, primary key (id));
create table item_estoque (id int8 not null, quantidade int8, estoque_id int8 not null, produto_id int8 not null, primary key (id));
create table pedido (id int8 not null, status varchar(255), cliente_id int8 not null, primary key (id));
create table produto (id int8 not null, nome varchar(255), valor float8, primary key (id));
create table reposicao (id int8 not null, status varchar(255), primary key (id));
create table item_reposicao (id int8 not null, quantidade int8, reposicao_id int8 not null, produto_id int8 not null, primary key (id));

alter table item add constraint item_pedido_id foreign key (pedido_id) references pedido;
alter table item add constraint item_produto_id foreign key (produto_id) references produto;
alter table item_estoque add constraint ie_estoque_id foreign key (estoque_id) references estoque;
alter table item_estoque add constraint ie_produto_id foreign key (produto_id) references produto;
alter table pedido add constraint pedido_cliente_id foreign key (cliente_id) references cliente;
alter table item_reposicao add constraint ir_reposicao_id foreign key (reposicao_id) references reposicao;
alter table item_reposicao add constraint ir_produto_id foreign key (produto_id) references produto;
