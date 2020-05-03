INSERT INTO fii (id, symbol, administrator, update_at) VALUES ('383a7eaa-8ced-41d6-9363-7e247d7e3f59', 'ABCP11', 'Rio Bravo', '2020-04-26 16:13:27');

INSERT INTO indicators (id, fii_id, daily_liquidity, last_yield, dividend_yield, net_worth, equity_value, profitability_month, pvp, price, percentage) VALUES
('f0c61779-359e-42de-b375-2921b762af36', '383a7eaa-8ced-41d6-9363-7e247d7e3f59', 3032, 0.0, 0.0, '1 bi', 85.43, -19.47, 0.98, 84.0, -0.13);

INSERT INTO basic_information(id, fii_id, company_name, fund_construction_date, quota_issued, initial_equity, initial_quota_value, type_management, rate_performance, rate_management, cnpj, public_something, mandate, followup, duration, rate_administration, rate_of_management, rate_consulting) VALUES
('f0c61779-359e-42de-b375-2921b762af36', '383a7eaa-8ced-41d6-9363-7e247d7e3f59', 'FDO INV IMOB GRAND PLAZA SHOPPING', 'N/A', '1.000.000', 'R$ 1.000.000,00', 'R$ 1,00', 'Passiva', 'N/A', 'N/A', '01.201.140/0001-90', 'Investidores em Geral', 'Renda', 'Shoppings', 'Indeterminado', 'R$ 42.402 ao mês, atualizado anualmente pelo IGP-M.', 'N/A', 'N/A');

INSERT INTO dividends (id, fii_id, earnings , last_month , three_months , six_months , twelve_months , since_ipo) VALUES ('f0c61779-359e-42de-b375-2921b762af36', '383a7eaa-8ced-41d6-9363-7e247d7e3f59', 'Retorno por cota|Em relação ao valor de cota atual', 'R$ 0,0000|0,00%', 'R$ 1,3200|1,57%', 'R$ 2,7900|3,32%', 'R$ 5,5700|6,63%', 'R$ 57,1460|68,03%');

INSERT INTO assets_fiis (id, fii_id, name, address, neighborhood, city, gross_leasable_area) VALUES('f0c61779-359e-42de-b375-2921b762af36', '383a7eaa-8ced-41d6-9363-7e247d7e3f59', 'Grand Plaza Shopping', 'Av. Industrial, 600', 'Tamanduateí 3', 'Santo André - SP', '69.628,00 m2');