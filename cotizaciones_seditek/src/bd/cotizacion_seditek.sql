Create database if not exists cotizaciones_seditek;
Use cotizaciones_seditek;

Create table if not exists Usuarios(
	id_usuario  varchar(15) primary key,
	nombre_usuario varchar(20) not null,
	tipo_usuario varchar(15) not null,
	password varchar(15) not null)ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;


Create table if not exists Clientes(
	id_cliente varchar(10) primary key,
	nombre_cliente varchar(20) not null,
	apellido_paterno varchar(20) not null,
	apellido_materno varchar(20) not null,
	telefono_cliente int(10) not null,
	telefono_empresa int(10) not null,
    email_cliente varchar(40) not null,
	rfc_cliente varchar(13) not null,
	calle_cliente varchar(30) not null,
	colonia_cliente varchar(30) not null,
	municipio_cliente varchar(15) not null,
    empresa_cliente varchar(20) not null,
	cp_cliente int(5) not null)ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;


Create table if not exists Productos(
	id_producto varchar(20) primary key,
	codigo_producto varchar(20) not null,
	nombre_producto varchar(40) not null,
	marca varchar(40) not null,
	modelo varchar(40) not null,
	descripcion_usuario varchar(100) not null,
	descripcion_cliente varchar(100) not null,
	accesorios varchar(100) not null,
	precio_unitario decimal(10) not null,
	INDEX fk_proveedor_1(id_proveedor) USING BTREE,
    CONSTRAINT fk_proveedor_1 FOREIGN KEY (id_proveedor) REFERENCES Proveedor (id_proveedor) ON DELETE RESTRICT ON UPDATE RESTRICT
    )ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

Create table if not exists Proveedor(
	id_proveedor varchar(20) primary key,
	nombre_proveedor varchar(40) not null,
	telefono_proveedor int(10) not null,
	telefono_contacto int(10) not null,
	email_proveedor varchar(40) not null,
    email_contacto varchar(40) not null,
	calle_proveedor varchar(40) not null,
	colonia_proveedor varchar(40) not null,
	municipio_proveedor varchar(40) not null,
	empresa_proveedor varchar(40) not null,
    rfc_proveedor varchar(13) not null,
	cp_proveedor int(5) not null)ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;


Create table if not exists Servicios(
	id_servicio varchar(20) primary key,
	tipo_servicio varchar(40) not null,
    descripcion_servicio varchar(40) not null,
	costo_servicio decimal(10) not null)ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;


Create table if not exists Cotizacion(
	id_detalle_cotizacion varchar(20) primary key,
	numero_cotizacion int(10)  not null,
    id_usuario  varchar(15) not null,
    id_cliente varchar(10) not null,
	fecha_cotizacion date not null)ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

Create table if not exists Detalle_cotizacion(
	id_detalle_cotizacion varchar(20) not null,
	cantidad int(10) not null,
	subtotal decimal(10) not null,
	total decimal(10) not null,
	id_cliente varchar(20) not null,
	id_producto varchar(20) not null,
	id_cotizacion varchar(20) not null,
	id_servicio varchar(20) null,
	primary key (id_detalle_cotizacion) using BTREE,
  	INDEX fk_clientes_1(id_cliente) USING BTREE,
  	INDEX fk_productos_1(id_producto) USING BTREE,
  	INDEX fk_cotizacion_1(id_cotizacion) USING BTREE,
  	INDEX fk_servicios_1(id_servicio) USING BTREE,
  	CONSTRAINT fk_servicios_1 FOREIGN KEY (id_servicio) REFERENCES Servicios (id_servicio) ON DELETE RESTRICT ON UPDATE RESTRICT,
  	CONSTRAINT fk_cotizacion_1 FOREIGN KEY (id_cotizacion) REFERENCES Cotizacion (id_cotizacion) ON DELETE RESTRICT ON UPDATE RESTRICT,
  	CONSTRAINT fk_productor_1 FOREIGN KEY (id_producto) REFERENCES Productos (id_producto) ON DELETE RESTRICT ON UPDATE RESTRICT,
  	CONSTRAINT fk_clientes_1 FOREIGN KEY (id_cliente) REFERENCES Clientes (id_cliente) ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;