USE `mydb` ;

-- Povoamento Utilizador
INSERT INTO Utilizador(numero, email_utilizador, usernameU, passwordU)
	VALUES
		(1, 'shahzod47@gmail.com', 'shahzod47', 'balboa47'),
        (1, 'nuno25@gmail.com', 'nuno25', 'mineiro25'),
        (1, 'ricardo8@gmail.com', 'ricardo8', 'squirtle8'),
        (1, 'adriana80@gmail.com', 'adriana80', 'thug80'),
        (2, 'professorAntonioNestorRibeiro@gmail.com', 'ProfessorANR', 'professor1DSS'),
        (2, 'professorRuiCouto@gmail.com', 'ProfessorRC', 'professor2DSS'),
        (3, 'fabrica@gmail.com', 'Fabrica', 'fabrica'),
        (3, 'fornecedor@gmail.com', 'Fornecedor', 'fornecedor');
        
-- Povoamento Cliente
INSERT INTO Cliente(nif_cl, morada_cl, email_cl, nome_cl)
	VALUES
		(1223, 'rua das camelias', 'jMatos@gmail.com', 'Joao Matos'),
        (321, 'rua das margaridas', 'aleatorio@gmail.com', 'Ricardo Rodrigues'),
        (123123, 'rua das rosas', 'aos@governo.pt', 'Antonio Oliveira Salazar'),
        (321321, 'rua das silvas', 'ah@mouros.com', 'Afonso Henriques'),
        (414144, 'rua do deserto', 'moises@gmail.com', 'Moises'),
        (1412412, 'rua do trono', 'ppc@exgoverno.com', 'Pedro Passos Coelho'),
        (2241244, 'rua do gota', 'mSilva@gotacafe.com', 'Manuel Silva'),
        (24242, 'rua das machas', 'hMartins81@gmail.com', 'Helena Martins'),
        (24443242, 'rua dos limoes', 'pipinha132@gmail.com', 'Filipa Pereira');
        
-- Povoamento Configuracao
INSERT INTO Configuracao(nome, utilizador_id_utilizador, cliente_nif_cl)
	VALUES
		('a',1, 1223),
        ('a',2, 321),
        ('a',3, 123123),
        ('a',4, 414144),
        ('a',5, 1412412),
        ('a',6, 2241244),
        ('a',7, 24242),
        ('a',8, 24443242);
        
-- Povoamento Veiculo
INSERT INTO Veiculo(modelo, preco, Configuracao_id_config)
	VALUES
		('mustang',12, 1),
        ('galaxy',123, 2),
        ('fiesta',123, 3),
        ('focus',412414, 4),
        ('ka+',2131, 5),
        ('mondeo',22222, 6),
        ('fiesta',3333, 7),
        ('tourneo',42242, 8);

-- Povoamento CompObrigatoria
INSERT INTO CompObrigatoria(nome_obg, preco_obg, stock_obg, Configuracao_id_config)
	VALUES
		('algo',10000, 1212121, 1),
        ('algo',123421, 1212121, 2),
        ('algo',232323, 1212121, 2),
        ('algo',242424, 1212121, 2),
        ('algo',54545, 1212121, 2),
        ('algo',3523, 1212121, 1),
        ('algo',65, 1212121, 1),
        ('algo',65, 1212121, 1),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4);
        
-- Povoamento DetInterior
INSERT INTO DetInterior(designacao_Int, preco_Int, stock_int, Configuracao_id_config)
	VALUES
		('algo',10000, 1212121, 1),
        ('algo',123421, 1212121, 2),
        ('algo',232323, 1212121, 2),
        ('algo',242424, 1212121, 2),
        ('algo',54545, 1212121, 2),
        ('algo',3523, 1212121, 1),
        ('algo',65, 1212121, 1),
        ('algo',65, 1212121, 1),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4);
        
-- Povoamento DetExterior
INSERT INTO DetExterior(designacao_ext, preco_ext, stock_ext, Configuracao_id_config)
	VALUES
		('algo',10000, 1212121, 1),
        ('algo',123421, 1212121, 2),
        ('algo',232323, 1212121, 2),
        ('algo',242424, 1212121, 2),
        ('algo',54545, 1212121, 2),
        ('algo',3523, 1212121, 1),
        ('algo',65, 1212121, 1),
        ('algo',65, 1212121, 1),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 3),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4),
        ('algo',10000, 1212121, 4);    
        
-- Povoamento CompOpcional
INSERT INTO CompOpcional(nome_opc, preco_opc, stock_opc,compIncomp, Configuracao_id_config)
	VALUES
		('algo',10000, 1212121, 'teto de abrir' ,1),
        ('algo',123421, 1212121, 'jantes',2),
        ('algo',232323, 1212121, 'teto de abrir',2),
        ('algo',242424, 1212121, 'grades',2),
        ('algo',54545, 1212121, 'motor',2),
        ('algo',3523, 1212121, 'estofos',1),
        ('algo',65, 1212121, 'teto de abrir',1),
        ('algo',65, 1212121,'teto de abrir' ,1),
        ('algo',10000, 1212121,'teto de abrir' ,3),
        ('algo',10000, 1212121, 'teto de abrir',3),
        ('algo',10000, 1212121,'teto de abrir' ,3),
        ('algo',10000, 1212121,'teto de abrir' ,3),
        ('algo',10000, 1212121,'teto de abrir' ,4),
        ('algo',10000, 1212121,'teto de abrir' ,4),
        ('algo',10000, 1212121,'teto de abrir' ,4),
        ('algo',10000, 1212121,'teto de abrir' ,4);        
        
        
        