CREATE OR REPLACE FUNCTION update_product_stock()
  RETURNS TRIGGER AS $$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    UPDATE products_stock
    SET quantity = quantity + NEW.quantity
    WHERE id = NEW.products_stock_id;
  ELSIF (TG_OP = 'UPDATE') THEN
    DECLARE
      difference INTEGER := NEW.quantity - OLD.quantity;
    BEGIN
      UPDATE products_stock
      SET quantity = quantity + difference
      WHERE id = NEW.products_stock_id;
    END;
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_product_stock
AFTER INSERT OR UPDATE ON movements_products
FOR EACH ROW
EXECUTE FUNCTION update_product_stock();
