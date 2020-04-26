CREATE SCHEMA IF NOT EXISTS `SEAT` DEFAULT CHARACTER SET utf8 ;
use Seat;
-- -----------------------------------------------------
-- Table `Seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Seat`.`Seat` (
  `Seat_ID` INT NOT NULL,
  `IS_empty` INT NOT NULL,
  `reamain_time` Time,
  PRIMARY KEY (`Seat_ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



insert into Seat values 
(1,0,"11:30:00"),
(2,0,"01:30:00"),
(3,1,NULL),
(4,1,NULL),
(5,1,NULL),
(6,1,NULL),
(7,0,"11:30:00"),
(8,0,"7:30:00"),
(9,0,"5:00:00"),
(10,1,NULL),
(11,1,NULL),
(12,1,NULL),
(13,1,NULL),
(14,0,"1:27:00"),
(15,0,"3:13:00"),
(16,0,"4:22:00"),
(17,0,"0:30:00"),
(18,0,"0:27:00"),
(19,1,NULL),
(20,1,NULL),
(21,1,NULL),
(22,1,NULL),
(23,1,NULL),
(24,0,"3:29:00"),
(25,0,"6:17:00"),
(26,1,NULL),
(27,1,NULL),
(28,0,"1:29:00"),
(29,1,NULL),
(30,1,NULL);
