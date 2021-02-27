select
	m.idnguoiquantri managerId,
	m.password password,
	m.hoten fullName,
	m.sodienthoai phoneNumber,
	m.email email,
	m.cccd identityCard,
	m.ngaysinh dateOfBirth,
	m.diachi address,
	m.chucvu roleCode,
	m.trangthai status
from
	manager m
where
	1 = 1