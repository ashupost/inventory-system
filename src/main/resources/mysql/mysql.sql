/*
SQLyog - Free MySQL GUI v5.17
Host - 5.6.19 : Database - mhtsoft1_swing
*********************************************************************
Server version : 5.6.19
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `mhtsoft1_swing`;

USE `mhtsoft1_swing`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `tbladjustment` */

DROP TABLE IF EXISTS `tbladjustment`;

CREATE TABLE `tbladjustment` (
  `AdjustmentIndex` int(11) NOT NULL AUTO_INCREMENT,
  `AdjustmentNo` varchar(100) DEFAULT NULL,
  `ItemIndex` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `QtyOnHand` int(11) DEFAULT NULL,
  `PhysicalCount` int(11) DEFAULT NULL,
  `Adj+` int(11) DEFAULT NULL,
  `Adj-` int(11) DEFAULT NULL,
  `UpdatedQtyOnHand` int(11) DEFAULT NULL,
  PRIMARY KEY (`AdjustmentIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `tblcarrier` */

DROP TABLE IF EXISTS `tblcarrier`;

CREATE TABLE `tblcarrier` (
  `CarrierIndex` int(11) NOT NULL AUTO_INCREMENT,
  `CompanyName` varchar(100) DEFAULT NULL,
  `Phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CarrierIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `tblcategory` */

DROP TABLE IF EXISTS `tblcategory`;

CREATE TABLE `tblcategory` (
  `CategoryIndex` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(100) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CategoryIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `tblcountry` */

DROP TABLE IF EXISTS `tblcountry`;

CREATE TABLE `tblcountry` (
  `Name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `tblcustomer` */

DROP TABLE IF EXISTS `tblcustomer`;

CREATE TABLE `tblcustomer` (
  `CustomerIndex` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` varchar(100) DEFAULT NULL,
  `CompanyName` varchar(100) DEFAULT NULL,
  `ContactName` varchar(100) DEFAULT NULL,
  `ContactTitle` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `CityTown` varchar(100) DEFAULT NULL,
  `StateProvince` varchar(100) DEFAULT NULL,
  `ZipCode` varchar(100) DEFAULT NULL,
  `Country` varchar(100) DEFAULT NULL,
  `Phone` varchar(100) DEFAULT NULL,
  `Fax` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CustomerIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

/*Table structure for table `tblexpense` */

DROP TABLE IF EXISTS `tblexpense`;

CREATE TABLE `tblexpense` (
  `ExpenseIndex` int(11) NOT NULL AUTO_INCREMENT,
  `ExpenseNo` varchar(100) DEFAULT NULL,
  `Purpose` varchar(100) DEFAULT NULL,
  `ApprovedBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ExpenseIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `tblexpensedetails` */

DROP TABLE IF EXISTS `tblexpensedetails`;

CREATE TABLE `tblexpensedetails` (
  `ExpenseIndex` int(11) DEFAULT NULL,
  `ExpenseFor` varchar(100) DEFAULT NULL,
  `Qty` int(11) DEFAULT NULL,
  `UnitMeasure` varchar(100) DEFAULT NULL,
  `Cost` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `tblinvoice` */

DROP TABLE IF EXISTS `tblinvoice`;

CREATE TABLE `tblinvoice` (
  `InvoiceIndex` int(11) NOT NULL AUTO_INCREMENT,
  `InvoiceNo` varchar(100) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `CustomerIndex` int(11) DEFAULT NULL,
  `ShipToAddress` varchar(100) DEFAULT NULL,
  `ShipToCityTown` varchar(100) DEFAULT NULL,
  `ShipToStateProvince` varchar(100) DEFAULT NULL,
  `ShipToZipCode` varchar(100) DEFAULT NULL,
  `ShipToCountry` varchar(100) DEFAULT NULL,
  `ShipViaCarrierIndex` int(11) DEFAULT NULL,
  `ShippingFee` int(11) DEFAULT NULL,
  `Others` int(11) DEFAULT NULL,
  `SalesRepIndex` int(11) DEFAULT NULL,
  `ApproveBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`InvoiceIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `tblinvoicedetails` */

DROP TABLE IF EXISTS `tblinvoicedetails`;

CREATE TABLE `tblinvoicedetails` (
  `InvoiceIndex` int(11) DEFAULT NULL,
  `ItemIndex` int(11) DEFAULT NULL,
  `QtyPurchased` int(11) DEFAULT NULL,
  `UnitCost` int(11) DEFAULT NULL,
  `SalesPrice` int(11) DEFAULT NULL,
  `Discount%` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `tblitem` */

DROP TABLE IF EXISTS `tblitem`;

CREATE TABLE `tblitem` (
  `ItemIndex` int(11) NOT NULL AUTO_INCREMENT,
  `ItemNo` varchar(100) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `LongDescription` varchar(100) DEFAULT NULL,
  `CategoryIndex` int(11) DEFAULT NULL,
  `SupplierIndex` int(11) DEFAULT NULL,
  `QuantityPerUnit` varchar(100) DEFAULT NULL,
  `UnitMeasure` varchar(100) DEFAULT NULL,
  `UnitCost` int(11) DEFAULT NULL,
  `SalesPrice` int(11) DEFAULT NULL,
  `QtyOnHand` int(11) DEFAULT NULL,
  `QtyOnOrder` int(11) DEFAULT NULL,
  `ReOrderLevel` int(11) DEFAULT NULL,
  `WarehouseIndex` int(11) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL,
  `Active` int(11) DEFAULT NULL,
  PRIMARY KEY (`ItemIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `tblpo` */

DROP TABLE IF EXISTS `tblpo`;

CREATE TABLE `tblpo` (
  `POIndex` int(11) NOT NULL AUTO_INCREMENT,
  `PONo` varchar(100) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `SupplierIndex` int(11) DEFAULT NULL,
  `ShipFromAddress` varchar(100) DEFAULT NULL,
  `ShipFromCityTown` varchar(100) DEFAULT NULL,
  `ShipFromStateProvince` varchar(100) DEFAULT NULL,
  `ShipFromZipCode` varchar(100) DEFAULT NULL,
  `ShipFromCountry` varchar(100) DEFAULT NULL,
  `ShipViaCarrierIndex` int(11) DEFAULT NULL,
  `ShippingFee` int(11) DEFAULT NULL,
  `Others` int(11) DEFAULT NULL,
  `ApproveBy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`POIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `tblpodetails` */

DROP TABLE IF EXISTS `tblpodetails`;

CREATE TABLE `tblpodetails` (
  `POIndex` int(11) DEFAULT NULL,
  `ItemIndex` int(11) DEFAULT NULL,
  `QtyPurchased` int(11) DEFAULT NULL,
  `UnitCost` int(11) DEFAULT NULL,
  `Discount%` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `tblpr` */

DROP TABLE IF EXISTS `tblpr`;

CREATE TABLE `tblpr` (
  `PRIndex` int(11) NOT NULL AUTO_INCREMENT,
  `PRNumber` varchar(110) DEFAULT NULL,
  `FromPOIndex` int(11) DEFAULT NULL,
  `DateRecieve` date DEFAULT NULL,
  `ApprovedBy` varchar(110) DEFAULT NULL,
  PRIMARY KEY (`PRIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `tblsalesrep` */

DROP TABLE IF EXISTS `tblsalesrep`;

CREATE TABLE `tblsalesrep` (
  `SalesRepIndex` int(11) NOT NULL AUTO_INCREMENT,
  `SalesRepID` varchar(100) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `CityTown` varchar(100) DEFAULT NULL,
  `StateProvince` varchar(100) DEFAULT NULL,
  `ZipCode` varchar(100) DEFAULT NULL,
  `ContactNo` varchar(100) DEFAULT NULL,
  `EmerContactNo` varchar(100) DEFAULT NULL,
  `EmerContactName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`SalesRepIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Table structure for table `tblsupplier` */

DROP TABLE IF EXISTS `tblsupplier`;

CREATE TABLE `tblsupplier` (
  `SupplierIndex` int(11) NOT NULL AUTO_INCREMENT,
  `SupplierID` varchar(100) DEFAULT NULL,
  `CompanyName` varchar(100) DEFAULT NULL,
  `ContactName` varchar(100) DEFAULT NULL,
  `ContactTitle` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `CityTown` varchar(100) DEFAULT NULL,
  `StateProvince` varchar(100) DEFAULT NULL,
  `ZipCode` varchar(100) DEFAULT NULL,
  `Country` varchar(100) DEFAULT NULL,
  `Phone` varchar(100) DEFAULT NULL,
  `Fax` varchar(100) DEFAULT NULL,
  `Website` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`SupplierIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Table structure for table `tblwarehouse` */

DROP TABLE IF EXISTS `tblwarehouse`;

CREATE TABLE `tblwarehouse` (
  `WarehouseIndex` int(11) NOT NULL AUTO_INCREMENT,
  `WarehouseID` varchar(100) DEFAULT NULL,
  `WarehouseName` varchar(100) DEFAULT NULL,
  `ContactPerson` varchar(100) DEFAULT NULL,
  `ContactTitle` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `CityTown` varchar(100) DEFAULT NULL,
  `StateProvince` varchar(100) DEFAULT NULL,
  `ZipCode` varchar(100) DEFAULT NULL,
  `Phone` varchar(100) DEFAULT NULL,
  `Fax` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`WarehouseIndex`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
