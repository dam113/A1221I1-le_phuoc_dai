create database quan_ly_sinh_vien;

USE quan_ly_sinh_vien;

CREATE TABLE Class
(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    Status    BIT
);

CREATE TABLE Student
(
    StudentId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassId     INT         NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);

CREATE TABLE Subject
(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
);

CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
    
-- Sử dụng câu lệnh Select * và lấy dữ liệu học viên từ bảng Student để hiển thị danh sách tất cả các học viên như sau:    
SELECT *
FROM Student;

-- Để hiển thị danh sách học viên đang theo học cần phải sử dụng câu lệnh select ... from kèm theo where để xét điều kiện truy vấn như sau:
SELECT *
FROM Student
WHERE Status = true;

-- Trong đó status là trang thái học tập của học viên (true: đang học, fasle: nghỉ học)
-- Sử dụng điều kiện where Credit < 10 và from Subject để lấy ra danh sách các môn học có thời gian học nhỏ hơn 10:
SELECT *
FROM Subject
WHERE Credit < 10;

-- Sử dụng câu lệnh Join và where để hiển thị danh sách học viên lớp A1
-- Join 2 bảng Student và Class bằng câu lệnh sau
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID;
-- Sử dụng câu lệnh Where C.ClassName ='A1' để hiển thị danh sách học viên lớp A1
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

-- Hiển thị điểm môn CF của các học viên
-- Hiển thị tất cả các điểm đang có của học viên
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S 
join Mark M on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId;
-- Sử dụng câu lệnh Where để hiển thị điểm môn CF của các học viên
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S 
join Mark M on S.StudentId = M.StudentId 
join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';