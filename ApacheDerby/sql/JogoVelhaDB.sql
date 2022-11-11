CREATE TABLE Resultados (
    nPartida int,
    jogador1 varchar(30) NOT NULL,
    jogador2 varchar(30) NOT NULL,

    CONSTRAINT pk_resultados PRIMARY KEY (nPartida)
)