###PRECISA SABER COMO LIMPAR A TELA DEPOIS DE VOCÊ FAZER A RECLAMAÇÃO, PRA NÃO TER QUE FAZER LOGIN DE NOVO 
###CRIEI O INSERT DAS RECLAMAÇÕES NUMA TABELA CHAMADA tabela_forum, PRA FICAR IGUAL A OUTRA, QLQR COISA MANDA MSG 

###AQUI A TABLE: 

    CREATE TABLE tabela_cadastro (
        id INT AUTO_INCREMENT PRIMARY KEY,
        assunto VARCHAR(255) NOT NULL UNIQUE,
        reclamacao VARCHAR(255) NOT NULL
    );
