select
p.idvatnuoi petId,
p.idloaivatnuoi petTypeId,
p.idnguoiquantri managerId,
p.tenvatnuoi petName,
p.hinhanh picture,
p.tengiong genusName,
p.tuoi age,
p.gioitinh gender,
p.cannang weight,
p.mausac color,
p.datiemphong vaccination,
p.datrietsan sterilization,
p.ngaythemvao createTime,
p.ngaycapnhat updateTime,
p.thongtinthem moreInformation,
p.trangthai status
from pet p
where 1 = 1