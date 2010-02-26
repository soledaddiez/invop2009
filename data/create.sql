DROP TABLE IF EXISTS tasa_produccion CASCADE;
DROP TABLE IF EXISTS linea CASCADE;
DROP TABLE IF EXISTS pedido CASCADE;
DROP TABLE IF EXISTS cliente CASCADE;
DROP TABLE IF EXISTS inventario CASCADE;
DROP TABLE IF EXISTS producto CASCADE;
DROP TABLE IF EXISTS formato CASCADE;


CREATE TABLE formato (
	id bigint NOT NULL,
	nombre character varying(255) NOT NULL,
	capacidad bigint NOT NULL
);
ALTER TABLE public.formato OWNER TO postgres;



CREATE TABLE producto (
    id bigint NOT NULL,
    nombre character varying(255) NOT NULL,
    id_formato bigint NOT NULL,
    utilidad double precision NOT NULL,
    lote_minimo bigint NOT NULL,
    inventario_seguridad double precision NOT NULL
);

ALTER TABLE public.producto OWNER TO postgres;


CREATE TABLE inventario (
	id bigint NOT NULL,
	id_producto bigint NOT NULL,
	cantidad bigint NOT NULL
);

ALTER TABLE public.inventario OWNER TO postgres;



CREATE TABLE cliente (
    id bigint NOT NULL,
    nombre character varying(255) NOT NULL,
    apellido character varying(255) NOT NULL,
    direccion character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL
);

ALTER TABLE public.cliente OWNER TO postgres;



CREATE TABLE pedido (
    id bigint NOT NULL,
    id_producto bigint NOT NULL,
    id_cliente bigint NOT NULL,
    cantidad bigint NOT NULL,
    fecha_orden timestamp without time zone NOT NULL
);

ALTER TABLE public.pedido OWNER TO postgres;



CREATE TABLE linea (
       id bigint NOT NULL,
       id_ultimo_formato bigint NULL,
       nombre character varying(255) NOT NULL
);

ALTER TABLE public.linea OWNER TO postgres;



CREATE TABLE tasa_produccion (
	id bigint NOT NULL,
	id_producto bigint NOT NULL,
	id_linea bigint NOT NULL,
	botellas_hora bigint NOT NULL
);

ALTER TABLE public.tasa_produccion OWNER TO postgres;



ALTER TABLE ONLY formato
    ADD CONSTRAINT pk_formato PRIMARY KEY (id);

ALTER TABLE ONLY producto
    ADD CONSTRAINT pk_producto PRIMARY KEY (id);

ALTER TABLE ONLY inventario
    ADD CONSTRAINT pk_inventario PRIMARY KEY (id);

ALTER TABLE ONLY cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (id);

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pk_pedido PRIMARY KEY (id);

ALTER TABLE ONLY linea
    ADD CONSTRAINT pk_linea PRIMARY KEY (id);

ALTER TABLE ONLY tasa_produccion
    ADD CONSTRAINT pk_tasa_produccion PRIMARY KEY (id);


ALTER TABLE ONLY producto
    ADD CONSTRAINT fk_formato FOREIGN KEY (id_formato) REFERENCES formato(id);

ALTER TABLE ONLY inventario
    ADD CONSTRAINT fk_inventario FOREIGN KEY (id_producto) REFERENCES producto(id);

ALTER TABLE ONLY pedido
    ADD CONSTRAINT fk_pedido_1 FOREIGN KEY (id_producto) REFERENCES producto(id);

ALTER TABLE ONLY pedido
    ADD CONSTRAINT fk_pedido_2 FOREIGN KEY (id_cliente) REFERENCES cliente(id);

ALTER TABLE ONLY linea
    ADD CONSTRAINT fk_linea FOREIGN KEY (id_ultimo_formato) REFERENCES formato(id);

ALTER TABLE ONLY tasa_produccion
    ADD CONSTRAINT fk_tasa_produccion_1 FOREIGN KEY (id_producto) REFERENCES producto(id);

ALTER TABLE ONLY tasa_produccion
    ADD CONSTRAINT fk_tasa_produccion_2 FOREIGN KEY (id_linea) REFERENCES linea(id);


REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

