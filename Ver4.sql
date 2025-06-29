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
    Major VARCHAR(50),
    FOREIGN KEY (UserID) REFERENCES UserAccount(UserID)
);

-- TEACHER
CREATE TABLE Teacher (
    ID INT IDENTITY PRIMARY KEY,
    UserID NVARCHAR(20) UNIQUE,
    Department NVARCHAR(100),
    FOREIGN KEY (UserID) REFERENCES UserAccount(UserID)
);

-- REVIEWER
CREATE TABLE Reviewer (
    ID INT IDENTITY PRIMARY KEY,
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
    ID INT PRIMARY KEY IDENTITY(1,1),
    StudentID NVARCHAR(20),
    Title NVARCHAR(255),
    Description NVARCHAR(MAX),
    Status NVARCHAR(50) DEFAULT 'None' CHECK(Status IN ('Processing','Accept','Reject','None')),
    TeacherID INT,
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

-- STUDENT
INSERT INTO Student (UserID, Major, studentCode) VALUES
('sv001', 'Information System', 'he000001' ),
('sv002', 'Software Engineering', 'he000002');

-- TEACHER
INSERT INTO Teacher (UserID, Department) VALUES
('gv001', N'Computer Science');

-- REVIEWER
INSERT INTO Reviewer (UserID, Department) VALUES
('rv001', N'Computer Science'),
('rv002', N'Information System');

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
INSERT INTO Request (Title, Description, Status, TeacherID) VALUES
(N'Xin đổi đề tài', N'Em muốn đổi đề tài sang hướng AI', 'Processing', 1),
(N'Gia hạn nộp báo cáo', N'Em xin thêm 1 tuần để hoàn thành báo cáo cuối kỳ', 'Accept', 1);
