<%-- 
    Document   : index
    Created on : Jun 7, 2025, 10:55:38 PM
    Author     : KHANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Quản lý Đồ Án</title>
        <style>
            * {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                line-height: 1.6;
                background-color: #f9f9f9;
                color: #333;
            }

            header {
                background: url('https://source.unsplash.com/1600x400/?technology,project') no-repeat center center/cover;
                color: white;
                height: 300px;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                text-align: center;
            }

            header h1 {
                font-size: 3rem;
                background: rgba(0, 0, 0, 0.5);
                padding: 0.5em 1em;
                border-radius: 10px;
            }

            nav {
                background-color: #333;
                color: white;
                display: flex;
                justify-content: center;
                padding: 0.5em 0;
            }

            nav a {
                color: white;
                margin: 0 1em;
                text-decoration: none;
            }

            nav a:hover {
                text-decoration: underline;
            }

            .projects-container {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
                gap: 1.5em;
                padding: 2em;
            }

            .project-card {
                background: white;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
                overflow: hidden;
                display: flex;
                flex-direction: column;
            }

            .project-card img {
                width: 100%;
                height: 200px;
                object-fit: cover;
            }

            .project-card .content {
                padding: 1em;
                flex-grow: 1;
                display: flex;
                flex-direction: column;
                justify-content: space-between;
            }

            .project-card h3 {
                margin-bottom: 0.5em;
            }

            .project-card button {
                background-color: #007BFF;
                color: white;
                border: none;
                padding: 0.5em;
                border-radius: 5px;
                cursor: pointer;
                align-self: flex-start;
            }

            .project-card button:hover {
                background-color: #0056b3;
            }

            footer {
                background-color: #222;
                color: white;
                padding: 2em;
                text-align: center;
            }

            footer a {
                color: #ccc;
                margin: 0 0.5em;
                text-decoration: none;
            }

            footer a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Hệ thống Quản lý Đồ Án</h1>
        </header>

        <nav>
            <a href="index.jsp">Trang chủ</a>
            <a href="TeacherReadProject">Đồ án</a>           
            <a href="TeacherViewRequest">Xem yêu cầu</a>
            <a href="Login">Đăng nhập<a>
            <a href="AdminReadReviewer">Danh sách giảng viên chấm điểm<a>
        </nav>

        <main class="projects-container">
            <div class="project-card">
                <img src="https://skt-tech.com/media/django-summernote/2021-05-29/7d362049-be23-43c7-a36e-68f2388e8591.png" alt="Dự án 1">
                <div class="content">
                    <h3>Hệ thống bán vé xe</h3>
                    <button>Xem chi tiết</button>
                </div>
            </div>
            <div class="project-card">
                <img src="https://adminweb.thuvien.edu.vn/UploadFolderNew/UBNDLongBien/Image/qi/administrator/giao-dien-phan-mem-thu-vien-thu-vien-dien-tu.png" alt="Dự án 2">
                <div class="content">
                    <h3>Ứng dụng quản lý nhà sách</h3>
                    <button>Xem chi tiết</button>
                </div>
            </div>
            <div class="project-card">
                <img src="https://blog.hub-js.com/wp-content/uploads/2021/08/Artboard-10@3x-1.png" alt="Dự án 3">
                <div class="content">
                    <h3>Phân tích dữ liệu khách hàng</h3>
                    <button>Xem chi tiết</button>
                </div>
            </div>
        </main>


        <footer>
            <p>&copy; 2025 Quản lý Đồ Án. Mọi quyền được bảo lưu.</p>
            <div>
                <a href="#">Chính sách bảo mật</a>|
                <a href="#">Điều khoản sử dụng</a>
            </div>
        </footer>
    </body>
</html>

