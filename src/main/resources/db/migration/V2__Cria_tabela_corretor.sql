DROP TABLE IF EXISTS `Corretor`;

CREATE TABLE `Corretor` (
    `documento` VARCHAR(255) NOT NULL,
    `nome` VARCHAR(255) DEFAULT NULL,
    `email` VARCHAR(255) DEFAULT NULL,
    `telefone` VARCHAR(255) DEFAULT NULL,
    `creci` VARCHAR(255) DEFAULT NULL,
    `bio` TEXT,
    PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;