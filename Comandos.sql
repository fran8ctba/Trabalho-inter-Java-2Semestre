DROP SEQUENCE ESTADO_SEQ;
DROP SEQUENCE CIDADE_SEQ;
DROP SEQUENCE SEXO_SEQ;
DROP SEQUENCE ESPECIE_SEQ;
DROP SEQUENCE PORTE_SEQ;
DROP SEQUENCE RACA_SEQ;
DROP SEQUENCE HISTCLINICO_SEQ;
DROP SEQUENCE HISTEXAME_SEQ;
DROP SEQUENCE HISTRECEITUARIO_SEQ;
DROP SEQUENCE HISTDIAGNOSTICO_SEQ;
DROP SEQUENCE TIPOEXAME_SEQ;
DROP SEQUENCE EXAME_SEQ;
DROP SEQUENCE DIAGNOSTICO_SEQ;
DROP SEQUENCE RECEITUARIO_SEQ;
DROP SEQUENCE CONSULTA_SEQ;
DROP SEQUENCE ANIMAL_SEQ;
DROP SEQUENCE DONO_SEQ;

DROP TABLE ANIMAL;
DROP TABLE DONO;
DROP TABLE CIDADE;
DROP TABLE ESTADO;
DROP TABLE SEXO;
DROP TABLE PORTE;
DROP TABLE RACA;
DROP TABLE ESPECIE;
DROP TABLE EXAME;
DROP TABLE TIPOEXAME;
DROP TABLE DIAGNOSTICO;
DROP TABLE RECEITUARIO;
DROP TABLE HISTCLINICO;

CREATE SEQUENCE ESTADO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
  CREATE SEQUENCE CIDADE_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
  CREATE SEQUENCE SEXO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE ESPECIE_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
  CREATE SEQUENCE RACA_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
  CREATE SEQUENCE PORTE_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
CREATE SEQUENCE DONO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
CREATE SEQUENCE ANIMAL_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;


CREATE SEQUENCE CONSULTA_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE RECEITUARIO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
CREATE SEQUENCE DIAGNOSTICO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
CREATE SEQUENCE EXAME_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
CREATE SEQUENCE TIPOEXAME_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;


CREATE SEQUENCE HISTRECEITUARIO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE SEQUENCE HISTDIAGNOSTICO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
CREATE SEQUENCE HISTEXAME_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
  
CREATE SEQUENCE HISTCLINICO_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;


 CREATE TABLE ESTADO
 (
 	ID 				INT 		NOT NULL PRIMARY KEY,
 	NOME			VARCHAR(30)	NOT NULL 	
 );
 
 CREATE TABLE CIDADE
 (
 	ID				INT			NOT NULL PRIMARY KEY,
 	NOME			VARCHAR(50) NOT NULL,
 	ID_ESTADO		INT			NOT NULL,
 	CONSTRAINT CIDADE_DONO_FK
 			   FOREIGN KEY (ID_ESTADO)
 			   REFERENCES ESTADO(ID) 
 );
 
 CREATE TABLE SEXO
 (
 	ID 				INT 		NOT NULL PRIMARY KEY,
 	DESCRICAO		VARCHAR(50)	NOT NULL 	
 );
 
 CREATE TABLE ESPECIE
 (
 	ID 				INT 		NOT NULL PRIMARY KEY,
 	DESCRICAO		VARCHAR(50) NOT NULL 	
 );
 
 CREATE TABLE RACA
 (
 	ID 				INT 		NOT NULL PRIMARY KEY,
 	DESCRICAO		VARCHAR(50), 	
 	ID_ESPECIE 		INT			NOT NULL,
 	CONSTRAINT ESPECIE_RACA_FK
 			  FOREIGN KEY (ID_ESPECIE)
 			  REFERENCES ESPECIE(ID)
 );
 
 CREATE TABLE PORTE
 (
 	ID 				INT 		NOT NULL PRIMARY KEY,
 	DESCRICAO		VARCHAR(50) NOT NULL
 ); 
  
CREATE TABLE HISTCLINICO
(
	ID 				 INT    	  NOT NULL PRIMARY KEY		  
);


 CREATE TABLE RECEITUARIO
