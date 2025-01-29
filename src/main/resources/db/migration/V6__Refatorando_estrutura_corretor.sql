DROP TABLE IF EXISTS `Usuario`;
DROP TABLE IF EXISTS `Corretor`;
DROP TABLE IF EXISTS `CorretorTipoImovel`;
DROP TABLE IF EXISTS `CorretorConstrutora`;
DROP TABLE IF EXISTS `CorretorCidadeBairro`;
DROP TABLE IF EXISTS `CorretorCidade`;

CREATE TABLE `Usuario` (
    `idUsuario` INT AUTO_INCREMENT PRIMARY KEY,
    `cpf` VARCHAR(50) UNIQUE NOT NULL,
    `nome` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Corretor` (
    `idCorretor` INT AUTO_INCREMENT PRIMARY KEY,
    `telefone` VARCHAR(20) NOT NULL,
    `bio` VARCHAR(255),
    `creci` VARCHAR(30) NOT NULL,
    `usuarioFk` INT,
    FOREIGN KEY (`usuarioFk`) REFERENCES Usuario(`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `CorretorTipoImovel` (
    `idCorretorTipoImovel` INT AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(50) NOT NULL,
    `corretorFk` INT,
    FOREIGN KEY (`corretorFk`) REFERENCES Corretor(idCorretor)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `CorretorConstrutora` (
    `idCorretorConstrutora` INT AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(50) NOT NULL,
    `corretorFk` INT,
    FOREIGN KEY (`corretorFk`) REFERENCES Corretor(idCorretor)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `CorretorCidadeBairro` (
  `idCorretorCidadeBairro` INT AUTO_INCREMENT PRIMARY KEY,
  `corretorFk` INT,
  `cidadeFk` INT,
  `bairroFk` INT,
  FOREIGN KEY (`corretorFk`) REFERENCES Corretor(`idCorretor`),
  FOREIGN KEY (`cidadeFk`) REFERENCES Cidade(`idCidade`),
  FOREIGN KEY (`bairroFk`) REFERENCES Bairro(`idBairro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `CorretorCidade` (
    `idCorretorCidade` INT AUTO_INCREMENT PRIMARY KEY,
    `corretorFk` INT,
    `cidadeFk` INT,
    FOREIGN KEY (`corretorFk`) REFERENCES Corretor(`idCorretor`),
    FOREIGN KEY (`cidadeFk`) REFERENCES Cidade(`idCidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `Corretor` ADD COLUMN `corretorConstrutoraFk` INT,
ADD FOREIGN KEY (`corretorConstrutoraFk`) REFERENCES `CorretorConstrutora`(`idCorretorConstrutora`);