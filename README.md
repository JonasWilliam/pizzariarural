# pizzariarural
Projeto de programação 2
Grupo: Jonas William e David Amorim

Repositório HTTPS: https://github.com/JonasWilliam/pizzariarural.git
Repositório SSH: git@github.com:JonasWilliam/pizzariarural.git

Pizzaria Rural

Descrição:
	A pizzaria vai vender pizza apenas de forma delivery, onde terá o controle de tamanho de pizzas e refrigerantes,onde também tem o seu estoque de alimentos para a pizza e acesso ao gerente dos ganhos dos últimos dias.


As classes básicas de negócio são: 
	a. Cliente: - Nome ( String ); Endereço ( String ); Telefone ( String );  
	b. Vendedor: Nome ( String ); salario ( Float ); Cargo ( String );
	c. Gerente: Nome ( String ); salario ( Float ); Cargo ( String );
	d. Entregador: Nome ( String ); salario ( Float ); Cargo ( String );
	e. Pedido: NúmeroPedido ( Int ); Tipo ( String ); Lista de Produtos ( Array); Cliente ( Cliente ) e Vendedor ( Vendedor ); Valor ( Float );
	f. Entrega: Status ( String );


Principais métodos:    
	Crud Produtos;
	Crud Funcionários;
	Realizar uma venda;
	Calcular ganhos do dia;

O Sistema possuirá: Acho que nao tem mais Interface...
	Interface Venda
	Interface Estoque
	Interface Lucro
	Interface Funcionários
