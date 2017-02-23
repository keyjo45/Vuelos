-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.7.14-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para aerotech
CREATE DATABASE IF NOT EXISTS `aerotech` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `aerotech`;


-- Volcando estructura para tabla aerotech.aerolinea
CREATE TABLE IF NOT EXISTS `aerolinea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aerotech.aerolinea: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `aerolinea` DISABLE KEYS */;
INSERT INTO `aerolinea` (`id`, `nombre`) VALUES
	(1, 'Avianca'),
	(2, 'LAN'),
	(3, 'VivaColombia'),
	(4, 'ADA');
/*!40000 ALTER TABLE `aerolinea` ENABLE KEYS */;


-- Volcando estructura para tabla aerotech.avion
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla aerotech.reserva: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` (`id`, `idVuelo`, `idUsuario`, `fechaReserva`) VALUES
	(3, 'FKY123', 1129572970, '2017-01-18');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;


-- Volcando estructura para tabla aerotech.usuario
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

-- Volcando datos para la tabla aerotech.usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombres`, `apellidos`, `fecha_nacimiento`, `genero`, `telefono`, `email`, `password`) VALUES
	(223451234, 'cristina', 'valega de la hoz', '1988-01-05', 'F', 3230321, 'cristina@hotmail.com', '15acfdc75fdb88851487238cd8442c5ecc8e0c31868ce9f52a4e2361ba899f2f'),
	(1129572970, 'yosimar enrique', 'valega de la hoz', '1986-11-13', 'M', 3108287508, 'keyjo45@yahoo.es', 'c21ebfb98e58aee7320676e22cd495f23ce8f747c803993f8d874c46d914e9b3');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


-- Volcando estructura para tabla aerotech.vuelo
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

-- Volcando datos para la tabla aerotech.vuelo: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` (`id`, `fecha`, `origen`, `destino`, `idAvion`, `tarifa`, `estado`) VALUES
	('FKY123', '2017-02-18 10:30:00', 'MEDELLIN', 'BARRANQUILLA', 543, 85000, 'DISPONIBLE'),
	('TYA234', '2017-01-18 10:30:00', 'MEDELLIN', 'BARRANQUILLA', 543, 85000, 'DISPONIBLE');
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
