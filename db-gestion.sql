-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-03-2021 a las 20:12:58
-- Versión del servidor: 5.7.26
-- Versión de PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db-gestion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `ID_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CATEGORIA` varchar(25) NOT NULL,
  PRIMARY KEY (`ID_CATEGORIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_ingreso`
--

DROP TABLE IF EXISTS `categoria_ingreso`;
CREATE TABLE IF NOT EXISTS `categoria_ingreso` (
  `ID_CATEGORIA_INGRESO` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_CATEGORIA_INGRESO` varchar(25) NOT NULL,
  PRIMARY KEY (`ID_CATEGORIA_INGRESO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gasto`
--

DROP TABLE IF EXISTS `gasto`;
CREATE TABLE IF NOT EXISTS `gasto` (
  `ID_GASTO` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO_GASTO` varchar(50) DEFAULT NULL,
  `DESCRIPCION_GASTO` varchar(50) DEFAULT NULL,
  `FOTO_GASTO` longblob,
  `FECHA_GASTO` varchar(25) DEFAULT NULL,
  `IMPORTE_GASTO` double NOT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  PRIMARY KEY (`ID_GASTO`),
  KEY `ID_CATEGORIA` (`ID_CATEGORIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso`
--

DROP TABLE IF EXISTS `ingreso`;
CREATE TABLE IF NOT EXISTS `ingreso` (
  `ID_INGRESO` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO_INGRESO` varchar(50) DEFAULT NULL,
  `IMPORTE_INGRESO` double DEFAULT NULL,
  `DESCRIPCION_INGRESO` varchar(50) DEFAULT NULL,
  `FECHA_INGRESO` varchar(15) DEFAULT NULL,
  `ID_CATEGORIA_INGRESO` int(11) NOT NULL,
  PRIMARY KEY (`ID_INGRESO`),
  KEY `ID_CATEGORIA` (`ID_CATEGORIA_INGRESO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `gasto`
--
ALTER TABLE `gasto`
  ADD CONSTRAINT `gasto_ibfk_2` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID_CATEGORIA`);

--
-- Filtros para la tabla `ingreso`
--
ALTER TABLE `ingreso`
  ADD CONSTRAINT `ingreso_ibfk_2` FOREIGN KEY (`ID_CATEGORIA_INGRESO`) REFERENCES `categoria_ingreso` (`ID_CATEGORIA_INGRESO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
