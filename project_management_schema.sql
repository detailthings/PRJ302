Create database QLDAver3


-- Tạo bảng Timeline (các kỳ học A, B, C)
CREATE TABLE Timeline (
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL,
	status_1 NVARCHAR(10) CHECK(status_1 IN ('On time','Late','Miss')),
	status_2 NVARCHAR(10) CHECK(status_2 IN ('On time','Late','Miss')),
	status_3 NVARCHAR(10) CHECK(status_3 IN ('On time','Late','Miss')),
    start_date DATE,
    end_date DATE
);

-- Tạo bảng Teacher
CREATE TABLE Teacher (
    id INT PRIMARY KEY,
    name NVARCHAR(100),
    email NVARCHAR(100),
    department NVARCHAR(100)
);

-- Tạo bảng Student
CREATE TABLE Student (
    id INT PRIMARY KEY,
    name NVARCHAR(100),
    email NVARCHAR(100),
    major NVARCHAR(50)
);

-- Tạo bảng Project
CREATE TABLE Project (
    id INT PRIMARY KEY IDENTITY(1,1),
    title NVARCHAR(255),
    description NVARCHAR(MAX),
    teacher_id INT FOREIGN KEY REFERENCES Teacher(id)
);

-- Tạo bảng Request
CREATE TABLE Request (
    id INT PRIMARY KEY IDENTITY(1,1),
    student_id INT FOREIGN KEY REFERENCES Student(id),   
	title NVARCHAR(255),
    description NVARCHAR(MAX),
    status NVARCHAR(50) CHECK(status IN ('Processing','Accept','Reject')),
    created_at DATETIME DEFAULT GETDATE()
);

-- Tạo bảng Project_Assignment (gán đề tài cho sinh viên theo kỳ học)
CREATE TABLE Project_Assignment (
    student_id INT FOREIGN KEY REFERENCES Student(id),
    project_id INT FOREIGN KEY REFERENCES Project(id),
    timeline_id INT FOREIGN KEY REFERENCES Timeline(id),
    status_1 NVARCHAR(10) CHECK(status_1 IN ('On time','Late','Miss')),
	status_2 NVARCHAR(10) CHECK(status_2 IN ('On time','Late','Miss')),
	status_3 NVARCHAR(10) CHECK(status_3 IN ('On time','Late','Miss')),
	Primary Key(student_id, project_id, timeline_id)
);

-- Tạo bảng Grade (chấm điểm)
CREATE TABLE Grade (
    teacher_id INT FOREIGN KEY REFERENCES Teacher(id),
    project_id INT FOREIGN KEY REFERENCES Project(id),
    score FLOAT,
    comment NVARCHAR(MAX),
	Primary Key(teacher_id, project_id)
);