(
	ID 				 INT   		  NOT NULL PRIMARY KEY,
	DATA			 TIMESTAMP	  NOT NULL,
	UNMEDIDA		 VARCHAR(10)  NOT NULL,
	PESO			 DECIMAL(8,3) NOT NULL,
	RECEITATEXTO	 VARCHAR(500) NOT NULL,
	ID_HISTCLINICO 	 INT   		  NOT NULL,	
	CONSTRAINT RECEITUARIO_HISTCLINICO_FK
			  FOREIGN KEY (ID_HISTCLINICO)
			  REFERENCES HISTCLINICO(ID)

);

CREATE TABLE DIAGNOSTICO
(
	ID 				 INT   		  NOT NULL PRIMARY KEY,
	DATA			 TIMESTAMP	  NOT NULL,
	UNMEDIDA		 VARCHAR(50)  NOT NULL,
	PESO			 DECIMAL(8,3) NOT NULL,
	DIAGNOSTICOTEXTO VARCHAR(500) NOT NULL,
	ID_HISTCLINICO	 INT		  NOT NULL,
	CONSTRAINT DIAGNOSTICO_HISTCLINICO_FK
			  FOREIGN KEY (ID_HISTCLINICO)
			  REFERENCES HISTCLINICO(ID)

	);

CREATE TABLE TIPOEXAME
(
	ID 				 INT 		  NOT NULL PRIMARY KEY,
	DESCRICAO		 VARCHAR(50)  NOT NULL	

);

/*O EXAME POSSUI DATA*/

CREATE TABLE EXAME
(
	ID 				 INT 		  NOT NULL PRIMARY KEY,
	DESCRICAO		 VARCHAR(50)  NOT NULL, 
	DATA			 TIMESTAMP	  NOT NULL,
	ID_TIPOEXAME	 INT		  NOT NULL,
	ID_HISTCLINICO	 INT		  NOT NULL,	
	CONSTRAINT EXAME_TIPOEXAME_FK
			  FOREIGN KEY (ID_TIPOEXAME)
			  REFERENCES TIPOEXAME(ID),
	CONSTRAINT EXAME_HISTCLINICO_FK
			  FOREIGN KEY (ID_HISTCLINICO)
			  REFERENCES HISTCLINICO(ID)
);



