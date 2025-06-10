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
    Role VARCHAR(20) CHECK (Role IN ('student', 'teacher', 'reviewer')) NOT NULL
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
    StudentID INT,
    Title NVARCHAR(255),
    Description NVARCHAR(MAX),
    Status NVARCHAR(50) CHECK(Status IN ('Processing','Accept','Reject')),
    TeacherID INT,
    Created_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (StudentID) REFERENCES Student(ID),
    FOREIGN KEY (TeacherID) REFERENCES Teacher(ID)
);
