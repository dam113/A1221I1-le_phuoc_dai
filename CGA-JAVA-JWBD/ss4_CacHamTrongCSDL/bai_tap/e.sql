USE quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select SubName, max(Credit) as Credit
from subject;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select s.SubName, s.Credit, max(m.Mark) as mark
from subject s inner join mark m on s.SubId = m.SubId;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần.
select s.StudentId, s.StudentName, avg(m.Mark) as mark
from student s inner join mark m on s.StudentId = m.StudentId
group by s.StudentId
order by m.Mark desc;