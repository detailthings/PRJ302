CREATE DATABASE QLDAver3


-- TERM
CREATE TABLE Semester (
    SemesterID VARCHAR(4) PRIMARY KEY,
    Semester VARCHAR(10) CHECK (Semester IN ('Fall', 'Spring', 'Summer')) NOT NULL,
    Year INT NOT NULL,
    StartDate DATE,
    EndDate DATE
);

-- USER
CREATE TABLE UserAccount (
    UserID NVARCHAR(20) PRIMARY KEY,
    Password VARCHAR(255) NOT NULL,
    FullName NVARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Role VARCHAR(20) CHECK (Role IN ('student', 'teacher', 'reviewer', 'admin')) NOT NULL
);

-- STUDENT
CREATE TABLE Student (
    ID INT IDENTITY PRIMARY KEY,
    UserID NVARCHAR(20) UNIQUE,
	StudentCode NVARCHAR(20) UNIQUE,
    Major VARCHAR(50),
    FOREIGN KEY (UserID) REFERENCES UserAccount(UserID)
);

-- TEACHER
CREATE TABLE Teacher (
    ID NVARCHAR(20) PRIMARY KEY,
    UserID NVARCHAR(20) UNIQUE,
    Department NVARCHAR(100),
    FOREIGN KEY (UserID) REFERENCES UserAccount(UserID)
);

-- REVIEWER
CREATE TABLE Reviewer (
    ID NVARCHAR(20) PRIMARY KEY,
    UserID NVARCHAR(20) UNIQUE,
    Department NVARCHAR(100),
    FOREIGN KEY (UserID) REFERENCES UserAccount(UserID)
);

-- PROJECT
CREATE TABLE Project (
    ProjectID NVARCHAR(10) PRIMARY KEY,
    Title NVARCHAR(255),
    Description NVARCHAR(MAX),
    TeacherID NVARCHAR(20) NOT NULL,
    SemesterID VARCHAR(4),
    JudgingID VARCHAR(50),
    FOREIGN KEY (TeacherID) REFERENCES UserAccount(UserID),
    FOREIGN KEY (SemesterID) REFERENCES Semester(SemesterID)
);

-- JUDGING
CREATE TABLE Judging (
    JudgingID VARCHAR(50) PRIMARY KEY,
    ProjectCode NVARCHAR(10) UNIQUE,
    TeacherID NVARCHAR(20),
    Reviewer1ID NVARCHAR(20),
    Reviewer2ID NVARCHAR(20),
    FOREIGN KEY (TeacherID) REFERENCES UserAccount(UserID),
    FOREIGN KEY (Reviewer1ID) REFERENCES UserAccount(UserID),
    FOREIGN KEY (Reviewer2ID) REFERENCES UserAccount(UserID)
);

-- DELIVERABLE
CREATE TABLE Deliverable (
    DeliverableID INT PRIMARY KEY IDENTITY,
    Title NVARCHAR(255),
    Description NVARCHAR(MAX),
    Weighting FLOAT,
    SubmissionOpenDate DATE,
    DueDate DATE
);

-- SUBMISSION
CREATE TABLE Submission (
    SubmissionID INT PRIMARY KEY IDENTITY,
    ProjectID NVARCHAR(10),
    DeliverableID INT,
    SubmissionDate DATETIME DEFAULT GETDATE(),
    LastModified DATETIME DEFAULT GETDATE(),
    Status VARCHAR(50),
    FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
    FOREIGN KEY (DeliverableID) REFERENCES Deliverable(DeliverableID)
);

-- REQUEST
CREATE TABLE Request (
    ID Nvarchar(20) PRIMARY KEY,
    StudentID NVARCHAR(20),
    Title NVARCHAR(255),
    Description NVARCHAR(MAX),
    Status NVARCHAR(50) DEFAULT 'None' CHECK(Status IN ('Processing','Accept','Reject','None')),
    TeacherID NVARCHAR(20),
    CreatedAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (TeacherID) REFERENCES Teacher(ID)
);


-- SEMESTER
INSERT INTO Semester (SemesterID, Semester, Year, StartDate, EndDate) VALUES
('SP24', 'Spring', 2024, '2024-01-01', '2024-04-30'),
('SU24', 'Summer', 2024, '2024-05-01', '2024-08-31'),
('FA24', 'Fall', 2024, '2024-09-01', '2024-12-31'),
('SP25', 'Spring', 2025, '2024-01-01', '2024-04-30'),
('SU25', 'Summer', 2025, '2025-05-01', '2025-08-31');

-- USERACCOUNT
INSERT INTO UserAccount (UserID, Password, FullName, Email, Role) VALUES
('sv001', '12345678', N'Nguyễn Văn A', 'a@student.fpt.edu.vn', 'student'),
('sv002', '12345678', N'Lê Thị B', 'b@student.fpt.edu.vn', 'student'),
('gv001', '12345678', N'Trần Văn C', 'c@fpt.edu.vn', 'teacher'),
('rv001', '12345678', N'Phạm Văn D', 'd@fpt.edu.vn', 'reviewer'),
('rv002', '12345678', N'Hoàng Thị E', 'e@fpt.edu.vn', 'reviewer'),
('admin01', 'admin123', N'Admin Hệ thống', 'admin@fpt.edu.vn', 'admin');

