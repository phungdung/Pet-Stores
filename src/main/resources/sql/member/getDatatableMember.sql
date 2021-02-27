select
	m.idkhachhang userId,
	m.password password,
	m.hoten fullName,
	m.sodienthoai phoneNumber,
	m.email email,
	m.ngaysinh dateOfBirth,
	m.diachi address,
	m.trangthai status
from
	`member` m
where
	1 = 1