use master 
go
create database QLBanHang
go
use QLBanHang
go
create table NhanVien(
	MaNV int identity(1,1) primary key,
	TenNhanVien nvarchar(50),
	NgaySinh DateTime,
	DiaChi nvarchar(50),
	SoDienThoai varchar(12),
	GioiTinh nvarchar(10)
)
go
create table SanPham(
	MaSP int identity(1,1) primary key,
	TenSP nvarchar(50),
	DonViTinh nvarchar (50),
	Gia money
)
go
create table HoaDon(
	MaHD int identity(1,1) primary key,
	MaNV int,
	LoaiHD nvarchar(20),
	NgayLap Datetime,
	NgayGiaoNhan Datetime,
	DienGiai nvarchar(60),
	constraint fk_nv foreign key (MaNV ) references NhanVien(MaNV)
)
create table ChiTietHoaDon(
MaHD int,
MaSP int,
SoLuong int,
constraint pk primary key (MaHD, MaSP),
constraint fkhd foreign key (MaHD ) references HoaDon(MaHD),
constraint fksp foreign key (MaSP ) references SanPham(MaSP)
)
go
insert into NhanVien values 
(N'Nhân Viên 1',N'2000-01-01',N'Hà Nội','0984987103','Nam'), 
(N'Nhân Viên 2',N'2000-01-01',N'Hà Nội','0123456789','Nam'),
(N'Nhân Viên 3',N'2021-01-01',N'Hà Nội','0123456789',N'Nữ'),
(N'Nhân Viên 4',N'2021-01-01',N'Hà Nội','0123456789',N'Nữ'),
(N'Nhân Viên 5',N'2021-01-01',N'Hà Nội','0123456789',N'Nữ');
go
insert into SanPham values
(N'Điện thoại 1',N'Chiếc',20000000),
(N'Điện thoại 2',N'Chiếc',15000000)
go
insert into HoaDon values 
(1,N'Xuất','2021-01-01','2021-01-01',N'Diễn dải 1'),
(2,N'Nhập','2021-01-01','2021-01-01',N'Diễn dải 2');
go
insert into ChiTietHoaDon values 
(1,1,5),
(2,2,5), 
(2,1,10), 
(3,2,10);
go
select * from NhanVien
select * from SanPham
select * from HoaDon
select * from ChiTietHoaDon
