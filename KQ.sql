CREATE DATABASE Khan_Choang_03
GO

USE Khan_Choang_03
GO
CREATE TABLE Users(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20),
	Ten NVARCHAR(50),
	Email NVARCHAR(50),
	Pass VARCHAR(30),
	Roles int
)
GO
--ThuongHieu
CREATE TABLE ThuongHieu(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(30)
)
GO

--MauSac
CREATE TABLE MauSac(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(30)
)
GO

--ChatLieu
CREATE TABLE ChatLieu(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(30)
)
GO

--Loai
CREATE TABLE Loai(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(30)
)
GO



--ChucVu
CREATE TABLE ChucVu(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(30)
)
GO

--NhanVien
CREATE TABLE NhanVien(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(30) DEFAULT NULL,
	DiaChi NVARCHAR(100) DEFAULT NULL,
	Sdt VARCHAR(30) DEFAULT NULL,
	MatKhau VARCHAR(MAX) DEFAULT NULL,	
	IdCV INT,
	TrangThai INT DEFAULT 0
)
GO
--SanPham
CREATE TABLE SanPham(
    Id INT PRIMARY KEY IDENTITY(1,1),
	MaSP VARCHAR(10) UNIQUE,
	TenSP NVARCHAR(150),
	IdThuongHieu INT,
	IdMauSac INT,
	IdChatLieu INT, 
	IdLoai INT,
	SoLuong INT,
	GiaNhap DECIMAL(20,0) DEFAULT 0,
	GiaBan DECIMAL(20,0) DEFAULT 0,
	TrangThai INT,
	MoTa NVARCHAR(150),
	NgayNhap DATE DEFAULT NULL,
)
GO

--KhachHang
CREATE TABLE KhachHang(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Ma VARCHAR(20) UNIQUE,
	Ten NVARCHAR(50),
	Sdt VARCHAR(30) DEFAULT NULL,
	DiaChi NVARCHAR(100) DEFAULT NULL,
	MatKhau VARCHAR(MAX) DEFAULT NULL
)
GO
CREATE TABLE GioHang(
	Id INT PRIMARY KEY IDENTITY(1,1),
	IdKH INT,
	IdNV INT,
	Ma VARCHAR(20) UNIQUE,
	NgayTao DATE DEFAULT NULL,
	NgayThanhToan DATE DEFAULT NULL,
	TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
	DiaChi NVARCHAR(100) DEFAULT NULL,
	Sdt VARCHAR(30) DEFAULT NULL,
	TinhTrang INT DEFAULT 0,
)
GO
CREATE TABLE GioHangChiTiet (
	Id INT PRIMARY KEY IDENTITY(1,1),
    IdGH INT,
    IdSP INT,
    SoLuong INT,
    DonGia DECIMAL(20, 0) DEFAULT 0,
    DonGiaKhiGiam DECIMAL(20, 0) DEFAULT 0,
  
)
GO

CREATE TABLE HoaDon(
	Id INT PRIMARY KEY IDENTITY(1,1),
	IdKH INT,
	IdNV INT,
	Ma VARCHAR(20) UNIQUE,
	NgayTao DATE DEFAULT NULL,
	TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
	DiaChiNhanHang NVARCHAR(100) DEFAULT NULL,
	Sdt VARCHAR(30) DEFAULT NULL,
	TinhTrang INT DEFAULT 0 
)

CREATE TABLE HoaDonChiTiet(
	Id INT PRIMARY KEY IDENTITY(1,1),
	IdHD INT,
	IdSP INT,
	SoLuong INT,
	DonGia DECIMAL(20,0) DEFAULT 0,
)
GO

ALTER TABLE SanPham ADD FOREIGN KEY (IdThuongHieu) REFERENCES ThuongHieu(Id);
ALTER TABLE SanPham ADD FOREIGN KEY (IdMauSac) REFERENCES MauSac(Id);
ALTER TABLE SanPham ADD FOREIGN KEY (IdChatLieu) REFERENCES ChatLieu(Id);
ALTER TABLE SanPham ADD FOREIGN KEY (IdLoai) REFERENCES Loai(Id);
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCV) REFERENCES ChucVu(Id);
ALTER TABLE GioHang ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id);
ALTER TABLE GioHang ADD FOREIGN KEY (IdNV) REFERENCES NhanVien(Id);
ALTER TABLE GioHangChiTiet ADD FOREIGN KEY (IdGH) REFERENCES GioHang(Id);
ALTER TABLE GioHangChiTiet ADD FOREIGN KEY (IdSP) REFERENCES SanPham(Id);
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id);
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNV) REFERENCES NhanVien(Id);
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdHD) REFERENCES HoaDon(Id);
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IdSP) REFERENCES SanPham(Id);


