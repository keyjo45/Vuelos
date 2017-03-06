-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.14-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para aerotech
DROP DATABASE IF EXISTS `aerotech`;
CREATE DATABASE IF NOT EXISTS `aerotech` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `aerotech`;


-- Volcando estructura para tabla aerotech.aerolinea
DROP TABLE IF EXISTS `aerolinea`;
CREATE TABLE IF NOT EXISTS `aerolinea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aerotech.aerolinea: ~4 rows (aproximadamente)
DELETE FROM `aerolinea`;
/*!40000 ALTER TABLE `aerolinea` DISABLE KEYS */;
INSERT INTO `aerolinea` (`id`, `nombre`) VALUES
	(1, 'Avianca'),
	(2, 'LAN'),
	(3, 'VivaColombia'),
	(4, 'ADA');
/*!40000 ALTER TABLE `aerolinea` ENABLE KEYS */;


-- Volcando estructura para tabla aerotech.avion
DROP TABLE IF EXISTS `avion`;
CREATE TABLE IF NOT EXISTS `avion` (
  `id` bigint(20) NOT NULL,
  `cantidadSilla` int(11) NOT NULL,
  `placa` varchar(100) NOT NULL,
  `idAerolinea` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKavion_aerolinea` (`idAerolinea`),
  CONSTRAINT `FKavion_aerolinea` FOREIGN KEY (`idAerolinea`) REFERENCES `aerolinea` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aerotech.avion: ~7 rows (aproximadamente)
DELETE FROM `avion`;
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
INSERT INTO `avion` (`id`, `cantidadSilla`, `placa`, `idAerolinea`) VALUES
	(123, 40, 'AED123', 1),
	(231, 40, 'ASD789', 2),
	(234, 50, 'BDG234', 1),
	(345, 60, 'DFE456', 2),
	(543, 50, 'VIV123', 3),
	(678, 50, 'ADA123', 4),
	(679, 30, 'VIV234', 3);
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;


-- Volcando estructura para tabla aerotech.reserva
DROP TABLE IF EXISTS `reserva`;
CREATE TABLE IF NOT EXISTS `reserva` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idVuelo` varchar(100) NOT NULL,
  `idUsuario` bigint(20) NOT NULL,
  `fechaReserva` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKreservas_vuelos` (`idVuelo`),
  KEY `FKreservas_usuario` (`idUsuario`),
  CONSTRAINT `FKreservas_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKreservas_vuelos` FOREIGN KEY (`idVuelo`) REFERENCES `vuelo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aerotech.reserva: ~0 rows (aproximadamente)
DELETE FROM `reserva`;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` (`id`, `idVuelo`, `idUsuario`, `fechaReserva`) VALUES
	(3, 'FKY123', 1129572970, '2017-01-18'),
	(4, 'TYA234', 1129572970, '2017-01-19');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;


-- Volcando estructura para tabla aerotech.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `genero` char(1) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aerotech.usuario: ~7 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombres`, `apellidos`, `fecha_nacimiento`, `genero`, `telefono`, `email`, `password`) VALUES
	(123, 'prueba', 'prueba', '1986-11-11', 'M', 323, 'prueba@prueba.com', '655e786674d9d3e77bc05ed1de37b4b6bc89f788829f9f3c679e7687b410c89b'),
	(1123, 'dds', 'sdsds', '1985-03-29', 'M', 3230321, 'jv@hotmail.com', 'edd023a83a9221dffba73d006c8c4aa2dcba31900271cb9338dc50657bd18d40'),
	(11234, 'dds', 'sdsds', '1985-03-29', 'M', 3230321, 'sjv@hotmail.com', 'ae28e4a671ab0c4c001d8db0cfdd1b272856887b32bbb8861d33bc17d81a77c7'),
	(222323, 'rueda', 'jajaj', '1987-11-11', 'F', 23443221, 'prueba@prueba1.com', 'ef994e7262a78b97c039adf58214ee7df1076824a7e47538948ba61ae02b05c7'),
	(11295729, 'soledad', 'escobar', '1988-11-11', 'F', 3234567, 'soledad@hotmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
	(134098766, 'juan', 'Vargas Lleras', '2000-01-21', 'M', 3005457689, 'juan@hotmail.com', '1d19a65d970e42dd5107309229bd73339ed6e94ed48977900a40edcbab8af495'),
	(223451234, 'cristina', 'valega de la hoz', '1988-01-05', 'F', 3230321, 'cristina@hotmail.com', '15acfdc75fdb88851487238cd8442c5ecc8e0c31868ce9f52a4e2361ba899f2f'),
	(1129572970, 'yosimar enrique', 'valega de la hoz', '1986-11-13', 'M', 3108287508, 'keyjo45@yahoo.es', 'c21ebfb98e58aee7320676e22cd495f23ce8f747c803993f8d874c46d914e9b3');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


-- Volcando estructura para tabla aerotech.vuelo
DROP TABLE IF EXISTS `vuelo`;
CREATE TABLE IF NOT EXISTS `vuelo` (
  `id` varchar(100) NOT NULL,
  `fecha` datetime NOT NULL,
  `origen` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `idAvion` bigint(20) NOT NULL,
  `tarifa` double NOT NULL,
  `estado` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_vuelo_avion` (`idAvion`),
  CONSTRAINT `FK_vuelo_avion` FOREIGN KEY (`idAvion`) REFERENCES `avion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aerotech.vuelo: ~4 rows (aproximadamente)
DELETE FROM `vuelo`;
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` (`id`, `fecha`, `origen`, `destino`, `idAvion`, `tarifa`, `estado`) VALUES
	('FKY123', '2017-02-18 10:30:00', 'MEDELLIN', 'BARRANQUILLA', 543, 85000, 'DISPONIBLE'),
	('FKY124', '2017-02-23 16:00:37', 'BOGOTÁ', 'MEDELLIN', 231, 200000, 'DISPONIBLE'),
	('TYA234', '2017-03-01 11:00:00', 'MEDELLIN', 'BOGOTA', 543, 85000, 'DISPONIBLE'),
	('WER123', '2017-02-18 15:04:15', 'MEDELLIN', 'BARRANQUILLA', 345, 120000, 'DISPONIBLE');
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
