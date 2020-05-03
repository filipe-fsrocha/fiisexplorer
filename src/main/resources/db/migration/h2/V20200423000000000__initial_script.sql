-- Create tables
CREATE TABLE users (
  id UUID PRIMARY KEY,
  fullname VARCHAR (255),
  username VARCHAR (255),
  email VARCHAR (255),
  password VARCHAR (255),
  confirm_email BOOLEAN DEFAULT FALSE,
  change_password BOOLEAN DEFAULT FALSE,
  UNIQUE(username, email)
);

CREATE TABLE fii (
  id UUID PRIMARY KEY,
  symbol VARCHAR (20),
  name VARCHAR (255),
  administrator VARCHAR (255),
  update_at TIMESTAMP DEFAULT NOW(),
UNIQUE(symbol)
);

CREATE TABLE indicators (
  id UUID PRIMARY KEY,
  fii_id UUID,
  daily_liquidity BIGINT,
  last_yield DECIMAL,
  dividend_yield DECIMAL,
  net_worth VARCHAR (255),
  equity_value DECIMAL,
  profitability_month DECIMAL,
  pvp DECIMAL,
  price DECIMAL,
  percentage DECIMAL,
  UNIQUE(fii_id)
);

CREATE TABLE assets_fiis (
  id UUID PRIMARY KEY,
  fii_id UUID,
  name VARCHAR (255),
  address VARCHAR (255),
  neighborhood VARCHAR (255),
  city VARCHAR (255),
  gross_leasable_area VARCHAR (255)
);

CREATE TABLE dividends (
  id UUID PRIMARY KEY,
  fii_id UUID,
  earnings VARCHAR (255),
  last_month VARCHAR (255),
  three_months VARCHAR (255),
  six_months VARCHAR (255),
  twelve_months VARCHAR (255),
  since_ipo VARCHAR (255),
  UNIQUE(fii_id)
);

CREATE TABLE basic_information (
  id UUID PRIMARY KEY,
  fii_id UUID,
  company_name VARCHAR (255),
  fund_construction_date VARCHAR (255),
  quota_issued VARCHAR (255),
  initial_equity VARCHAR (255),
  initial_quota_value VARCHAR (255),
  type_management VARCHAR (255),
  rate_performance VARCHAR (255),
  rate_management VARCHAR (255),
  cnpj VARCHAR (255),
  public_something VARCHAR (255),
  mandate VARCHAR (255),
  followup VARCHAR (255),
  duration VARCHAR (255),
  rate_administration VARCHAR (255),
  rate_of_management VARCHAR (255),
  rate_consulting VARCHAR (255),
  UNIQUE(fii_id)
);

-- Constraints foreign key
ALTER TABLE indicators ADD CONSTRAINT fii_fk FOREIGN KEY (fii_id) REFERENCES fii(id);
ALTER TABLE basic_information ADD CONSTRAINT fii_fk FOREIGN KEY (fii_id) REFERENCES fii(id);
ALTER TABLE dividends ADD CONSTRAINT fii_fk FOREIGN KEY (fii_id) REFERENCES fii(id);
ALTER TABLE assets_fiis ADD CONSTRAINT fii_fk FOREIGN KEY (fii_id) REFERENCES fii(id);
