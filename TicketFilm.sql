// Tạo bảng tblPhim
CREATE TABLE tblPhim (
    PhimID INT PRIMARY KEY,
    Ten_Phim NVARCHAR(30) NOT NULL,
    Loai_Phim NVARCHAR(25) NOT NULL,
    Thoi_Luong INT NOT NULL
);

// Tạo bảng tblPhong
CREATE TABLE tblPhong (
    PhongID INT PRIMARY KEY,
    Ten_Phong NVARCHAR(20) NOT NULL,
    Trang_thai INT NOT NULL
);

// Tạo bảng tblGhe
CREATE TABLE tblGhe (
    GheID INT PRIMARY KEY,
    PhongID INT NOT NULL,
    FOREIGN KEY (PhongID) REFERENCES tblPhong(PhongID),
    So_Ghe VARCHAR(10) NOT NULL
);

// Tạo bảng tblVe
CREATE TABLE tblVe (
    GheID INT NOT NULL,
    PhimID INT NOT NULL,
    FOREIGN KEY (GheID) REFERENCES tblGhe(GheID),
    FOREIGN KEY (PhimID) REFERENCES tblPhim(PhimID),
    Ngay_chieu DATE NOT NULL,
    Trang_thai NVARCHAR(20) NOT NULL,
);

//them du lieu vao bang tblPhim
INSERT INTO tblPhim (PhimID, Ten_Phim, Loai_Phim, Thoi_Luong) VALUES (1, 'Em bé Hà Nội', 'Tâm Lý', 90),
(2,'Nhiệm vụ bất khả thi','Hành động', 100),
(3,'Dị nhân','Viễn tưởng',90),
(4,'Cuốn theo chiều gió','tình cảm',120);

//them du lieu vao bang tblPhong
INSERT INTO tblPhong (PhongID, Ten_Phong, Trang_thai) VALUES (1, 'Phong chiếu 1', 1),
(2, 'Phong chiếu 2', 1),
(3, 'Phong chiếu 3', 0);

//them du lieu vao bang tblGhe
INSERT INTO tblGhe (GheID, PhongID, So_Ghe) VALUES (1, 1,  'A3'),
(2, 1, 'B5'),
(3, 1, 'A7'),
(4, 1, 'D1'),
(5, 1, 'T2');

//them du lieu vao bang tblVe
INSERT INTO tblVe (GheID, PhimID, Ngay_chieu, Trang_thai) VALUES (1, 1, '2008-10-20', 'Đã bán'),
(3, 1, '2008-11-20', 'Đã bán'),
(4, 1, '2008-12-23', 'Đã bán'),
(1, 2, '2009-02-14', 'Đã bán'),
(1, 3, '2009-02-14', 'Đã bán'),
(5, 2, '2009-03-08', 'Chưa bán'),
(3, 2, '2009-03-08', 'Chưa bán');

//Hiển thị danh sách các phim (chú ý: danh sách phải được sắp xếp theo trường Thoi_gian)
SELECT * FROM tblPhim ORDER BY Thoi_Luong;

// Hiển thị Ten_phim có thời gian chiếu dài nhất
SELECT Ten_Phim FROM tblPhim WHERE Thoi_Luong = (SELECT MAX(Thoi_Luong) FROM tblPhim);

//Hiển thị Ten_Phim có thời gian chiếu ngắn nhất
SELECT Ten_Phim FROM tblPhim WHERE Thoi_Luong = (SELECT MIN(Thoi_Luong) FROM tblPhim);

//Hiển thị danh sách So_Ghe mà bắt đầu bằng chữ ‘A’
SELECT * FROM tblGhe WHERE So_Ghe LIKE 'A%';

//Sửa cột Trang_thai của bảng tblPhong sang kiểu nvarchar(25)
ALTER TABLE tblPhong MODIFY COLUMN Trang_thai VARCHAR(25);

// Cập nhật giá trị cột Trang_thai của bảng tblPhong theo các luật sau:
//Nếu Trang_thai=0 thì gán Trang_thai=’Đang sửa’

//Nếu Trang_thai=1 thì gán Trang_thai=’Đang sử dụng’

//Nếu Trang_thai=null thì gán Trang_thai=’Unknow’

UPDATE tblPhong
SET Trang_thai = CASE
                    WHEN Trang_thai = 0 THEN 'Đang sửa'
                    WHEN Trang_thai = 1 THEN 'Đang hoạt động'
                    WHEN Trang_thai = null THEN 'Unknow'
                    ELSE Trang_thai
                 END;

//Sau đó hiển thị bảng tblPhong (Yêu cầu dùng procedure để hiển thị đồng thời sau khi update)
    DELIMITER //
CREATE PROCEDURE Display_tblPhong()
BEGIN
    SELECT * FROM tblPhong;
END //
DELIMITER ;

CALL Display_tblPhong();


//Hiển thị danh sách tên phim mà có độ dài >15 và < 25 ký tự **
SELECT Ten_Phim 
FROM tblphim 
WHERE LENGTH(Ten_Phim) > 15 AND LENGTH(Ten_Phim) < 25;

//Hiển thị Ten_Phong và Trang_Thai trong bảng tblPhong trong 1 cột với tiêu đề ‘Trạng thái phòng chiếu’
SELECT Ten_Phong, Trang_thai AS 'Trạng thái phòng chiếu' FROM tblPhong;

// Tạo view có tên tblRank với các cột sau: STT(thứ hạng sắp xếp theo Ten_Phim), TenPhim, Thoi_gian
CREATE VIEW tblRank AS 
SELECT ROW_NUMBER() OVER (ORDER BY Ten_Phim) AS STT,Ten_Phim, Thoi_Luong
FROM tblphim;

//Trong bảng tblPhim :
Thêm trường Mo_ta kiểu nvarchar(max)
ALTER TABLE tblPhim
ADD Mo_ta VARCHAR(50);

Cập nhật trường Mo_ta: thêm chuỗi “Đây là bộ phim thể loại ” + nội dung trường LoaiPhim
UPDATE tblPhim
SET Mo_ta = CONCAT('Đây là bộ phim thể loại ', Loai_Phim);


Hiển thị bảng tblPhim sau khi cập nhật
SELECT * FROM tblPhim;

Cập nhật trường Mo_ta: thay chuỗi “bộ phim” thành chuỗi “film” (Dùng replace)
Hiển thị bảng tblPhim sau khi cập nhật
UPDATE tblPhim
SET Mo_ta = REPLACE(Mo_ta, 'bộ phim', 'film');
SELECT * FROM tblPhim;

//Xóa tất cả các khóa ngoại trong các bảng trên.
ALTER TABLE tblGhe DROP FOREIGN KEY PhongID;

//Xóa dữ liệu ở bảng tblGhe
DELETE FROM tblGhe;

//Hiển thị ngày giờ hiện chiếu và ngày giờ chiếu cộng thêm 5000 phút trong bảng tblVe
SELECT Ngay_chieu, DATE_ADD(Ngay_chieu, INTERVAL 5000 MINUTE) AS 'Ngay chieu sau 5000 phut' FROM tblVe;



