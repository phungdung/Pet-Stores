CREATE DATABASE `pet_rescue_center` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- Bảng thông tin người dùng
CREATE TABLE pet_rescue_center.members (
	user_id BIGINT(20) auto_increment NOT NULL COMMENT 'id người dùng',
	username varchar(20) NOT NULL COMMENT 'tên đăng nhập',
	password varchar(100) NOT NULL COMMENT 'mật khẩu người dùng(mã hóa)',
	full_name varchar(50) NOT NULL COMMENT 'Họ tên',
	phone_number varchar(20) NOT NULL COMMENT 'số điện thoại',
	email varchar(20) NOT NULL COMMENT 'địa chỉ thư điện tử',
	identity_card varchar(20) NULL COMMENT 'số thẻ CMTND/CCCD',
	date_of_birth DATE NULL COMMENT 'Ngày sinh',
	address varchar(100) NOT NULL COMMENT 'địa chỉ',
	role_code varchar(20) NOT NULL COMMENT 'mã quyền/chức vụ',
	status varchar(20) NULL COMMENT 'trạng thái',
	CONSTRAINT members_pk PRIMARY KEY (user_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='bảng thông tin người dùng';

-- Bảng Vật nuôi
CREATE TABLE pet_rescue_center.pets (
	pet_id BIGINT(20) auto_increment NOT NULL COMMENT 'id vật nuôi',
	username varchar(20) NOT NULL COMMENT 'tên đăng nhập',
	password varchar(100) NOT NULL COMMENT 'mật khẩu người dùng(mã hóa)',
	full_name varchar(50) NOT NULL COMMENT 'Họ tên',
	phone_number varchar(20) NOT NULL COMMENT 'số điện thoại',
	email varchar(20) NOT NULL COMMENT 'địa chỉ thư điện tử',
	identity_card varchar(20) NULL COMMENT 'số thẻ CMTND/CCCD',
	date_of_birth DATE NULL COMMENT 'Ngày sinh',
	address varchar(100) NOT NULL COMMENT 'địa chỉ',
	role_code varchar(20) NOT NULL COMMENT 'mã quyền/chức vụ',
	status varchar(20) NULL COMMENT 'trạng thái',
	CONSTRAINT members_pk PRIMARY KEY (user_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='bảng thông tin người dùng';

