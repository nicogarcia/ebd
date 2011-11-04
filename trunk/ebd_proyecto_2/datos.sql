SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `parquimetros`
USE parquimetros;
--
--

-- Volcar la base de datos para la tabla `conductores`
--
INSERT INTO `conductores` (`dni`, `nombre`, `apellido`, `direccion`, `telefono`, `registro`) VALUES
(3455654, 'Magali', 'Alegre', 'zapiola 44', '4564321', 23450),
(7654421, 'Robert', 'Ansi', 'Sarmiento 21', '6754324', 23411),
(16548472, 'Carlos', 'Perez', 'Calle 5 N°547', '4158764', 3837),
(18784645, 'Juana', 'Gonzalez', 'Calle 4 N°468', '4687895', 6541);
--
--

-- Volcar la base de datos para la tabla `automoviles`
--
INSERT INTO `automoviles` (`patente`, `marca`, `modelo`, `color`, `dni`) VALUES
('AAA111', 'Ford', 'Mondeo', 'Azul', 18784645),
('BBB222', 'Volkswagen', 'Voyage', 'Dorado', 16548472),
('CDE109', 'ford', 'falcon', 'negro', 7654421),
('DER789', 'volkswagen', 'gol', 'azul', 3455654);
--
--

-- Volcar la base de datos para la tabla `inspectores`
--
INSERT INTO `inspectores` (`legajo`, `dni`, `nombre`, `apellido`, `password`) VALUES
(12, 34567, 'Susana', 'Fiere', 'fieresu'),
(134, 345678, 'Roberta', 'Martinez', 'mariroberta'),
(345, 23445432, 'Abigail', 'Pereira', 'pereabi');
--
--

-- Volcar la base de datos para la tabla `tipos_cospeles`
--
INSERT INTO `tipos_cospeles` (`tipo`, `descuento`) VALUES
('Zona 1', '0.10'),
('Zona 2', '0.30');
--
--

-- Volcar la base de datos para la tabla `cospeles`
--
INSERT INTO `cospeles` (`id_cospel`, `saldo`, `tipo`, `patente`) VALUES
(1111, '35.00', 'Zona 1', 'AAA111'),
(2222, '15.00', 'Zona 2', 'BBB222');
--
--

-- Volcar la base de datos para la tabla `ubicaciones`
--
INSERT INTO `ubicaciones` (`calle`, `altura`, `tarifa`) VALUES
('Alsina', 100, '1.50'),
('Alsina', 200, '1.50'),
('calle 1', 200, '1.50'),
('calle 2', 100, '1.50'),
('Sarmiento', 100, '1.60'),
('Sarmiento', 200, '1.50');
--
--

-- Volcar la base de datos para la tabla `parquimetros`
--
INSERT INTO `parquimetros` (`id_parq`, `numero`, `calle`, `altura`) VALUES
(1, 1, 'Calle 1', 200),
(2, 1, 'Calle 2', 100),
(3, 3, 'Alsina', 100),
(4, 4, 'Alsina', 200),
(5, 5, 'Sarmiento', 100),
(6, 6, 'Sarmiento', 200);
--
--

-- Volcar la base de datos para la tabla `estacionamientos`
--
INSERT INTO `estacionamientos` (`id_cospel`, `id_parq`, `fecha_ent`, `hora_ent`, `fecha_sal`, `hora_sal`) VALUES
(1111, 1, '2011-10-17', '15:00:00', NULL, NULL),
(2222, 2, '2011-10-17', '20:00:00', '2011-10-21', '20:45:00');
--
--

-- Volcar la base de datos para la tabla `accede`
--
INSERT INTO `accede` (`legajo`, `id_parq`, `fecha`, `hora`) VALUES
(12, 6, '2011-10-11', '19:00:00'),
(12, 6, '2011-10-12', '19:00:00'),
(134, 2, '2011-10-09', '19:00:00'),
(134, 5, '2011-10-11', '19:00:00'),
(345, 1, '2011-10-11', '19:00:00'),
(345, 4, '2011-10-10', '19:00:00');
--
--

-- Volcar la base de datos para la tabla `asociado_con`
--
INSERT INTO `asociado_con` (`id_asociado_con`, `legajo`, `calle`, `altura`, `dia`, `turno`) VALUES
(1, 12, 'Sarmiento', 200, 'MA', 'M'),
(2, 134, 'Alsina', 100, 'MI', 'T'),
(3, 345, 'Alsina', 200, 'MA', 'T');
--
--

-- Volcar la base de datos para la tabla `multa`
--

INSERT INTO `multa` (`numero`, `fecha`, `hora`, `patente`, `id_asociado_con`) VALUES
(10, '2011-10-05', '10:00:00', 'AAA111', 1),
(11, '2011-10-10', '19:00:00', 'CDE109', 2);
--


