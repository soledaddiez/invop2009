DROP TABLE demanda;
DROP TABLE pedido;
DROP TABLE linea;
DROP TABLE producto;

CREATE TABLE demanda (
    id bigint NOT NULL,
    id_producto bigint NOT NULL,
    fecha_demanda timestamp without time zone NOT NULL,
    consumo double precision NOT NULL
);


ALTER TABLE public.demanda OWNER TO postgres;

CREATE TABLE pedido (
    id bigint NOT NULL
);


ALTER TABLE public.pedido OWNER TO postgres;

CREATE TABLE producto (
    id bigint NOT NULL,
    nombre character varying(255) NOT NULL,
    cc bigint NOT NULL
);

ALTER TABLE public.producto OWNER TO postgres;
    
ALTER TABLE ONLY demanda
    ADD CONSTRAINT pk_demanda PRIMARY KEY (id);

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pk_pedido PRIMARY KEY (id);

ALTER TABLE ONLY producto
    ADD CONSTRAINT pk_producto PRIMARY KEY (id);

ALTER TABLE ONLY demanda
    ADD CONSTRAINT fk_producto FOREIGN KEY (id_producto) REFERENCES producto(id);


CREATE TABLE linea (
	id bigint NOT NULL,
	id_producto bigint NOT NULL,
	nombreLinea character varying(255) NOT NULL,
	tasaFabricacion bigint NOT NULL
);

ALTER TABLE public.linea OWNER TO postgres;


ALTER TABLE ONLY linea
    ADD CONSTRAINT pk_linea PRIMARY KEY (id);

ALTER TABLE ONLY linea
    ADD CONSTRAINT fk_producto FOREIGN KEY (id_producto) REFERENCES producto(id);


REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