/*
CREATE TABLE HISTRECEITUARIO
(
	ID_RECEITUARIO	 INT		  NULL,
	ID_HISTCLINICO	 INT		  NULL,
	CONSTRAINT HISTRECEITUARIO_RECEITUARIO_FK
			  FOREIGN KEY(ID_RECEITUARIO)
			  REFERENCES RECEITUARIO(ID),
    CONSTRAINT HISTRECEITUARIO_HISTCLINICO_FK
			  FOREIGN KEY(ID_HISTCLINICO)
			  REFERENCES HISTCLINICO(ID)

);


CREATE TABLE HISTDIAGNOSTICO
(
	ID_DIAGNOSTICO	 INT		  NULL,
	ID_HISTCLINICO	 INT		  NULL,
	CONSTRAINT HISTDIAGNOSTICO_DIAGNOSTICO_FK
			  FOREIGN KEY(ID_DIAGNOSTICO)
			  REFERENCES DIAGNOSTICO(ID),
	CONSTRAINT HISTDIAGNOSTICO_HISTCLINICO_FK
			  FOREIGN KEY(ID_HISTCLINICO)
			  REFERENCES HISTCLINICO(ID)
);

CREATE TABLE HISTEXAME
(
	/*ID 				 INT    	  NOT NULL PRIMARY KEY,*/
	ID_EXAME	 	 INT		 	  NULL,
	ID_HISTCLINICO	 INT		 	  NULL,
	CONSTRAINT HISTEXAME_EXAME_FK
			  FOREIGN KEY(ID_EXAME)
			  REFERENCES EXAME(ID),	
	CONSTRAINT HISTEXAME_HISTCLINICO_FK
			  FOREIGN KEY(ID_HISTCLINICO)
			  REFERENCES HISTCLINICO(ID)
);
*/


 CREATE TABLE DONO
 (
	ID              INT        	NOT NULL PRIMARY KEY,
	NOME            VARCHAR(90) NOT NULL,
	SEXO            VARCHAR(1)  NOT NULL,
	DATA_NASCIMENTO	DATE		NOT NULL,
	RG				DECIMAL(10) NOT NULL,
	CPF             DECIMAL(11) NOT NULL,
	TELEFONE        DECIMAL(11) NOT NULL,
	CELULAR			DECIMAL(11)	NOT NULL,
	EMAIL           VARCHAR(100) NOT NULL,
	SENHA           VARCHAR(100) NULL,
	OBSERVACAO		VARCHAR(100) NOT NULL,
	ENDERECO		VARCHAR(100) NOT NULL,
	BAIRRO			VARCHAR(30) NOT NULL,
	CEP				DECIMAL(9)	NOT NULL,	
	ID_CIDADE		INT 	 	NOT NULL,
	CONSTRAINT DONO_CIDADE_FK
			  FOREIGN KEY (ID_CIDADE)
			  REFERENCES CIDADE(ID)
	
 );
	 
 CREATE TABLE ANIMAL
 (
	ID               INT          NOT NULL PRIMARY KEY,
	NOME             VARCHAR(90)  NULL,
	DATA_NASCIMENTO  DATE         NULL,
	IDADE			 DECIMAL(2)	  NULL,
	ANILHA			 DECIMAL(10)  NULL,
	CONSUMO_RACAO	 DECIMAL(3,3) NULL,
	PELAGEM			 VARCHAR(50)  NULL,
	PEDIGREE		 VARCHAR(1)   NULL,	
	ID_DONO			 INT 		  NULL,
	ID_SEXO			 INT          NULL,
	ID_RACA			 INT 		  NULL,
	ID_PORTE		 INT 		  NULL,
	ID_HISTCLINICO	 INT		  NULL,
	CONSTRAINT ANIMAL_DONO_FK
			  FOREIGN KEY (ID_DONO)
			  REFERENCES DONO(ID),
	CONSTRAINT ANIMAL_SEXO_FK
			  FOREIGN KEY (ID_SEXO)
			  REFERENCES SEXO(ID),
	CONSTRAINT ANIMAL_RACA_FK
			  FOREIGN KEY (ID_RACA)
			  REFERENCES RACA(ID),
	CONSTRAINT ANIMAL_PORTE_FK
			  FOREIGN KEY (ID_PORTE)
			  REFERENCES PORTE(ID),
	CONSTRAINT ANIMAL_HISTCLINICO_FK
			  FOREIGN KEY (ID_HISTCLINICO)
			  REFERENCES HISTCLINICO(ID)
);


SELECT DESCRICAO FROM EXAME;

