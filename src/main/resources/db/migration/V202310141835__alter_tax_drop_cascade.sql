ALTER TABLE tax
ADD CONSTRAINT fk_tax_name_id
FOREIGN KEY (tax_name_id)
REFERENCES tax_name(id)
ON DELETE CASCADE;