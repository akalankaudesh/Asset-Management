CREATE DATABASE Assets_Management;


CREATE TABLE Asset_Types(
  type_id VARCHAR(10) NOT NULL ,
  type_name VARCHAR(25) NOT NULL ,
  type_description VARCHAR(50) NULL ,
  CONSTRAINT PRIMARY KEY (type_id)
);
# DROP TABLE Asset_Types;

CREATE TABLE Department(
  dep_id VARCHAR(10) NOT NULL ,
  dep_name VARCHAR(35) NOT NULL ,
  dep_description VARCHAR(50) NULL ,
  CONSTRAINT PRIMARY KEY (dep_id)
);

CREATE TABLE vendor(
  vendor_id VARCHAR(10) NOT NULL,
  venodr_name VARCHAR(20) NOT NULL ,
  venodr_telephone INT(10) NULL,
  venodr_email VARCHAR(50),
  CONSTRAINT PRIMARY KEY (vendor_id)
);

CREATE TABLE Assets (
  asset_id INT AUTO_INCREMENT NOT NULL ,
  asset_type VARCHAR(10) NOT NULL ,
  asset_description VARCHAR(60) NOT NULL ,
  asset_department VARCHAR(10) NOT NULL ,
  asset_vendor VARCHAR(10) NOT NULL ,
  asset_model VARCHAR(30) NULL ,
  asset_brand VARCHAR(20) NULL,
  asset_price DOUBLE(10,2) NOT NULL ,
  asset_date DATE NULL,
  CONSTRAINT pk_assets PRIMARY KEY (asset_id),
  CONSTRAINT fk_department FOREIGN KEY (asset_department) REFERENCES department (dep_id),
  CONSTRAINT fk_asset_type FOREIGN KEY (asset_type) REFERENCES asset_types(type_id),
  CONSTRAINT fk_vendor FOREIGN KEY (asset_vendor) REFERENCES vendor(vendor_id)
);

DROP TABLE Assets;

CREATE TABLE employee(
  emp_id INT AUTO_INCREMENT NOT NULL ,
  emp_name VARCHAR(25) NOT NULL ,
  emp_department VARCHAR(10) NOT NULL ,
  emp_address VARCHAR(50) NOT NULL,
  emp_telephone INT(10) ,
  emp_monthly_salary DOUBLE(10,2) NOT NULL ,
  CONSTRAINT PRIMARY KEY (emp_id),
  CONSTRAINT fk_emp_department FOREIGN KEY (emp_department) REFERENCES department(dep_id)
);

CREATE TABLE service(
  service_id INT AUTO_INCREMENT NOT NULL,
  asset_name INT NOT NULL ,
  service_description VARCHAR(50) NULL ,
  service_date DATE NULL ,
  service_cost DOUBLE(10,2),
  CONSTRAINT PRIMARY KEY (service_id),
  CONSTRAINT fk_asset_service FOREIGN KEY (asset_name) REFERENCES assets(asset_id)
);
