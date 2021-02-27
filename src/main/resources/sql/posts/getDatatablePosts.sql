select
p.idbaiviet postsId,
p.idnguoiquantri managerId,
p.tieude title,
p.noidung content,
p.tacgia author,
p.ngayviet writeDate,
p.ngaycapnhat updateTime,
p.hinhanh picture,
p.trangthai status
from posts p
where 1 = 1