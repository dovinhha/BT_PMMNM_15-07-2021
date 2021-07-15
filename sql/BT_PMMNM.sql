use master 
go
create database PMMNM1
go
use PMMNM1
go
create table LoaiSanPham(
	MaLoaiSP int identity(1,1) primary key,
	TenLoaiSP nvarchar(50)
)
go
create table SanPham(
	MaSP int identity(1,1) primary key,
	TenSP nvarchar(50),
	NhaSanXuat nvarchar (50),
	MaLoaiSP int,
	constraint fk foreign key (MaLoaiSP) references LoaiSanPham(MaLoaiSP)
)

go
insert into LoaiSanPham values 
(N'Máy tính'), 
(N'Điện thoại') 
go 

insert into SanPham values 
(N'Sản phẩm 1', 'NSX1',1), 
(N'Sản phẩm 2', 'NSX2',1), 
(N'Sản phẩm 3', 'NSX3',1), 
(N'Sản phẩm 4', 'NSX4',1);
go
select * from LoaiSanPham
select * from SanPham