SELECT ID,DESCRICAO FROM ESPECIE;
	
 
               INSERT INTO ESTADO VALUES(1, 'AC');
               INSERT INTO ESTADO  VALUES(2, 'AL');
               INSERT INTO ESTADO  VALUES(3, 'AP');
               INSERT INTO ESTADO  VALUES(4, 'AM');
               INSERT INTO ESTADO  VALUES(5, 'BA');
               INSERT INTO ESTADO  VALUES(6, 'CE');
               INSERT INTO ESTADO  VALUES(7, 'DF');
               INSERT INTO ESTADO  VALUES(8, 'ES');
               INSERT INTO ESTADO  VALUES(9, 'GO');
               INSERT INTO ESTADO  VALUES(10, 'MA');
               INSERT INTO ESTADO  VALUES(11, 'MG');
               INSERT INTO ESTADO  VALUES(12, 'MS');
               INSERT INTO ESTADO  VALUES(13, 'MT');
               INSERT INTO ESTADO  VALUES(14, 'PA');
               INSERT INTO ESTADO  VALUES(15, 'PB');
               INSERT INTO ESTADO  VALUES(16, 'PE');
               INSERT INTO ESTADO  VALUES(17, 'PI');
               INSERT INTO ESTADO  VALUES(18, 'PR');
               INSERT INTO ESTADO  VALUES(19, 'RJ');
               INSERT INTO ESTADO  VALUES(20, 'RN'); 
               INSERT INTO ESTADO  VALUES(21, 'RS');
               INSERT INTO ESTADO  VALUES(22, 'RO');
               INSERT INTO ESTADO  VALUES(23, 'RR');
               INSERT INTO ESTADO  VALUES(24, 'SC');
               INSERT INTO ESTADO  VALUES(25, 'SP');
               INSERT INTO ESTADO  VALUES(26, 'SE');
               INSERT INTO ESTADO  VALUES(27, 'TO');
	
              /* SELECT ID, NOME FROM ESTADO;
               SELECT ID, DESCRICAO FROM SEXO;
              delete from ESTADO where ID>27 and ID<41;*/
               
	           INSERT INTO CIDADE VALUES(1, 'Rio Branco',1);
               INSERT INTO CIDADE VALUES(2, 'Maceió',2);
               INSERT INTO CIDADE VALUES(3, 'Macapá',3);
               INSERT INTO CIDADE VALUES(4, 'Manaus',4);
               INSERT INTO CIDADE VALUES(5, 'Salvador',5);
               INSERT INTO CIDADE VALUES(6, 'Fortaleza',6);
               INSERT INTO CIDADE VALUES(7, 'Brasília',7);
               INSERT INTO CIDADE VALUES(8, 'Vitória',8);
               INSERT INTO CIDADE VALUES(9, 'Goiânia',9);
               INSERT INTO CIDADE VALUES(10, 'São Luís',10);
               INSERT INTO CIDADE VALUES(11, 'Belo Horizonte',11);
               INSERT INTO CIDADE VALUES(12, 'Campo Grande',12);
               INSERT INTO CIDADE VALUES(13, 'Cuiabá',13);
               INSERT INTO CIDADE VALUES(14, 'Belém',14);
               INSERT INTO CIDADE VALUES(15, 'João Pessoa',15);
               INSERT INTO CIDADE VALUES(16, 'Recife',16);
               INSERT INTO CIDADE VALUES(17, 'Teresina',17);
               INSERT INTO CIDADE VALUES(18, 'Curitiba',18);
               INSERT INTO CIDADE VALUES(19, 'Rio de Janeiro',19);
               INSERT INTO CIDADE VALUES(20, 'Natal',20); 
               INSERT INTO CIDADE VALUES(21, 'Porto Alegre',21);
               INSERT INTO CIDADE VALUES(22, 'Porto Velho',22);
               INSERT INTO CIDADE VALUES(23, 'Boa Vista',23);
               INSERT INTO CIDADE VALUES(24, 'Florianópolis',24);
               INSERT INTO CIDADE VALUES(25, 'São Paulo',25);
               INSERT INTO CIDADE VALUES(26, 'Aracaju',26);
               INSERT INTO CIDADE VALUES(27, 'Palmas',27);	
	
               INSERT INTO ESPECIE VALUES(1, 'Ave');
               INSERT INTO ESPECIE  VALUES(2, 'Bovina');
               INSERT INTO ESPECIE  VALUES(3, 'Caprino');
               INSERT INTO ESPECIE  VALUES(4, 'Coelho');
               INSERT INTO ESPECIE  VALUES(5, 'Equino');
               INSERT INTO ESPECIE  VALUES(6, 'Felino');
               INSERT INTO ESPECIE  VALUES(7, 'Ovino');
               INSERT INTO ESPECIE  VALUES(8, 'Peixe');
               INSERT INTO ESPECIE  VALUES(9, 'Réptil');
               INSERT INTO ESPECIE  VALUES(10, 'Suina');
               INSERT INTO ESPECIE  VALUES(11, 'Canino');
               
               INSERT INTO RACA VALUES(1,'Andorinha',1);
               INSERT INTO RACA VALUES(2,'Bandeirinha',1);
               INSERT INTO RACA VALUES(3,'Coruja',1);
			   INSERT INTO RACA VALUES(4,'Degolado',1);
  			   INSERT INTO RACA VALUES(5,'Quero quero',1);               
			   INSERT INTO RACA VALUES(6,'Gavião',1);               
            
               INSERT INTO RACA VALUES(7,'Angus',2);
               INSERT INTO RACA VALUES(8,'Caracu',2);
               INSERT INTO RACA VALUES(9,'Nelore',2);
               
		   	   INSERT INTO RACA VALUES(17,'Repartida',3);
  			   INSERT INTO RACA VALUES(18,'Canindé',3);               
			   INSERT INTO RACA VALUES(19,'Boer',3);               
			   
			   INSERT INTO RACA VALUES(20,'Holandês',4);
  			   INSERT INTO RACA VALUES(21,'Dwarf Hotot',4);               
			   INSERT INTO RACA VALUES(22,'Mini lop',4);               
			   INSERT INTO RACA VALUES(23,'Polish',4);
  			   INSERT INTO RACA VALUES(24,'Lion',4);               
	
  			   INSERT INTO RACA VALUES(25,'American Saddlebred',5);
  			   INSERT INTO RACA VALUES(26,'Finlandês',5);               
			   INSERT INTO RACA VALUES(27,'Pônei',5);               
			   INSERT INTO RACA VALUES(28,'Puro Sangue Lusitano',5);
  			   INSERT INTO RACA VALUES(29,'Shire',5);               
			   
  			   INSERT INTO RACA VALUES(30,'Abissínio',6);
  			   INSERT INTO RACA VALUES(32,'Egyptian Mau',6);               
			   INSERT INTO RACA VALUES(33,'Angorá',6);               
			   INSERT INTO RACA VALUES(34,'Exótico',6);
  			   INSERT INTO RACA VALUES(35,'Maine Coon',6);               
			   INSERT INTO RACA VALUES(36,'Persa',6);               
			   INSERT INTO RACA VALUES(37,'Scottish Fold',6);

			   INSERT INTO RACA VALUES(38,'Dorper',7);
  			   INSERT INTO RACA VALUES(39,'Merino',7);               
			   INSERT INTO RACA VALUES(40,'Ryeland',7);               
			   INSERT INTO RACA VALUES(41,'Texel',7);

		       INSERT INTO RACA VALUES(42,'Abelhinha',8);               
			   INSERT INTO RACA VALUES(43,'Baiacu',8);
			   INSERT INTO RACA VALUES(44,'Dojô',8);               
			   INSERT INTO RACA VALUES(45,'Neon',8);
			   INSERT INTO RACA VALUES(46,'Peixe-palhaço',8);               
			   INSERT INTO RACA VALUES(47,'Tubarão',8);
			   INSERT INTO RACA VALUES(48,'Baiacu',8);
			   INSERT INTO RACA VALUES(49,'Dojô',8);               
			   INSERT INTO RACA VALUES(50,'Neon',8);
			   INSERT INTO RACA VALUES(51,'Peixe-palhaço',8);               
			   INSERT INTO RACA VALUES(52,'Tubarão',8);

			   INSERT INTO RACA VALUES(53,'Anole Verde',9);               
			   INSERT INTO RACA VALUES(54,'Boicora',9);
			   INSERT INTO RACA VALUES(55,'Cobra-de-vidro',9);               
			   INSERT INTO RACA VALUES(56,'Jararaca-verde',9);
			   INSERT INTO RACA VALUES(57,'Lagarto aranha',9);               

			   INSERT INTO RACA VALUES(58,'Berkshire',10);               
			   INSERT INTO RACA VALUES(59,'British Lop',10);
			   INSERT INTO RACA VALUES(60,'Cantonense',10);               
			   INSERT INTO RACA VALUES(61,'Duroc',10);

			   INSERT INTO RACA VALUES(10,'Akita',11);
  			   INSERT INTO RACA VALUES(11,'Basset Hound',11);               
			   INSERT INTO RACA VALUES(12,'Cocker Spaniel Inglês',11);               
			   INSERT INTO RACA VALUES(13,'Golden Retriever',11);
  			   INSERT INTO RACA VALUES(14,'Maltês',11);               
			   INSERT INTO RACA VALUES(15,'Pastor Alemão',11);               
		   	   INSERT INTO RACA VALUES(16,'Sem Raça Definida',11);

			   INSERT INTO SEXO VALUES(1,'Macho');               
			   INSERT INTO SEXO VALUES(2,'Femêa');
			   INSERT INTO SEXO VALUES(3,'Macho - Castrado');               
			   INSERT INTO SEXO VALUES(4,'Femêa - Esterelizada');               
			   INSERT INTO SEXO VALUES(5,'Indeterminado');
			   
			
			   INSERT INTO PORTE VALUES(1,'Pequeno');            
			   INSERT INTO PORTE VALUES(2,'Médio');
			   INSERT INTO PORTE VALUES(3,'Grande');               
			   INSERT INTO PORTE VALUES(4,'Gigante');  
				
			   
			   INSERT INTO DONO VALUES (1,	'Francieli Ferreira Geraldo',
			   								'f',
			   								'08111999',
			   								81220450,
			   								11908805986,
			   								41984568688,
			   								4130105214,
			   								'fran8ctba@hotmail.com',
			   								'123456',
			   								'Antonio Paullino Teixeira de Freitas - 267',
			   								'Campo Comprido',
			   								81220450,
			   								18);
			   							
		   INSERT INTO DONO VALUES (2,	'Erika Paiva',
			   								'f',
			   								'22061998',
			   								13216545,
			   								12345678915,
			   								41965328456,
			   								4132568945,
			   								'erikapaiva@hotmail.com',
			   								'123456',
			   								'Getulio Vargas - 15',
			   								'Rebolças',
			   								21223456,
			   								19);
	
			   INSERT INTO A VALUES (1,	'Erika Paiva',
			   								'f',
			   								'22061998',
			   								13216545,
			   								12345678915,
			   								41965328456,
			   								4132568945,
			   								'erikapaiva@hotmail.com',
			   								'123456',
			   								'Getulio Vargas - 15',
			   								'Rebolças',
			   								21223456,
			   								19);
		  		   
