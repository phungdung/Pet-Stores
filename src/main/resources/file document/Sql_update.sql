CREATE DATABASE `pet_rescue_center` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- Bảng thông tin người dùng
CREATE TABLE pet_rescue_center.`member` (
	idkhachhang BIGINT(20) auto_increment NOT NULL COMMENT 'id khách hàng',
	password varchar(100) NOT NULL COMMENT 'mật khẩu người dùng(mã hóa)',
	hoten varchar(50) NOT NULL COMMENT 'Họ tên',
	sodienthoai varchar(20) NOT NULL COMMENT 'số điện thoại',
	email varchar(20) NOT NULL COMMENT 'địa chỉ thư điện tử',
	ngaysinh DATE NULL COMMENT 'Ngày sinh',
	diachi varchar(100) NOT NULL COMMENT 'địa chỉ',
	trangthai varchar(20) NULL COMMENT 'trạng thái',
	CONSTRAINT member_pk PRIMARY KEY (idkhachhang)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='bảng thông tin người dùng';

-- Bảng thông tin người quản trị
CREATE TABLE pet_rescue_center.manager (
	idnguoiquantri BIGINT(20) auto_increment NOT NULL COMMENT 'id người quản trị',
	password varchar(100) NOT NULL COMMENT 'mật khẩu người dùng(mã hóa)',
	hoten varchar(50) NOT NULL COMMENT 'Họ tên',
	sodienthoai varchar(20) NOT NULL COMMENT 'số điện thoại',
	email varchar(20) NOT NULL COMMENT 'địa chỉ thư điện tử',
	cccd varchar(20) NULL COMMENT 'CCCD',
	ngaysinh DATE NULL COMMENT 'Ngày sinh',
	diachi varchar(100) NOT NULL COMMENT 'địa chỉ',
	chucvu varchar(20) NOT NULL COMMENT 'mã quyền/chức vụ',
	trangthai varchar(20) NULL COMMENT 'trạng thái',
	CONSTRAINT manager_pk PRIMARY KEY (idnguoiquantri)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='bảng thông tin người quản trị';

-- Bảng thông tin đơn nhận nuôi
CREATE TABLE pet_rescue_center.`order` (
	iddonnhannuoi BIGINT(20) auto_increment NOT NULL COMMENT 'id đơn nhân nuôi',
	idkhachhang BIGINT(20) NOT NULL COMMENT 'id khách hàng',
	idnguoiquantri BIGINT(20) NOT NULL COMMENT 'id người quản trị',
	idvatnuoi BIGINT(20) NOT NULL COMMENT 'id vật nuôi',
	lydo VARCHAR(200) NOT NULL COMMENT 'Lý do',
	khaibaodieukien VARCHAR(200) NOT NULL COMMENT 'khai báo điều kiện',
	ngayguidon DATETIME NOT NULL COMMENT 'Ngày gửi đơn',
	ngayduyetnuoi DATETIME NOT NULL COMMENT 'ngày duyệt nuôi',
	ngaygiaovatnuoi DATETIME NOT NULL COMMENT 'ngày giao vật nuôi',
	trangthai VARCHAR(100) NOT NULL COMMENT 'trạng thái',
	CONSTRAINT order_pk PRIMARY KEY (iddonnhannuoi)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Bảng thông tin đơn nhận nuôi';



-- Bảng Vật nuôi
CREATE TABLE pet_rescue_center.pet (
	idvatnuoi BIGINT(20) auto_increment NOT NULL COMMENT 'id vật nuôi',
	idloaivatnuoi BIGINT(20) NOT NULL COMMENT 'id loại vật nuôi',
	idnguoiquantri BIGINT(20) NOT NULL COMMENT 'id người quản trị',
	tenvatnuoi varchar(50) NOT NULL COMMENT 'tên vật nuôi',
	hinhanh varchar(50) NOT NULL COMMENT 'hình ảnh',
	tengiong varchar(50) NULL COMMENT 'tên giống',
	tuoi varchar(50) NOT NULL COMMENT 'tuổi',
	gioitinh varchar(50) NOT NULL COMMENT 'giới tính',
	cannang varchar(50) NOT NULL COMMENT 'cân nặng',
	mausac varchar(50) NULL COMMENT 'màu sắc',
	datiemphong Int(10) NOT NULL COMMENT 'đã tiêm phòng',
	datrietsan Int(10) NOT NULL COMMENT 'đã triệt sản',
	ngaythemvao DATETIME NOT NULL COMMENT 'ngày thêm vào',
	ngaycapnhat DATETIME NULL COMMENT 'ngày cập nhật',
	thongtinthem TEXT(500) NOT NULL COMMENT 'thông tin thêm',
	trangthai varchar(100) NOT NULL COMMENT 'trạng thái',
	CONSTRAINT members_pk PRIMARY KEY (idvatnuoi)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='bảng thông tin vật nuôi';


-- bảng loại vật nuôi
CREATE TABLE pet_rescue_center.pet_type (
	idloaivatnuoi BIGINT(20) auto_increment NOT NULL COMMENT 'id loại vật nuôi',
	tenloaivatnuoi varchar(100) NOT NULL COMMENT 'tên loại vật nuôi',
	CONSTRAINT pet_type_pk PRIMARY KEY (idloaivatnuoi)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='bảng loại vật nuôi';

-- Bảng thông tin bài viết
CREATE TABLE pet_rescue_center.posts (
	idbaiviet BIGINT(20) auto_increment NOT NULL COMMENT 'id bài viết',
	tieude varchar(100) NOT NULL COMMENT 'tiêu đề',
	noidung TEXT(1000) NOT NULL COMMENT 'Nội dung',
	tacgia varchar(50) NOT NULL COMMENT 'tác giả',
	idnguoiquantri BIGINT(20) NOT NULL COMMENT 'id người quản trị',
	ngayviet DATETIME NOT NULL COMMENT 'ngày viết',
	ngaycapnhat DATETIME NULL COMMENT 'ngày cập nhật',
	hinhanh varchar(100) NOT NULL COMMENT 'hình ảnh',
	trangthai varchar(100) NOT NULL COMMENT 'trạng thái',
	CONSTRAINT posts_pk PRIMARY KEY (idbaiviet)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Bảng thông tin bài viết';


