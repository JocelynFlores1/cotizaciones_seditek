-- Database: `bizgkbbqrlrldpommd6i`
--

-- --------------------------------------------------------

-- Table structure for table `Clientes`
--

CREATE TABLE `Clientes` (
  `id_cliente` varchar(10) NOT NULL,
  `nombre_cliente` varchar(20) NOT NULL,
  `apellido_paterno` varchar(20) NOT NULL,
  `apellido_materno` varchar(20) NOT NULL,
  `telefono_cliente` int(10) NOT NULL,
  `telefono_empresa` int(10) NOT NULL,
  `email_cliente` varchar(40) NOT NULL,
  `rfc_cliente` varchar(13) NOT NULL,
  `calle_cliente` varchar(30) NOT NULL,
  `colonia_cliente` varchar(30) NOT NULL,
  `municipio_cliente` varchar(15) NOT NULL,
  `empresa_cliente` varchar(20) NOT NULL,
  `cp_cliente` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `Cotizacion`
--

CREATE TABLE `Cotizacion` (
  `id_cotizacion` varchar(20) NOT NULL,
  `numero_cotizacion` int(10) NOT NULL,
  `id_usuario` varchar(15) NOT NULL,
  `id_cliente` varchar(10) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `validez_oferta` varchar(50) NOT NULL,
  `promocion_especial` varchar(50) NOT NULL,
  `condiciones_comerciles` varchar(150) NOT NULL,
  `fecha_cotizacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `Detalle_cotizacion`
--

CREATE TABLE `Detalle_cotizacion` (
  `id_detalle_cotizacion` varchar(20) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `subtotal` decimal(10,0) NOT NULL,
  `total` decimal(10,0) NOT NULL,
  `id_cliente` varchar(20) NOT NULL,
  `id_producto` varchar(20) NOT NULL,
  `id_cotizacion` varchar(20) NOT NULL,
  `id_servicio` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `Productos`
--

CREATE TABLE `Productos` (
  `id_producto` varchar(20) NOT NULL,
  `codigo_producto` varchar(20) NOT NULL,
  `nombre_producto` varchar(40) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `modelo` varchar(40) NOT NULL,
  `descripcion_usuario` varchar(100) NOT NULL,
  `descripcion_cliente` varchar(100) NOT NULL,
  `accesorios` varchar(100) NOT NULL,
  `precio_unitario` decimal(10,0) NOT NULL,
  `stock` int(50) NOT NULL,
  `id_proveedor` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `Proveedor`
--

CREATE TABLE `Proveedor` (
  `id_proveedor` varchar(20) NOT NULL,
  `nombre_proveedor` varchar(40) NOT NULL,
  `telefono_proveedor` int(10) NOT NULL,
  `telefono_contacto` int(10) NOT NULL,
  `email_proveedor` varchar(40) NOT NULL,
  `email_contacto` varchar(40) NOT NULL,
  `calle_proveedor` varchar(40) NOT NULL,
  `colonia_proveedor` varchar(40) NOT NULL,
  `municipio_proveedor` varchar(40) NOT NULL,
  `empresa_proveedor` varchar(40) NOT NULL,
  `rfc_proveedor` varchar(13) NOT NULL,
  `cp_proveedor` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `Servicios`
--

CREATE TABLE `Servicios` (
  `id_servicio` varchar(20) NOT NULL,
  `tipo_servicio` varchar(40) NOT NULL,
  `descripcion_servicio` varchar(40) NOT NULL,
  `costo_servicio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `Usuarios`
--

CREATE TABLE `Usuarios` (
  `id_usuario` varchar(15) NOT NULL,
  `nombre_usuario` varchar(20) NOT NULL,
  `tipo_usuario` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Clientes`
--
ALTER TABLE `Clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `Cotizacion`
--
ALTER TABLE `Cotizacion`
  ADD PRIMARY KEY (`id_cotizacion`);

--
-- Indexes for table `Detalle_cotizacion`
--
ALTER TABLE `Detalle_cotizacion`
  ADD PRIMARY KEY (`id_detalle_cotizacion`) USING BTREE,
  ADD KEY `fk_clientes_1` (`id_cliente`) USING BTREE,
  ADD KEY `fk_productos_1` (`id_producto`) USING BTREE,
  ADD KEY `fk_cotizacion_1` (`id_cotizacion`) USING BTREE,
  ADD KEY `fk_servicios_1` (`id_servicio`) USING BTREE;

--
-- Indexes for table `Productos`
--
ALTER TABLE `Productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `fk_proveedor_1` (`id_proveedor`) USING BTREE;

--
-- Indexes for table `Proveedor`
--
ALTER TABLE `Proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indexes for table `Servicios`
--
ALTER TABLE `Servicios`
  ADD PRIMARY KEY (`id_servicio`);

--
-- Indexes for table `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Detalle_cotizacion`
--
ALTER TABLE `Detalle_cotizacion`
  ADD CONSTRAINT `fk_clientes_1` FOREIGN KEY (`id_cliente`) REFERENCES `Clientes` (`id_cliente`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_cotizacion_1` FOREIGN KEY (`id_cotizacion`) REFERENCES `Cotizacion` (`id_cotizacion`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_productor_1` FOREIGN KEY (`id_producto`) REFERENCES `Productos` (`id_producto`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_servicios_1` FOREIGN KEY (`id_servicio`) REFERENCES `Servicios` (`id_servicio`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `Productos`
--
ALTER TABLE `Productos`
  ADD CONSTRAINT `fk_proveedor_1` FOREIGN KEY (`id_proveedor`) REFERENCES `Proveedor` (`id_proveedor`) ON DELETE RESTRICT ON UPDATE RESTRICT;