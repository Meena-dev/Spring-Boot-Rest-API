CREATE TABLE IF NOT EXISTS products (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) DEFAULT NULL,
  currentPrice BigDecimal DEFAULT NULL,
  lastUpdate datetime DEFAULT NULL,
  description varchar(500) DEFAULT NULL
);
