CREATE TABLE `signup2` (
  `form_no` varchar(45) NOT NULL,
  `religion` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `income` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `pan` varchar(45) DEFAULT NULL,
  `aadhar` varchar(45) DEFAULT NULL,
  `seniorcitizen` varchar(45) DEFAULT NULL,
  `existing_account` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`form_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci