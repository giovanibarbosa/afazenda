create database if not exists AFazenda;

CREATE TABLE if not exists  `AFazenda`.`Vaqueiros` (
  `vaqueiroCPF` varchar(15) NOT NULL DEFAULT '',
  `nome` varchar(30) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `idade` int(2) DEFAULT NULL,
  PRIMARY KEY (`vaqueiroCPF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists  `AFazenda`.`Touros` (
  `idTouro` int(8) NOT NULL auto_increment,
  `nome` varchar(30) DEFAULT NULL,
  `idade` int(2) default null,
  PRIMARY KEY (`idTouro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists  `AFazenda`.`Clientes` (
  `clienteCPF` varchar(15) NOT NULL DEFAULT '',
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `totalComprado` Double(10,2) DEFAULT 0,		
  PRIMARY KEY (`clienteCPF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists `AFazenda`.`Rebanhos` (
  `rebanhoID` int(8) NOT NULL auto_increment,
  `nome` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`rebanhoID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists `AFazenda`.`Vacas` (
  `vacaID` int(8) NOT NULL auto_increment,
  `nome` varchar(50) DEFAULT NULL,
  `idade` int(2) DEFAULT NULL,
  `qntdDeFilhos` int(3) DEFAULT NULL,
  `vaqueiroCPF` varchar(15) DEFAULT NULL,
  `apartada` varchar(5) DEFAULT 'false',
  `inseminada` varchar(5) DEFAULT 'false',
  `rebanhoID` int(8) DEFAULT NULL,
  PRIMARY KEY (`vacaID`),
  KEY `vaqueiroCPF` (`vaqueiroCPF`),
  KEY `rebanhoID` (`rebanhoID`),
  CONSTRAINT `Vacas_ibfk_1` FOREIGN KEY (`vaqueiroCPF`) REFERENCES `Vaqueiros` (`vaqueiroCPF`),
  CONSTRAINT `Rebanhos_ibfk_1` FOREIGN KEY (`rebanhoID`) REFERENCES `Rebanhos` (`rebanhoID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists `AFazenda`.`Vacinas` (
  `nome` varchar(50) NOT NULL DEFAULT '',
  `dosagem` double(10,2) DEFAULT NULL,
  `vacaID` int(8) DEFAULT NULL,
  KEY `vacaID` (`vacaID`),
  CONSTRAINT `Vacinas_ibfk_1` FOREIGN KEY (`vacaID`) REFERENCES `Vacas` (`vacaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists `AFazenda`.`Coberturas` (
  `coberturaID` int(8) NOT NULL auto_increment,
  `dataInseminacao` date DEFAULT NULL,
  `idTouro` int(8) DEFAULT NULL,
  `previsaoDeParto` date DEFAULT NULL,
  `dataRealParto` date DEFAULT NULL,
  `vacaID` int(8) DEFAULT NULL,
  PRIMARY KEY (`coberturaID`),
  KEY `vacaID` (`vacaID`),
  KEY `idTouro` (`idTouro`),
  CONSTRAINT `Coberturas_ibfk_1` FOREIGN KEY (`vacaID`) REFERENCES `Vacas` (`vacaID`),
  CONSTRAINT `Coberturas_ibfk_2` FOREIGN KEY (`idTouro`) REFERENCES `Touros` (`idTouro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists `AFazenda`.`Caixa` (
  `total` double(10,2) DEFAULT NULL,
  `dataDaAtualizacao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists `AFazenda`.`Tiragens` (
  `tiragemID` int(8) NOT NULL auto_increment,
  `qntdTirada` double(10,2) DEFAULT NULL,
  `dataTiragem` date DEFAULT NULL,
  `vez` int(1) DEFAULT NULL,
  `vacaID` int(8) DEFAULT NULL,
  PRIMARY KEY (`tiragemID`),
  KEY `vacaID` (`vacaID`),
  CONSTRAINT `Tiragens_ibfk_1` FOREIGN KEY (`vacaID`) REFERENCES `Vacas` (`vacaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists `AFazenda`.`Vendas` (
  `vendaID` int(8) NOT NULL auto_increment,
  `qntdDeLeite` double(10,2) NOT NULL,
  `valor` double(10,2) DEFAULT NULL,
  `clienteCPF` varchar(11) DEFAULT NULL,
  `dataDeVenda` date DEFAULT NULL,
  PRIMARY KEY (`vendaID`),
   KEY `clienteCPF` (`clienteCPF`),
  CONSTRAINT `Vendas_ibfk_1` FOREIGN KEY (`clienteCPF`) REFERENCES `Clientes` (`clienteCPF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE if not exists `AFazenda`.`EstoqueDeLeite` (
  `total` double(20,2) DEFAULT NULL,
  `dataDaAtualizacao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
