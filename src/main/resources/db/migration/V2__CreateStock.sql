CREATE TABLE products_stock (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  variant TEXT NOT NULL,
  quantity INTEGER NOT NULL,
  products_id UUID NOT NULL,
  CONSTRAINT fk_productsid FOREIGN KEY (products_id)
    REFERENCES products (id)
    ON DELETE CASCADE
);


CREATE TABLE movements_products (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  insert_product boolean NOT NULL,
  quantity INTEGER NOT NULL,
  products_stock_id UUID NOT NULL,
  CONSTRAINT fk_products_stockid FOREIGN KEY (products_stock_id)
    REFERENCES products_stock (id)
    ON DELETE CASCADE
);

CREATE TABLE product_movement_details (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  price_products FLOAT NOT NULL,
  price_discount FLOAT NOT NULL,
  price_freight FLOAT NOT NULL,
  movements_products_id UUID NOT NULL,
  created DATE NOT NULL DEFAULT current_date,
  CONSTRAINT fk_movements_productsid FOREIGN KEY (movements_products_id)
    REFERENCES movements_products (id)
    ON DELETE CASCADE
);