INSERT INTO UserAccount (UserID, Password, FullName, Email, Role) VALUES
('sv003', '12345678', N'Đỗ Minh F', 'sv003@student.fpt.edu.vn', 'student'),
('sv004', '12345678', N'Nguyễn Thị G', 'sv004@student.fpt.edu.vn', 'student'),
('sv005', '12345678', N'Trịnh Văn H', 'sv005@student.fpt.edu.vn', 'student'),
('sv006', '12345678', N'Lê Văn I', 'sv006@student.fpt.edu.vn', 'student'),
('sv007', '12345678', N'Phạm Thị K', 'sv007@student.fpt.edu.vn', 'student'),
('sv008', '12345678', N'Võ Minh L', 'sv008@student.fpt.edu.vn', 'student'),
('sv009', '12345678', N'Nguyễn Văn M', 'sv009@student.fpt.edu.vn', 'student'),
('sv010', '12345678', N'Phan Thị N', 'sv010@student.fpt.edu.vn', 'student'),
('sv011', '12345678', N'Hồ Quốc O', 'sv011@student.fpt.edu.vn', 'student'),
('sv012', '12345678', N'Trương Văn P', 'sv012@student.fpt.edu.vn', 'student'),
('sv013', '12345678', N'Lý Thị Q', 'sv013@student.fpt.edu.vn', 'student'),
('sv014', '12345678', N'Huỳnh Văn R', 'sv014@student.fpt.edu.vn', 'student'),
('sv015', '12345678', N'Ngô Thị S', 'sv015@student.fpt.edu.vn', 'student'),
('sv016', '12345678', N'Mai Văn T', 'sv016@student.fpt.edu.vn', 'student'),
('sv017', '12345678', N'Tạ Thị U', 'sv017@student.fpt.edu.vn', 'student'),
('sv018', '12345678', N'Bùi Văn V', 'sv018@student.fpt.edu.vn', 'student'),
('sv019', '12345678', N'Đặng Thị X', 'sv019@student.fpt.edu.vn', 'student'),
('sv020', '12345678', N'Đỗ Văn Y', 'sv020@student.fpt.edu.vn', 'student'),
('sv021', '12345678', N'Nguyễn Thị Z', 'sv021@student.fpt.edu.vn', 'student'),
('sv022', '12345678', N'Trần Văn AA', 'sv022@student.fpt.edu.vn', 'student');




-- STUDENT
INSERT INTO Student (UserID, Major, studentCode) VALUES
('sv001', 'Information System', 'he000001' ),
('sv002', 'Software Engineering', 'he000002');
INSERT INTO Student (UserID, Major, studentCode) VALUES
('sv003', 'Information System', 'he000003'),
('sv004', 'Information System', 'he000004'),
('sv005', 'Information System', 'he000005'),
('sv006', 'Software Engineering', 'he000006'),
('sv007', 'Software Engineering', 'he000007'),
('sv008', 'Software Engineering', 'he000008'),
('sv009', 'Software Engineering', 'he000009'),
('sv010', 'Software Engineering', 'he000010'),
('sv011', 'Computer Science', 'he000011'),
('sv012', 'Computer Science', 'he000012'),
('sv013', 'Computer Science', 'he000013'),
('sv014', 'Computer Science', 'he000014'),
('sv015', 'Computer Science', 'he000015'),
('sv016', 'AI', 'he000016'),
('sv017', 'AI', 'he000017'),
('sv018', 'AI', 'he000018'),
('sv019', 'AI', 'he000019'),
('sv020', 'AI', 'he000020');


-- TEACHER
INSERT INTO Teacher (ID, UserID, Department) VALUES
('gv001','gv001', N'Computer Science');

-- REVIEWER
INSERT INTO Reviewer (ID, UserID, Department) VALUES
('rv001','rv001', N'Computer Science'),
('rv002','rv002', N'Information System');

-- PROJECT
INSERT INTO Project (ProjectID, Title, Description, TeacherID, SemesterID, JudgingID) VALUES
('PRJ001', N'Hệ thống quản lý khóa luận', N'Một hệ thống giúp quản lý sinh viên và tiến độ khóa luận', 'gv001', 'FA24', 'JUDG001');

-- JUDGING
INSERT INTO Judging (JudgingID, ProjectCode, TeacherID, Reviewer1ID, Reviewer2ID) VALUES
('JUDG001', 'PRJ001', 'gv001', 'rv001', 'rv002');

-- DELIVERABLE
INSERT INTO Deliverable (Title, Description, Weighting, SubmissionOpenDate, DueDate) VALUES
(N'Proposal', N'Nộp đề cương khóa luận', 20, '2024-08-15', '2024-09-01'),
(N'Final Report', N'Nộp báo cáo cuối kỳ', 80, '2024-11-15', '2024-12-01');

-- SUBMISSION
INSERT INTO Submission (ProjectID, DeliverableID, Status) VALUES
('PRJ001', 1, 'Submitted'),
('PRJ001', 2, 'Pending');

-- REQUEST
INSERT INTO Request (ID, Title, Description, Status, TeacherID) VALUES
('CSS111', N'Gia hạn nộp báo cáo', N'Em xin thêm 1 tuần để hoàn thành báo cáo cuối kỳ', 'None', 'gv001'),
('WEB201', N'Xin đổi nhóm', N'Em muốn chuyển sang nhóm làm việc khác phù hợp hơn', 'None', 'gv001'),
('DBS301', N'Yêu cầu hỗ trợ', N'Em cần thêm tài liệu để hoàn thành đồ án', 'None', 'gv001'),
('PRJ310', N'Xin bảo lưu', N'Em gặp vấn đề cá nhân, xin bảo lưu đồ án sang kỳ sau', 'None', 'gv001'),
('PRJ300', N'Xin đổi đề tài', N'Em muốn đổi đề tài sang hướng AI', 'None', 'gv001');