--
--            #region DONOS
--            List<Dono> donos = new List<Dono>()
--            {
--                new Dono() {
--                             Email = "fran8ctba@hotmail.com",
--                             Senha = "123456",
--                             Nome = "Francieli Ferreira",
--                             Sexo = 'F',
--                             DtNascimento = new DateTime(1999,11,08),
--                             RG = 103171261,
--                             CPF = 11908805986,
--                             Celular = 41984568688,
--                             Telefone = 4132691901,
--                             CEP = 81220450,
--                             Endereco = "Antônio Paulino Teixeira de Freitas - 267",
--                             Bairro = "Campo Comprido",
--                             Cidade = cidades.FirstOrDefault(c => c.NMCidade == "Curitiba")
--                },
--
--                new Dono() {
--                             Email = "camiscoltinho@hotmail.com",
--                             Senha = "123456789",
--                             Nome = "Camila Colto",
--                             Sexo = 'F',
--                             DtNascimento = new DateTime(1993,03,02),
--                             RG = 126152359,
--                             CPF = 11654423658,
--                             Celular = 41985626456,
--                             Telefone = 4132659832,
--                             CEP = 36542983,
--                             Endereco = "Pedro Dibas - 556",
--                             Bairro = "NaoSei",
--                             Cidade = cidades.FirstOrDefault(c => c.NMCidade == "Maringá")
--                }
--
--            };
--            donos.ForEach(d => contexto.Donos.Add(d));
--            #endregion
--
--            #region ANIMAIS
--            List<Animal> animais = new List<Animal>()
--            {
--                new Animal{
--                            Nome = "Dog",
--                            Idade = 7,
--                            Anilha= 000111,
--                            ConsumoRacao = 380,
--                            Pelagem = "Branca",
--                            Pedigree = true,
--                            Dono = donos.FirstOrDefault(d => d.Nome == "Francieli Ferreira"),
--                            Sexo = sexos.FirstOrDefault(s => s.Descricao == "Macho - Castrado"),
--                            Raca = racas.FirstOrDefault(r => r.Descricao == "Akita" ),
--                            Porte = portes .FirstOrDefault(p => p.Descricao == "Médio")
--                },
--
--                new Animal{
--                            Nome = "Totó",
--                            Idade = 3,
--                            Anilha= 000222,
--                            ConsumoRacao = 17,
--                            Pedigree = true,
--                            Pelagem = "Mesclado",
--                            Dono = donos.FirstOrDefault(d => d.Nome == "Camila Colto"),
--                            Sexo = sexos.FirstOrDefault(s => s.Descricao == "Femêa"),
--                            Raca = racas.FirstOrDefault(r => r.Descricao == "Persa" ),
--                            Porte = portes .FirstOrDefault(p => p.Descricao == "Médio")
--                }
--            };
--            animais.ForEach(a => contexto.Animais.Add(a));
--            #endregion
--        }
--    }
--}
 	