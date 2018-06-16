-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2018 a las 04:50:16
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `filtros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `filtros_aceite`
--

CREATE TABLE `filtros_aceite` (
  `idFiltro` int(11) NOT NULL,
  `codFiltro` varchar(11) NOT NULL,
  `marca` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `existencia` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `filtros_aceite`
--

INSERT INTO `filtros_aceite` (`idFiltro`, `codFiltro`, `marca`, `stock`, `existencia`) VALUES
(1, '90915-03001', 1, 105, 0),
(3, 'LF-2825', 2, 45, 1),
(4, 'PH3537', 2, 23, 1),
(11, '90915-03006', 3, 123, 1),
(12, 'PH3593A', 1, 34, 1),
(13, 'PH54', 2, 45, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`id`, `nombre`) VALUES
(1, 'FRAM'),
(2, 'WIX'),
(3, 'Luber Finer'),
(4, 'OSK');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `filtros_aceite`
--
ALTER TABLE `filtros_aceite`
  ADD PRIMARY KEY (`idFiltro`),
  ADD UNIQUE KEY `codFiltro_UNIQUE` (`codFiltro`),
  ADD KEY `marca` (`marca`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `filtros_aceite`
--
ALTER TABLE `filtros_aceite`
  MODIFY `idFiltro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `filtros_aceite`
--
ALTER TABLE `filtros_aceite`
  ADD CONSTRAINT `filtros_aceite_ibfk_1` FOREIGN KEY (`marca`) REFERENCES `marcas` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
