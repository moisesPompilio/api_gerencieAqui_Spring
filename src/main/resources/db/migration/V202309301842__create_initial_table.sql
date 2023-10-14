CREATE EXTENSION "uuid-ossp";

CREATE TABLE tax_name (
    id UUID PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE tax (
    id UUID PRIMARY KEY,
    data DATE NOT NULL,
    percentual DOUBLE PRECISION NOT NULL,
    tax_name_id UUID NOT NULL,
    FOREIGN KEY (tax_name_id) REFERENCES tax_name(id)
);

CREATE TABLE salario (
    id UUID PRIMARY KEY,
    data DATE NOT NULL,
    valor FLOAT NOT NULL
);

CREATE TABLE reajuste (
    id UUID PRIMARY KEY,
    data DATE NOT NULL,
    reajuste_acumulado DOUBLE PRECISION NOT NULL
);

CREATE TABLE beneficios (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    salario_13 BOOLEAN NOT NULL,
    inacumulavel VARCHAR[] NOT NULL,
    dif BOOLEAN NOT NULL
);

CREATE TYPE tax_type AS ENUM (
    'CORRECTION',
    'INTEREST'
);

CREATE TABLE tax_rate (
    id UUID PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    type tax_type NOT NULL,
    rate_timeline JSONB NOT NULL
);