INSERT INTO ThuongHieu (Ma, Ten) VALUES ('TH001', 'ABC Brand');
INSERT INTO ThuongHieu (Ma, Ten) VALUES ('TH002', 'XYZ Brand');
INSERT INTO ThuongHieu (Ma, Ten) VALUES ('TH003', 'DEF Brand');
INSERT INTO ThuongHieu (Ma, Ten) VALUES ('TH004', 'GHI Brand');
INSERT INTO ThuongHieu (Ma, Ten) VALUES ('TH005', 'JKL Brand');

INSERT INTO MauSac (Ma, Ten) VALUES ('MS001', 'Red');
INSERT INTO MauSac (Ma, Ten) VALUES ('MS002', 'Blue');
INSERT INTO MauSac (Ma, Ten) VALUES ('MS003', 'Green');
INSERT INTO MauSac (Ma, Ten) VALUES ('MS004', 'Yellow');
INSERT INTO MauSac (Ma, Ten) VALUES ('MS005', 'Black');


INSERT INTO ChatLieu (Ma, Ten) VALUES ('CL001', N'Vải Lụa');
INSERT INTO ChatLieu (Ma, Ten) VALUES ('CL002', N'Vải Cotton');
INSERT INTO ChatLieu (Ma, Ten) VALUES ('CL003', N'Lông');
INSERT INTO ChatLieu (Ma, Ten) VALUES ('CL004', N'Polyester');
INSERT INTO ChatLieu (Ma, Ten) VALUES ('CL005', N'Cashmere');


INSERT INTO Loai (Ma, Ten) VALUES ('L001', N'Khăn Scarves');
INSERT INTO Loai (Ma, Ten) VALUES ('L002', N'Khăn Shawl');
INSERT INTO Loai (Ma, Ten) VALUES ('L003', N'Khăn pashmina');
INSERT INTO Loai (Ma, Ten) VALUES ('L004', N'Lụa quàng');
INSERT INTO Loai (Ma, Ten) VALUES ('L005', N'Khăn quàng cổ');


INSERT INTO SanPham VALUES ('SP001', 'Khăn choàng A', 1, 1, 1, 1, 35, 100000, 150000, 1, N'Đẹp', '2023-04-20');
INSERT INTO SanPham VALUES ('SP002', N'Khăn choàng B', 2, 2, 2, 2, 50, 120000, 180000, 1, N'Mềm', '2023-03-10');
INSERT INTO SanPham VALUES ('SP003', N'Khăn choàng C', 1, 1, 3, 1, 25, 200000, 320000, 1, N'Giữ ấm', '2023-05-25');
INSERT INTO SanPham VALUES ('SP004', N'Khăn choàng D', 3, 3, 2, 3, 15, 150000, 250000, 0, N'Chống nắng', '2023-05-20');
INSERT INTO SanPham VALUES ('SP005', N'Khăn choàng E', 2, 4, 4, 2, 45, 330000, 420000, 1, N'Bền,đẹp', '2023-05-23');


INSERT INTO ChucVu (Ma, Ten) VALUES ('CV001', N'Quản lý');
INSERT INTO ChucVu (Ma, Ten) VALUES ('CV002', N'Nhân viên bán hàng');

INSERT INTO NhanVien VALUES ('NV001', N'Lê Thị Nga', '789 DEF Street', '0123456789', '12345', 1, 1);
INSERT INTO NhanVien VALUES ('NV002', N'Hoàng Nam Anh', '012 GHI Street', '0987654321', '54321', 2, 1);

INSERT INTO KhachHang (Ma, Ten, Sdt, DiaChi, MatKhau) VALUES
('KH001', N'Nguyễn Văn A', '0987654321', N'Thanh Hoá', 'password123'),
('KH002', N'Trần Thị B', '0123456789', N'Hà Nội', 'pass456'),
('KH003', N'Lê Văn C', '0912345678', N'Thái Bình', 'abc123'),
('KH004', N'Phạm Thị D', '0909090909', N'Hải Phòng', 'pass789'),
('KH005', N'Nguyễn Thị E', '0988888888', N'Nam Định', '123abc');


