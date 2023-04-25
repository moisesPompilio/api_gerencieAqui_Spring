CREATE EXTENSION "uuid-ossp";

CREATE TABLE categories (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  name TEXT UNIQUE NOT NULL,
  url_photo TEXT
);

CREATE TABLE products (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  name TEXT UNIQUE NOT NULL,
  description TEXT,
  url_photo TEXT,
  price FLOAT NOT NULL,
  categories_id UUID NOT NULL,
  CONSTRAINT fk_categoriesid FOREIGN KEY (categories_id)
    REFERENCES categories (id)
    ON DELETE CASCADE
);