INSERT INTO GioHang (IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang) VALUES
(1, 1, 'GH001', '2023-05-01', '2023-05-02', N'Nguyễn Văn A', N'Thanh Hoá', '0987654321', 1),
(2, 2, 'GH002', '2023-04-20', '2023-04-22', N'Trần Thị B', N'Hà Nội', '0123456789', 1),
(3, 1, 'GH003', '2023-05-10', '2023-05-12', N'Lê Văn C', N'Thái Bình', '0912345678', 0),
(4, 2, 'GH004', '2023-05-15', '2023-05-17', N'Phạm Thị D', N'Hải Phòng', '0909090909', 1),
(5, 1, 'GH005', '2023-05-25', '2023-05-26', N'Nguyễn Thị E', N'Nam Định', '0988888888', 0);

INSERT INTO GioHangChiTiet (IdGH, IdSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES  (1, 2, 2, 100000, 90000)
INSERT INTO GioHangChiTiet (IdGH, IdSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES	(1, 2, 3, 120000, 110000)
INSERT INTO GioHangChiTiet (IdGH, IdSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES  (2, 3, 1, 200000, 180000)
INSERT INTO GioHangChiTiet (IdGH, IdSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES  (3, 4, 4, 150000, 140000)
INSERT INTO GioHangChiTiet (IdGH, IdSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES  (4, 5, 2, 330000, 310000)

INSERT INTO HoaDon (IdKH, IdNV, Ma, NgayTao, TenNguoiNhan, DiaChiNhanHang, Sdt, TinhTrang) VALUES
(1, 1, 'HD001', '2023-05-03', N'Nguyễn Văn A', N'123 ABC Street', '0987654321', 1),
(2, 2, 'HD002', '2023-04-20', N'Trần Thị B', N'456 XYZ Street', '0123456789', 1),
(3, 1, 'HD003', '2023-05-10',  N'Lê Văn C', N'789 DEF Street', '0912345678', 0),
(4, 2, 'HD004', '2023-05-15', N'Phạm Thị D', N'456 GHI Street', '0909090909', 1),
(5, 1, 'HD005', '2023-05-25',  N'Nguyễn Thị E', N'789 JKL Street', '0988888888', 0);

INSERT INTO HoaDonChiTiet (IdHD, IdSP, SoLuong, DonGia) VALUES
(1, 1, 2, 100000),
(1, 2, 3, 120000),
(2, 3, 1, 200000),
(3, 4, 4, 150000),
(4, 5, 2, 330000);

INSERT INTO Users VALUES
('U1','admin','ngale4089@gmail.com','12345',1),
('U12','nga','ngaltph26840@.com','12345',0),
('U13','aa','ngale4089@gmail.com','12345',0)


SELECT * FROM Users
SELECT * FROM KhachHang
SELECT * FROM SanPham
SELECT * FROM KhachHang
SELECT * FROM GioHang
SELECT * FROM GioHangChiTiet
SELECT * FROM HoaDon WHERE Id = 1
SELECT * FROM HoaDonChiTiet WHERE IdHD = 30

DELETE FROM HoaDon where Id = 30
DELETE FROM HoaDonChiTiet where IdHD = 4

SELECT HoaDon.Ma,SanPham.TenSP,HoaDon.TenNguoiNhan,HoaDon.DiaChiNhanHang,HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia
FROM HoaDonChiTiet JOIN HoaDon ON HoaDonChiTiet.IdHD = HoaDon.Id
					JOIN SanPham ON HoaDonChiTiet.IdSP = SanPham.Id  WHERE HoaDon.Id = 4


SELECT TOP 10 TenSP,SoLuong, DATEDIFF(DAY, NgayNhap, GETDATE()) AS SoNgayTon
FROM SanPham ORDER BY DATEDIFF(DAY, NgayNhap, GETDATE()) DESC;

SELECT TOP 10 TenSP,SoLuong,NgayNhap FROM SanPham
order by NgayNhap ASC


SELECT TOP 10 sp.Id, sp.TenSP,sp.GiaBan,SUM(hdct.SoLuong) AS SoLuongBan
FROM SanPham sp
JOIN HoaDonChiTiet hdct ON sp.Id = hdct.IdSP
JOIN HoaDon hd ON hd.Id = hdct.IdHD
WHERE hd.NgayTao >= '2023-06-10' AND hd.NgayTao <= '2023-06-13'
GROUP BY sp.Id, sp.TenSP, sp.GiaBan
ORDER BY SoLuongBan DESC

SELECT * FROM SanPham

